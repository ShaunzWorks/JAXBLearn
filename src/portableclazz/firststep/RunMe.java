package portableclazz.firststep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import log.Logger;
import util.IOStreamUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);
	public static void main(String[] args) {
		marshal();
		unmarshal();
	}
	
	public static void unmarshal(){
		InputStream is = IOStreamUtil.readFile("User.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			User user = (User) unmarshaller.unmarshal(is);
			
			user.say();
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		}
	}
	
	public static void marshal(){
		User user = new User();
		user.name = "dengxiong";
		user.gender = "male";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			File file = new File(IOStreamUtil.getClazzPath()+"/xmls/AUser.xml");
			marshaller.marshal(user, new FileOutputStream(file));
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
	}

}
