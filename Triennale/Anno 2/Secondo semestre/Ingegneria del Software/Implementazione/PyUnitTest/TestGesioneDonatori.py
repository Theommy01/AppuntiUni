import datetime
import os
import pickle
from unittest import TestCase

from CodicePython.Model.Amministratore import Amministratore


class TestGestioneDonatori(TestCase):
    def test_add_donatore(self):
        self.amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")

        self.amministratore.iscriviDonatore("nome", "cognome", "cf", datetime.datetime(1990, 10, 12), 3333333333,
                                            "email", "password", "AB")
        donatori = None
        if os.path.isfile('../Model/Donatori.pickle'):
            with open('../Model/Donatori.pickle', 'rb') as f:
                donatori = pickle.load(f)
        self.assertIsNotNone(donatori)  #controllo se il file Donatori esiste
        self.assertIn("cf", donatori)  #chiave, elenco

    def test_remove_donatore(self):
        donatori = None
        if os.path.isfile('../Model/Donatori.pickle'):
            with open('../Model/Donatori.pickle', 'rb') as f:
                donatori = pickle.load(f)
        self.assertIsNotNone(donatori)
        self.assertIn("cf", donatori)
        self.donatore = self.amministratore.ricercaDonatore("cf")
        self.amministratore.eliminaDonatore("cf")
        if os.path.isfile('../Model/Donatori.pickle'):
            with open('../Model/Donatori.pickle', 'rb') as f:
                donatori = pickle.load(f)
        self.assertIsNotNone(donatori)
        self.assertNotIn("cf", donatori)

