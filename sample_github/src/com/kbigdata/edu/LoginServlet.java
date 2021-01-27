package com.kbigdata.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login") // form action이 login이기 때문에 login 을 넣어줌
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// method가 "get"이니까 doget에서 실행됨
		// request에 "hong"과 "1234"가 입력되는 것이 key value로서 변수에 저장됨
		String id = request.getParameter("id"); // id name에 들어올 값
		String pw = request.getParameter("pw"); // pw name에 들어올 값
		
		String result = "";
		if(id.equals("hong") && pw.equals("1234")) {
			result = "get 정상 로그인" ;
		}else {
			result = "get 아이디나 비밀번호가 틀렸습니다";
		}
		
		// 이 과를 client에 보내야 함 (보낼 경로를 표시)
		// 결과를 반환하는 것
		response.setContentType("text/html; charset=utf-8");
		PrintWriter client = response.getWriter();
		client.println(result);
		client.close();
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// method가 "post"니까 dopost에서 실행됨
				// request에 "hong"과 "1234"가 입력되는 것이 key value로서 변수에 저장됨
				String id = request.getParameter("id"); // id name에 들어올 값
				String pw = request.getParameter("pw"); // pw name에 들어올 값
				
				String result = "";
				if(id.equals("hong") && pw.equals("1234")) {
					result = "post 정상 로그인  ";
				}else {
					result = "post 아이디나 비밀번호가 틀렸습니다";
				}
				
				// 이 과를 client에 보내야 함 (보낼 경로를 표시)
				// 결과를 반환하는 것
				response.setContentType("text/html; charset=utf-8");
				PrintWriter client = response.getWriter();
				client.println(result);
				client.close();
	}

}
