package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;

import log.Logger;

public class JavaXmlBindUtil {
	private static Logger logger = Logger.getLogger(JavaXmlBindUtil.class);
	private final static JavaXmlBindUtil instance  = new JavaXmlBindUtil();
	
	private JavaXmlBindUtil(){};
	
	public static JavaXmlBindUtil getInstance(){
		return instance;
	}
	/**
	 * POJO to XML OutputStream
	 * @method marShallBean
	 * @param clazz POJO Class
	 * @param target POJO instance
	 * @param os XML OutputStream
	 * @param properties The properties for {@linkplain Marshaller}
	 * @throws JAXBException
	 */
	public void marShalBean(Object target,OutputStream os,Map<String, Object> properties,Class<?> ... classes)throws JAXBException{
		try {
			JAXBContext jaxbContext = getJAXBContext(classes);
			Marshaller marshaller = jaxbContext.createMarshaller();
			if(properties != null && properties.size() > 0){
				Iterator<String> iterator = properties.keySet().iterator();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					marshaller.setProperty(key, properties.get(key));
				}
			}
			marshaller.marshal(target, os);
		} catch (JAXBException e) {
			logger.error("JavaXmlBindUtil#marShallBean"+e.getMessage());
			throw e;
		}
	}
	
	/**
	 * POJO to XML OutputStream
	 * @method marShallBean
	 * @param clazz POJO Class
	 * @param target POJO instance
	 * @param os XML OutputStream
	 * @throws JAXBException
	 */
	public void marShalBean(Object target,OutputStream os,Class<?> ... classes)throws JAXBException{
		marShalBean(target, os,null, classes);
	}
	
	/**
	 * POJO to XML String
	 * @method marShallBeanToXmlStr
	 * @param clazz POJO Class
	 * @param target POJO instance
	 * @param os XML OutputStream
	 * @return
	 * @throws JAXBException
	 */
	public String marShalBean(Object target,Class<?> ... classes)throws JAXBException{
		String str = "";
		OutputStream os = null;
		try {
			os = new ByteArrayOutputStream();
			marShalBean(target, os,classes);
			str = os.toString();
		} catch (JAXBException e) {
			logger.error("JavaXmlBindUtil#marShallBean"+e.getMessage());
			throw e;
		} finally {
			if(os != null)
				try {
					os.close();
				} catch (IOException e) {
					logger.error("JavaXmlBindUtil#marShallBean"+e.getMessage());
				}
		}
		return str;
	}
	
	/**
	 * XML InputStream to POJO
	 * @method unMarShallXml
	 * @param clazz POJO Class
	 * @param is XML InputStream
	 * @param properties The properties for {@linkplain Unmarshaller}
	 * @return
	 * @throws JAXBException
	 */
	public Object unMarShalXml(InputStream is,Map<String, Object> properties,Class<?> ... classes)throws JAXBException{
		Object target = null;
		try {
			JAXBContext jaxbContext = getJAXBContext(classes);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			if(properties != null && properties.size() > 0){
				Iterator<String> iterator = properties.keySet().iterator();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					unmarshaller.setProperty(key, properties.get(key));
				}
			}
			target = unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			logger.error("JavaXmlBindUtil#unMarShallXml"+e.getMessage());
			throw e;
		}
		return target;
	}
	
	/**
	 * XML InputStream to POJO
	 * @method unMarShallXml
	 * @param clazz POJO Class
	 * @param is XML InputStream
	 * @return
	 * @throws JAXBException
	 */
	public Object unMarShalXml(InputStream is,Class<?> ... classes)throws JAXBException{
		return unMarShalXml(is,null,classes);
	}
	
	/**
	 * XML String to POJO
	 * @method unMarShallXml
	 * @param clazz POJO Class
	 * @param str XML String
	 * @return
	 * @throws JAXBException
	 */
	public Object unMarShalXml(String str,Class<?> ... classes)throws JAXBException{
		Object target = null;
		InputStream input = null;
		try {
			str = str.replaceAll("<\\?xml\\s+version=(['\"])1.0(['\"])\\s+encoding=(['\"])UTF-8(['\"])\\s*\\?>", "");
			Pattern pattern = Pattern.compile("\t|\r|\n");
            Matcher matcher = pattern.matcher(str);
            str = matcher.replaceAll("");
			input = new ByteArrayInputStream(str.getBytes());
			target = unMarShalXml(input, classes);
		} catch (JAXBException e) {
			logger.error("JavaXmlBindUtil#unMarShallXml"+e.getMessage());
			throw e;
		} finally {
			if(input != null)
				try {
					input.close();
				} catch (IOException e) {
					logger.error("JavaXmlBindUtil#unMarShallXml"+e.getMessage());
				}
		}
		return target;
	}
	
	/**
	 * Generate schema for specific binding classes
	 * @param schemaOutputResolver A resolver implemented <code>SchemaOutputResolver</code> which Controls where a JAXB implementation puts the generates schema files.<br/>
	 * 			For the detail please refer to {@link SchemaOutputResolver}
	 * @param classes
	 * @throws IOException
	 * @throws JAXBException
	 * @throws Exception
	 */
	public void generateSchema(SchemaOutputResolver schemaOutputResolver,Class<?> ... classes) throws IOException,JAXBException,Exception{
		try {
			JAXBContext jaxbContext = getJAXBContext(classes);
			jaxbContext.generateSchema(schemaOutputResolver);
		} catch (JAXBException e) {
			logger.error("JavaXmlBindUtil#marShallBean"+e.getMessage());
			throw e;
		} catch (IOException e) {
			logger.error("JavaXmlBindUtil#marShallBean"+e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.error("JavaXmlBindUtil#marShallBean"+e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Get the JAXBContext instance base on specific binding classes.
	 * @param classes
	 * @return
	 * @throws JAXBException
	 */
	public JAXBContext getJAXBContext(Class<?> ... classes) throws JAXBException{
		JAXBContext jaxbContext = null;
		try {
			jaxbContext = JAXBCache.getInstance().getJAXBContext(classes);
		} catch (JAXBException e) {
			logger.error("JavaXmlBindUtil#marShallBean"+e.getMessage());
			throw e;
		}
		return jaxbContext;
	}
}
