package com.study.springboot.entity;

import com.study.springboot.dto.MyCommentsDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyComments {

	@Id
	@SequenceGenerator (
			name = "mySequence02",
			sequenceName = "MyComments_SEQ",
			initialValue = 1,
			allocationSize = 1
	)
	@GeneratedValue (generator = "mySequence02")
	private Long id;
	@ManyToOne
	@JoinColumn(name="article_id", referencedColumnName = "id")
	private Article article;
	@Column
	private String nickname;
	@Column
	private String body;
	
	public static MyComments createMyComments(MyCommentsDto dto, Article article) {
		
		if(dto.getId() != null) {
			throw new IllegalArgumentException("Fail to Write Comments!!! need to null id");
		}
		if(dto.getArticleId() != article.getId()) {
			throw new IllegalArgumentException("Fail to Write Comments!!! Wrong Article's ID");
		}
		
		return new MyComments(
				dto.getId(),
				article,
				dto.getNickname(),
				dto.getBody()
				);
	}

	public void patch(MyCommentsDto dto) {
		if(this.id != dto.getId()) {
			throw new IllegalArgumentException("Fail to Modifing Comments!!! Cause of Wrong Id ");
		}
		if(dto.getNickname() != null) {
			this.nickname = dto.getNickname();
		}
		if(dto.getBody() != null) {
			this.body = dto.getBody();
		}
	}
	
	
}
