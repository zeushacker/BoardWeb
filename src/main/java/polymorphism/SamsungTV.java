package polymorphism;

// 결합도 : 하나의 클래스가 다른 클래스와 얼마나 많이 연결되어 있는지를 나타내는 표현

public class SamsungTV  implements TV {

	private Speaker speaker;
	private int price;
	
	
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("====> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("====> setPrice() 호출");
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("===> Samsung(1) 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		   System.out.println("====> SamsungTV(2) 객체 생성.... ");
		   this.speaker=speaker;
	}
	
	public SamsungTV(Speaker speaker, int price ) {
		   System.out.println("====> SamsungTV(3) 객체 생성.... ");
		   this.speaker=speaker;
		   this.price=price;
	}
	
	
	
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리 .....");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제전에 처리할 로직 처리 ......");
	}
	
	
	
	public void powerOn() {
		System.out.println("SamsungTV 전원을 켠다......");
	}
	
	public void powerOff() {
		//System.out.println("SamsungTV 전원을 끈다......");
		System.out.println("Samsung TV   (가격 : "+price+")");
	}
	
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV -- 소리 올린다......");
	}
	
	public void volumeDown() {
		//speaker = new SonySpeaker();
		speaker.volumeDown();
		//System.out.println("SamsungTV -- 소리 내린다......");
	}
	
	
	
}
