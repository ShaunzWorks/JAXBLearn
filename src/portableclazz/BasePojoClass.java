package portableclazz;

public abstract class BasePojoClass implements Comparable<BasePojoClass>{
	private String sequnce;

	@Override
	public int compareTo(BasePojoClass o) {
		
		return this.sequnce.compareTo(o.getSequnce());
	}
	
	public String getSequnce(){
		return sequnce;
	}
	
	public void setSequnce(String sequnce){
		this.sequnce = sequnce;
	}
	

}
