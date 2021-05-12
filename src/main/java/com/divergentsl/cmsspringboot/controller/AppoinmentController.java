
package com.divergentsl.cmsspringboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

import com.divergentsl.cmsspringboot.entity.Appoinment;
import com.divergentsl.cmsspringboot.service.AppoinmentService;


@Controller
@RequestMapping("appoinment")
public class AppoinmentController {

	private static final long serialVersionUID = 1L;

	@Autowired
	AppoinmentService appoinmentService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@GetMapping
	protected ModelAndView showPage() {
		List<Appoinment> allAppoinment = appoinmentService.list();
		ModelAndView model = new ModelAndView("appoinment");
		model.addObject("allAppoinment", allAppoinment);
		return model;
	}

	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String problem = req.getParameter("problem");
		String appoinmentDate = req.getParameter("appoinmentDate");
		String currentDate = req.getParameter("currentdate");
		int doctorId = Integer.parseInt(req.getParameter("doctorId"));

		appoinmentService.add(name, problem, appoinmentDate, currentDate, doctorId);
		return "rediect:/appoinment";
	}

	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		appoinmentService.remove(id);

		return "redirect:/appoinment";
	}
	
	@GetMapping("/searchbyid")
	protected String searchById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		appoinmentService.searchById(id);

		return "redirect:/appoinment";
	}
}
