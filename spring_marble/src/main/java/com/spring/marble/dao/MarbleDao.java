package com.spring.marble.dao;

import java.util.ArrayList;
import java.util.Map;

import com.spring.marble.dto.MemberVO;
import com.spring.marble.dto.UserParam;

public interface MarbleDao {
	public void joinMemberDao(String id, String password, String email);
	public void joinDiceDao(String id);
	public MemberVO loginDao(String id, String password);
	public ArrayList<UserParam> listDao();
	public UserParam selectOneById(String id);
	public void updateDao(Map<String, Object> param);
}
