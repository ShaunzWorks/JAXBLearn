package portableclazz.xmltype.nonanonymous;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import log.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="user")
public class User {
	private static Logger logger = Logger.getLogger(User.class);
	public String name;
	public String gender;
	@XmlElement(name="messages")
	private String message;
	
	private Car car;
	
	public void say(){
		logger.info(name + "("+gender+")" + " saying: " + message +" and my car is " + car.getName() + "("+  car.getColor() +")");
	}

	public Car getCar() {
		return car;
	}

	public void setCars(Car car) {
		this.car = car;
	}
	
	
}
