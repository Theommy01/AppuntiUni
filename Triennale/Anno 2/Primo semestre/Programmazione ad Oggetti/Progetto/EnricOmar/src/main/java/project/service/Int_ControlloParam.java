package project.service;

public interface Int_ControlloParam {
	
	/**
	 * interfaccia che ci permette di visualizzare i vari metodi di ControlloParam
	 * 
	 * @author Enrico Maria Sardellini
	 */
	
	public abstract void ControlDay(String day);
	public abstract String ControlColour(String colour);
	public abstract int ControlMonth(String month, String year);
	public abstract boolean ControlYear(String day);
	public abstract void ControlWeek(String day);
	public abstract String ControlData(Long day);
}
