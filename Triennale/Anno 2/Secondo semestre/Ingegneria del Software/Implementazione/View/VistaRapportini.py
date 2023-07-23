import os
import pickle

from CodicePython.Model.Amministratore import Amministratore
from CodicePython.View.VistaVisualizzaRapportino import VistaVisualizzaRapportino
from PyQt5.QtGui import QStandardItemModel, QStandardItem

from PyQt5.QtWidgets import QWidget, QHBoxLayout, QListView, QVBoxLayout, QPushButton


class VistaRapportini(QWidget):
    def __init__(self, parent=None):
        self.windowTemp = QWidget
        super(VistaRapportini, self).__init__(parent)
        h_layout = QHBoxLayout()
        self.list_view = QListView()
        self.update_rapportini()
        h_layout.addWidget(self.list_view)

        buttons_layout = QVBoxLayout()  # layout verticale
        open_button = QPushButton('Apri')
        open_button.clicked.connect(self.show_selected_info)
        buttons_layout.addWidget(open_button)
        buttons_layout.addStretch()
        h_layout.addLayout(buttons_layout)

        self.setLayout(h_layout)
        self.resize(600, 300)
        self.setWindowTitle("Rapportini")

    def load_rapportini(self):
        if os.path.isfile('../Model/Rapportino.pickle'):
            with open('../Model/Rapportino.pickle', 'rb') as f:
                self.rapportini = list(pickle.load(f))

    #         current = list(pickle.load(f))
    #        self.rapportini.extend(current)

    def update_rapportini(self):
        self.rapportini = []
        self.load_rapportini()
        print(self.rapportini)
        listview_model = QStandardItemModel(self.list_view)  # definisce come è fatta una riga
        for rapportino in self.rapportini:
            item = QStandardItem()
            nome = f"{rapportino.data_servizio}"
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
            print(selected)
            rapportino = amministratore.visualizzaRapportini(selected)  # non returna niente
            print(rapportino)
            self.vista_rapportino = VistaVisualizzaRapportino(rapportino)
            self.vista_rapportino.show()
        except IndexError:
            print("INDEX ERROR")
            return
