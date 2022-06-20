package com.spring.marble.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.marble.dao.MarbleDao;
import com.spring.marble.dto.JoinParam;
import com.spring.marble.dto.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	
	@RequestMapping("/join")
	public String join(HttpServletRequest request, Model model) {
		MarbleDao dao = sqlSession.getMapper(MarbleDao.class);
		dao.joinMemberDao(request.getParameter("id"), request.getParameter("password"), request.getParameter("email"));
		dao.joinDiceDao(request.getParameter("id"));
		JoinParam param = new JoinParam(request.getParameter("id"), request.getParameter("password"), request.getParameter("email"));
		model.addAttribute("user", param);
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
	public String login(HttpServletRequest request, Model model) {
		MarbleDao dao = sqlSession.getMapper(MarbleDao.class);
		MemberVO member = dao.loginDao(request.getParameter("id"), request.getParameter("password"));
 		HttpSession session = request.getSession();
 		session.setAttribute("user", member);
		return "redirect:main";
	}
	
	@RequestMapping("/marble")
	public String marble(Model model) {
		return "/marble";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		MarbleDao dao = sqlSession.getMapper(MarbleDao.class);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		param.put("diceNumber", request.getParameter("diceNumber"));
		param.put("roundNum", request.getParameter("roundNum"));
		dao.updateDao(param);
		
		return "";
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
