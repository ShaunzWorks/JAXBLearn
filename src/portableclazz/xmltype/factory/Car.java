package portableclazz.xmltype.factory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="car",factoryMethod="getNewInstance")
public class Car {
	@XmlElement(name="carNm")
	private String name;
	@XmlElement(name="carColor")
	private String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Car(){
		
	}
	
	public Car(String name,String color){
		this.name = name;
		this.color = color;
	}
	
	public static Car getNewInstance(){
		return new Car();
	}
	
	
}
