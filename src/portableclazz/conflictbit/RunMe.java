package portableclazz.complicatebit;

import java.io.InputStream;

import javax.xml.bind.JAXBException;

import log.Logger;
import util.IOStreamUtil;
import util.JavaXmlBindUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);

	public static void main(String[] args) {
		InputStream io = IOStreamUtil.readFile("web.xml");
		Web web = null;
		try {
			web = (Web)JavaXmlBindUtil.getInstance().unMarShalXml(io, Web.class,Filter.class,FilterMap.class,Listener.class,Parameter.class,Servlet.class,ServletMap.class,WelcomeFile.class);
			print(web);
		} catch (JAXBException e) {
			logger.error(e.getMessage());
		} finally {
			System.out.println("Finished!");
		}

	}
	
	public static void print(Web web){
		if(web != null && web.getFilters() != null)
			System.out.println("We got " + web.getFilters().size() + " filters");
	}

}
