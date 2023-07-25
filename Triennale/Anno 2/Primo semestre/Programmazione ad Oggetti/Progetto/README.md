 # PROGETTO NAJA - SARDELLINI
 ## Introduzione e descrizione del progetto
 
 Questa applicazione è stata realizzata per un compito d'esame del corso di Programmazione ad Oggetti dell'UNIVPM nell'anno 2021/22. Autori del progetto sono due studenti del
 corso di ingegneria informatica.
 Scopo dell'applicazione è di restituite i dati relativi ad un dato giorno dell'andamento della situazione COVID-19 negli Stati Uniti, facendo un'analisi sul territorio
 nazionale. Per limiti dovuti all'API di riferimento, tali dati sono disponibili solo nel periodo dal 13 gennaio 2020 al 7 marzo 2021.
 A livello di programmazione, questo programma consiste in diversi sottoprogrammi raggruppati in rispettivi packages:
 
 - **project**: contiene il main del programma e il file JSON da cui prendere i dati;
 - **project.control**: contiene l'implementazione e la gestione delle rotte;
 - **project.model**: contiene due classe da cui si instanziano gli oggetti a mano a mano che viene effettuato il parsing,  , delle varie date dal file JSon;
 - **project.service**: vengono impletementati e gestiti, con delle opportune eccezioni, i metodi chiamati da control, e restituiscono degli oggetti JSOn impostati dalle rotte. Viene inoltre effettuato un controllo dei dati presi in input;
 - **project.stats**: vengono sviluppati alcuni metodi per l'analisi di alcuni dati statistici;
 
 Contiene, inoltre, un package a parte su cui vengono svolti dei test sul corretto funzionamento del programma.
 
 ## Come utilizzare l'applicazione
 
  ![Main2](https://user-images.githubusercontent.com/95374284/149659632-28a75c78-61e5-4cec-b649-02d010842991.JPG)
 
 L'applicazione viene facilmente eseguita dopo aver installato il programma, effettuato il debug da questo main. Per fare ciò, installare un ambiente di sviluppo che intepreti
 il linguaggio Java, ad esempio Eclipse, importare l'intero pacchetto contenente il programma su Eclipse come "Existing Maven Project", ed eseguire il "Debug as Spring Boot
 App". Fatto ciò, non occorre farr altro che inserire su un Browser un indirizzo del tipo "localhost:8080/...", dove i "..." indicano quale rotta si vuole mandare in esecuzione.
 
 Qui di seguito un esempio con il seguente indirizzo: **localhost:8080/day?day=13.11.2020**

 ![Chromegetday](https://user-images.githubusercontent.com/95374284/149162861-e2b3b7ef-7fad-4ef2-84de-c9895258b73c.JPG)
 
 La rotta */day*, così come tutte le altre rotte, verrà descritta in seguito.
 
 ![JSON1](https://user-images.githubusercontent.com/95374284/149661797-458adfb2-ea06-4d40-a1fe-d566039d86b7.JPG)
 ![JSON](https://user-images.githubusercontent.com/95374284/149660673-3008833b-6b0c-46cf-b7cf-4b0e18ef932d.JPG)

 Una visuale più chiara di questo codice può essere visualizzata al sito "http://jsonviewer.stack.hu/", ponendo come testo il testo dato in output dall'indirizzo desiderato
 scritto in precedenza e poi selezionando _viewer_.
 
 ### Il Main
 
 ![Main](https://user-images.githubusercontent.com/95374284/148680326-06585bd9-d2c5-4d1a-b31e-7b9c351ea251.JPG)
 
 Il codice qui presente è molto breve, ma fondamentale: viene specificato che l'applicazione che si sta sviluppando è di tipo **SpringBoot**. Ciò significa che, a differenza di
 un classico programma sviluppato in Java, un programma di tipo SpringBoot fornisce funzionalità aggiuntive al framework di partenza, in questo caso **Covid Tracking**.
 Il file *USA.json* contiene tutti i dati covid dei giorni compresi nel periodo sopra definito. Essi si sono ottenuti mettendo l'indirizzo dell'API su postman, da cui poi si è
 generato il file Json fondamentale per effettuare il parsing dei dati, di cui si parlerà in seguito.
 
 ![Postman1](https://user-images.githubusercontent.com/95374284/148680920-ad5c1ba3-f195-4c4d-a8d3-d964ce550aaa.JPG)
 
  ### Il Model
  
  ![Model1](https://user-images.githubusercontent.com/95374284/149664917-bdeae15d-fd76-4d7a-8a57-53e71631b94a.JPG)

  La prima classe presente è una interfaccia, costituita da metodi che verrano poi eseguiti dalle classi che implementano *Dati* tramite il meccanismo di overriding.
 
 ![Model2](https://user-images.githubusercontent.com/95374284/148681779-04151db8-d0ac-40f5-9763-8d245705eb2f.JPG)
 
 Questa è la sottoclasse in cui vengono raccolte le informazioni dei singoli giorni, poi gestite con i dovuti metodi *get()* e *set()*. Tutti questi dati verrano in seguito
 salvati in un vettore dinamico definito nel service.
 
 ![Model3](https://user-images.githubusercontent.com/95374284/149328981-0152ec0d-fe96-4a25-89e4-b1286a1a27cd.JPG)
 
 La sottoclasse *DatiHospital* è molto simile alla sottoclasse *DatiUSA* sopra descritta, ma con la differenza che i dati raccolti in questa sono solo quelli necessari per
 effettuare il calcolo nel metodo **setColour()** per la determinazione del colore del giorno/settimana/mese dato in input.

 
 ### Il Service
 
 ![Service1](https://user-images.githubusercontent.com/95374284/149592659-704a13cd-ef16-49ff-a7bd-bc1c021b584d.JPG)

 La prima classe è una semplice interfaccia, e ha il solo scopo di definire i vari metodi che verranno poi implementati e nella classe *connection*.
 
 ![Eccezione](https://user-images.githubusercontent.com/95374284/149592703-58db90d5-f08c-4505-94c8-012bd140822f.JPG)

 Si apre una breve parentesi per definire la classe *EccezionePersonalizzata*, inserita in un altro package ma definita per l'uso delle eccezioni da lanciare proprio nella
 classe *connection*, centrale nello sviluppo dell'intero programma.
 
 ![ControlParam1](https://user-images.githubusercontent.com/95374284/149592904-6f1ad038-4a9a-4958-9cc2-46f1c8f6bed0.JPG)

 Un controllo viene effettuato anche dalla classe *ControlParam*, dotata anch'essa di una interfaccia da cui poi vengono implementati i vari metodi definiti, per verificare
 che la data presa in input sia valida e vengono lanciati errori nel caso non lo sia. In particolare:
 
 ![ControlParam2](https://user-images.githubusercontent.com/95374284/149593095-0f06ab19-a858-4884-b1b8-15244bb9076a.JPG)

 In *ControlDay(String day)* viene controllato se il giorno inserito è del formato corretto, ossia gg.mm.aaaa. Tale metodo richiama un'altro metodo, *ControlYear(String day)*
 che "aaaa" sia o 2020 o 2021;
 
 ![ControlParam3](https://user-images.githubusercontent.com/95374284/149593211-ea092334-f127-47ba-9590-56b21b4e8b06.JPG)

 In *ControlColour(String finale)* viene verificato che venga dato in input un colore accettabile;
 
 ![ControlParam4](https://user-images.githubusercontent.com/95374284/149593360-78496316-4c1d-4086-b443-1f846d7fa64c.JPG)

 In *ControlMonth(String month, String year)* viene verificato che sia stato inserito un mese accettabile.
 
 ![ControlParam5](https://user-images.githubusercontent.com/95374284/149593447-4671acfe-5dfa-4a60-9129-912a4cc73101.JPG)
 
 Ultimi controlli per verificare che, alla chiamata di *getWeek(String day)*, non venga inserito un giorno troppo vicino all'ultima data del range fornito dall'API.
 Dovendo questo metodo lavorare sui 7 giorni successivi a quello dato in input, come si spiegherà in seguito, dare ad esempio il penultimo giorno disponibile significherebbe che
 verrebbero letti solo 2 giorni e per gli altri 5 si cadrebbe in errore.
 
 ![Conversion USA-UE](https://user-images.githubusercontent.com/95374284/149593524-5fdac710-a25e-41a6-a064-4ac0d433ddba.JPG)

 
 In ControlData(Long day) qui implementato il metodo che converte le date dal formato aaaa.mm.gg (ossia quello di default dell'API) al "formato europeo" gg.mm.aaaa.
 
 ![Service2](https://user-images.githubusercontent.com/95374284/149593717-77249fb3-3cf5-435a-9481-8ac93097705a.JPG)
 ![Service3](https://user-images.githubusercontent.com/95374284/149593813-29ac719f-9168-4c67-b8e6-ae336cb91167.JPG)
 ![Service4](https://user-images.githubusercontent.com/95374284/149593887-56ba7a6b-77d8-4862-b235-a2e59d995986.JPG)

 
 Il primo metodo presente nella classe *connection* è chiamato *parsingData()*, e ha lo scopo di definire due vettori dinamici vett1 e vett2 dove vengono a mano a mano
 immagazzinati i vari oggetti di tipo rispettivamente *DatiUSA* e *DatiHospital*, con le proprietà definite in precedenza nel Model e prese dal file JSon.
 
 I successivi metodi sono quelli che poi verranno usati dalle rotte, per tutti e 5 si implementa il dovuto metodo per la ricerca del giorno/settimana/mese/2 giorni/colore
 dato/i in input per poi svolgere il compito richiesto.
 
 ![Service5](https://user-images.githubusercontent.com/95374284/149593970-a038ed09-7854-4dda-99f7-04636d13a201.JPG)
 
 Il metodo *getToday(String day)* chiede in input un giorno di cui si vuole stampare il bollettino COVID, successivamente cerca all'interno del vettore di tipo DatiUSA se quella
 data fornita in input è presente. In caso affermativo, stampa in output le informazioni richieste, e delle relative statistiche su quel giorno. In caso negativo, viene lanciata
 l'eccezione con il messaggio "Day not found!".
 
 ![Service11](https://user-images.githubusercontent.com/95374284/149594039-64ed6ee2-19e4-4f91-a7de-2cf2f933e371.JPG)
 
 E' presente anche il metodo *getToday(Integer day)*, che viene facilmente distinto dal primo grazie al meccanismo di overloading; viene avviato dagli altri metodi di
 *connection* che avranno già effettuato i loro controlli sulla data e dunque evitare ulteriori calcoli e ricerche già svolte in precedenza.
 
 ![Service6](https://user-images.githubusercontent.com/95374284/149594135-8a1426df-94d1-4827-8344-4e390edcf091.JPG)
 
 *getWeek(String day)* funziona in maniera del tutto analoga: chiede in input un giorno e vengono restituite 2 diverse informazioni: la prima riguarda i bollettini dei 7 giorni
 successivi al giorno dato in input, la seconda stima l'incremento/decremento di alcuni dati nel corso della settimana. In caso di settimana "inesistente" (basta che su 7 giorni
 uno solo non sia all'interno del range di date precedentemente definito) viene lanciata l'eccezione.
 
 ![Service7](https://user-images.githubusercontent.com/95374284/149594267-cb9e1abf-3613-4c38-9e69-e9da8ff4b5e8.JPG)
 ![Service8](https://user-images.githubusercontent.com/95374284/149594277-b6041096-0f1c-448b-8033-1a97d48d5fd9.JPG)
 
 Il metodo *getMonth(String month, String year)* è leggermente più complesso perchè chiede in input due parametri: il mese e l'anno di interesse. Una volte prese queste
 informazioni, viene restituito in output il bollettino di tutti i giorno del mese richiesto. L'eccezione viene lanciata se viene inserito un mese o un anno non valido.
 
 ![Service9](https://user-images.githubusercontent.com/95374284/149594415-f5cb6015-ce0d-44e2-81dc-7df7c5f6d867.JPG)
 
 *getColour(String finale)* chiede in input un colore e restituisce tutti i giorni che hanno una situazione pandemica tale dall'essere di quel colore (bianco, rosso etc.).
 Se il colore non esiste (ad esempio, chiedere informazioni circa la "zona viola"), viene lanciata l'eccezione.
 
 ![Service10](https://user-images.githubusercontent.com/95374284/149594531-f2a7f841-d7f4-444b-8f49-02eb84c46c74.JPG)
 ![Service10+](https://user-images.githubusercontent.com/95374284/149594546-e16cbde6-9601-4b55-9786-2d54f66e269f.JPG)
 
 L'ultimo metodo implementato chiede in input due date diverse e fa il confronto della situazione COVID tra i due giorni. Basta che uno solo dei due non esista per lanciare
 l'eccezione.
 
 ### Lo Stats
 
 ![Stats1](https://user-images.githubusercontent.com/95374284/149322094-048abd91-c6cb-4f94-9562-a82a4f9a7204.JPG)
 In *Stats* è presente una prima interfaccia **Statistics_interface** da cui poi vengono implementati i vari metodi nella classe **Statistics**.
 
 ![Stats2](https://user-images.githubusercontent.com/95374284/149322491-b3cadab4-8027-44f6-b829-e20aad9e6ce6.JPG)

 La classe *statistics* è formata da 4 metodi i quali riportano delle statistiche. Le percentuali sono arrotondate al secondo decimale e vengono presi in considerazioni il
 numero dei positivi, dei negativi, delle ospedalizzazioni, delle terapie intensive e delle morti.
 
 ![Statslong1](https://user-images.githubusercontent.com/95374284/149322712-dd0bd239-d653-4a8f-8973-f8641e0c106c.JPG)
 ![Statslong2](https://user-images.githubusercontent.com/95374284/149322735-a9c52930-bfc0-45c4-91e0-313c1418e47f.JPG)
 
 StatsLong(ArrayList<DatiUSA> vett1, ArrayList<DatiHospital> vett2, JSONArray array, Integer i, Integer dayfinal) è legata alle rotte **/week** & **/month**. Mostra gli
 andamenti percentuali del primo e ultimo giorno, il numero totale e medio nella settimana/mese dei positivi e negativi e l’aumento o diminuzione dei letti d’ospedale.
 
 ![Stats2days1](https://user-images.githubusercontent.com/95374284/149323292-5b27f1ea-1b98-4a75-a784-0d7df16e17d2.JPG)
 ![Stats2days2](https://user-images.githubusercontent.com/95374284/149323319-925317ff-c837-42d9-8b7e-1550f62a98f6.JPG)
 
 Stats2days(ArrayList<DatiUSA> vett1, ArrayList<DatiHospital> vett2, JSONArray array, String day1, String day2) è legata alla rotta **/2days**. Confronta gli andamenti
 percentuali dei vari parametri sopra elencati.
 
 ![StatsColour](https://user-images.githubusercontent.com/95374284/149325565-b418afa6-2869-4a4e-ae41-9224314fdba0.JPG)

 Il primo StastsColour(ArrayList<DatiHospital> vett2, String colour) è un semplice contatore che conta i giorni con il colore passato tra i parametri.
 Il secondo StatsColour(ArrayList<DatiHospital> vett2, JSONObject obj, Integer i) prende in input un oggetto JSon è restituisce dei nuovi risultati in cui vengono calcolate le
 percentuali di terapie intensive ed ospedalizzazioni.
 
 I due metodi vengono distinti grazie al meccanismo di overloading.
 
 ### Il Control
 
 ![Control1](https://user-images.githubusercontent.com/95374284/149161993-e4686fcf-3c37-4215-bb4e-d77fd2c29f41.JPG)
 ![Control2](https://user-images.githubusercontent.com/95374284/149162008-bae7a93c-35d3-4af7-9a74-5c0b27edb30d.JPG)
 
 All'interno del *Controller* vengono gestiti i metodi che consentono l'utilizzo delle rotte da web service esterni (tra cui postman oppure internet)
 
 **Rotte e descrizione**
 
 <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Tipo</th>
      <th scope="col">Descrizione</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>/day</td>
      <td>GET</td>
      <td>Restituisce il bollettino COVID del giorno dato in input</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>/week</td>
      <td>GET</td>
      <td>Restituisce il bollettino COVID dei 7 giorni successivi a quello dato in input</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>/month</td>
      <td>GET</td>
      <td>Restituisce tutti i bollettini COVID del mese dato in input</td>
    </tr>
   <tr>
      <th scope="row">4</th>
      <td>/colour</td>
      <td>GET</td>
      <td>Restituisce tutti i bollettini COVID dei giorni che sono risultati di un certo colore (bianco, giallo etc.)</td>
    </tr>
   <tr>
      <th scope="row">5</th>
      <td>/2days</td>
      <td>GET</td>
      <td>Effettua un confronto dei dati COVID tra 2 giorni diversi, dati entrambi in input</td>
    </tr>
  </tbody>
</table>

Alcuni esempi di utilizzo delle rotte:

**/day**

![Postman2](https://user-images.githubusercontent.com/95374284/149158978-a8cce1f0-f12a-4620-8e8d-121b23231aea.JPG)

**/week**

 ![Postman3](https://user-images.githubusercontent.com/95374284/149159350-7f009f66-1a15-4086-9f19-25f3f6823732.JPG)

**/month**

![Postman4](https://user-images.githubusercontent.com/95374284/149160038-373fc347-60ae-4084-8d31-99e35c60ebf9.jpeg)

**/colour**

![Postman5](https://user-images.githubusercontent.com/95374284/149160354-aa85f13c-622e-4096-94da-643c2b25aea3.JPG)

**/2days**

![Postman6](https://user-images.githubusercontent.com/95374284/149160780-4d512069-4d5b-4365-9562-29dd964acc54.JPG)


## Test
 
![Test](https://user-images.githubusercontent.com/95374284/149595246-dda66b96-3007-4ed3-ab62-7b17c6d353d3.JPG)
 
 Nel programma sono presenti alcuni test che verificano il corretto funzionamento di alcuni metodi. Vediamo in particolare, come esempi, quelli che controllano iln funzionamento
 (e non funzionamento) del metodo *getDay()* e il corretto funzionamento per *get2Days()*.
 Appoggiandosi ad un oggetto di tipo *connection*, si richiamato tali metodi e, attraverso il ***JUnit test***, si verifica se tali metodi effettuano ciò che ci si aspetta o
 meno.
 Infatti, dei 3 test presi in esame, 2 funzionano correttamente mentre il terzo (testDataNoOK()) restituisce errore, in quanto gli viene passato come argomento una data
 non appartenente al range dell'API.
 
 ## Divisione dei compiti
- Naja Omar: project.model, alcuni metodi del connection, project.controller, project.exception, test, readme
- Sardellini Enrico Maria: project.model, project.service, project.stats, project.controller, JavaDoc
