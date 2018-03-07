package portableclazz.anyelement;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.w3c.dom.Element;

import log.Logger;
import util.IOStreamUtil;
import util.JavaXmlBindUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);
	public static void main(String[] args) {
		try {
			Foo foo = (Foo)JavaXmlBindUtil.getInstance().unMarShalXml(IOStreamUtil.readFile("AnyElement.xml"), Foo.class);
			List<Element> elements = foo.getAny();
			for (Element element : elements) {
				logger.info(element.getNodeName() + " : " + element.getTextContent());
			}
		} catch (JAXBException e) {
			logger.error(e);
		}
	}
	
}
