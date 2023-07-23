from CodicePython.View.VistaDonazioni import VistaDonazioni
from CodicePython.View.VistaPagamenti import VistaPagamenti
from CodicePython.View.VistaRapportini import VistaRapportini
from CodicePython.View.VistaVisualizzaTurni import VistaVisualizzaTurni
from PyQt5.QtWidgets import QWidget, QGridLayout, QSizePolicy, QPushButton


class VistaAmministratore(QWidget):
    def __init__(self, parent=None):
        super(VistaAmministratore, self).__init__(parent)
        grid_layout = QGridLayout()
        grid_layout.addWidget(self.get_generic_button("Gestione Donazioni", self.go_handle_donazioni), 1, 0)
        grid_layout.addWidget(self.get_generic_button("Gestione Rapportini", self.go_handle_rapportini), 1, 1)
        grid_layout.addWidget(self.get_generic_button("Gestione Pagamenti", self.go_handle_payments), 0, 1)
        grid_layout.addWidget(self.get_generic_button("Gestione Turni", self.go_turni), 0, 0)
        self.setLayout(grid_layout)
        self.resize(400, 300)
        self.setWindowTitle("Amministratore")

    def get_generic_button(self, titolo, on_click):
        button = QPushButton(titolo)
        button.setSizePolicy(QSizePolicy.Expanding, QSizePolicy.Expanding)
        button.clicked.connect(on_click)
        return button

    def go_handle_donazioni(self):
        self.vista_donazioni = VistaDonazioni()
        self.vista_donazioni.show()

    def go_handle_rapportini(self):
        self.vista_rapportini = VistaRapportini()
        self.vista_rapportini.show()

    def go_handle_payments(self):
        self.vista_pagamenti = VistaPagamenti()
        self.vista_pagamenti.show()

    def go_turni(self):
        self.vista_turni = VistaVisualizzaTurni()
        self.vista_turni.show()



