package portableclazz.xmllist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
		
		
		List<String> dataAsElement = new ArrayList<String>();
		dataAsElement.add("acd");
		dataAsElement.add("ffe");
		dataAsElement.add("ggj");
		
		List<String> dataAsValues = new ArrayList<String>();
		dataAsValues.add("acd");
		dataAsValues.add("ffe");
		dataAsValues.add("ggj");
		
		Foo foo = new Foo();
		foo.setDataAsElement(dataAsElement);
		foo.setDataAsValues(dataAsValues);
		
		File file = new File(IOStreamUtil.getClazzPath()+"/xmls/XmlList.xml");
		try {
			JavaXmlBindUtil.getInstance().marShalBean(foo, new FileOutputStream(file), properties, Foo.class);
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (JAXBException e) {
			logger.error(e);
		} finally {
			logger.info("Completed!");
		}
		
		
	}
	
}
