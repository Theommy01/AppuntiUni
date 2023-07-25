package project.service;

import project.exception.EccezionePersonalizzata;

/**
 * Tale classe effettuerà una serie di metodi per andare a
 * trovare eventuali errori nei dati passati in input
 * 
 * @author Enrico Maria Sardellini
 */
public class ControlloParam implements Int_ControlloParam{
	
	/**
	 * costruttore vuoto della classe
	 */
	public ControlloParam() {};
	
	/**
	 * metodo che determina eventuali errori nell'inserimento della data
	 * 
	 * @author Enrico Maria Sardellini
	 * @param String day (variabile contenente il giorno dato in input)
	 * @throws EccezionePersonalizzata (stamperà un messaggio di errore se il giorno avesse delle irregolarità)
	 * @see project.service.control.ControlYear(); (valuterà se l'anno è accettabile)
	 */
	public void ControlDay(String day) {
		
		char punto = '.';
		int lunghezza = day.length();
		
		/**
		 * se la lunghezza fosse minore o eccessiva di quella richiesta, il parametro 
		 * sicuramente non sarebbe accettabile come data
		 */
		if((lunghezza<=7) || (lunghezza>=11)) throw new EccezionePersonalizzata("The writing of the day is not suitable! Examples of days (12.1.2020 or 3.2.2021)"); 
		
		/**
		 * a seconda della lunghezza ci sono delle cose da controllare:
		 * 1) la posizione dei punti '.' è sempre la stessa. quindi la loro posizione ci aiuta a capire se la data scritta va bene o no
		 * 2) gli zeri inutili genereranno degli errori. 
		 * per esempio: 12.01.2021 genererà un errore dicendo che lo 0 nel mese non ci può essere (forma esatta 12.1.2021)
		 * oppure se il giorno o il mese fosse 0 (0.3.2020) genererà un altro errore
		 * 
		 */
		if (lunghezza==8) {
			if((Character.compare(day.charAt(1),punto)!=0) || (Character.compare(day.charAt(3), punto)!=0)) throw new EccezionePersonalizzata("The writing of the day is not suitable! Days, months and years are separated by a point '.'! Examples of days (2.7.2020 or 3.2.2021)"); 
			if(Character.compare(day.charAt(0),'0')==0) throw new EccezionePersonalizzata("The day cannot be '0'!");
			if(Character.compare(day.charAt(2),'0')==0) throw new EccezionePersonalizzata("The month cannot be '0'!");
		}
		else if(lunghezza==9) {
			if((Character.compare(day.charAt(1),punto)==0) && (Character.compare(day.charAt(4), punto)==0)) {
				if(Character.compare(day.charAt(0),'0')==0) throw new EccezionePersonalizzata("The day cannot be '0'!");
				if(Character.compare(day.charAt(2),'0')==0) throw new EccezionePersonalizzata("The month cannot have '0'!");
			}
			else if((Character.compare(day.charAt(2),punto)==0) && (Character.compare(day.charAt(4), punto)==0)) {
				if(Character.compare(day.charAt(0),'0')==0) throw new EccezionePersonalizzata("The day cannot have '0'!");
				if(Character.compare(day.charAt(3),'0')==0) throw new EccezionePersonalizzata("The month cannot be'0'!");
			}
			else throw new EccezionePersonalizzata("The writing of the day is not suitable! Days, months and years are separated by a point '.'!  Examples of days (12.1.2021 or 7.10.2020)");
		}
		else if(lunghezza==10) {
			if((Character.compare(day.charAt(2),punto)!=0) || (Character.compare(day.charAt(5), punto)!=0)) throw new EccezionePersonalizzata("The writing of the day is not suitable! Days, months and years are separated by a point '.'! Examples of days (12.11.2020 or 22.12.2020)"); 
			if(Character.compare(day.charAt(0),'0')==0) throw new EccezionePersonalizzata("The day cannot have '0'!");
			if(Character.compare(day.charAt(3),'0')==0) throw new EccezionePersonalizzata("The month cannot have '0'!");
		}
		
		/**
		 * metodo che valuterà se l'anno è accettabile
		 */
		if(!ControlYear(day)) throw new EccezionePersonalizzata("Invalid year entered! Only 2020 & 2021 are accepted");
	};

	/**
	 * metodo che determinerà se la scritta colour è accettabile 
	 * ritornando una scritta precisa del colore da poter confrontare 
	 * coi i colori inseriti negli oggetti DatiHospital
	 * 
	 * @author Enrico Maria Sardellini
	 * @param String finale (variabile contenente il colore dato in input)
	 * @return String color (contiene il colore con cui andremo a comparare gli altri colori del giorno)
	 * @throws EccezionePersonalizzata (stamperà un messaggio di errore se il colore non fosse accettabile)
	 */
	public String ControlColour(String finale) {
		
		String color;
		String colour = finale.toLowerCase();
		
		switch(colour) {
			case "white": color = "White"; break; 
			case "yellow": color = "Yellow"; break; 
			case "orange": color = "Orange";break; 
			case "red": color = "Red";break; 
			default: color = "Error"; break;
		}
		
		if(color.equals("Error")) throw new EccezionePersonalizzata("Colour not found! The possible colors are: red, orange, yellow and white");
		return color;
	};
	
