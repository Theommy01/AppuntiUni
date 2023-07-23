import datetime
import os
import pickle
import unittest

from CodicePython.Model.Amministratore import Amministratore


class MyTestCase(unittest.TestCase):
    def test_add_dipendente(self):
        self.amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                             2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")

        self.amministratore.iscriviDipendente(123456789, "cf", "cognome", datetime.datetime(2000, 1, 1), "email",
                                              "nome", 3333333333, "password", 1, 1)

        dipendenti = None
        if os.path.isfile('../Model/Dipendenti.pickle'):
            with open('../Model/Dipendenti.pickle', 'rb') as f:
                dipendenti = pickle.load(f)
        self.assertIsNotNone(dipendenti)  # controllo se il file Dipendenti esiste
        self.assertIn("cf", dipendenti)   # chiave, elenco

    def test_remove_donatore(self):
        dipendenti = None
        if os.path.isfile('../Model/Dipendenti.pickle'):
            with open('../Model/Dipendenti.pickle', 'rb') as f:
                dipendenti = pickle.load(f)
        self.assertIsNotNone(dipendenti)
        self.assertIn("cf", dipendenti)
        self.dipendente = self.amministratore.ricercaDipendente("cf")
        self.amministratore.eliminaDipendente("cf")
        if os.path.isfile('../Model/Dipendenti.pickle'):
            with open('../Model/Dipendenti.pickle', 'rb') as f:
                dipendenti = pickle.load(f)
        self.assertIsNotNone(dipendenti)
        self.assertNotIn("cf", dipendenti)


if __name__ == '__main__':
    unittest.main()
