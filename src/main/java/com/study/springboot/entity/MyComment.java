package com.study.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyComment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne  // foreign key setting
	@JoinColumn(name = "article_id", referencedColumnName = "id") // column name
	private Article article;
	
	@Column
	private String nickname;
	@Column
	private String body;

}
