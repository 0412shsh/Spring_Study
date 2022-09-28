package com.home.test;

public class MessageBeanKr implements MessageBean {
	//특정 메세지 출력 객체
	
	public void sayHello(String name) {
		System.out.println("안녕~ "+name);
	}
	//이름을 매개변수로 받고 Hello~ 와 함께 name 출력
	//MessageBean 인터페이스를 구현하는 클래스, sayHello() 오버라이딩
}
