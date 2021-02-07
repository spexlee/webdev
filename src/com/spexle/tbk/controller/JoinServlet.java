package com.spexle.tbk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spexle.tbk.service.MemberService;
import com.spexle.tbk.vo.MemberVO;


@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		회원가입 화면 이동
		response.setCharacterEncoding("utf-8");
		request.setAttribute("msg", "아이디와 비밀번호는 필수입력사항입니다.");
		RequestDispatcher disp = request.getRequestDispatcher("joinForm.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		회원가입 처리 : insert
//		request에서 입력한 데이터 추출 => 서비스단 => DAO 단, 그리고 dao단에서  insert처리
//		vo에 담아서 넘기면 됨 (dao단부터 만드는게 바람직)
		//request의 encoding 처리 필요 : 한글 깨짐 방지
	    request.setCharacterEncoding("utf-8");
	    
		MemberVO member = new MemberVO();
		member.setName(request.getParameter("name")); 
		member.setId(request.getParameter("id")); 
		member.setPw(request.getParameter("pw"));
		member.setPhone1(request.getParameter("phone1"));
		member.setPhone2(request.getParameter("phone2"));
		member.setPhone3(request.getParameter("phone3"));
		
		request.setAttribute("member", member); // 이 값을 다시 화면에 넣기 위해 request에 다시 담음
		
		if(member.getId().equals("") || member.getPw().equals("")) {
			doGet(request, response); // 아이디, 비밀번호가 없을 경우에 다시 회원가입 폼으로 가게 됨
			
//			request.setAttribute("msg", "아이디와 비밀번호는 필수 입력사항입니다.");
//			request를 살리기 위해서는 forwarding 해야 함 redirect말고

//			doGet(request, response); // 바로 sendredirect로 다른 곳으로 넘어갈 수 있음
//			doGet도 그냥 메소드일 뿐이다.
		}else {
//			insert 회원가입 코드                           
			MemberService mSrv = new MemberService();
			mSrv.insertMember(member); // member를 집어넣어주는 insert문
			response.sendRedirect("MainServlet");
			
		}
	}

}
