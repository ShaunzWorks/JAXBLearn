package portableclazz.movemore;

import javax.xml.bind.annotation.XmlAttribute;

import log.Logger;

public class Staff {
	private static Logger logger = Logger.getLogger(Staff.class);
	@XmlAttribute(name="name")
	private String name;
	@XmlAttribute(name="gender")
	private String gender;
	@XmlAttribute(name="say")
	private String say;
	
	public void speak(){
		logger.info("---"+name+"("+gender+")" + "Speaking: " + say);
	}
}
