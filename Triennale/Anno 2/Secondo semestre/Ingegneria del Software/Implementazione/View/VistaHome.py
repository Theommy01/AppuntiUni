from CodicePython.View.LoginAmministratore import LoginAmministratore
from CodicePython.View.VistaAmministratore import VistaAmministratore
from CodicePython.View.VistaDonatori import VistaDonatori

from CodicePython.View.VistaPersonale import VistaPersonale
from PyQt5.QtWidgets import QWidget, QGridLayout, QPushButton, QSizePolicy

from CodicePython.Controller.GestioneBackup import callAll


class VistaHome(QWidget):

    def __init__(self, parent=None):
        super(VistaHome, self).__init__(parent)
        grid_layout = QGridLayout()
        grid_layout.addWidget(self.get_generic_button("Amministratore", self.go_amministratore), 0, 0)
        grid_layout.addWidget(self.get_generic_button("Donatore", self.go_donatori), 0, 1)
        grid_layout.addWidget(self.get_generic_button("Personale", self.go_personale), 1, 0)
        grid_layout.addWidget(self.get_generic_button("Sistema", self.go_sistema), 1, 1)
        self.setLayout(grid_layout)
        self.resize(400, 300)
        self.setWindowTitle("AVIS")

    def get_generic_button(self, titolo, on_click):
        button = QPushButton(titolo)
        button.setSizePolicy(QSizePolicy.Expanding, QSizePolicy.Expanding)
        button.clicked.connect(on_click)
        return button

    def go_amministratore(self):
        self.login = LoginAmministratore(callback=LoginAmministratore.log)
        self.login.show()

    def go_donatori(self):
        self.vista_donatori = VistaDonatori()
        self.vista_donatori.show()

    def go_personale(self):
        self.vista_personale = VistaPersonale()
        self.vista_personale.show()

    def go_sistema(self):
        callAll()
