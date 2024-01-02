package com.study.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dto.MyCommentsDto;
import com.study.springboot.entity.Article;
import com.study.springboot.entity.MyComments;
import com.study.springboot.repository.ArticleRepository;
import com.study.springboot.repository.MyCommentsRepository;

import jakarta.transaction.Transactional;

@Service
public class MyCommentsService {

	@Autowired
	private MyCommentsRepository myCommentsRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public List<MyCommentsDto> myComments(Long articleId){
//		// select comments
//		List<MyComments> myComments = myCommentsRepository.findByArticleId(articleId);
//		// entity >>> dto
//		List<MyCommentsDto> dtos = new ArrayList<MyCommentsDto>();
//		for(int i = 0; i<myComments.size(); i++) {
//			MyComments c = myComments.get(i);
//			MyCommentsDto dto = MyCommentsDto.createMyCommentsDto(c);
//			dtos.add(dto);
//		}
//		
//		return dtos;
		return myCommentsRepository.findByArticleId(articleId)
				.stream()
				.map(myComments -> MyCommentsDto.createMyCommentsDto(myComments))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public MyCommentsDto create(Long articleId, MyCommentsDto dto) {
		// 1. select article & Exception
		Article article = articleRepository.findById(articleId)
				.orElseThrow(()->new IllegalArgumentException("!!! Fail to write Comments !!!"));
		// 2. Create Comments Entity
		MyComments myComments = MyComments.createMyComments(dto, article);
		// 3. Save DB in Comments Entity
		MyComments created = myCommentsRepository.save(myComments);
		// 4. convert and return Dto
		return MyCommentsDto.createMyCommentsDto(created);
		
	}
	
	@Transactional
	public MyCommentsDto update(Long id, MyCommentsDto dto) {
		MyComments target = myCommentsRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Failed to Modifing Comments"));
		target.patch(dto);
		MyComments updated = myCommentsRepository.save(target);
		return MyCommentsDto.createMyCommentsDto(updated);
	}
	
	@Transactional
	public MyCommentsDto delete(Long id) {
		MyComments target = myCommentsRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Fail to Remove Comments"));
		myCommentsRepository.delete(target);
		return MyCommentsDto.createMyCommentsDto(target);
	}
	
}
