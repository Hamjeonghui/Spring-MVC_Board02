package test;

public class BeanFactory {
	// Factory 패턴: 객체 생성을 캡슐화하여 결합을 약하게 만듦
	// -> 객체생성로직을 캡슐화할 메서드
	public Object getBean(String beanName) {
		if(beanName.equals("lg")) {
			return new LgTV();
		}
		else if(beanName.equals("samsung")) {
			return new SamsungTV();
		}
		return null;
	}
}
