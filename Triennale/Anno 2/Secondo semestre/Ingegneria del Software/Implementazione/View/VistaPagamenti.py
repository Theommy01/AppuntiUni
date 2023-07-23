import datetime
import os.path
import pickle

from CodicePython.Model.Amministratore import Amministratore
from CodicePython.Controller.GestioneFinanze import GestioneFinanze
from CodicePython.View.LoginNuovoDonatore import LoginNuovoDonatore
from CodicePython.View.VistaVisualizzaDonatore import VistaVisualizzaDonatore
from CodicePython.View.VistaVisualizzaPagamento import VistaVisualizzaPagamento
from PyQt5.QtGui import QStandardItemModel, QStandardItem
from PyQt5.QtWidgets import QVBoxLayout, QLabel, QSpacerItem, QSizePolicy, QHBoxLayout, QListView, \
    QWidget, QPushButton


class VistaPagamenti(QWidget):
    def __init__(self, parent=None):
        self.vista_pagamento = None
        self.donatori = []

        self.windowTemp = QWidget
        super(VistaPagamenti, self).__init__(parent)
        h_layout = QHBoxLayout()
        self.list_view = QListView()
        self.update_pagamenti()
        h_layout.addWidget(self.list_view)

        buttons_layout = QVBoxLayout()  # layout verticale
        open_button = QPushButton('Richiedi')
        open_button.clicked.connect(self.show_selected_info)
        buttons_layout.addWidget(open_button)

        buttons_layout.addStretch()
        h_layout.addLayout(buttons_layout)

        self.setLayout(h_layout)
        self.resize(600, 300)
        self.setWindowTitle("Pagamenti")

    def update_pagamenti(self):
        listview_model = QStandardItemModel(self.list_view)  # definisce come è fatta una riga
        item = QStandardItem()
        nome = f"{'Pagamento in data'}  {datetime.date.today()} : €{GestioneFinanze.calcolaSpese()}"
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
            select = float(selected.split("€")[1].strip())
            pagamento = GestioneFinanze.calcolaSpese()
            self.vista_pagamento = VistaVisualizzaPagamento(pagamento)
            self.vista_pagamento.show()
        except IndexError:
            print("INDEX ERROR")
            return
