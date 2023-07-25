package project.model;

public class DatiUSA implements Dati{
	
	/**
	 * Sottoclasse in cui verranno raccolte le informazioni di ogni giorno:
	 * saranno sempre presenti il numero dei positivi(positiveIncrease), 
	 * dei negativi(negativeIncrease) e il numero dei morti(deathIncrease) di tale giorno
	 * ed il totale dei negativi (negative)
	 * 
	 * @author Enrico Maria Sardellini
	 */
	
	private String day=null;  
	private long num_states=0; 
	private long positive = 0;
	private long positiveIncrease = 0;
	private long negative = 0;
	private long negativeIncrease = 0; 
	private long deathIncrease = 0; 
	
	public DatiUSA () {}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public long getNum_states() {
		return num_states;
	}

	public void setNum_states(long num_states) {
		this.num_states = num_states;
	}
	
	public long getPositive() {
		return positive;
	}

	public void setPositive(long positive) {
		this.positive = positive;
	}

	public long getPositiveIncrease() {
		return positiveIncrease;
	}

	public void setPositiveIncrease(long positiveIncrease) {
		this.positiveIncrease = positiveIncrease;
	}

	public long getNegative() {
		return negative;
	}

	public void setNegative(long negative) {
		this.negative = negative;
	}

	public long getNegativeIncrease() {
		return negativeIncrease;
	}

	public void setNegativeIncrease(long negativeIncrease) {
		this.negativeIncrease = negativeIncrease;
	}
	
	public long getDeathIncrease() {
		return deathIncrease;
	}

	public void setDeathIncrease(long deathIncrease) {
		this.deathIncrease = deathIncrease;
	}

	
}
