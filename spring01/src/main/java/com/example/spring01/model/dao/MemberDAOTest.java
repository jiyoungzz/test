package com.example.spring01.model.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.logging.LoggerFactory;

import com.example.spring01.model.dto.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class MemberDAOTest {
	private static final Logger logger= LoggerFactory.getLogger(MemberDTATest.class);
	
	@Inject
	MemberDAO memberDao;
	
	@Test
	public void testList() {
		logger.info("회원목록:" + memberDao.list());
	}

	@Test
	public void testInsert() {
		MemberDTO dto=new MemberDTO();
		dto.setUserid("kim2");
		dto.setPasswd("1234");
		dto.setName("김철수");
		dto.setEmail("kim@naver.com");
		memberDao.insert(dto);
	}

	@Test
	public void testDetail() {
		logger.info("dto:"+ memberDao.detail("kim2"));
	}

	@Test
	public void testDelete() {
		memberDao.delete("kim2");
	}

	@Test
	public void testUpdate() {
		MemberDTO dto=new MemberDTO();
		dto.setUserid("kim2");
		dto.setPasswd("2222");
		dto.setName("김철호");
		dto.setEmail("kim@daum.net");
		memberDao.update(dto);
	}

	@Test
	public void testCheck_passwd() {
		logger.info("비밀번호 체크:"+ memberDao.check_passwd("kim2", "1234"));
		logger.info("비밀번호 체크:"+ memberDao.check_passwd("kim2","2222"));
	}

}
