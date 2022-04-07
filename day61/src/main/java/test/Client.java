package test;

import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client { // 사용자,브라우저
	public static void main(String[] args) {
		// 0. Spring 컨테이너를 실행시킬때필요한 설정정보파일(==applicationContext.xml) 생성했기때문에 1번가능!
		// 1. Spring 컨테이너를 실행시킴
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. 스프링 컨테이너에게 객체요청
		/*
		TV tv=(TV)factory.getBean("tv"); // 객체를 요청하는 행위==Lookup
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		*/
		/*
		Test test=(Test)factory.getBean("test");
		Map<String,String> map=test.getMap();
		Iterator<String> itr=map.keySet().iterator();
		while(itr.hasNext()) {
			String key=itr.next();
			System.out.println(key+" : "+map.get(key));
		}
		*/
		
		TV tv=(TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		
		
		
		// 3. 컨테이너 연결해제
		factory.close();
		
		
		
		// 1. 다형성(인터페이스)
		/*
		TV tv=new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		*/
		
		// 2. 디자인 패턴 활용
		// Factory 패턴: 객체 생성을 캡슐화하여 결합을 약하게 만듦
		/*
		BeanFactory factory=new BeanFactory();
		TV tv=(TV)factory.getBean(args[0]);
		// ★ "new"라는 코드가 캡슐화되었기때문에,
		//  개발자가 객체생성을 직접하지않는다! 컨테이너가 대신함!!!
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		*/
	}
}
