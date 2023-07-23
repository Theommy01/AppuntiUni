from datetime import datetime

from CodicePython.Model.Amministratore import Amministratore
from CodicePython.Model.Donatore import Donatore
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QLineEdit, QPushButton, QMessageBox


class VistaInserisciDonatore(QWidget):

    def __init__(self, callback):
        super(VistaInserisciDonatore, self).__init__()
        self.callback = callback
        self.v_layout = QVBoxLayout()
        self.qLines = {}
        self.add_info_text("codice_fiscale", "CF")
        self.add_info_text("nome", "Nome")
        self.add_info_text("cognome", "Cognome")
        self.add_info_text("data di nascita", "Data Nascita")
        self.add_info_text("gruppo sanguigno", "Gruppo Sanguigno")
        self.add_info_text("email", "Email")
        self.add_info_text("cellulare", "Cellulare")
        self.add_info_text("idoneita", "Idoneita")
        self.add_info_text("password", "Password")

        btn_ok = QPushButton("Ok")
        btn_ok.clicked.connect(self.aggiungi_donatore)
        self.qLines["btn_ok"] = btn_ok
        self.v_layout.addWidget(btn_ok)

        self.setLayout(self.v_layout)
        self.setWindowTitle("Nuovo donatore")

    def add_info_text(self, nome, label):
        self.v_layout.addWidget(QLabel(label))
        current_text = QLineEdit(self)
        self.qLines[nome] = current_text
        self.v_layout.addWidget(current_text)

    def aggiungi_donatore(self):  # problema Amministratore !!!!!
        # se serve, aggiungere un try catch. In questo caso no poiche il CF può essere una stringa
        for value in self.qLines.values():
            if isinstance(value, QLineEdit):
                if value.text() == "":
                    QMessageBox.critical(self, 'Errore', 'Inserire tutte le informazioni richieste',
                                         QMessageBox.Ok, QMessageBox.Ok)
                    return
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        try:  # DA CONTROLLARE
            nome = self.qLines["nome"].text()
            print(nome)
            cognome = self.qLines["cognome"].text()
            print(cognome)
            codice_fiscale = self.qLines["codice_fiscale"].text()
            print(codice_fiscale)
            gruppo_sanguigno = self.qLines["gruppo sanguigno"].text()
            print(gruppo_sanguigno)
            data_nascita = datetime.strptime(self.qLines["data di nascita"].text(), '%Y/%m/%d')
            print(data_nascita)
            email = self.qLines["email"].text()
            print(email)
            cellulare = self.qLines["cellulare"].text()
            print(cellulare)
            idoneita = self.qLines["idoneita"].text()
            print(idoneita)
            password = self.qLines["password"].text()
            print(password)
            amministratore.iscriviDonatore(nome, cognome, codice_fiscale, data_nascita, cellulare, email,
                                           password, gruppo_sanguigno, idoneita)
            amministratore.crea_tessera(nome, cognome)
            # donatore = Donatore(cellulare, codice_fiscale, cognome, data_nascita,
            #     email, nome, password, numtessera, gruppo_sanguigno, idoneita)
        except:
            QMessageBox.critical(self, 'Errore', 'Controlla i dati inseriti', QMessageBox.Ok, QMessageBox.Ok)
            return
        #     self.callback()
        self.close()
