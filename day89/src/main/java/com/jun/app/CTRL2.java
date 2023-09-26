package com.jun.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

// 방식2
@Controller
public class CTRL2 {
	@RequestMapping("/test2")
	public String test2(@Valid VO2 vo, BindingResult br, Model model) {
		/////
		if (br.hasErrors()) {
			System.out.println("로그 : 발생한 에러목록");
			System.out.println(br.getAllErrors());
			
			if (br.getFieldError("id") != null) { // id에서 Error가 발생헀다는 의미
//				System.out.println(br.getFieldError("id").getCode());
				System.out.println(br.getFieldError("id").getDefaultMessage());
			}
			if (br.getFieldError("password") != null) {
//				System.out.println(br.getFieldError("password").getCode());		
				System.out.println(br.getFieldError("password").getDefaultMessage());
			}
			
		}
		/////
		model.addAttribute("apple", vo.getId());
		return "test";
	}
}
