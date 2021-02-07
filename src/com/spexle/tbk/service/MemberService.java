/**
 * 
 */
package com.spexle.tbk.service;

import java.util.ArrayList;

import com.spexle.tbk.dao.MemberDAO;
import com.spexle.tbk.vo.ContactVO;
import com.spexle.tbk.vo.MemberVO;


/**
 * @작성자 이예빈
 * @작성일 2021. 2. 7.
 * @파일명 MemberService.java
 * @package_name com.spexle.tbk.service
 * @description
 * 각 메뉴별로 실행되는데 필요한 도구 
 */
public class MemberService {
	
	/**
	  * @description: 이름 검색
	  * @Method:selectCnm
	  */
	public String selectCnm(String name) {
		return name;
	}
	
	/**
	  * @description: 전체조회
	  * @Method:selectAll
	  */
	public ArrayList<MemberVO> selectAll(){
		ArrayList<MemberVO> members = new MemberDAO().selectAll();
		
		return members;
	}
	
	/**
	  * @description: 아이디와 비밀번호 조회
	  * @Method:selectByIdPw
	  */
	public MemberVO selectByIdPw(String id, String pw) {
		MemberVO member = new MemberDAO().selectByIdPw(id, pw);
		return member;
	}
	
	/**
	  * @description: 멤버추가
	  * @Method:insertMember
	  */
	public void insertMember(MemberVO member) {
		MemberDAO mDao = new MemberDAO();
		mDao.insertMember(member);
	}

	/**
	  * @description: 아이디 조회
	  * @Method:selectById
	  */
	public MemberVO selectById(String id) {
		MemberVO member = null;
		MemberDAO mDao = new MemberDAO();
		member = mDao.selectById(id);
		
		return member;
	}
	
	/**
	  * @description: 멤버 수정 (CONTACT)
	  * @Method:updateMember
	  */
	public void updateMember(ContactVO contact) {
		MemberDAO mDao = new MemberDAO();
		mDao.updateMember(contact);
	}
	
	/**
	  * @description: 멤버삭제(CONTACT)
	  * @Method:deleteMember
	  */
	public void deleteMember(ContactVO contact) {
		MemberDAO mDao = new MemberDAO();
		mDao.deleteMember(contact);
	}
}
