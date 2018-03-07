package portableclazz.xmllist;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

	@XmlElement(name="dataE")
	private List<String> dataAsElement;
	
	@XmlElement(name="dataV")
	@XmlList
	private List<String> dataAsValues;

	public List<String> getDataAsElement() {
		return dataAsElement;
	}

	public void setDataAsElement(List<String> dataAsElement) {
		this.dataAsElement = dataAsElement;
	}

	public List<String> getDataAsValues() {
		return dataAsValues;
	}

	public void setDataAsValues(List<String> dataAsValues) {
		this.dataAsValues = dataAsValues;
	}
}
