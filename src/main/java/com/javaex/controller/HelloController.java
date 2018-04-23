package com.javaex.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.UserVo;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("/hellospring/hello");
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		System.out.println("/hellospring/main");
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		System.out.println("/hellospring/form");
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET) 
	public String add(@RequestParam("age") int age, @ RequestParam("name") String name) {
		
		System.out.println(age);
		System.out.println(name);
		
		return "";
	}
	
	@RequestMapping(value="/add2", method=RequestMethod.GET) 
	public String add(@ModelAttribute UserVo userVo) {
		
		System.out.println(userVo.toString());
		return "";
	}
	
	//@RequestMapping(value="/{no}/read", method=RequestMethod.GET) 
	@RequestMapping(value="/read/{no}", method=RequestMethod.GET) 
	public String read(@PathVariable("no") int no) {
		
		System.out.println(no + "번 글 가져오기");
		return "";
	}
	
	//가급적 안쓰는게 좋음 -> dispatcher가 대신 일하게 하는게 좋음
	@RequestMapping(value="add3", method=RequestMethod.GET)
	public String http(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		System.out.println(name);
		return "";
		
	}
	
	@RequestMapping(value="/userlist", method=RequestMethod.GET)
	public String list(Model model) {
	
		List<UserVo> userList = new ArrayList<UserVo>();
		UserVo user01 = new UserVo(11, "유재석");
		UserVo user02 = new UserVo(22, "정준하");
		UserVo user03 = new UserVo(33, "박명수");
		
		userList.add(user01);
		userList.add(user02);
		userList.add(user03);
		System.out.println(userList.toString());
		
		model.addAttribute("userList", userList);
		
		return "WEB-INF/views/index.jsp";	
		}
	
	
	
}