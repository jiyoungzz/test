package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.example.spring01.model.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO {
	//의존관계 주입
	@Inject
	SqlSession sqlSession;

	@Override
	public List<MemberDTO> list() {
		return sqlSession.selectList("member.list"); //auto close
	}

	@Override
	public void insert(MemberDTO dto) {
		sqlSession.insert("member.insert",dto); //auto commit
	}

	@Override
	public MemberDTO detail(String userid) {
		return sqlSession.selectOne("member.detail", userid);
	}

	@Override
	public void delete(String userid) {
		sqlSession.delete("member.delete", userid);
	}

	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}

	@Override
	public boolean check_passwd(String userid, String passwd) {
		boolean result=false;
		Map<String, String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count=sqlSession.selectOne("member.check_passwd", map);
		if(count==1) result=true;
		return result;
	}

}
