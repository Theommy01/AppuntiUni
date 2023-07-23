from CodicePython.Model.Amministratore import Amministratore
from CodicePython.Model.Dipendente import Dipendente
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QSpacerItem, QSizePolicy, QPushButton


class VistaVisualizzaDipendente(QWidget):
    def __init__(self, dipendente, elimina_callback):
        super(VistaVisualizzaDipendente, self).__init__()
        self.elimina_callback = elimina_callback

        v_layout = QVBoxLayout()
        codice_fiscale = f"{dipendente.nome} {dipendente.cognome}"
        label_codice_fiscale = QLabel(codice_fiscale)
        font_codice_fiscale = label_codice_fiscale.font()
        font_codice_fiscale.setPointSize(30)
        label_codice_fiscale.setFont(font_codice_fiscale)
        v_layout.addWidget(label_codice_fiscale)

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        v_layout.addWidget(QLabel(f"Nome: {dipendente.nome}"))
        v_layout.addWidget(QLabel(f"Cognome: {dipendente.cognome}"))
        v_layout.addWidget(QLabel(f"Codice fiscale: {dipendente.codice_fiscale}"))
        v_layout.addWidget(QLabel(f"Data di nascita: {dipendente.data_nascita}"))
        v_layout.addWidget(QLabel(f"Email: {dipendente.email}"))
        v_layout.addWidget(QLabel(f"Cellulare: {dipendente.cellulare}"))
        v_layout.addWidget(QLabel(f"Idoneita 118: {dipendente.idoneita118}"))
        v_layout.addWidget(QLabel(f"IBAN: {dipendente.IBAN}"))

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        btn_elimina = QPushButton('Elimina')
        btn_elimina.clicked.connect(lambda: self.elimina_dipendente_click(dipendente))
        v_layout.addWidget(btn_elimina)

        self.setLayout(v_layout)
        self.setWindowTitle("Dipendente")

    def elimina_dipendente_click(self, dipendente):
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        print("elimina")
        if isinstance(dipendente, Dipendente):
            amministratore.eliminaDipendente(dipendente.codice_fiscale)
        self.elimina_callback()
        self.close()
