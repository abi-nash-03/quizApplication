package com.project.telusko.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Demo;
import com.project.model.Questions;

public interface quizDao extends JpaRepository<Questions, Integer>
{

	List<Questions> findByType(String type);

}
