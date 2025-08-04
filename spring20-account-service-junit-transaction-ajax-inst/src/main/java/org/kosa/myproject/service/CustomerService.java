package org.kosa.myproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 비즈니스 계층 , Service Layer , 업무정의(작업단위) , 트랜잭션 처리 
@Transactional // AOP 기반 트랜잭션 처리 : 문제 발생시 자동 롤백, 정상 수행 커밋
public class CustomerService {

}
