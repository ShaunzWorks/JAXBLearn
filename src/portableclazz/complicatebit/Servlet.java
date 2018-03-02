package portableclazz.complicatebit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Servlet {
	@XmlElement(name="servlet-name")
	private String name;
	@XmlElement(name="servlet-class")
	private String clazz;
	@XmlElement(name="init-param")
	private Parameter initParam;
	@XmlElement(name="load-on-startup")
	private int loadOnStartUp;
	@XmlElement(name="async-supported")
	private boolean async;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public Parameter getInitParam() {
		return initParam;
	}
	public void setInitParam(Parameter initParam) {
		this.initParam = initParam;
	}
	public int getLoadOnStartUp() {
		return loadOnStartUp;
	}
	public void setLoadOnStartUp(int loadOnStartUp) {
		this.loadOnStartUp = loadOnStartUp;
	}
	public boolean isAsync() {
		return async;
	}
	public void setAsync(boolean async) {
		this.async = async;
	}
}
