package com.example.spring07;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.spring07.model.ItemService;

@SpringBootApplication
public class Spring07Application implements CommandLineRunner{

	
	
	public static void main(String[] args) {
		SpringApplication.run(Spring07Application.class, args);
	}
	private final ItemService itemService;
	public Spring07Application(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner 실행");
		String itemInfo = itemService.findItemById("1");
	    System.out.println(itemInfo);
	}
}
















