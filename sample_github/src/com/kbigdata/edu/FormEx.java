package com.kbigdata.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/FormEx")
public class FormEx extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernm = request.getParameter("nm");
		String userid = request.getParameter("id");
		String userpw = request.getParameter("pw");
		System.out.println("사용자 입력한 이름 : " + usernm);
		System.out.println("사용자 입력한 아이디 : " + userid);
		System.out.println("사용자 입력한 비밀번호" + userpw);
		
//		지금부터 클라이언트 한테 텍스트를 html 형태로 보낼거야
//		그리고 형식은 utf-8로 할거야
		response.setContentType("text/html; charset=utf-8"); 

		PrintWriter out = response.getWriter();
//		response:  클라이언트한테 프린트하라는 것
//		out은 response한테 write 할 수 있는 놈
//		그런 놈한테 프린트 하라는 것은 client한테 프린트하라는 것
		out.print("<h1>이예빈<h1>");
		out.print("이름 : " + usernm + "<br>" );
		out.print("아이디 : " + userid + "<br>" );
		out.print("비밀번호 : " + userpw + "<br>" );
		out.print("<h1>로그인성공<h1>" );
		
		
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEx() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
