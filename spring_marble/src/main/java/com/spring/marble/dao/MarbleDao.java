package com.spring.marble.dao;

import java.util.ArrayList;

import com.spring.marble.dto.JoinParam;
import com.spring.marble.dto.MemberVO;
import com.spring.marble.dto.UserParam;

public interface MarbleDao {
	public void joinMemberDao(JoinParam param);
	public void joinDiceDao(String id);
	public MemberVO loginDao(String id);
	public ArrayList<UserParam> listDao();
	public MemberVO selectMemberById(String id);
	public UserParam selectOneById(String id);
	public void updateDao(UserParam param);
}
