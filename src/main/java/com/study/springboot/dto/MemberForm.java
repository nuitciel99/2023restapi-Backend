package com.study.springboot.dto;

import com.study.springboot.entity.Article;
import com.study.springboot.entity.Member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
	
	private Long id;
	private String email;
	private String password;
	
	public Member toEntity() {
			
		// 최초 테이블 생성 시 null, 생성 후 id로 해줘야 update 됨
		
		return new Member(id, email, password);
	}
	

}
