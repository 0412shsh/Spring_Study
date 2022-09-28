package com.home.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {

	public static void main(String[] args) {
		
		//MessageBean 객체를 사용해서 인사메세지 출력 
		// => HelloApp객체는 MessageBean 객체를 필요로함
		// => HelloApp객체는 MessageBean 객체에 의존하고 있다. 
		// HelloApp <-> MessageBean 객체는 의존관계에 있다. 
		
		//HelloApp - 결합도 - MessageBean
		//           높음 => 직접 객체를 생성함
		//MessageBean 객체를 사용해서 인사메세지 출력 
		MessageBeanKr mb = new MessageBeanKr();
		mb.sayHello("SEOSEO"); //String name 입력 받고, sayHello 메서드 사용 
		
		System.out.println("=========================================");
		
		//MessageBeanKr 객체
		MessageBeanKr mbk = new MessageBeanKr();
		mbk.sayHello("랄라"); 
		
		//MessageBeanEn 객체
		MessageBeanEn mbe = new MessageBeanEn();
		mbe.sayHello("룰루");
		
		
		// 다형성 -> 결합도 중간
		// 상속받은 인터페이스 객체를 업캐스팅을 통해 객체 생성 -> 객체를 직접 생성하는 것보다 결합도 낮음
		// Action 인터페이스에다가 new OOO한거랑 같음
		// 객체는 MessageBean이라고 불리지만 실제는 MessageBeanKr이 들어 있음 
		// 건너건너 객체에 접근 
		MessageBean mbk1 = new MessageBeanKr();
		mbk1.sayHello("묭묭");
		
		//Spring(IoC) => 결합도 낮음
		//직접적인 객체 생성 하지 않음 , 객체를 받아온다(Spring)
		//Spring에서 객체를 받아오려면, Spring형태의 객체를 만들어야함 
		
		//beans.xml 파일에서 객체(bean)를 생성했음
		// => 빈을 불러오기(파일을 불러오기) 
		//BeanFactory는 인터페이스라 객체 생성 불가, 하위 객체 하나 만들어 줄거
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
		
		System.out.println("factory : "+factory); //콘솔확인
		
		//kr 객체가 필요하다 -> 쇼핑몰(Spring)에서 사오기(xml에서 받아오기) , 빈=객체를 가져옴(IoC)
		//다운캐스팅
		//MessageBeanKr mbk2 = (MessageBeanKr)factory.getBean("mb"); 권장 X
		
		//인터페이스의 객체로 변경 시킴 => 결합도를 더 떨어트리기
		//MessageBean mbk2 = (MessageBeanKr)factory.getBean("mb"); //권장 O
		
		//형변환하지 않아도됨 mb라는 이름의 객체를 가져올건데, MessageBean()이라는 형태로 맞춰서 가져와달라 => 다운캐스팅 필요X (.class의미)
		//mbk2.sayHello("쇼핑몰(Spring)에서 산 객체");
		
		//의존성 주입(만들어진걸 가져와서 넣는것, 객체를 생성해서 가져오는 것)
		MessageBean mbk2 = factory.getBean("mb",MessageBean.class);
		mbk2.sayHello("쇼핑몰(Spring)에서 산 객체");
		
		
		
		
		
		
				
	}

}
