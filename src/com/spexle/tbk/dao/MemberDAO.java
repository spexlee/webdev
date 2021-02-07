/**
 * 
 */
package com.spexle.tbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.spexle.tbk.vo.ContactVO;
import com.spexle.tbk.vo.MemberVO;


/**
 * @작성자 이예빈
 * @작성일 2021. 2. 7.
 * @파일명 MemberDAO.java
 * @package_name com.spexle.tbk.dao
 * @description 
 * id에 해당하는 레코드 조회하기
 * 전부 조회하기
 * 회원정보에 해당하는 정보로 수정하기
 * 데이터 추가하기
 */
public class MemberDAO {
//	공통기능인 Connection을 처리함 => 원래는 class로 빠지는 것이 바람직함 => DBConnection.java
	   
  /**
  * @description: 모든 회원 검색
  * @Method:selectAll
  */
public ArrayList<MemberVO> selectAll(){
     Connection con         = null;
     PreparedStatement pstmt = null;
     ResultSet rs          = null;
     DBConnection dbCon       = null;
     
     ArrayList<MemberVO> members = new ArrayList<MemberVO>();
     String query = "select * from member";
     
     try {
        dbCon = DBConnection.getInstance();
        con = dbCon.getConnection();
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        while(rs.next()) {
           MemberVO member = new MemberVO();
           member.setName(rs.getString("name"));
           member.setId(rs.getString("id"));
           member.setPw(rs.getString("pw"));
           member.setPhone1(rs.getString("phone1"));
           member.setPhone2(rs.getString("phone2"));
           member.setPhone3(rs.getString("phone3"));
           
           members.add(member);
        }
        
     }catch(Exception e) {
        e.printStackTrace();
     }finally {
        dbCon.close(con, pstmt);
     }
     return members;
  }
  
  
	 /**
	  * @description: 로그인 처리(아이디와 비밀번호 기입)
	  * @Method:selectByIdPw
	  */
	public MemberVO selectByIdPw(String id, String pw) {
		 Connection con			= null;
		 PreparedStatement pstmt = null;
		 ResultSet rs			= null;
		
		 MemberVO member = new MemberVO();
		 StringBuilder query = new StringBuilder();
		 query.append("SELECT name, id 			");
		 query.append("  FROM member 			");
		 query.append(" WHERE id = ? 			");
		 query.append("  AND pw = ? 			");
		 
//		 String query = "SELECT name, id FROM member WHERE id = ? AND pw = ?"; 
//		  쿼리문이 길 경우는 Stringbuilder로 나누는 것이 필요
		 
		 DBConnection dbCon = DBConnection.getInstance(); //생성되어서 나옴
		 
		try {
			con = dbCon.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw); // 여기까지 실행이 됨
			rs = pstmt.executeQuery();
			if(rs.next()) { //next가 안될 경우가 있기 때문에 (이게 없으면 NullPointException이 뜰 수 도 있음)
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { //rs는 따로 닫아야 함
					rs.close();
				}
				dbCon.close(con, pstmt);
			} catch (Exception e) {
				
			}
		}
		 return member;
	 }
	   
	   /**
	  * @description: close
	  * @Method:close
	  */
	public void close(Connection con, PreparedStatement pstmt) {
		   try {
			   if(pstmt != null) {
				   pstmt.close();
			   }
			   if(con != null) {
				   con.close();
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }

		/**
		  * @description: 회원추가 메소드
		  * @Method:insertMember
		  */
	   public void insertMember(MemberVO member) {
		   Connection con			= null;
		   PreparedStatement pstmt = null;
//		   ResultSet는 필요 없음 => insert만 할 것이기 때문
		   String query = "INSERT INTO member VALUES(?,?,?,?,?,?)";
		   
		   DBConnection dbCon = DBConnection.getInstance();
		   
		   try {
			   con = dbCon.getConnection();
			   pstmt = con.prepareStatement(query);
			   pstmt.setString(1, member.getName()); //db sql의 순서대로 넣어야 함
			   pstmt.setString(2, member.getId());
			   pstmt.setString(3, member.getPw());
			   pstmt.setString(4, member.getPhone1());
			   pstmt.setString(5, member.getPhone2());
			   pstmt.setString(6, member.getPhone3());
			   
			   pstmt.executeUpdate();
			   // 결과 안받고 끝냄 (void 처리 => return하는 값이 필요 없기 때문)
			   
		   } catch (Exception e) {
			   e.printStackTrace();
		   }finally {
			   dbCon.close(con, pstmt);
		   }
	   }

		/**
		  * @description: 아이디 검색
		  * @Method:selectById
		  */
		public MemberVO selectById(String id) {
			Connection con 			= null;
			PreparedStatement pstmt = null;
			ResultSet rs			= null; // select 하기 때문에 resultset이 필요
			MemberVO member			= null;
			DBConnection dbCon		= DBConnection.getInstance(); // 이 방식이 springFrameWork 방식임

			String query = "SELECT * FROM member WHERE id = ?";
			
			try {
				con = dbCon.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					member = new MemberVO();
					member.setName(rs.getString("name"));
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setPhone1(rs.getString("phone1"));
					member.setPhone2(rs.getString("phone2"));
					member.setPhone3(rs.getString("phone3"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					dbCon.close(con, pstmt);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return member;
		}

		/**
		  * @description:수정
		  * @Method:updateMember
		  */
		public void updateMember(ContactVO contact) {
//			memberDao에 있는 놈들을 update처리 하면 됨
			Connection con			= null;
			PreparedStatement pstmt = null;
			DBConnection dbCon		= DBConnection.getInstance();
			
			StringBuilder query = new StringBuilder();
			query.append("update contact	");
			query.append("  SET name = ? 	");
			query.append("   , phone1 = ?	");
			query.append("   , phone2 = ?	");
			query.append("   , phone3 = ?	");
			query.append(" WHERE id = ? 	");

			try {
				con = dbCon.getConnection();
				pstmt = con.prepareStatement(query.toString());
				pstmt.setString(1, contact.getName()); //mem이 파라미터로 들어왔기 때문
				pstmt.setString(2, contact.getPhone1());
				pstmt.setString(3, contact.getPhone2());
				pstmt.setString(4, contact.getPhone3());
				pstmt.setString(5, contact.getId());
				
				pstmt.getUpdateCount();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void deleteMember(ContactVO contact) {
			Connection con			= null;
			PreparedStatement pstmt = null;
			DBConnection dbCon		= DBConnection.getInstance();
			
			StringBuilder query = new StringBuilder();
			query.append("DELETE FROM contact	");
			query.append(" WHERE id = ?			");
			
			try {
				con		= dbCon.getConnection();
				pstmt	= con.prepareStatement(query.toString());
				pstmt.setString(1, contact.getId());
				
				pstmt.getUpdateCount();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
