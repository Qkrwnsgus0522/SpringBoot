package test;

public class PhoneB implements Phone {

	@Override
	public void call(String name) { // 오버라이딩
		System.out.println("PhoneB : " + name + "이(가) 전화거는중...");
	}

}
