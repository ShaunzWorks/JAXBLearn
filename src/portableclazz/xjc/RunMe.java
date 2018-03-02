package portableclazz.xjc;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import log.Logger;
import portableclazz.xjc.pojo.Dependency;
import portableclazz.xjc.pojo.Model;
import portableclazz.xjc.pojo.ObjectFactory;
import util.IOStreamUtil;
import util.JavaXmlBindUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);
	public static void main(String[] args) {
		InputStream is = IOStreamUtil.readFile("pom.xml");
		try {
			Model model = null;
			JAXBElement<Model> object = (JAXBElement<Model>)JavaXmlBindUtil.getInstance().unMarShalXml(is, ObjectFactory.class);
			model = object.getValue();
			print(model);
		} catch (JAXBException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void print(Model model){
		List<Dependency> dependencies = model.getDependencies().getDependency();
		for (int i = 0; i < dependencies.size(); i++) {
			logger.info(dependencies.get(i).getGroupId() + "-" + dependencies.get(i).getArtifactId());
		}
	}

}
