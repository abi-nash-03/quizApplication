package com.project.telusko.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.model.Questions;
import com.project.model.User;
import com.project.telusko.dao.quizDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	quizDao dao;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("addUser")
	public String addUser(@ModelAttribute User u) {
		
		return "user"; 
	}
	
	@RequestMapping("quizByType")
	public String getQuizByType(@RequestParam("type") String type, Model m) {
		List<Questions> li = dao.findByType(type);
		m.addAttribute("quizQuestions",li);
		m.addAttribute("completed",false);
		return "Quiz";
	}
	
	@RequestMapping("validateAns")
	public String validateAns(Model m) {
		String type = (String) m.getAttribute("type");
		List<Questions> li = dao.findByType(type);
		m.addAttribute("quizQuestions",li);
		m.addAttribute("completed",true);
		return "Quiz";
	}
}

