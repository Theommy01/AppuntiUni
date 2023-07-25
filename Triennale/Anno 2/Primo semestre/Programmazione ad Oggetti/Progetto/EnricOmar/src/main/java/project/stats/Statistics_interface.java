package project.stats;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import project.model.DatiHospital;
import project.model.DatiUSA;


/**
 * interfaccia che ci permette di definire i metodi che useremo per avere delle statistiche
 * della settimana/anno (StatsLong), del colore (StatsColour) e dei 2 giorni (Stats2day);
 * 
 * @author Enrico Maria Sardellini
 */
public interface Statistics_interface {
	
	public abstract void StatsLong(ArrayList<DatiUSA> vett1, ArrayList<DatiHospital> vett2, JSONArray array, Integer i, Integer dayfinal);
	public abstract void Stats2days(ArrayList<DatiUSA> vett1, ArrayList<DatiHospital> vett2, JSONArray array, String day1, String day2);
	public abstract int StatsColour(ArrayList<DatiHospital> vett2, String colour);
	public abstract void StatsColour(ArrayList<DatiHospital> vett2, JSONObject obj, Integer i);
}
