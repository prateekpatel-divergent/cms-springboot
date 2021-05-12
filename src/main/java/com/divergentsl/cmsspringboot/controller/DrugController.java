package com.divergentsl.cmsspringboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.cmsspringboot.entity.Drug;
import com.divergentsl.cmsspringboot.service.DrugService;

@Controller
@RequestMapping("drug")
public class DrugController{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	DrugService drugService;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@GetMapping
	protected ModelAndView showPage() {
		List<Drug> allDrugs = drugService.list();
		ModelAndView model = new ModelAndView("drug"); 
		model.addObject("allDrugs", allDrugs); 
		return model;
	}
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		int rate =Integer.parseInt(req.getParameter("rate"));

		drugService.add(name, rate);
		return "rediect:/drug";
	}
	
	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		drugService.remove(id);
		return "rediect:/drug";
	}
}
