package polymorphism.coupling;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //id는 tv로
public class SamsungTV implements TV {
	
	/*
	@Autowired	//property constructor-arg 처럼 초기화 시켜주는 문장이다.
	//객체 타입으로 찾는다.
	@Qualifier("apple") //이름으로 찾는다. @Autowired와 같이 묶어서 사용
	//구현 클래스가 여러개라면 선택을 해야 하는데 이름을 지정할 수 있다.
	*/	
	
	@Resource(name="apple") // 그냥 리소스만 사용하면 @Autowired 와 같다. 여기선 name을 사용	
	private Speaker speaker;	//필드(멤버변수) = 속성(property)
	private int price;
	private List<String> program;
	
	//List set,get	
	public List<String> getProgram() {
		return program;
	}
	public void setProgram(List<String> program) {
		this.program = program;
	}
		
	//Speaker set,get
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//생성자 
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println("SamsungTV 생성자 호출 - 인수 2");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("SamsungTV 생성자 호출 - 인수 1");
		this.speaker = speaker;
	}
	public SamsungTV() {
		System.out.println("SamsungTV 생성자 호출");
	}
	
	
	public void initMethod() {
		System.out.println("초기화 메서드 호출");
	}
	public void destroyMethod() {
		System.out.println("종료 메서드 호출");
	}
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
