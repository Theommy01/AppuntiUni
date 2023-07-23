import datetime


class Utente:
    def __init__(self, cellulare, codice_fiscale, cognome, data_nascita, email, nome, password):
        self.cellulare = cellulare
        self.codice_fiscale = codice_fiscale
        self.cognome = cognome
        self.data_nascita = data_nascita
        self.email = email
        self.nome = nome
        self.password = password

    def getCellulare(self):
        return self.cellulare

    def setCellulare(self, cellulare: int):
        self.cellulare = cellulare

    def getCodice_fiscale(self):
        return self.codice_fiscale

    def setCodice_fiscale(self, codice_fiscale: ""):
        self.codice_fiscale = codice_fiscale

    def getCognome(self):
        return self.cognome

    def setCognome(self, cognome: ""):
        self.cognome = cognome

    def getData_nascita(self):
        return self.data_nascita

    def setData_nascita(self, data_nascita: datetime.date):
        self.data_nascita = data_nascita

    def getEmail(self):
        return self.email

    def setEmail(self, email: ""):
        self.email = email

    def getNome(self):
        return self.nome

    def setNome(self, nome: ""):
        self.nome = nome

    def getPassword(self):
        return self.password

    def setPassword(self, password: ""):
        self.password = password

    # Permette il ritorno in formato String di tutti gli Attributi (getinfoUtente)
    def getinfoUtente(self):
        return {
            "Nome": self.getNome(),
            "Cognome": self.getCognome(),
            "Codice Fiscale": self.getCodice_fiscale(),
            "Email": self.getEmail(),
            "Cellulare": self.getCellulare(),
            "Data di nascita": self.getData_nascita(),
            "Password": self.getPassword()
        }

    # Permette l'aggiornamento di tutti gli attributi dell'oggetto Utente (setinfoUtente)
    def setinfoUtente(self, nome: "", cognome: "", codice_fiscale: "", email: "", cellulare: int,
                      data_nascita: datetime.datetime, password: ""):
        Utente.setNome(self, nome)
        Utente.setCognome(self, cognome)
        Utente.setCodice_fiscale(self, codice_fiscale)
        Utente.setEmail(self, email)
        Utente.setCellulare(self, cellulare)
        Utente.setData_nascita(self, data_nascita)
        Utente.setPassword(self, password)
