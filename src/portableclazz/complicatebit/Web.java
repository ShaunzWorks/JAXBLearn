package portableclazz.complicatebit;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="web-app")
public class Web {
	@XmlElement(name="display-name",required=true)
	private String displayNm;
	
	@XmlElement(name="context-param")
	private Parameter contxtParam;
	
	@XmlAttribute(name="version")
	private String version;
	
	@XmlElement(name="filter")
	private List<Filter> filters;
	
	@XmlElement(name="filter-mapping")
	private List<FilterMap> filterMaps;
	
	@XmlElement(name="listener")
	private List<Listener> listeners;
	
	@XmlElement(name="servlet")
	private List<Servlet> servlets;
	
	@XmlElement(name="servlet-mapping")
	private List<ServletMap> servletMaps;
	
	@XmlElement(name="welcome-file-list")
	private WelcomeFile welcomeFile;

	public String getDisplayNm() {
		return displayNm;
	}

	public void setDisplayNm(String displayNm) {
		this.displayNm = displayNm;
	}

	public Parameter getContxtParam() {
		return contxtParam;
	}

	public void setContxtParam(Parameter contxtParam) {
		this.contxtParam = contxtParam;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public List<FilterMap> getFilterMaps() {
		return filterMaps;
	}

	public void setFilterMaps(List<FilterMap> filterMaps) {
		this.filterMaps = filterMaps;
	}

	public List<Listener> getListeners() {
		return listeners;
	}

	public void setListeners(List<Listener> listeners) {
		this.listeners = listeners;
	}

	public List<Servlet> getServlets() {
		return servlets;
	}

	public void setServlets(List<Servlet> servlets) {
		this.servlets = servlets;
	}

	public List<ServletMap> getServletMaps() {
		return servletMaps;
	}

	public void setServletMaps(List<ServletMap> servletMaps) {
		this.servletMaps = servletMaps;
	}

	public WelcomeFile getWelcomeFile() {
		return welcomeFile;
	}

	public void setWelcomeFile(WelcomeFile welcomeFile) {
		this.welcomeFile = welcomeFile;
	}
	
	
}
