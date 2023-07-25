package project.control;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import project.exception.EccezionePersonalizzata;
import project.service.connection;

/**
 * la classe SimpleRestController traccia le 5 rotte che permettono di ottenere una lista e/o una statistica 
 * del file USA.json.
 * 
 * limitazioni parametri:
 * -i giorni del file JSON vanno dal 13.1.2020 al 7.3.2021;
 * -i colori sono: white, yellow, orange, red;
 * 
 * Il parametro da passare se viene richiesto il giorno è gg.mm.aaaa
 * (esempio 12.3.2020 o 7.10.2021)
 * Attenti agli 0
 * 
 * @author Enrico Maria Sardellini
 * @author Omar Naja
 */
@RestController
public class SimpleRestController {
	
	public connection uss = new connection();

	/**
	 * permette di ottenere il bollettino covid del giorno inserito
	 * 	 
	 * @author Enrico Maria Sardellini
	 * @author Omar Naja
	 * @param day (variabile che indica il giorno)
	 * @see project.service.connection.getToday()
	 */
	@RequestMapping(value = "/day", method = RequestMethod.GET)
	public ResponseEntity<Object> getDay(@RequestParam String day) {
		return new ResponseEntity<Object>(this.uss.getToday(day), HttpStatus.OK);		
	}

	/**
	 * permette di ottenere un andamento della pandemia nella settimana,
	 * che ha come 1° giorno la stringa data e la lista dei bollettini della settimana 
	 * 
	 * @author Enrico Maria Sardellini
	 * @param day (variabile che indica il primo giorno della settimana)
	 * @see project.service.connection.getWeek()
	 */
	@RequestMapping(value = "/week", method = RequestMethod.GET)
	public ResponseEntity<Object> getWeek(@RequestParam String day) {
		return new ResponseEntity<Object>(this.uss.getWeek(day), HttpStatus.OK);
	}
	
	/**
	 * permette di ottenere un andamento della pandemia nel mese,
	 * e la lista dei bollettini del mese 
	 * 
	 * @author Enrico Maria Sardellini
	 * @param month (variabile che indica il mese)
	 * @param year (variabile che indica l'anno)
	 * @see project.service.connection.getMonth()
	 */
	@RequestMapping(value = "/month", method = RequestMethod.GET)
	public ResponseEntity<Object> getMonth(@RequestParam String month, String year) {
		return new ResponseEntity<Object>(this.uss.getMonth(month, year), HttpStatus.OK);
	}
	
	/**
	 * permette di avere la lista dei giorni aventi quel colore
	 * 
	 * @author Enrico Maria Sardellini
	 * @param colour (variabile che indica il colore)
	 * @see project.service.connection.getColour()
	 */
	@RequestMapping(value = "/colour", method = RequestMethod.GET)
	public ResponseEntity<Object> getColour(@RequestParam String colour) {
		return new ResponseEntity<Object>(this.uss.getColour(colour), HttpStatus.OK);
	}
	
	/**
	 * permette di avere i bollettini dei due giorni e una serie 
	 * di statistiche messe a confronto. se il giorno è lo stesso, verrà stampato solo il 
	 * bollettino di quel giorno
	 * 
	 * @author Enrico Maria Sardellini
	 * @param day1 (variabile che indica il primo giorno)
	 * @param day2 (variabile che indica il secondo giorno)
	 * @see project.service.connection.get2days()
	 */
	@RequestMapping(value = "/2days", method = RequestMethod.GET)
	public ResponseEntity<Object> getDays(@RequestParam String day1, String day2) {
		return new ResponseEntity<Object>(this.uss.get2days(day1, day2), HttpStatus.OK);
	}

}