package org.kosa.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
/**
 * 	 final field 로  DataSource 를 선언 
 *  Constructor Injection 
 *  실제 DataSource 를 이용해 spring_member  table의  회원정보를 조회하여 회원 객체를 리턴한다 
 */
@Repository
public class MemberDao {
	private final DataSource dataSource;
	//@Autowired
	public MemberDao(DataSource dataSource) { // DI : Constructor Injection 
		super();
		this.dataSource = dataSource;
	}
	public MemberVo findMemberById(String id) throws SQLException {
		MemberVo memberVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();// DataSource 타입의 DBCP 구현체로부터 컨넥션을 빌려온다 
			String sql = "select id,password,name,address from spring_member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				memberVo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		} finally {
			closeAll(rs, pstmt, con);// DBCP 로부터 빌린 컨넥션을 반납한다 
		}
		return memberVo;
	}

	
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		closeAll(pstmt, con);
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close(); // 컨넥션을 소멸 시키는 것이 아니라 DBCP 에 컨넥션을 반납한다
	}
}
