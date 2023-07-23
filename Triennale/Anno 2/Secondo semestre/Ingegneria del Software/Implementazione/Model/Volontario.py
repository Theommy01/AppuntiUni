from CodicePython.Model.Personale import Personale
import datetime


class Volontario(Personale):
    def __init__(self, cellulare, codice_fiscale, cognome, data_nascita, email, nome, password, idoneita118, stato):
        Personale.__init__(self, cellulare, codice_fiscale, cognome, data_nascita, email, nome, password, idoneita118,
                           stato)

    def getInfoVolontario(self):
        info = self.getinfoPersonale()
        return info

    # correggere argomenti metodo su enterprise
    def setinfoVolonario(self, cellulare: int, codice_fiscale: "", cognome: "", data_nascita: datetime.date, email: "",
                         nome: "", password: "", idoneita118: bool, stato: bool):
        self.setinfoPersonale(cellulare, codice_fiscale, cognome, data_nascita, email, nome, password,
                              idoneita118, stato)
