package portableclazz.movemore;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import log.Logger;
import util.IOStreamUtil;
import util.JavaXmlBindUtil;

public class RunMe {
	private static Logger logger = Logger.getLogger(RunMe.class);
	public static void main(String[] args) {
		InputStream is = IOStreamUtil.readFile("Company.xml");
		try {
			Company company = (Company) JavaXmlBindUtil.getInstance().unMarShalXml(is, Company.class,Branch.class,Staff.class);
			
			print(company);
		} catch (JAXBException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void print(Company company){
		logger.info("-Company Name: " + company.getName());
		logger.info("-Website: " + company.getWebsite());
		logger.info("-CEO: " + company.getCeo());
		logger.info("-Estabilish Time: " + company.getEstabilishTime().toString());
		logger.info("-BRANCHS");
		List<Branch> branchs = company.getBranchs();
		if(branchs != null && branchs.size() > 0){
			for (int j = 0; j < branchs.size(); j++) {
				Branch branch = branchs.get(j);
				logger.info("--Branch name:" + branch.getName() + " And manager is: " + branch.getManager());
				List<Staff> staffs = branch.getStaffs();
				if(staffs != null && staffs.size() > 0){
					for (int i = 0; i < staffs.size(); i++) {
						Staff staff = staffs.get(i);
						staff.speak();
					}
				}
			}
		}
	}

}
