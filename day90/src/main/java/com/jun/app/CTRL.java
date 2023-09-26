package com.jun.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class CTRL {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@RequestMapping("/main")
	public String main(Model model) {
		model.addAttribute("bDatas", boardDAO.selectAll(null));
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(MemberDTO mDTO, HttpSession session) {
		mDTO = memberDAO.selectOne(mDTO);
		if (mDTO != null) {
			session.setAttribute("sessionMid", mDTO.getMid());
		}
		return "redirect:/main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionMid");
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join() {
		return "mypage";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(MemberDTO mDTO) {
		mDTO.setSearch("CHECK");
		if (memberDAO.selectOne(mDTO) == null) {
			memberDAO.insert(mDTO);			
		}
		return "redirect:/main";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@RequestMapping("/updateMember")
	public String updateMember(MemberDTO mDTO) {
		memberDAO.update(mDTO);
		return "redirect:/logout";
	}
	
	@RequestMapping("/deleteMember")
	public String deleteMember(MemberDTO mDTO, HttpSession session) {
		mDTO.setMid((String)session.getAttribute("sessionMid"));
		memberDAO.delete(mDTO);
		return "redirect:/logout";
	}
	
	@RequestMapping("/board")
	public String board(BoardDTO bDTO, Model model) {
		model.addAttribute("bData", boardDAO.selectOne(bDTO));
		return "board";
	}
	
	@RequestMapping("/insertBoard")
	public String insertBoard(BoardDTO bDTO) {
		boardDAO.insert(bDTO);
		return "redirect:/main";
	}
	
	@RequestMapping("/updateBoard")
	public String updateBoard(BoardDTO bDTO) {
		boardDAO.update(bDTO);
		return "redirect:/main";
	}
	
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardDTO bDTO) {
		boardDAO.delete(bDTO);
		return "redirect:/main";
	}
}
