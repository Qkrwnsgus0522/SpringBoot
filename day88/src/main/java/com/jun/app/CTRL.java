package com.jun.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CTRL {
	
	@RequestMapping("/") // 루트 요청
	public @ResponseBody String root() {
		return "롬복 예제입니다! :D";
		// VR xxxxx
		// 문자열 "값"
	}
	
	// ★
	@RequestMapping("/test")
	public String test(@ModelAttribute("banana")VO vo) {
						// 커맨드 객체
		System.out.println("vo : " + vo);
		
		return "test";
	}
	
//	@RequestMapping("/test")
//	public String test(VO vo, Model model) {
//		// 커맨드 객체
//		System.out.println("vo : " + vo);
//		model.addAttribute("apple", vo.getId());
//		
//		return "test";
//		// /WEB-INF/views/test.jsp
//	}
	
	@RequestMapping("/test01")
	public String test01(HttpServletRequest request, Model model) {
//		VO vo = new VO();
//		vo.setId(request.getParameter("id"));
//		System.out.println("vo : " + vo);
//		model.addAttribute("apple", vo.getId());
		model.addAttribute("apple", request.getParameter("id"));
		System.out.println("request.getParameter(id) : " + request.getParameter("id"));
		return "test";
	} // request 자체가 not POHO인 Servlet 객체이기 때문에 활용도가 낮다!
	
	@RequestMapping("/test02")
	public String test02(@RequestParam("id")String id, @RequestParam("name")String name, Model model) {
		model.addAttribute("apple", id);
		model.addAttribute("banana", name);
		System.out.println("id : " + id + ", name : " + name);
		return "test";
	} // 가독성이 커맨드 객체를 사용할 때 보다 별로임...!!
	
	@RequestMapping("/test03/{id}/{name}")
	public String test03(@PathVariable String id, @PathVariable String name, Model model) {
		model.addAttribute("apple", id);
		model.addAttribute("banana", name);
		System.out.println("id : " + id + ", name : " + name);
		return "test";
	} // URL에 데이터를 바로 보내는 방법 ☆
}
