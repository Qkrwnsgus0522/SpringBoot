package com.jun.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

// 방식1
@Controller
public class CTRL {
	
	@RequestMapping("/")
	public String root() {
		return "test";
	}
	
	@RequestMapping("/test")
	public String root(@Valid VO vo, BindingResult br, Model model) {
		/////
//		if (vo.getId() == null || vo.getId().isBlank() || vo.getId().equals("") || vo.getId().isEmpty()) {
//			
//		}
//		if (vo.getPassword().length() <= 5) {
//			
//		}
		
		//VOValidator voV = new VOValidator();
		//voV.validate(vo, br); // br는 커맨드 객체(참조 변수)
		if (br.hasErrors()) {
			System.out.println("로그 : 발생한 에러목록");
			System.out.println(br.getAllErrors());
			
			if (br.getFieldError("id") != null) { // id에서 Error가 발생헀다는 의미
				System.out.println(br.getFieldError("id").getCode());
			}
			if (br.getFieldError("password") != null) {
				System.out.println(br.getFieldError("password").getCode());				
			}
			
		}
		/////
		model.addAttribute("apple", vo.getId());
		return "test";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder wdb) {
		wdb.setValidator(new VOValidator());
	}
}
