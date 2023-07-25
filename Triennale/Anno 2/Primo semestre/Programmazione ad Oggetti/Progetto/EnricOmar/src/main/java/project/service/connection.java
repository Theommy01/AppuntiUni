package project.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import project.model.DatiUSA;
import project.model.DatiHospital;
import project.stats.Statistics;
import project.exception.EccezionePersonalizzata;

/**
 * Tale classe: 
 * -avrà un metodo che gestirà il parsing dei dati dal file Json ad oggetti java
 * -avrà dei metodi che produrranno un JSONObject/JSONArray che verrà postato dalle rotte
 * 
 * @author Enrico Maria Sardellini
 * @author Omar Naja
 */
@Service
public class connection implements Int_connection {
	
	/**
	 * oggetti che ci serviranno nella classe
	 * vett1 e vett2 serviranno a raccogliere i vari oggetti DatiUSA e DatiHospital estrapolati dal fila USA.json
	 * control e stats ci servono rispettivamente per avviare i metodi di controllo della data e delle statistiche
	 */
	ArrayList<DatiUSA> vett1 = new ArrayList<DatiUSA>();
	ArrayList<DatiHospital> vett2 = new ArrayList<DatiHospital>();
	ControlloParam control = new ControlloParam();
	Statistics stats = new Statistics();
	
	/**
	 * cotruttore della classe
	 */
	public connection() {
		this.parsingData();
	}	
	
