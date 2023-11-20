package com.project.telusko.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Demo;
import com.project.model.Questions;
import com.project.telusko.dao.quizDao;


@EnableJpaRepositories("com.project.*")
@ComponentScan(basePackages = { "com.project.*" })
@EntityScan("com.project.*") 

@RestController
public class QuizController {
	
	@Autowired
	quizDao dao;
	
	@RequestMapping("allQuestions")
	public List<Questions> getAllQuestions(){
//		System.out.println("getAllQueation called");
		
		return dao.findAll();
//		List<QuizQsn> li = new ArrayList<>();
//		return li;
	}
	
	@GetMapping("question/{type}")
	public List<Questions> getByType(@PathVariable("type") String type){
		System.out.println(type);
		return dao.findByType(type);
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Questions qsn) {
		dao.save(qsn);
		return new ResponseEntity<>("Inserted successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("deleteQuestion/{qid}")
	public ResponseEntity<String> deleteQuestion(@PathVariable("qid") String qid){
//		System.out.println("Delete method called");
		int id = Integer.valueOf(qid);
		dao.deleteById(id);
		return new ResponseEntity<>("Deleted successfully", HttpStatus.ACCEPTED);
	}
	
	
}
