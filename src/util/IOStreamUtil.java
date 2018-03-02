package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import log.Logger;

public class IOStreamUtil {
	private static Logger logger = Logger.getLogger(IOStreamUtil.class);
	
	public static InputStream readFile(String fileNm){
		File file = new File(getClazzPath()+"/xmls/" + fileNm);
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		return inputStream;
	}
	
	public static String getClazzPath(){
		return System.getProperty("user.dir");
	}

}
