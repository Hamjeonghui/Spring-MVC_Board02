package test;

public class SamsungTV implements TV {
	private Remote remote;
	private int tvid;
	public SamsungTV() {
		System.out.println("SamsungTV 객체생성");
	}
	
	public Remote getRemote() {
		return remote;
	}

	public void setRemote(Remote remote) {
		this.remote = remote;
	}

	public int getTvid() {
		return tvid;
	}

	public void setTvid(int tvid) {
		this.tvid = tvid;
	}
	// ★ setter 주입

	public void initMethod() {
		System.out.println("객체의 멤버변수들 초기화 작업");
	}
	public void destroyMethod() {
		System.out.println("객체 메모리 해제 작업");
	}
	@Override
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	@Override
	public void volumeUp() {
		remote.volumeUp();
	}
	@Override
	public void volumeDown() {
		remote.volumeDown();
	}
}
