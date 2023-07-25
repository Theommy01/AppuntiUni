package project.model;

/**
 * interfaccia delle due sottoclassi DatiHospital e DatiUSA 
 * 
 * @author Enrico Maria Sardellini
 */
public interface Dati {

	public String day=null;  
	public long num_states=0; 
	public long positive = 0;
	
	public abstract String getDay();
	public abstract void setDay(String day);
	public abstract long getNum_states();
	public abstract void setNum_states(long num_states);
	public abstract long getPositive();
	public abstract void setPositive(long positive);
}
