import os
import pickle

from CodicePython.Model.Amministratore import Amministratore
from CodicePython.View.LoginRapportiniVolontari import LoginRapportiniVolontari
from CodicePython.View.VistaVisualizzaVolontario import VistaVisualizzaVolontario
from PyQt5.QtGui import QStandardItemModel, QStandardItem

from CodicePython.View.LoginNuovoVolontario import LoginNuovoVolontario
from PyQt5.QtWidgets import QWidget, QHBoxLayout, QListView, QVBoxLayout, QPushButton


class VistaVolontario(QWidget):
    def __init__(self, parent=None):
        self.windowTemp = QWidget
        super(VistaVolontario, self).__init__(parent)
        h_layout = QHBoxLayout()
        self.list_view = QListView()
        self.update_volontari()
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
        self.setWindowTitle("Volontari")

    def load_volontari(self):
        if os.path.isfile('../Model/Volontari.pickle'):
            with open('../Model/Volontari.pickle', 'rb') as f:
                current = list(pickle.load(f))
                self.volontari.extend(current)

    def update_volontari(self):
        self.volontari = []
        self.load_volontari()
        listview_model = QStandardItemModel(self.list_view)  # definisce come è fatta una riga
        for volontario in self.volontari:
            item = QStandardItem()
            nome = f"{volontario.cognome} {volontario.nome} - {volontario.codice_fiscale}"
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
            volontario = amministratore.ricercaVolontario(selected)
            print(volontario.nome)
            self.vista_volontario = VistaVisualizzaVolontario(volontario, elimina_callback=self.update_volontari)
            self.vista_volontario.show()
        except IndexError:
            print("INDEX ERROR")
            return

    def show_new(self):
        self.login = LoginNuovoVolontario(callback=LoginNuovoVolontario.log)
        self.login.show()

    def show_new_rapportini(self):
        self.login = LoginRapportiniVolontari(callback=LoginRapportiniVolontari.log)
        self.login.show()