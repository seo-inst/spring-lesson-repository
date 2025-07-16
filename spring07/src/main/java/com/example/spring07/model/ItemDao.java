package com.example.spring07.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

/**
 *    final field 에 DataSource type 을 선언하고 
 *    constructor injection DI 을 통해  dbcp 를 스프링 컨테이너로부터 주입 받는다 
 */
@Repository
public class ItemDao {
	private final DataSource dataSource;
	
	public ItemDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public String findItemById(String id) throws SQLException {// 실제 db 연동 안함
		Connection con=dataSource.getConnection(); // dbcp 로부터 빌려온다
		System.out.println(con.getClass());//dbcp 로부터 빌려온 컨넥션 확인 
		con.close(); // dbcp 에 반납한다 
		return id+" 아이템 정보";
	}
}














