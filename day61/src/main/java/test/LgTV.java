package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv") // <bean class="test.LgTV" id="tv" />   LgTV tv=new LgTV();
public class LgTV implements TV {
	@Autowired // 멤버변수,메서드 모두 사용가능 + 해당 멤버변수의 타입만으로 주입가능!
	private Remote remote;
	private int tvid;
	public LgTV() { // @ : 기본생성자가 필요!
		System.out.println("LgTV 객체생성");
	}
	public LgTV(Remote remote) {
		// 생성자를 통해 의존관계에있는 객체를 주입
		// ★ 생성자 주입(생성자 인젝션)
		System.out.println("LgTV 객체생성22");
		this.remote=remote;
	}
	public LgTV(Remote remote,int tvid) {
		System.out.println("LgTV 객체생성333");
		this.remote=remote;
		this.tvid=tvid;
	}
	public void powerOn() {
		System.out.println("전원 ON tvid: "+tvid);
	}
	public void powerOff() {
		System.out.println("전원 OFF tvid: "+tvid);
	}
	public void volumeUp() {
		remote.volumeUp();
	}
	public void volumeDown() {
		remote.volumeDown();
	}
}
