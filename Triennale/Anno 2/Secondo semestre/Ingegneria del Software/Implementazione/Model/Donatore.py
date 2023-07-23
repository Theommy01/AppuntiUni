import datetime

from CodicePython.Model import Tessera
from CodicePython.Model.Donazione import Donazione
from CodicePython.Model.Utente import Utente
from CodicePython.Controller import GestioneFinanze


class Donatore(Utente):

    def __init__(self, cellulare, codice_fiscale, cognome, data_nascita,
                 email, nome, password, numtessera, gruppo_sanguigno, idoneita):
        Utente.__init__(self, cellulare, codice_fiscale, cognome, data_nascita, email, nome, password)
        self.numtessera = numtessera
        self.gruppo_sanguigno = gruppo_sanguigno
        self.idoneita = idoneita

    def __getGruppo_sanguigno__(self):
        return self.gruppo_sanguigno

    def __setGruppo_sanguigno__(self, gruppo_sanguigno):
        self.gruppo_sanguigno = gruppo_sanguigno

    def __getIdoneita__(self):
        return self.idoneita

    def __setIdoneita__(self, idoneita):
        self.idoneita = idoneita

    def getInfoDonatore(self):
        return {
            "Nome": self.nome,
            "Cognome": self.cognome,
            "Codice Fiscale": self.codice_fiscale,
            "Email": self.email,
            "Cellulare": self.cellulare,
            "Data di nascita": self.data_nascita,
            "Password": self.password,
            "Gruppo sanguigno": self.__getGruppo_sanguigno__(),
            "Idoneita": self.__getIdoneita__()
        }

    def __visualizzaDisponibilita__(self):
        donazioni = []
        disponibili = []
        with open('../orari.txt', 'r') as fp:
            for line in fp:  # problema
                donazione = Donazione(year, month, day, hour, minute, disponibile)  # aggiungere attributo???
                donazioni.append(donazione)
            for donazione in donazioni:
                if donazione.disponibile:
                    disponibili.append(donazione)
                    with open('../Controller/disponibilita.txt', 'w') as fp:
                        for donazione in donazioni:
                            fp.write(str(donazione.year) + ' ' + str(donazione.month) + ' ' + str(donazione.day) + ' ' +
                                     str(donazione.hour) + ' ' + str(donazione.minute) + ' ' + str(
                                donazione.disponibile))

"""
Metodo __visualizzaDisponibilità__ (alternativo che stampa solo il file Orari.txt)
--> Per questo motivo bisognerà creare un metodo che permetta di salvare una data
    e fare in modo che non possa essere scelta ancora.
    
    def __visualizzaDisponibilita__(self):
            with open('Orari.txt') as f:
                lines = f.read()
                print(lines)
                
--> IMPORTANTE: QUESTO METODO SU ENTERPRISE CE L'HA SIA IL "DONATORE" CHE "GESTIONE PRENOTAZIONE"
                DEVE ESSERE TENUTO SOLO SU "GESTIONE PRENOTAZIONE"
"""

