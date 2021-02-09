package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// GenericXmlApplicationContext : 파일 시스템이나 클래스 경로에 있는 xml 설정파일을 
		           //  로딩하여 구동하는 컨테이너
		
		//  XMLWebApplicationContext : 웹 기반의 스프링 애플리케이션을 개발할때
		 // 사용하는 컨테이너임
		
		//TV tv = new SamsungTV();
		//BeanFactory factory = new BeanFactory();
		
		// 2. Spring 컨테이너로 부터 필요한 객체를 요청(lookup) 함
	/*	
		TV tv1 =  new SamsungTV();
		TV tv2 =  tv1;
		TV tv3 =  tv2;
	*/	
		// 하나의 객체만 생성해서 주소를 복사해서 재사용
		
		
		
		TV tv = (TV)factory.getBean("tv");
		//TV tv2 = (TV)factory.getBean("tv");
		//TV tv3 = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		/*
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
       */
		// 3. spring 컨테이너를 종료한다.
		factory.close();
	}

}
