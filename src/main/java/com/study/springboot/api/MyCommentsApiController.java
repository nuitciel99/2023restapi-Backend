package com.study.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.MyCommentsDto;
import com.study.springboot.service.ArticleService;
import com.study.springboot.service.MyCommentsService;

@RestController
public class MyCommentsApiController {

	@Autowired
	private MyCommentsService myCommentsService;
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/api/articles/{articleId}/comments")
	@CrossOrigin
	public ResponseEntity<List<MyCommentsDto>> myComments(@PathVariable Long articleId){
		
		List<MyCommentsDto> dtos = myCommentsService.myComments(articleId);
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		 
	}
	
	@PostMapping("/api/articles/{articleId}/comments")
	@CrossOrigin
	public ResponseEntity<MyCommentsDto> create(
			@PathVariable Long articleId,
			@RequestBody MyCommentsDto dto
			){
		MyCommentsDto createDto = myCommentsService.create(articleId, dto);
		return ResponseEntity.status(HttpStatus.OK).body(createDto);
	}
	
	@PatchMapping("/api/comments/{id}")
	@CrossOrigin
	public ResponseEntity<MyCommentsDto> update(
			@PathVariable Long id,
			@RequestBody MyCommentsDto dto
			){
		MyCommentsDto updateDto = myCommentsService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(updateDto);
	}
	
	@DeleteMapping("/api/comments/{id}")
	@CrossOrigin
	public ResponseEntity<MyCommentsDto> delete(@PathVariable Long id){
		MyCommentsDto deleteDto = myCommentsService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleteDto);
	}
	
}
