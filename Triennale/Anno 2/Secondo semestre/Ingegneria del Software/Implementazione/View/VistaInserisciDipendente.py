from datetime import datetime

from CodicePython.Model.Amministratore import Amministratore
from PyQt5.QtWidgets import QVBoxLayout, QPushButton, QLabel, QLineEdit, QMessageBox, QWidget


class VistaInserisciDipendente(QWidget):

    def __init__(self, callback):
        super(VistaInserisciDipendente, self).__init__()
        self.callback = callback
        self.v_layout = QVBoxLayout()
        self.qLines = {}
        self.add_info_text("codice_fiscale", "CF")
        self.add_info_text("nome", "Nome")
        self.add_info_text("cognome", "Cognome")
        self.add_info_text("data di nascita", "Data Nascita")
        self.add_info_text("idoneita 118", "Idoneita 118")
        self.add_info_text("email", "Email")
        self.add_info_text("cellulare", "Cellulare")
        self.add_info_text("password", "Password")
        self.add_info_text("stato", "Stato")
        self.add_info_text("iban", "IBAN")

        btn_ok = QPushButton("Ok")
        btn_ok.clicked.connect(self.aggiungi_dipendente)
        self.qLines["btn_ok"] = btn_ok
        self.v_layout.addWidget(btn_ok)

        self.setLayout(self.v_layout)
        self.setWindowTitle("Nuovo dipendente")

    def add_info_text(self, nome, label):
        self.v_layout.addWidget(QLabel(label))
        current_text = QLineEdit(self)
        self.qLines[nome] = current_text
        self.v_layout.addWidget(current_text)

    def aggiungi_dipendente(self):  # problema Amministratore !!!!!
        # se serve, aggiungere un try catch. In questo caso no poiche il CF può essere una stringa
        for value in self.qLines.values():
            if isinstance(value, QLineEdit):
                if value.text() == "":
                    QMessageBox.critical(self, 'Errore', 'Inserire tutte le informazioni richieste', QMessageBox.Ok,
                                         QMessageBox.Ok)
                    return
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        try:
            nome = self.qLines["nome"].text()
            print(nome)
            cognome = self.qLines["cognome"].text()
            print(cognome)
            codice_fiscale = self.qLines["codice_fiscale"].text()
            print(codice_fiscale)
            idoneita118 = self.qLines["idoneita 118"].text()
            print(idoneita118)
            data_nascita = datetime.strptime(self.qLines["data di nascita"].text(), '%Y/%m/%d')
            print(data_nascita)
            email = self.qLines["email"].text()
            print(email)
            password = self.qLines["password"].text()
            print(password)
            cellulare = self.qLines["cellulare"].text()
            print(cellulare)
            stato = self.qLines["stato"].text()
            iban = self.qLines["iban"].text()
            print(iban)
            amministratore.iscriviDipendente(cellulare, codice_fiscale, cognome, data_nascita, email, nome, password,
                                             idoneita118, stato, iban)
            print("done")
        except Exception as e:
            print(e)
            QMessageBox.critical(self, 'Errore', 'Controlla i dati inseriti', QMessageBox.Ok, QMessageBox.Ok)
            return
        # self.callback()
        self.close()
