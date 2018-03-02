package portableclazz.complicatebit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Filter {
	@XmlElement(name="filter-name")
	private String name;
	@XmlElement(name="filter-class")
	private String clazz;
	@XmlElement(name="async-supported")
	private boolean async;
	@XmlElement(name="init-param")
	private Parameter initParam;
	
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
	public boolean isAsync() {
		return async;
	}
	public void setAsync(boolean async) {
		this.async = async;
	}
	public Parameter getInitParam() {
		return initParam;
	}
	public void setInitParam(Parameter initParam) {
		this.initParam = initParam;
	}
}
