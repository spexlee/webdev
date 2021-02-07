package com.spexle.tbk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spexle.tbk.service.MemberService;
import com.spexle.tbk.vo.MemberVO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		로그인 화면으로 이동
		response.sendRedirect("loginForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Select : 입력한 아이디와 비밀번호가 데이터베이스에 존재하는지 여부 확인
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberService mSrv = new MemberService();
		
		MemberVO member = mSrv.selectByIdPw(id, pw);
		
//		아이디가 있는가 없는가, 있으면 로그인 정상적
		if(member.getId() != null) { //null이 아닌경우로 하면 else를 할 필요가 없음(최적화 가능)
//			정상 로그인
//			1. Session에 이름과 아이디 추가
			HttpSession session = request.getSession();
			session.setAttribute("name", member.getName()); //이름을 집어넣음
			session.setAttribute("id", member.getId());
			
//			2. MainServlet으로 감
//			request에 담아서 보내도 됨(다른 방법!)
			response.sendRedirect("MainServlet");
		}else {
//			비정상 로그인
			response.sendRedirect("loginForm.jsp");
		}
	}

}
