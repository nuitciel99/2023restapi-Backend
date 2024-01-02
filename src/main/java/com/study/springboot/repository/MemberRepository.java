package com.study.springboot.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Article;
import com.study.springboot.entity.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
	
	@Override
	ArrayList<Member> findAll();

}
