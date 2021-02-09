package polymorphism;

public class LgTV   implements TV  {

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
		System.out.println("Lg TV 전원을 끈다. ....");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("Lg TV  소리 올린다.....");
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
