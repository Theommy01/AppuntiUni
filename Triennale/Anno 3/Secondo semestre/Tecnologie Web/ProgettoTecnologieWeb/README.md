# Come muoversi all'interno del progetto
In questa breve guida, verranno elencati i file importanti da modificare in modo da poter procedere con la
stesura del progetto.

Il progetto è realizzato secondo l'architettura MVC

## Interfaccia Utente
I file relativi alla **View** sono contenuti all'interno della cartella *resources/views*. Si può importare un documento esterno da inserire come "parte fissa" attraverso il comando **@extends(indirizzofoglio)**, come viene fatto ad esempio per il footer, il nav e altri.

Le regole CSS possono essere importate usando il semplice attributo "class". Le regole CSS sono tutte definite all'interno della cartella *public/assets/css*.

## Collegamento al DB
I file relativi al **Model** sono contenuti all'interno della cartella *App/Models*. Usando gli opportuni comandi artisan, si possono creare tanti file quante le entità esistenti nella Base di Dati. Il file autogenerato, se desiderato, è modificabile.

Per la connessione diretta al database, ci si connette ad esso tramite il file *config/database.php*, modificando opportunamente i nomi dei paramentri "'database', 'username' e 'password'". Tutte le interazoni saranno successivamente visibili in **phpmyadmin**.

Le classi del Model verrano usate dagli opportuni metodi nei controller per interagire con il DB. I file relativi al **Controller** sono contenuti all'interno della cartella *App/Controllers*. I metodi implementati, tra le altre cose, consentono appuntp di interagire con il database.

Sono, infine, presenti le Migrations ed i Seeders. Le prime servono per gestire e versionare lo schema del database in un'applicazione. Infatti, durante lo sviluppo un'applicazione web che richiede l'utilizzo di un database, è possibile che le tabelle e le colonne cambino nel tempo. Le migrazioni consentono di mantenere traccia di queste modifiche; le seconde sono un gruppo di file utilizzati per popolare il database con dati di esempio utili per testare l'applicazione.

## Attivare le rotte

Le rotte vengono attivate quando richiamate da alcune condizioni, ad esempio il click dell'utente. Sono definite come **route('nomerotta')**. Le rotte sono definite nella cartella *routes*, ed in particolare si lavora solo sui file *web.php*, *auth.php*,*customer.php*, *staff.php* *admin.php*. Nelle rotte, vengono richiamate prima la classe del controller di proprio interesse, e poi un metodo in essa contenuta. Esistono 4 tipologie di rotte, ognuna con le sue esigenze:

 <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Descrizione</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>GET</td>
      <td>Metodo di richiesta per ottenere informazioni dal server</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>POST</td>
      <td>Metodo di richiesta per inviare nuovi dati al server per l'elaborazione</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>PUT</td>
      <td>Metodo di richiesta per aggiornare o sostituire dati esistenti sul server</td>
    </tr>
   <tr>
      <th scope="row">4</th>
      <td>DELETE</td>
      <td>Metodo di richiesta per eliminare dati dal server</td>
    </tr>
  </tbody>
</table>

## Meccanismi di autorizzazione

Le regole e le condizioni di autorizzazione, strutturate come Gate, sono definite nel file *App/Providers/AuthServiceProviders.php*
