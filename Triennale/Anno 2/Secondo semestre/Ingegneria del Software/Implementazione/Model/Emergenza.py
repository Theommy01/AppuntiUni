import datetime
import pickle
from CodicePython.Model.Dipendente import Dipendente
from CodicePython.Model.Rapportino import Rapportino


class Emergenza:

    def __init__(self, spesa: int, stato: bool, tipo: ""):
        self.spesa = spesa
        self.stato = stato
        self.tipo = tipo

    def __getSpesa__(self):
        return self.spesa

    def __setSpesa__(self, spesa: int):
        self.spesa = spesa

    def __getStato__(self):
        return self.stato

    def __setStato__(self, stato: bool):
        self.stato = stato

    def __getTipo__(self):
        return self.tipo

    def __setTipo__(self, tipo: ""):
        self.tipo = tipo

    def __assegnaPersonale__(self, dipendente: Dipendente, volontario: Volontario, volontario2: Volontario):
        pass

    def __assegnaRapportino__(self, data: datetime.datetime, inizio: int, fine: int):
        pass