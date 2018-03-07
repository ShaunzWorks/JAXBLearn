package portableclazz.anyelementNattribute;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

import log.Logger;
import util.IOStreamUtil;
import util.JavaXmlBindUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);
	public static void main(String[] args) {
		try {
			Foo foo = (Foo)JavaXmlBindUtil.getInstance().unMarShalXml(IOStreamUtil.readFile("AnyElement.xml"), Foo.class);
			List<Element> elements = foo.getAnyElement();
			logger.info("Other Elements:");
			for (Element element : elements) {
				logger.info(element.getNodeName() + " : " + element.getTextContent());
			}
			
			logger.info("Attributes:");
			Map<QName, String> attributes = foo.getAnyAttribute();
			Iterator<QName> attrKeys = attributes.keySet().iterator();
			while (attrKeys.hasNext()) {
				QName key = attrKeys.next();
				logger.info(key.toString() + " : " + attributes.get(key));
			}
		} catch (JAXBException e) {
			logger.error(e);
		}
	}
	
}
