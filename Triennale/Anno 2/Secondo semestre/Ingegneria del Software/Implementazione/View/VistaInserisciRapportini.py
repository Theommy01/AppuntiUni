from datetime import datetime

from CodicePython.Model.Personale import Personale
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QPushButton, QLabel, QLineEdit, QMessageBox


class VistaInserisciRapportini(QWidget):
    def __init__(self, callback):
        super(VistaInserisciRapportini, self).__init__()
        self.callback = callback
        self.v_layout = QVBoxLayout()
        self.qLines = {}
        self.add_info_text("data", "Data")
        self.add_info_text("km inizio", "KM Inizio")
        self.add_info_text("km fine", "KM Fine")

        btn_ok = QPushButton("Ok")
        btn_ok.clicked.connect(self.aggiungi_rapportino)
        self.qLines["btn_ok"] = btn_ok
        self.v_layout.addWidget(btn_ok)

        self.setLayout(self.v_layout)
        self.setWindowTitle("Nuovo rapportino")

    def add_info_text(self, nome, label):
        self.v_layout.addWidget(QLabel(label))
        current_text = QLineEdit(self)
        self.qLines[nome] = current_text
        self.v_layout.addWidget(current_text)

    def aggiungi_rapportino(self):
        for value in self.qLines.values():
            if isinstance(value, QLineEdit):
                if value.text() == "":
                    QMessageBox.critical(self, 'Errore', 'Inserire tutte le informazioni richieste', QMessageBox.Ok,
                                         QMessageBox.Ok)
                    return
        try:
            data = datetime.strptime(self.qLines["data"].text(), '%Y/%m/%d')
            print(data)
            km_inizio = self.qLines["km inizio"].text()
            print(km_inizio)
            km_fine = self.qLines["km fine"].text()
            print(km_fine)
            personale = Personale(1, 1, 1, 1, 1, 1, 1, 1, 1)  # valori di default
            personale.inserisciRapportino(data, km_inizio, km_fine)
        except Exception as e:
            print(e)
            QMessageBox.critical(self, 'Errore', 'Controlla i dati inseriti', QMessageBox.Ok, QMessageBox.Ok)
            return
        # self.callback()
        self.close()
