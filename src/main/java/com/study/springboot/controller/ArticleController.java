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
import com.study.springboot.entity.Article;
import com.study.springboot.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/articles/new")
	public String newArticleForm() {
		return "/articles/new";
	}
	
	@PostMapping("/articles/create")
	public String newArticle(ArticleForm form) {
		
		// dto를 entity로 변환
		Article article = form.toEntity();
		// repository에 entity save
		Article saved = articleRepository.save(article);
		
		return "redirect:/articles/" + saved.getId();
	}
	
	@GetMapping("/articles/{id}")
	public String show(@PathVariable Long id, Model model) {
		Article article = articleRepository.findById(id).orElse(null);
		model.addAttribute("article", article);
		return "articles/show";
	}
	
	@GetMapping("/articles")
	public String index(Model model) {
		List<Article> articles = articleRepository.findAll();
		model.addAttribute("lists", articles);
		
		return "articles/index";
	}
	
	@GetMapping("/articles/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Article article = articleRepository.findById(id).orElse(null);
		model.addAttribute("id", id);
		model.addAttribute("article", article);
		
		return "articles/edit";
	}
	
	@PostMapping("/articles/update")
	public String update(ArticleForm form) {
		Article article = form.toEntity();
		Article target = articleRepository.findById(article.getId()).orElse(null);
		
		if(target != null) {
			articleRepository.save(article);
		}
		
		return "redirect:/articles/" + article.getId();
	}
	
	@GetMapping("/articles/{id}/delete")
	public String delete(@PathVariable Long id, RedirectAttributes attr) {
		Article target = articleRepository.findById(id).orElse(null);
		if(target != null) {
			articleRepository.delete(target);
			attr.addFlashAttribute("msg", "delete completed");
		}
		
		return "redirect:/articles";
	}

}
