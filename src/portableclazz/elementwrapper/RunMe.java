package portableclazz.elementwrapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import log.Logger;
import util.IOStreamUtil;
import util.JavaXmlBindUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);
	public static void main(String[] args) {
		marshal();
	}
	
	public static void marshal(){
		Map<String, Object> properties = new HashMap<String,Object>();
		properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("LykanHypersport","White"));
		cars.add(new Car("Lamborghini","Black"));
		cars.add(new Car("Maybach","Red"));
		User user = new User("LiSi", "Female", "NI HAO!", cars);
		File file = new File(IOStreamUtil.getClazzPath()+"/xmls/User_xmltype4.xml");
		try {
			JavaXmlBindUtil.getInstance().marShalBean(user, new FileOutputStream(file), properties, User.class,Car.class);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (JAXBException e) {
			logger.error(e);
		}
		
		
	}
	
}
