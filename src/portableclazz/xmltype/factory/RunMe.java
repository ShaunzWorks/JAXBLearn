package portableclazz.xmltype.factory;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import log.Logger;
import util.IOStreamUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);
	public static void main(String[] args) {
		unmarshal();
	}
	
	public static void unmarshal(){
		InputStream is = IOStreamUtil.readFile("User_xmltype2.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			User user = (User) unmarshaller.unmarshal(is);
			
			user.say();
		} catch (JAXBException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
