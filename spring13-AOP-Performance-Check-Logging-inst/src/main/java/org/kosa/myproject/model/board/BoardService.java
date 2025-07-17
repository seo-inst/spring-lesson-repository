package org.kosa.myproject.model.board;

import org.springframework.stereotype.Service;

@Service
public class BoardService {
	public String find() {
		try {
			Thread.sleep(100);//0.1초 소요
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("core find post");
		return "게시물 정보";
	}
	public String findAllList() {
		try {
			Thread.sleep(700);//0.7초 소요
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("core findList post");
		return "게시물 리스트 정보";
	}
}









