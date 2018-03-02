package portableclazz.complicatebit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ServletMap {
	@XmlElement(name="servlet-name")
	private String name;
	@XmlElement(name="url-pattern")
	private String urlPartten;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlPartten() {
		return urlPartten;
	}
	public void setUrlPartten(String urlPartten) {
		this.urlPartten = urlPartten;
	}
}
