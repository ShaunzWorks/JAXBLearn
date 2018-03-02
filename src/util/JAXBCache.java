package util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public final class JAXBCache {
	private static final JAXBCache instance = new JAXBCache();
	private final ConcurrentMap<String, JAXBContext> contextCache = new ConcurrentHashMap<String, JAXBContext>();
	
	private JAXBCache(){};
	
	public static JAXBCache getInstance(){
		return instance;
	}
	
	/**
	 * Return <code>JAXBContext</code> instance and cache it
	 * @param classes
	 * @return
	 * @throws JAXBException
	 */
	public JAXBContext getJAXBContext(Class<?>... classes) throws JAXBException{
		JAXBContext jaxbContext = contextCache.get(generateKey(classes));
		if(jaxbContext == null){
			jaxbContext = JAXBContext.newInstance(classes);
			contextCache.putIfAbsent(generateKey(classes), jaxbContext);
		}
		return jaxbContext;
	}
	
	private String generateKey(Class<?>... classes){
		StringBuffer key = new StringBuffer("");
		if(classes != null && classes.length > 0){
			for(Class<?> clazz : classes){
				key.append(cutPackageNm(clazz.getName()));
			}
		}
		return key.toString();
	}
	
	private String cutPackageNm(String name){
		if(name != null && name.length() > 0){
			int index = name.lastIndexOf(".");
			name = name.substring(index, name.length());
		}
		return name;
	}
}
