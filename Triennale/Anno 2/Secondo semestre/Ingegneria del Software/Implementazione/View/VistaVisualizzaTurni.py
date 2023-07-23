import datetime
import os.path
import pickle
import random

from CodicePython.Model.Amministratore import Amministratore
from CodicePython.Controller.GestioneFinanze import GestioneFinanze
from CodicePython.View.LoginNuovoDonatore import LoginNuovoDonatore
from CodicePython.View.VistaVisualizzaDonatore import VistaVisualizzaDonatore
from CodicePython.View.VistaVisualizzaPagamento import VistaVisualizzaPagamento
from PyQt5.QtGui import QStandardItemModel, QStandardItem
from PyQt5.QtWidgets import QVBoxLayout, QLabel, QSpacerItem, QSizePolicy, QHBoxLayout, QListView, \
    QWidget, QPushButton


class VistaVisualizzaTurni(QWidget):

    def __init__(self, parent=None):

        self.elenco_volontari = []
        self.elenco_dipendenti = []
        self.windowTemp = QWidget
        super(VistaVisualizzaTurni, self).__init__(parent)
        h_layout = QHBoxLayout()
        self.list_view = QListView()
        self.update_turni()
        h_layout.addWidget(self.list_view)

        self.setLayout(h_layout)
        self.resize(600, 300)
        self.setWindowTitle("Turni Personale Emergenze")

    def update_turni(self):
        self.elenco_volontari = []
        self.elenco_dipendenti = []

        listview_model = QStandardItemModel(self.list_view)  # definisce come è fatta una riga

        with open('../Model/Volontari.pickle', 'rb') as f:  # lettura
            self.elenco_volontari = pickle.load(f)
        with open('../Model/Dipendenti.pickle', 'rb') as f:  # lettura
            self.elenco_dipendenti = pickle.load(f)

        for volontario in self.elenco_volontari:
            if not volontario.idoneita118:
                self.elenco_volontari.remove(volontario)
        for dipendente in self.elenco_dipendenti:
            if not dipendente.idoneita118:
                self.elenco_dipendenti.remove(dipendente)

        if len(self.elenco_dipendenti) >= 1 & len(self.elenco_volontari) >= 1:
            self.list_of_random_items_d = random.sample(self.elenco_dipendenti, 1)
            self.list_of_random_items_v = random.sample(self.elenco_volontari, 1)

        count = 0
        for volontario in self.list_of_random_items_v:
            count += 1
            item = QStandardItem()
            nome = f"{'Volontario scelto n°'}{count}:  " \
                   f"{volontario.nome} {volontario.cognome} {volontario.codice_fiscale}"
            item.setText(nome)
            item.setEditable(False)
            font = item.font()
            font.setPointSize(15)
            item.setFont(font)
            listview_model.appendRow(item)

        count = 0
        for dipendente in self.list_of_random_items_d:
            count += 1
            item = QStandardItem()
            nome = f"{'Dipendente scelto n°'}{count}:  " \
                   f"{dipendente.nome} {dipendente.cognome} {dipendente.codice_fiscale}"
            item.setText(nome)
            item.setEditable(False)
            font = item.font()
            font.setPointSize(15)
            item.setFont(font)
            listview_model.appendRow(item)

        self.list_view.setModel(listview_model)

