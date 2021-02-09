package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@Autowired : 생성자, 메소드, 멤버변수일때 사용하는 어노테이션임

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV   implements TV  {

 	@Autowired// 자동주입
	// 변수의 타입을 기준으로 객체를 검색해서 의존성을 주입
	@Qualifier("apple")
	//@Resource(name="sony")// 객체의 이름을 사용하여 의존성을 주입처리함
	private Speaker speaker;
	
	// @Qualifier("apple") : 의존성이 주입될 객체나 아이디가 두개 이상일때 하나를 지정해서
	// 처리할수 있는 어노테이션
	
	
	
	public LgTV() {
	   System.out.println("===> Lg TV 객체 생성 .........");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("Lg TV 전원을 켠다. ....");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("Lg TV 전원을 끈다. ....");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		//System.out.println("Lg TV 전원을 끈다. ....");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		//System.out.println("Lg TV  소리 올린다.....");
		speaker.volumeDown();
	}

	/*
	public void turnOn() {
		System.out.println("Lg TV 전원을 켠다. ....");
	}
	
	public void turnOff() {
		System.out.println("Lg TV 전원을 끈다. ....");
	}
	
	public void soundUp() {
		System.out.println("Lg TV  소리 올린다.....");
	}
	
	public void soundDown() {
		System.out.println("Lg TV  소리 올린다.....");
	}
	*/
}
