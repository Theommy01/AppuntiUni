package project.exception;

/**
 * Classe che estende IllegalArgumentException e consente di mandare in output il messaggio di errore.
 * 
 * @author Omar Naja
 */
public class EccezionePersonalizzata extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public EccezionePersonalizzata() {
		super();
	}
	
	public EccezionePersonalizzata(String messaggio) {
		super(messaggio);
	}

}