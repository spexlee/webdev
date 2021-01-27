package com.kbigdata.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp/EmpServlet") // 요청이들어오면 이라는 뜻
//	세부위치를 잘 설정해 놔야 함
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response); //get에서 post가 실행될 수 있음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // 인코딩 방식 설정 (post방식에서만 사용)
		
		String empno = request.getParameter("empno"); // empno라는 key값을 가져와라 => value를 가져옴
		String empnm = request.getParameter("empnm");
		String deptno =request.getParameter("deptno");
		String sex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby"); 
		// checkbox로 넘어온 경우 서버가 배열로 처리하기 때문에 getParameterValues를 받아야 한다.
		
//		한글을 출력하기 위해 형식 변경
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>사원등록 정보</h1>");
		out.println("사원번호 : " + empno);
		out.println("사원명 : " + empnm);
		out.println("부서번호 : " + deptno);
		out.println("성별 : " + sex);
		out.println("취미 : ");
//		배열의 경우 for문을 돌려야 함
		for(int i =0; i<hobby.length; i++) {
			out.print(hobby[i] + ", "); // hobby의 i번째 것을 출력해라
		}
		out.close();
//		서버로는 value가 넘어가는 것
		
		
		
	}

}
