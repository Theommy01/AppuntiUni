package project.model;

/**
 * sottoclasse che riceve due attributi quali
 * hospitalized (gli ospedalizzati) e intensive_care(il numero di terapie intensive)
 * tali dati ci servono per la determinazione del colore del giorno (colour)
 * 
 * @author Enrico Maria Sardellini
 */
public class DatiHospital implements Dati{
	
	private String day=null;  
	private long num_states=0;
	private long positive = 0;
	private long hospitalized=0;  
	private long intensive_care=0;
	private String colour=null;
	
	/**
	 * Valori semplificati a costanti, anche se costanti non sono, per la determinazione del colore:
	 * uno è la popolazione degli USA(popolation_USA) e gli altri due sono i letti di terapia intensiva totali(ICU_total)
	 * e i letti degli ospedali totali(beds_total) 
	 * 
	 * @author Enrico Maria Sardellini
	 * @link https://globalepidemics.org/hospital-capacity-2/
	 */
	static final int population_USA = 330000000; 
	static final int ICU_total= 84750; 
	static final int beds_total = 737567;
	
	public DatiHospital() {}

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

	public long getHospitalized() {
		return hospitalized;
	}

	public void setHospitalized(long hospitalized) {
		this.hospitalized = hospitalized;
	}

	public long getIntensive_care() {
		return intensive_care;
	}

	public void setIntensive_care(long intensive_care) {
		this.intensive_care = intensive_care;
	};
	
	/**
	 * Il metodo setColour ci permette di ottenere il colore da assegnare al rispettivo giorno 
	 * avendo il numero dei casi ogni 100mila abitanti (casi), i valori delle occupazioni percentuali 
	 * delle terapie intensive(perIcu) e degli ospedali(perBeds). 
	 * 
	 * E' presente anche un'alternativa di tale metodo che non considera (perBeds)
	 * 
	 * @author Enrico Maria Sardellini
	 * @link https://www.ilsole24ore.com/art/come-cambiano-colori-regioni-restano-bianche-sicilia-piu-rischio-contagi-e-ricoveri-AEi3FOY
	 */
	public void setColour() {
		double casi = ((double)this.getPositive()/(double)population_USA)*100000;
		double perIcu = ((double)intensive_care/(double)ICU_total)*100;
		double perBeds = ((double)hospitalized/(double)beds_total)*100;
		
		String colour=null;
		if(casi < 50) colour = "White";
		else if((casi >= 50) && (casi < 150)) {  
			if((perIcu < 10) || (perBeds < 15)) colour = "White";
			if((perIcu >= 10) && (perBeds >= 15)) colour = "Yellow";
		}else if (casi >= 150) {
			if((perIcu < 20) || (perBeds < 30)) colour = "Yellow";
			if((perIcu >= 20) && (perBeds >= 30)) colour = "Orange";
			if((perIcu >= 30) && (perBeds >= 40)) colour = "Red";
		}
		this.colour = colour;
		/* 
		if (casi < 50) colour = "White";
		else if((casi >= 50) && (casi < 150)) {  
			if((perIcu < 10))colour = "White";
			if((perIcu >= 10)) colour = "Yellow";
		}else if (casi >= 150) {
			if((perIcu < 20)) colour = "Yellow";
			if((perIcu >= 20)) colour = "Orange";
			if((perIcu >= 30)) colour = "Red";
		}
		return colour;
		*/
	}
	
	public String getColour() {
		return colour;
	}

	
}
