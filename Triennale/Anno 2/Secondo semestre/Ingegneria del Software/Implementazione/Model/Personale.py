import os
import pickle

from CodicePython.Model.Rapportino import Rapportino
from CodicePython.Model.Utente import Utente
import datetime


class Personale(Utente):
    lista_rapportini = []

    def __init__(self, cellulare, codice_fiscale, cognome, data_nascita, email, nome, password, idoneita118,
                 stato):  # CONTROLLARE QUA
        Utente.__init__(self, cellulare, codice_fiscale, cognome, data_nascita, email, nome, password)
        self.idoneita118 = idoneita118
        self.stato = stato

    def getinfoPersonale(self):
        info = self.getinfoUtente()
        info += {
            "Idoneità 118": self.idoneita118,
            "Stato": self.stato,
            "Turno": self.turno
        }
        return info

    def getIdoneita118(self):
        return self.idoneita118

    def getStato(self):
        return self.stato

    def getTurno(self):
        return self.turno

    def setinfoPersonale(self, cellulare: int, codice_fiscale: "", cognome: "",
                         data_nascita: datetime.date, email: "", nome: "", password: "", idoneita118: bool,
                         stato: bool):
        self.setinfoUtente(cellulare, codice_fiscale, cognome,
                           data_nascita, email, nome, password)
        self.idoneita118 = idoneita118
        self.stato = stato

    def setIdoneita118(self, idoneita: bool):
        self.idoneita118 = idoneita

    def setStato(self, stato: bool):
        self.stato = stato

    def setTurno(self, turno: datetime.date):
        self.turno = turno

    def inserisciRapportino(self, data, KM_inizio, KM_fine):
        rapportino = Rapportino(data, KM_inizio, KM_fine)
        if os.path.isfile('../Model/Rapportini.pickle'):
            with open('../Model/Rapportini.pickle', 'rb') as f:  # lettura
                self.lista_rapportini = pickle.load(f)
        self.lista_rapportini.append(rapportino)
        with open('../Model/Rapportino.pickle', 'wb') as f:
            pickle.dump(self.lista_rapportini, f, pickle.HIGHEST_PROTOCOL)
        return True
