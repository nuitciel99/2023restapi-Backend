package com.study.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.MemberForm;
import com.study.springboot.entity.Article;
import com.study.springboot.entity.Member;
import com.study.springboot.repository.ArticleRepository;
import com.study.springboot.repository.MemberRepository;

@RestController
public class MemberApiController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/api/members")
	@CrossOrigin
	public List<Member> index(){
		return memberRepository.findAll();
	}
	
	@GetMapping("/api/members/{id}")
	@CrossOrigin
	public Member show(@PathVariable Long id) {
		return memberRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/api/members")
	public Member create(@RequestBody MemberForm dto){
		Member member = dto.toEntity();
		return memberRepository.save(member);
	}

}
