import os
import pickle

from CodicePython.View.VistaInserisciRapportini import VistaInserisciRapportini
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QPushButton, QLabel, QLineEdit, QMessageBox
from CodicePython.Model import Amministratore


class LoginRapportiniDipendenti(QWidget):
    def __init__(self, callback):
        super(LoginRapportiniDipendenti, self).__init__()
        self.callback = callback
        self.v_layout = QVBoxLayout()
        self.qLines = {}
        self.add_info_text("username", "Username")
        self.add_info_text("password", "Password")
        self.setWindowTitle("Login")
        self.setLayout(self.v_layout)
        btn_ok = QPushButton("Ok")
        btn_ok.clicked.connect(self.log)
        self.qLines["btn_ok"] = btn_ok
        self.v_layout.addWidget(btn_ok)

    def add_info_text(self, param, label):
        self.v_layout.addWidget(QLabel(label))
        current_text = QLineEdit()
        self.qLines[param] = current_text
        self.v_layout.addWidget(current_text)

    def log(self):
        username = self.qLines["username"].text()
        password = self.qLines["password"].text()
        self.elenco_dipendenti = []
        if os.path.isfile('../Model/Dipendenti.pickle'):
            with open('../Model/Dipendenti.pickle', 'rb') as f:
                current = list(pickle.load(f))
                self.elenco_dipendenti.extend(current)
        print(self.elenco_dipendenti)
        for dipendente in self.elenco_dipendenti:
            print(dipendente.codice_fiscale)
            print(dipendente.password)
            if username == dipendente.codice_fiscale and password == dipendente.password:
                self.inserisci_rapportino = VistaInserisciRapportini(callback=VistaInserisciRapportini.aggiungi_rapportino)
                self.inserisci_rapportino.show()
                return
        QMessageBox.critical(self, 'Errore', 'Username e/o password errati', QMessageBox.Ok, QMessageBox.Ok)
