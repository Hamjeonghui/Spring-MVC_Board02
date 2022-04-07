package test;

public class RemoteA implements Remote {
	public RemoteA() {
		System.out.println("A리모컨 생성완료");
	}
	public void volumeUp() {
		System.out.println("A: 소리 ++");
	}
	public void volumeDown() {
		System.out.println("A: 소리 --");
	}
}
