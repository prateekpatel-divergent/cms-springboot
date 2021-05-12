package com.divergentsl.cmsspringboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergentsl.cmsspringboot.entity.Patient;
import com.divergentsl.cmsspringboot.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	PatientService patientService;

	@GetMapping
	protected ModelAndView showPage() {
		List<Patient> allPatients = patientService.list();
		ModelAndView model = new ModelAndView("patient"); 
		model.addObject("allPatients", allPatients); 
		return model;
	}
	
	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String patientName = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		int weight = Integer.parseInt(req.getParameter("weight"));
		String gender = req.getParameter("gender");
		int contactNumber = Integer.parseInt(req.getParameter("contactno"));
		String address = req.getParameter("address");
		
		patientService.add(patientName, age, weight, gender, contactNumber, address);
		return "redirect:/patient";
	}

	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		patientService.remove(id);

		return "redirect:/patient";
	}
}
