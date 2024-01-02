package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.springboot.dto.ArticleForm;
import com.study.springboot.dto.MemberForm;
import com.study.springboot.entity.Article;
import com.study.springboot.entity.Member;
import com.study.springboot.repository.ArticleRepository;
import com.study.springboot.repository.MemberRepository;

@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/members/new")
	public String newMemberForm() {
		return "/members/new";
	}
	
	@PostMapping("/members/signup")
	public String newMember(MemberForm form) {
		
		// dto를 entity로 변환
		Member member = form.toEntity();
		// repository에 entity save
		Member saved = memberRepository.save(member);
		
		return "redirect:/members/" + saved.getId();
	}
	
	@GetMapping("/members/{id}")
	public String show(@PathVariable Long id, Model model) {
		Member member = memberRepository.findById(id).orElse(null);
		model.addAttribute("member", member);
		return "members/show";
	}
	
	@GetMapping("/members")
	public String index(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("lists", members);
		
		return "members/index";
	}
	
	@GetMapping("/members/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Member member = memberRepository.findById(id).orElse(null);
		model.addAttribute("id", id);
		model.addAttribute("member", member);
		
		return "members/edit";
	}
	
	@PostMapping("/members/update")
	public String update(MemberForm form) {
		Member member = form.toEntity();
		Member target = memberRepository.findById(member.getId()).orElse(null);
		
		if(target != null) {
			memberRepository.save(member);
		}
		
		return "redirect:/members/" + member.getId();
	}
	
	@GetMapping("/members/{id}/delete")
	public String delete(@PathVariable Long id, RedirectAttributes attr) {
		Member target = memberRepository.findById(id).orElse(null);
		if(target != null) {
			memberRepository.delete(target);
			attr.addFlashAttribute("msg", "delete completed");
		}
		
		return "redirect:/members";
	}

}
