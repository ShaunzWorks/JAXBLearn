package portableclazz.SchemaGenerator;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import log.Logger;
import portableclazz.movemore.Branch;
import portableclazz.movemore.Company;
import portableclazz.movemore.Staff;
import util.IOStreamUtil;
import util.JavaXmlBindUtil;

public class SchemaGenerator {
	private static Logger logger = Logger.getLogger(SchemaGenerator.class);
	private static final String fileNm = "schema.xsd";
	
	public static void main(String[] args) {
		try {
			JavaXmlBindUtil.getInstance().generateSchema(new SchemaGenerator().new Resolver(), Company.class,Branch.class,Staff.class);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	class Resolver extends SchemaOutputResolver{
		private File file = new File(IOStreamUtil.getClazzPath()+"/schemas/"+fileNm);

		@Override
		public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
			StreamResult result = new StreamResult(file);
			result.setSystemId(file.toURI().toURL().toString());
			return result;
		}
		
	}
}