	/**
	 * metodo che controlla l'accettabilità del mese e dell'anno dati in input
	 * 
	 * @author Enrico Maria Sardellini
	 * @param String month (variabile contenente il mese dato in input)
	 * @param String year (variabile contenente l'anno dato in input)
	 * @return int m (variabile che rappresenta il numero del mese)
	 * @throws EccezionePersonalizzata (stamperà un messaggio di errore se il mese/anno avesse delle irregolarità)
	 */
	public int ControlMonth(String month, String year) {
		
		int m = 0; 
		String mese = month.toLowerCase();
		
		switch(mese) {
		case "1", "january": m= 1; break; 
		case "2","february":  m=2; break;
		case "3", "march": m=3; break; 
		case "4", "april":  m=4; break; 
		case "5", "may": m=5; break; 
		case "6", "june": m=6; break; 
		case "7", "july": m=7; break; 
		case "8", "august": m=8; break; 
		case "9", "september": m=9; break; 
		case "10", "october": m=10; break; 
		case "11", "november": m=11; break; 
		case "12", "december": m=12; break; 
		default: break; 
		}
		
		/**
		 * vengono valutati 3 errori
		 * 1) se il mese è sbagliato
		 * 2) se l'anno è sbagliato (solo 2020 e 2021 sono accettabili)
		 * 3) se viene richiesto un mese non presente nella lista
		 *    i mesi esclusi vanno da aprile 2021 fino a fine anno 
		 */
		if(m == 0) throw new EccezionePersonalizzata("Invalid month entered!");
		if(!year.equals("2020") && !year.equals("2021")) throw new EccezionePersonalizzata("Invalid year entered! Only 2020 & 2021 are accepted");
		if(m>=4 && year.equals("2021")) throw new EccezionePersonalizzata("Month not found! It runs from January 2020 to March 2021");
		
		
		
		return m;
	};

	/**
	 * metodo richiamato da ControlDay() e che valuta se l'anno è ammissibile (solo 2020 e 2021)
	 * 
	 * @author Enrico Maria Sardellini
	 * @param String day (variabile contenente il giorno dato in input)
	 * @return boolean done (se l'anno è ammissibile ritornerà true)
	 */
	public boolean ControlYear(String day) {
		boolean done = false;
		int m = day.length();
		if((Character.compare(day.charAt(m-1),'1')==0) || (Character.compare(day.charAt(m-1),'0')==0)) {
			if(Character.compare(day.charAt(m-2),'2')==0) {
				if(Character.compare(day.charAt(m-3),'0')==0){
					if(Character.compare(day.charAt(m-4),'2')==0) done = true; 
				}
			}
		}
		return done;
	}

	/**
	 * questo metodo stampa un errore se viene richiesto uno dei giorni più vicini
	 * alla fine temporale della lista
	 * 
	 * @author Enrico Maria Sardellini
	 * @param String day (variabile contenente il giorno dato in input)
	 * @throws EccezionePersonalizzata (stamperà un messaggio di errore se il giorno fosse troppo vicino alla fine della lista) 
	 */
	public void ControlWeek(String day) {
		if(day.equals("1.3.2021")) throw new EccezionePersonalizzata("The '/week' route only accepts the days from 13.1.2020 to 28.2.2021!");
		if(day.equals("2.3.2021")) throw new EccezionePersonalizzata("The '/week' route only accepts the days from 13.1.2020 to 28.2.2021!");
		if(day.equals("3.3.2021")) throw new EccezionePersonalizzata("The '/week' route only accepts the days from 13.1.2020 to 28.2.2021!");
		if(day.equals("4.3.2021")) throw new EccezionePersonalizzata("The '/week' route only accepts the days from 13.1.2020 to 28.2.2021!");
		if(day.equals("5.3.2021")) throw new EccezionePersonalizzata("The '/week' route only accepts the days from 13.1.2020 to 28.2.2021!");
		if(day.equals("6.3.2021")) throw new EccezionePersonalizzata("The '/week' route only accepts the days from 13.1.2020 to 28.2.2021!");
		if(day.equals("7.3.2021")) throw new EccezionePersonalizzata("The '/week' route only accepts the days from 13.1.2020 to 28.2.2021!");
	}

	/**
	 * questo metodo converte le date dal formato americano (aaaa.mm.gg) in formato europeo (gg.mm.aaaa)
	 * 
	 * @author Enrico Maria Sardellini
	 * @param Long day (variabile contenente il giorno in formato americano)
	 * @return String finale (stringa contenente il giorno in formato europeo)
	 * 
	 */
	public String ControlData(Long day) {
		
		/**
		 * queste variabili string servono a scomporre la data di 8 cifre in formato long
		 * per poi ricomporla in formato europeo nella stringa finale
		 */
		String gg, mm, aaaa, finale;
		
		gg = String.valueOf(day%100);
		mm = String.valueOf(((day%10000) - (day%100))/100);
		aaaa = String.valueOf(day/10000);
		finale = gg + "." + mm + "." + aaaa;
		return finale;
	}
}
