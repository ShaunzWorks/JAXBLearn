package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import log.Logger;

public class IOStreamUtil {
	private static Logger logger = Logger.getLogger(IOStreamUtil.class);
	public static InputStream readFile(String fileNm) {
		InputStream inputStream = null;
		try {
			String prePath = getClazzPath()+"/xmls/";
			inputStream = new FileInputStream(new File(prePath+fileNm));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return inputStream;
	}
	
	public static String getClazzPath(){
		//String clazzPath = System.getProperty("java.class.path", ".");
		String clazzPath = System.getProperty("user.dir", ".");
		return clazzPath;
	}

}