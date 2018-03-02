package portableclazz.movemore;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="company")
public class Company {
	
	private String name;
	private String website;
	private String ceo;
	
	@XmlAttribute(name="estabilishTime")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date estabilishTime;
	
	private List<Branch> branchs;

	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name="website")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@XmlAttribute(name="ceo")
	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
	
	@XmlTransient
	public Date getEstabilishTime() {
		return estabilishTime;
	}

	public void setEstabilishTime(Date estabilishTime) {
		this.estabilishTime = estabilishTime;
	}

	@XmlElement(name="branch")
	public List<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	
	
}
