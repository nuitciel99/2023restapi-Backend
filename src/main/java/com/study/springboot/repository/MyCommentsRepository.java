package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.MyComments;

@Repository
public interface MyCommentsRepository extends JpaRepository<MyComments, Long>{
	
	@Query(value = "select * from my_comments where article_id = :articleId", 
			nativeQuery = true)
//	List<MyComments> findByArticleId(Long articleId);
	List<MyComments> findByArticleId(@Param("articleId") Long articleId);
	
	

}
