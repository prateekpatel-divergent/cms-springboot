package com.divergentsl.cmsspringboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.cmsspringboot.entity.LabTest;
import com.divergentsl.cmsspringboot.service.LabTestService;

@Controller
@RequestMapping("labtest")
public class LabTestController{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	LabTestService labTestService;
	
	@GetMapping
	protected ModelAndView showPage() {
		List<LabTest> allLabTests = labTestService.listAll();
		ModelAndView model = new ModelAndView("labtest"); 
		model.addObject("allLabTests", allLabTests); 
		return model;
	}
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		int rate = Integer.parseInt(req.getParameter("rate"));
		int patientid = Integer.parseInt(req.getParameter("patientid"));

		labTestService.add(name, rate, patientid);
		return "redirect:/labtest";

	}
	
	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		labTestService.remove(id);
		return "redirect:/labtest";
	}
}
