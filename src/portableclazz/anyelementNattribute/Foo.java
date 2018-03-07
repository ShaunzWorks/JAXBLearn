package portableclazz.anyelementNattribute;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

@XmlRootElement(name="foo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {
	private int a;
	private int b;
	
	@XmlAnyElement
	private List<Element> anyElement;
	
	@XmlAnyAttribute
	private Map<QName, String> anyAttribute;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public List<Element> getAnyElement() {
		return anyElement;
	}

	public void setAnyElement(List<Element> anyElement) {
		this.anyElement = anyElement;
	}

	public Map<QName, String> getAnyAttribute() {
		return anyAttribute;
	}

	public void setAnyAttribute(Map<QName, String> anyAttribute) {
		this.anyAttribute = anyAttribute;
	}
}
