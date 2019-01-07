package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.BoardBean;

public class BoardDAO {
	public static BoardDAO instance;
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	//db연결
	public Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/board");
		return ds.getConnection();
	}
	
	//등록
	public void boardInsert(BoardBean bb) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into board values(board_seq.nextval,?,?,?,?,?,board_seq.nextval,0,0,0,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, bb.getBoard_name());
			ps.setString(2, bb.getBoard_pass());
			ps.setString(3, bb.getBoard_subject());
			ps.setString(4, bb.getBoard_content());
			ps.setString(5, bb.getBoard_file());
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			CloseOn(con,ps);
		}
	}
	//전체보기
	public ArrayList<BoardBean> boardList(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<BoardBean> arr = new ArrayList<>();
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from board";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardBean bb = new BoardBean();
				bb.setBoard_num(rs.getInt("board_num"));
				bb.setBoard_name(rs.getString("board_name"));
				bb.setBoard_pass(rs.getString("board_pass"));
				bb.setBoard_subject(rs.getString("board_subject"));
				bb.setBoard_content(rs.getString("board_content"));
				bb.setBoard_file(rs.getString("board_file"));
				bb.setre_ref(rs.getInt("re_ref"));
				bb.setre_lev(rs.getInt("re_lev"));
				bb.setre_step(rs.getInt("re_step"));
				bb.setBoard_readcount(rs.getInt("board_readcount"));
				bb.setBoard_date(rs.getString("board_date"));
				arr.add(bb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, st,rs);
		}
		return arr;
	}
	//상세보기
	public BoardBean boardView(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BoardBean bb = null;
		String sql = "";
		
		try {
			con = getConnection();
			st = con.createStatement();
			sql = "update board set board_readcount = board_readcount+1 where board_num = "+num;
			rs = st.executeQuery(sql);
			sql = "select * from board where board_num = "+num;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				bb = new BoardBean();
				bb.setBoard_num(rs.getInt("board_num"));
				bb.setBoard_name(rs.getString("board_name"));
				bb.setBoard_pass(rs.getString("board_pass"));
				bb.setBoard_subject(rs.getString("board_subject"));
				bb.setBoard_content(rs.getString("board_content"));
				bb.setBoard_file(rs.getString("board_file"));
				bb.setre_ref(rs.getInt("re_ref"));
				bb.setre_lev(rs.getInt("re_lev"));
				bb.setre_step(rs.getInt("re_step"));
				bb.setBoard_readcount(rs.getInt("board_readcount"));
				bb.setBoard_date(rs.getString("board_date"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseOn(con, st, rs);
		}
		return bb;
	}
	
	//닫는함수.
	public void CloseOn(Connection con , PreparedStatement ps) {
		try {
			if(con != null)con.close();
			if(ps != null)ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void CloseOn(Connection con , Statement st, ResultSet rs) {
		try {
			if(con != null)con.close();
			if(st != null)st.close();
			if(rs != null)rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
