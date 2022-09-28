package com.home.web;

import org.junit.Before;
import org.junit.Test;

public class MysqlConnectTest {
	//테스트 클래스 : 서버를 사용해서 테스트하는 동작을 junit을 사용해서 대신 테스트하는 클래스
	
	//@Test : 테스트 동작을 수행하는 메서드에 사용 
	//        @Test가 있어야지만, junit 실행가능, 메서드는 있는데 @Test가 없으면 실행 X 
	
	//@Before : 테스트 작업전에 반드시 준비(실행)되어야하는 동작을 처리하는 어노테이션
	
	//테스트에서 JUnit 실행 순서 
	//@Before - @Test - @After
	
	//@Test
	@Before
	public void test() throws Exception {
		System.out.println("MysqlConnectTest - test() 호출");
		System.out.println("테스트 클래스 실행!!");
	}


	@Test
	public void 디비연결테스트() throws Exception {
		System.out.println("디비연결테스트() 수행");
	}
}
