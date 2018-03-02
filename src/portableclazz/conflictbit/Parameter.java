package portableclazz.complicatebit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Parameter {
	@XmlElement(name="param-name")
	private String parameNm;
	@XmlElement(name="paramValue")
	private String paramValue;
	
	public String getParameNm() {
		return parameNm;
	}
	public void setParameNm(String parameNm) {
		this.parameNm = parameNm;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
}
