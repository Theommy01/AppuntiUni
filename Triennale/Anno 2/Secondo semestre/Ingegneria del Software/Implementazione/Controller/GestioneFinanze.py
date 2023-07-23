import pickle
from typing import Type
from CodicePython.Model import Amministratore
from CodicePython import Model


class GestioneFinanze:
    KPrezzo = 1.80

    @staticmethod
    def calcolaSpese():
        Tot = 0
        with open('../Model/Rapportino.pickle', 'rb') as f:
            rapportini = list(pickle.load(f))
            for rapportino in rapportini:
                Tot += (float(rapportino.KM_fine) - float(rapportino.KM_inizio)) * GestioneFinanze.KPrezzo
        return float(Tot)

