from CodicePython.Model.Tessera import Tessera
from CodicePython.Model.Amministratore import Amministratore
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QSpacerItem, QSizePolicy


class VistaTessera(QWidget):  # DA CORREGGERE
    def __init__(self, donatore):
        super(VistaTessera, self).__init__()

        v_layout = QVBoxLayout()
        numero = f"{donatore.numtessera}"
        label_numero = QLabel(numero)
        font_numero = label_numero.font()
        font_numero.setPointSize(30)
        label_numero.setFont(font_numero)
        v_layout.addWidget(label_numero)

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        # Temporaneo?
        # tessera = Tessera(donatore.numtessera, donatore.nome, donatore.cognome, donazioni=None, numero_donazioni=0)
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        tessera = amministratore.ricercaTessera(donatore.numtessera)

        v_layout.addWidget(QLabel(f"Nome: {tessera.nome_donatore}"))
        v_layout.addWidget(QLabel(f"Cognome: {tessera.cognome_donatore}"))
        v_layout.addWidget(QLabel(f"Tessera: {tessera.codice}"))
        v_layout.addWidget(QLabel(f"Donazioni: {tessera.donazioni}"))
        v_layout.addWidget(QLabel(f"Donazioni effettuate: {tessera.numero_donazioni}"))

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        self.setLayout(v_layout)
        self.setWindowTitle("Tessera")
