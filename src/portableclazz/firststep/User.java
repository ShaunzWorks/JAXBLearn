package portableclazz.firststep;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import log.Logger;

@XmlRootElement(name="user")
public class User {
	private static Logger logger = Logger.getLogger(User.class);
	public String name;
	public String gender;
	@XmlElement(name="messages")
	private String message;
	
	public void say(){
		logger.info(name + "("+gender+")" + " saying: " + message);
	}
}
