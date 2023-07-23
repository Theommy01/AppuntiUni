from CodicePython.Model.Donatore import Donatore
from CodicePython.View.VistaTessera import VistaTessera
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QSpacerItem, QSizePolicy, QPushButton
from CodicePython.Model.Amministratore import Amministratore


class VistaVisualizzaDonatore(QWidget):
    def __init__(self, donatore, elimina_callback):  # gestione visualizza ed elimina donatore
        super(VistaVisualizzaDonatore, self).__init__()
        self.elimina_callback = elimina_callback

        v_layout = QVBoxLayout()
        codice_fiscale = f"{donatore.nome} {donatore.cognome}"
        label_codice_fiscale = QLabel(codice_fiscale)
        font_codice_fiscale = label_codice_fiscale.font()
        font_codice_fiscale.setPointSize(30)
        label_codice_fiscale.setFont(font_codice_fiscale)
        v_layout.addWidget(label_codice_fiscale)

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        v_layout.addWidget(QLabel(f"Nome: {donatore.nome}"))
        v_layout.addWidget(QLabel(f"Cognome: {donatore.cognome}"))
        v_layout.addWidget(QLabel(f"Codice fiscale: {donatore.codice_fiscale}"))
        v_layout.addWidget(QLabel(f"Gruppo sanguigno: {donatore.gruppo_sanguigno}"))
        v_layout.addWidget(QLabel(f"Data di nascita: {donatore.data_nascita}"))
        v_layout.addWidget(QLabel(f"Email: {donatore.email}"))
        v_layout.addWidget(QLabel(f"Cellulare: {donatore.cellulare}"))
        v_layout.addWidget(QLabel(f"Idoneita: {donatore.idoneita}"))

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        btn_elimina = QPushButton('Elimina')
        btn_elimina.clicked.connect(lambda: self.elimina_donatore_click(donatore))
        v_layout.addWidget(btn_elimina)

        btn_tessera = QPushButton('Tessera')
        btn_tessera.clicked.connect(lambda: self.visualizza_tessera(donatore))
        v_layout.addWidget(btn_tessera)

        self.setLayout(v_layout)
        self.setWindowTitle("Donatore")

    def elimina_donatore_click(self, donatore):
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        if isinstance(donatore, Donatore):
            amministratore.eliminaDonatore(donatore.codice_fiscale)
        self.elimina_callback()
        self.close()

    def visualizza_tessera(self, donatore):
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        try:
            self.vista_tessera = VistaTessera(donatore)
            self.vista_tessera.show()
        except IndexError:
            print("INDEX ERROR")
            return
