package com.spexle.tbk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spexle.tbk.service.MemberService;
import com.spexle.tbk.vo.MemberVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	/**
	 * 주소창으로 들어오는 것은 GET 방식!
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		1. 로그인 여부 확인
//		1.1 Session 확인 => 로그인 후에 이름, 아이디 => Session 저장
		HttpSession session = request.getSession(); 
		// request에 session이 담겨있기 때문에 이 곳에서 session을 꺼낸다.
		String id	= (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
//		getAttribute하게되면 object 타입으로 나오기 때문에 강제형변환 해야 함
		
//		session에 없다는 것은 로그인을 하지 않았다는 의미
		if(id == null || name == null) {
			response.sendRedirect("LoginServlet");// get 방식으로 전달됨
//			SendRedirect하게 되면 그 밑의 명령어는 실행X
		}else {
//			2. 로그인이 되어 있는 경우
//			2.1 main.jsp에 전달할 데이터 생성 => request에 담아야 함
//			회원목록(MemberVO) 목록(ArrayList)
			MemberService mSrv = new MemberService();
			ArrayList<MemberVO> members = mSrv.selectAll();
			
//			request에 members를 담는다
			request.setAttribute("members", members);
			
//			2.2 main.jsp 포워딩
//			RequestDispatcher => request를 보낸다는 의미로, " "안 으로 보내겠다.
//			그렇기 때문에 request에 담아서 보냄 => main.jsp 로 보내는 것
			RequestDispatcher disp = request.getRequestDispatcher("Main.jsp");
			disp.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
