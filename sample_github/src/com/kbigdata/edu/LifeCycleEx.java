package com.kbigdata.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleEx
 */
@WebServlet("/LifeCycleEx")
public class LifeCycleEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleEx() {
        super();
        System.out.println("생성자가 호출되었다.");
        
    }
    
    @Override
    public void init() throws ServletException {
//    	super.init(); // super가 HttpServlet 상속받은 것을 의미함
    	System.out.println("init이 호출되었다.");
//    	호출되었다면 위 문구가 출력될 것임
    }
    
    @Override
    public void destroy() {
//    	super.destroy();
    	System.out.println("destory 호출되었다."); 
//    	주로 close할 때 사용됨
//    	회사 전체를 관리하는 사장(was)이 사원을 뽑는(new)도 함
//    	그 사장이 오늘 매장 마감한다고 말안하고 나가면 직원은 끝났는지 모름
//    	몇 시되면 나가라고 정해야 함 즉, 각각 종료시키는 것이 중요함
//    	WAS가 stop되어야지 이 메소드가 실행됨
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet이 호출되었다.");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doPost가 호출되었다.");
	}
	
	

}
