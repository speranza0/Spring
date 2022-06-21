package com.spring.marble.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.marble.dao.MarbleDao;
import com.spring.marble.dto.JoinParam;
import com.spring.marble.dto.LoginParam;
import com.spring.marble.dto.MemberVO;
import com.spring.marble.dto.UserParam;
import com.spring.marble.excrption.LoginException;

@Service
public class MableService {

	@Autowired
	private SqlSession sqlSession;
	
	public MemberVO login(LoginParam param) {
		MarbleDao dao = sqlSession.getMapper(MarbleDao.class);
		MemberVO member = dao.loginDao(param.getId());
		
		if(member == null) {
			throw new LoginException("아이디가 없습니다.");
		}
		
		if(!param.getPassword().equals(member.getPassword())) {
			throw new LoginException("비밀번호가 잘못되었습니다.");
		}
		
		return member;
		
	}

	@Transactional
	public MemberVO join(JoinParam param) {
		MarbleDao dao = sqlSession.getMapper(MarbleDao.class);
		dao.joinMemberDao(param);
		dao.joinDiceDao(param.getId());
		MemberVO member = dao.loginDao(param.getId());
		return member;
	}

	public void update(UserParam param) {
		MarbleDao dao = sqlSession.getMapper(MarbleDao.class);
		UserParam updateUser = dao.selectOneById(param.getId());
		
		updateUser.setDicesum(updateUser.getDicesum() + param.getDicesum());
		updateUser.setDicecount(updateUser.getDicecount() + 1);
		updateUser.setRoundnum(updateUser.getRoundnum() + param.getRoundnum());
		dao.updateDao(updateUser);
	}
}
