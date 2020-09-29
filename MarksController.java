package com.pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.pack.model.Student;

@Controller
public class MarksController {
	
	@RequestMapping(value="/login")
	public String loginForm(ModelMap m) {
		Student s=new Student();
		m.addAttribute("std",s);
		return "form";
	}
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public String saveData(@Validated @ModelAttribute("std")Student s1,BindingResult result,ModelMap m1)
	{
		String finalResult;
		if(result.hasErrors())
		{
			finalResult="form";
		}
		else
		{
		m1.addAttribute("stud",s1);
		finalResult="success";
		}
		return finalResult;
	}
}
