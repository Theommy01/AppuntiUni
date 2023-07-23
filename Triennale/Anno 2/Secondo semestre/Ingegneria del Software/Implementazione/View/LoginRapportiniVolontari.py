import os
import pickle

from CodicePython.View.VistaInserisciRapportini import VistaInserisciRapportini
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QPushButton, QLabel, QLineEdit, QMessageBox
from CodicePython.Model import Amministratore


class LoginRapportiniVolontari(QWidget):
    def __init__(self, callback):
        super(LoginRapportiniVolontari, self).__init__()
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
        self.elenco_volontari = []
        if os.path.isfile('../Model/Volontari.pickle'):
            with open('../Model/Volontari.pickle', 'rb') as f:
                current = list(pickle.load(f))
                self.elenco_volontari.extend(current)
        print(self.elenco_volontari)
        for volontario in self.elenco_volontari:
            print(volontario.codice_fiscale)
            print(volontario.password)
            if username == volontario.codice_fiscale and password == volontario.password:
                self.inserisci_rapportino = VistaInserisciRapportini(callback=VistaInserisciRapportini.aggiungi_rapportino)
                self.inserisci_rapportino.show()
                return
        QMessageBox.critical(self, 'Errore', 'Username e/o password errati', QMessageBox.Ok, QMessageBox.Ok)