	/**
	 * Questo metodo converte i dati letti dal file USA.json 
	 * in oggetti (DatiUSA e DatiHospital) utilizzabili in java
	 * e li inserisce nelle rispettive Arraylist
	 * 
	 * @author Enrico Maria Sardellini
	 * @author Omar Naja
	 * @see metodi set del model
	 * @see project.service.ControlloParam.ControlData() (trasforma la data del formato americano (aaaa.mm.gg) a quello europeo (gg.mm.aaaa)) 
	 * @see project.USA.json
	 */
	public void parsingData() {
		/**
		 * Usiamo JSONsimple per effettuare il parsing 
		 * e apriamo un flusso di input dal file USA.json
		 */
		JSONParser par= new JSONParser();
		FileReader read;
		try {
			read = new FileReader("src/main/java/project/USA.json");
			
			/**
			 * con i JSONobject e i JSONArray creati possiamo accedere all'interno
			 * della struttura annidata del file JSON e, utilizzando poi setter
			 * delle classi del package project.model, assegniamo i valori ai nostri oggetti
			 * 
			 */
			Object oggetto = par.parse(read);
			JSONArray array = (JSONArray) oggetto;
			
			/**
			 * Queste variabili long servono a prendere il valore in ingresso
			 * per verificare se tale valore può essere accettato dal relativo
			 * metodo set 
			 * 
			 * Ci siamo accorti che se, per esempio, non ci sono contagi non abbiamo uno 0 ma un null
			 * nel file Json, e ci crea problemi di compatibilità del tipo.
			 * quindi salviamo i valori nelle variabili e se sono null, assegniamo ai metodi set uno 0, 
			 * altrimenti assegnamo ai metodi set la variabile
			 */
			Long day, positive, negative, death, HN, TN, PI, NI;
				
			/**
			 * scorriamo il file Json e usiamo i vari setter per modificare gli oggetti usa e hospital
			 * inserendoli infine nelle apposite ArrayList
			 */
			for(int i=0; i<array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				DatiUSA usa = new DatiUSA();
				DatiHospital hospital = new DatiHospital();
				
				day = (Long) obj.get("date");
				usa.setDay(control.ControlData(day));
				hospital.setDay(control.ControlData(day));
				
				usa.setNum_states((long) obj.get("states"));
				hospital.setNum_states((long) obj.get("states"));
					
				positive = ((Long) obj.get("positive"));
			    if(positive == null) usa.setPositive(0);
			    else usa.setPositive(positive);
			    if(positive == null) hospital.setPositive(0);
			    else hospital.setPositive(positive);
			    
			    negative = ((Long) obj.get("negative"));
			    if(negative == null) usa.setNegative(0);
			    else usa.setNegative(negative);
				    
			    PI = ((Long) obj.get("positiveIncrease"));
			    if(PI == null) usa.setPositiveIncrease(0);
			    else usa.setPositiveIncrease(PI);
				    
			    NI = ((Long) obj.get("negativeIncrease"));
			    if(NI == null) usa.setNegativeIncrease(0);
			    else usa.setNegativeIncrease(NI);
			    
			    HN = ((Long) obj.get("hospitalizedCurrently"));
			    if(HN == null) hospital.setHospitalized(0);
			    else hospital.setHospitalized(HN);
				    
			    TN = ((Long) obj.get("inIcuCurrently"));
			    if(TN == null) hospital.setIntensive_care(0);
			    else hospital.setIntensive_care(TN);
				    
			    hospital.setColour();
				    
			    death = ((Long) obj.get("deathIncrease"));
			    if(death == null) usa.setDeathIncrease(0);
			    else usa.setDeathIncrease(death);
				
				vett1.add(usa);
				vett2.add(hospital);
				};
			}
			
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	/**
	 * tale metodo prende la stringa del giorno (day) e se compare 
	 * nell'arraylist, tramuta i dati dell'oggetto in un JSONObject
	 * restituendolo;
	 * 
	 * effettuerà prima un ControlDay per verificare la correttezza della data.
	 * se l'errore persiste o la data non è presente nel file, stamperà un errore. 
	 * 
	 * @author Enrico Maria Sardellini
	 * @author Omar Naja
	 * @param String day (il giorno passato in input)
	 * @return JSONObject obj (oggetto JSON avente i dati di quel giorno)
	 * 
	 * @throws EccezionePersonalizzata (stamperà un messaggio di errore se il giorno avesse delle irregolarità o non è presente nel file)
	 * @see metodi get del model
	 * @see project.service.ControlParam.ControlDay(); (valuterà alcuni possibili errori della data inserita in input)
	 */
	public JSONObject getToday(String day){
		
		control.ControlDay(day);
		
		JSONObject obj = new JSONObject();
		String mistake = "Day not found or irregular! The day must be between 13.1.2020 and 7.3.2021";
		boolean done = false;
		
		for(int i=0; i<vett1.size(); i++) {
		if (day.equals(vett1.get(i).getDay())) {
			obj.put("Number of states", vett1.get(i).getNum_states());
			obj.put("Death increase", vett1.get(i).getDeathIncrease());
			obj.put("Day", vett1.get(i).getDay()); 
            obj.put("Colour", vett2.get(i).getColour());
            obj.put("Positive increase", vett1.get(i).getPositiveIncrease());
            obj.put("Positive total", vett1.get(i).getPositive());
            obj.put("Negative increase", vett1.get(i).getPositiveIncrease());
            obj.put("Negative total", vett1.get(i).getNegative());
            done = true;
			}
		}
		if (done == false) throw new EccezionePersonalizzata(mistake);
		return obj;
	}
	
	@Override
	/**
	 * Overloading del metodo getToday();
	 * Questo metodo verrà avviato dagli altri metodi di questa classe che avranno già effettuato 
	 * i loro controlli sulla data. 
	 * evitiamo quindi di far fare al compilatore dei calcoli in più
	 * 
	 * @author Enrico Maria Sardellini
	 * @param Integer i (posizione del giorno nella lista)
	 * @return JSONObject obj (oggetto JSON avente i dati di quel giorno)
	 * @see metodi get del model
	 */
	public JSONObject getToday(Integer day){
		
		JSONObject obj = new JSONObject();

		obj.put("Number of states", vett1.get(day).getNum_states());
		obj.put("Death increase", vett1.get(day).getDeathIncrease());
		obj.put("Day", vett1.get(day).getDay()); 
        obj.put("Colour", vett2.get(day).getColour());
        obj.put("Positive increase", vett1.get(day).getPositiveIncrease());
        obj.put("Positive total", vett1.get(day).getPositive());
        obj.put("Negative increase", vett1.get(day).getPositiveIncrease());
        obj.put("Negative total", vett1.get(day).getNegative());

		return obj;
	}
	
	@Override
	/**
	 * Tale metodo riceve in input un giorno e dovrà ritornare un JSONArray con i 
	 * dati di quel giorno e dei 6 giorni seguenti. 
	 * 
	 * @author Enrico Maria Sardellini
	 * @param String day (il giorno passato in input)
	 * @return JSONArray array (Jsonaarray avente i dati della settimana)
	 * 
	 * @throws EccezionePersonalizzata (stamperà un messaggio di errore se la settimana avesse delle irregolarità o non è presente nel file)
	 * @see project.service.connection.getToday() (per modificare l'oggetto JSON da inserire nell'array)
	 * @see project.stats.Statistics.StatsLong() (inserisce nell'JSONArray le statistiche di quella settimana)
	 * @see project.service.ControlParam.ControlDay(); (valuterà alcuni possibili errore della data inserita in input)
	 * @see project.service.ControlParam.ControlWeek(); (manderà un errore se la data appartiene a determinati giorni limite, ovvero a marzo 2021)
	 */
	public JSONArray getWeek(String day){
		
		/**
		 * metodi di controllo della data
		 */
		control.ControlDay(day);
		control.ControlWeek(day);
		
		JSONArray array = new JSONArray();
		boolean done = false;
		
		/**
		 * scorre la lista fino alla fine e stamperà un errore se non trova il giorno
		 */
		for(int i=0; i<vett1.size(); i++) {
			
			if (day.equals(vett1.get(i).getDay())) {
				
				stats.StatsLong(vett1, vett2, array, i, 7);
				
				done = true;
				
				for(int j=0; j<7; j++) {
					
					JSONObject obj = new JSONObject();
					int finale = i-j;
					obj = getToday(finale);
					array.add(obj);
					
				}
				
			}
		}
		if (done == false) throw new EccezionePersonalizzata("Week not found or irregular! The day must be between 13.1.2020 and 28.2.2021");
		return array;
	}
	
	@Override
	/**
	 * tale metodo prende in ingresso il mese e l'anno(month & year) e
	 * stamperà le statistiche di tale mese e la lista dei giorni;
	 * 
	 * @author Enrico Maria Sardellini
	 * @param month (variabile del mese)
	 * @param year (variabile dell'anno)
	 * @return JSONArray array (conterrà delle statistiche del mese e la lista dei giorni)
	 *
	 * @see project.service.connection.getToday() (per modificare l'oggetto JSON da inserire nell'array)
	 * @see project.stats.Statistics.StatsLong() (inserisce nell'array le statistiche di quel mese)
	 * @see project.service.ControlParam.ControlMonth(); (valuterà alcuni possibili errore della data inserita in input e ritornerà il numero del mese)
	 */
	public JSONArray getMonth(String month, String year){
		int dayfinal=0;
		int m = control.ControlMonth(month, year); 
		
		/**
		 * lo switch serve per definire 
		 * dayfinal, ovvero il numero di giorno di quel mese
		 */
		switch(m) {
		case 1, 3, 5, 7, 8, 10, 12: dayfinal=31; break; 
		case 2: dayfinal=28; break;
		case 4, 6, 9, 11: dayfinal=30; break; 
		default: break; 
		}
		
		/**
		 * questa parte del programma crea la stringa con cui andremo a verificare 
		 * la data di partenza del mese
		 * 
		 * eccezzioni da considerare:
		 * -febbraio 2020 arrivava al 29
		 * -gennaio 2020 parte dal 13
		 * -marzo 2021 arriva fino al 6
		 */
		String m_a =(m + "." + year);
		JSONArray array = new JSONArray();
		int daystart=1;
		if(m_a.equals("1.2020")) {
			daystart = 13;
			dayfinal = 19;
		}
		else if(m_a.equals("2.2020")) dayfinal = 29;
		else if(m_a.equals("3.2021")) dayfinal = 6;
		String day = daystart + "." + m_a;
		
		/**
		 * scorre la lista fino alla fine per trovare il giorno iniziale
		 */
		for(int i=0; i<vett1.size(); i++) {
			if (day.equals(vett1.get(i).getDay())) {
				
				stats.StatsLong(vett1, vett2, array, i, dayfinal);
				
				for(int j=0; j<dayfinal; j++) {
				
					JSONObject obj = new JSONObject();
					int finale = i-j;
					obj = getToday(finale);
					array.add(obj);
				}
				
			}
		}
		return array;
	};
	
	@Override
	
	/**
	 * stamperà la lista dei giorni con quel colore e 
	 * e aggiungerà ai singoli oggetti le statistiche percentuali 
	 * degli ospedalizzati e delle terapie intensive di quel giorno
	 * 
	 * @author Enrico Maria Sardellini
	 * 
	 * @param colour (variabile del colore)
	 * @return JSONArray array (JSONArray che riporterà i giorni di quel colore)
	 * 
	 * @see project.service.connection.getToday() (se il colore di un giorno ha lo stesso colore del (colour) lo aggiungerà all'array)
	 * @see project.stats.Statistics.StatsColour() (aggiungerà al JSONObject i dati ospedalieri percentuali del giorno)
	 * @see project.service.control.ControlColour() (valuterà se il colore è ammissibile o no)
	 */
	public JSONArray getColour(String finale) {
		
		String colour = control.ControlColour(finale);
		JSONArray array = new JSONArray();
		JSONObject general  = new JSONObject ();
		
		general.put("Type of colour is", colour);
		int volte = stats.StatsColour(vett2, colour);
		general.put("There were", volte + " " + colour + " days");
		array.add(general);
			
		for(int i=0; i<vett1.size(); i++) {
			if(colour.equals(vett2.get(i).getColour())) {
				
				JSONObject obj = new JSONObject();
				obj = getToday(i);
				stats.StatsColour(vett2, obj, i);
				array.add(obj);
			}
		}
		return array;
	}
	
	@Override
	/**
	 * prende in ingresso 2 stringhe giorno e se sono differenti stamperà quei giorni
	 * ed eseguirà il metodo Stats2days, altrimenti se i giorni sono identici
	 * eseguirà un semplice getToday()
	 * 
	 * @author Enrico Maria Sardellini
	 * @param day1 (variabile primo giorno)
	 * @param day2 (variabile secondo giorno)
	 * @return JSONArray array (JSONArray che riporterà quei giorni e le loro statistiche)
	 * 
	 * @see project.service.connection.getToday() (se il giorno venisse trovato lo aggiungerà all'array)
	 * @see project.stats.Statistics.Stats2days() (aggiungerà al JSONArray delle statistiche percentuali dei giorni)
	 * @see project.service.ControlParam.ControlDay(); (valuterà alcuni possibili errori della data inserita in input)
	 * @throws EccezionePersonalizzata (stamperà un messaggio di errore uno o entrambi i giorni avessero delle irregolarità o non sono presenti nel file)
	 */
	public JSONArray get2days(String day1, String day2) {
		
		JSONArray array = new JSONArray();
		boolean done1=false; 
		boolean done2=false; 
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		
		control.ControlDay(day2);
		control.ControlDay(day1);
		
		if(day1.equals(day2)) {
			
			for(int i=0; i<vett1.size(); i++) {
				
				if(day1.equals(vett1.get(i).getDay())) {
					
					JSONObject obj = getToday(i);
					array.add(obj);
					done1 = true;
					done2 = true;
					
				}
			}
		}
		else {
			
			for(int i=0; i<vett1.size(); i++) {
				
				if(day1.equals(vett1.get(i).getDay())) {
					
					obj1 = getToday(i);
					done1 = true; 
					
				}
				
				if(day2.equals(vett1.get(i).getDay())) {
					
					obj2 = getToday(i);
					done2 = true; 
					
				}
			}		
		}
		
		if((done1 == false) && (done2 == false)) throw new EccezionePersonalizzata("Day1 and day2 not found or irregular! The day must be between 13.1.2020 and 7.3.2021");
		if(done1 == false) throw new EccezionePersonalizzata("Day1 not found or irregular! The day must be between 13.1.2020 and 7.3.2021");
		if(done2 == false) throw new EccezionePersonalizzata("Day2 not found or irregular! The day must be between 13.1.2020 and 7.3.2021");
		if(!day1.equals(day2)) stats.Stats2days(vett1, vett2, array, day1, day2);
	
		array.add(obj1);
		array.add(obj2);
		return array;
	}

}

