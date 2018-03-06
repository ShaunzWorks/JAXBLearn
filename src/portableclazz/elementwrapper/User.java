package portableclazz.elementwrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
	
	@XmlElementWrapper(name="cars")
	@XmlElement(name="car")
	private List<Car> cars;
	
	public void say(){
		logger.info(name + "("+gender+")" + " saying: " + message +" and I have:");
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			logger.info(car.getName() + "("+car.getColor()+")");
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public User(){}
	
	public User(String name,String gender,String message,List<Car> cars){
		this.name = name;
		this.gender = gender;
		this.message = message;
		this.cars = cars;
	}
	
	
}
