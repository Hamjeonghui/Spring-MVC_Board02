package test;

public class RemoteB implements Remote {
	public RemoteB() {
		System.out.println("B리모컨 생성완료");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("B: 소리 ++");
	}

	@Override
	public void volumeDown() {
		System.out.println("B: 소리 --");
	}

}
