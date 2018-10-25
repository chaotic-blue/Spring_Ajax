package polymorphism.coupling;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");			
		
		TV tv = (TV)factory.getBean("samsungTV"); //팩토리에서 bean으로 등록된 모든것을 관리 해준다.
		/*TV tv2 = (TV)factory.getBean(SamsungTV.class);*/
		
		tv.powerOn();
		tv.volumeUp();
		
		System.out.println(((SamsungTV)tv).getProgram());
	}
}
