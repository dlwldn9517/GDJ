package com.gdu.app06.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdu.app06.domain.BoardDTO;


@Repository		// DAO가 사용하는 @Component == @configuration, @bean
public class BoardDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void close() {
		try {
			if(rs != null) { rs.close(); }
			if(ps != null) { ps.close(); }
			if(con != null) { con.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 레파지토리 계층의 이름은 "DB 친화적으로" 작성
	   
	public List<BoardDTO> selectAllBoards() {
		List<BoardDTO> boards = new ArrayList<BoardDTO>();
	      
		return boards;
	}
	   
	public BoardDTO selectBoardByNo(int board_no) {
		BoardDTO board = null;
	      
		return board;
	}
	   
	public int insertBoard(BoardDTO board) {
		int result = 0;
      
		return result;
	}
   
	public int updateBoard(BoardDTO board) {
		int result = 0;
      
		return result;
	}
   
	public int deleteBoard(int board_no) {
		int result = 0;
      
		return result;
	}

}
