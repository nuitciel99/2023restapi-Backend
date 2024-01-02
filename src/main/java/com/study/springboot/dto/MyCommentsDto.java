package com.study.springboot.dto;

import com.study.springboot.entity.MyComments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MyCommentsDto {

	private Long id;
	private Long articleId;
	private String nickname;
	private String body;
	
	public static MyCommentsDto createMyCommentsDto(MyComments myComments) {
		
		return new MyCommentsDto(
				myComments.getId(),
				myComments.getArticle().getId(),
				myComments.getNickname(),
				myComments.getBody()
				);
	}
	
}
