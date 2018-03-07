package portableclazz.anyelement;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.w3c.dom.Element;

@XmlRootElement(name="foo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {
	private int a;
	private int b;
	
	@XmlAnyElement
	private List<Element> any;

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

	public List<Element> getAny() {
		return any;
	}

	public void setAny(List<Element> any) {
		this.any = any;
	}
	
	

}
