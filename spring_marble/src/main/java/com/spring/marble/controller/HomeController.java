package com.spring.marble.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.marble.dao.MarbleDao;
import com.spring.marble.dto.JoinParam;
import com.spring.marble.dto.LoginParam;
import com.spring.marble.dto.MemberVO;
import com.spring.marble.dto.UserParam;
import com.spring.marble.exception.LoginException;
import com.spring.marble.service.MableService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MableService marbleService;
	
	@Autowired
	private SqlSession sqlSession;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
	
	@RequestMapping("/joinView")
	public String joinView() {
		return "/join";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(@ModelAttribute JoinParam param, Model model) {
		MemberVO member = marbleService.join(param);
		model.addAttribute("user", member);
		return "welcome";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "/welcome";
	}
	
	@RequestMapping("/loginView")
	public String loginView() {
		return "/login";
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute LoginParam param, HttpServletRequest request,  Model model) {		
		
		try {
			MemberVO member = marbleService.login(param);
			HttpSession session = request.getSession();
	 		session.setAttribute("user", member);
			return "redirect:main";
		} catch (LoginException e) {
			model.addAttribute("error", e.getMessage());
			return "/login";
		}
		
	}
	
	@RequestMapping("/marble")
	public String marble(Model model) {
		return "/marble";
	}
	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@RequestBody UserParam param) {
		marbleService.update(param);
		return "update success";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		MarbleDao dao = sqlSession.getMapper(MarbleDao.class);
		model.addAttribute("list", dao.listDao());
		
		return "/list";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/main";
	}
}
