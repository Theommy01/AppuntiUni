import os
import pickle

from CodicePython.Model.Amministratore import Amministratore
from CodicePython.View.LoginNuovoDipendente import LoginNuovoDipendente
from CodicePython.View.LoginRapportiniDipendenti import LoginRapportiniDipendenti
from CodicePython.View.VistaVisualizzaDipendente import VistaVisualizzaDipendente
from PyQt5.QtGui import QStandardItemModel, QStandardItem

from PyQt5.QtWidgets import QWidget, QHBoxLayout, QListView, QVBoxLayout, QPushButton


class VistaDipendente(QWidget):
    def __init__(self, parent=None):
        self.windowTemp = QWidget
        super(VistaDipendente, self).__init__(parent)
        h_layout = QHBoxLayout()
        self.list_view = QListView()
        self.update_dipendenti()
        h_layout.addWidget(self.list_view)

        buttons_layout = QVBoxLayout()  # layout verticale
        open_button = QPushButton('Apri')
        open_button.clicked.connect(self.show_selected_info)
        buttons_layout.addWidget(open_button)

        new_button = QPushButton('Nuovo')
        new_button.clicked.connect(self.show_new)
        buttons_layout.addWidget(new_button)
        buttons_layout.addStretch()
        h_layout.addLayout(buttons_layout)

        rapportini_button = QPushButton('Rapportini')
        rapportini_button.clicked.connect(self.show_new_rapportini)
        buttons_layout.addWidget(rapportini_button)
        buttons_layout.addStretch()
        h_layout.addLayout(buttons_layout)

        self.setLayout(h_layout)
        self.resize(600, 300)
        self.setWindowTitle("Dipendenti")

    def load_dipendenti(self):
        if os.path.isfile('../Model/Dipendenti.pickle'):
            with open('../Model/Dipendenti.pickle', 'rb') as f:
                current = list(pickle.load(f))
                self.dipendenti.extend(current)

    def update_dipendenti(self):
        self.dipendenti = []
        self.load_dipendenti()
        listview_model = QStandardItemModel(self.list_view)  # definisce come è fatta una riga
        for dipendente in self.dipendenti:
            item = QStandardItem()
            nome = f"{dipendente.cognome} {dipendente.nome} - {dipendente.codice_fiscale}"
            item.setText(nome)
            item.setEditable(False)
            font = item.font()
            font.setPointSize(15)
            item.setFont(font)
            listview_model.appendRow(item)
        self.list_view.setModel(listview_model)

    def show_selected_info(self):
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        try:
            selected = self.list_view.selectedIndexes()[0].data()
            selected = selected.split("-")[1].strip()
            print(selected)
            dipendente = amministratore.ricercaDipendente(selected)
            self.vista_dipendente = VistaVisualizzaDipendente(dipendente, elimina_callback=self.update_dipendenti)
            self.vista_dipendente.show()
        except IndexError:
            print("INDEX ERROR")
            return

    def show_new(self):
        self.login = LoginNuovoDipendente(callback=LoginNuovoDipendente.log)
        self.login.show()

    def show_new_rapportini(self):
        self.login = LoginRapportiniDipendenti(callback=LoginRapportiniDipendenti.log)
        self.login.show()