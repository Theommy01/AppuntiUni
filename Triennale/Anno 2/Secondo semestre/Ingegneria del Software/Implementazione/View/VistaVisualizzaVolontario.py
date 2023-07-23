from CodicePython.Model.Volontario import Volontario
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QSpacerItem, QSizePolicy, QPushButton

from CodicePython.Model.Amministratore import Amministratore


class VistaVisualizzaVolontario(QWidget):
    def __init__(self, volontario, elimina_callback):  # gestione visualizza ed elimina donatore
        super(VistaVisualizzaVolontario, self).__init__()
        self.elimina_callback = elimina_callback

        v_layout = QVBoxLayout()
        codice_fiscale = f"{volontario.nome} {volontario.cognome}"
        label_codice_fiscale = QLabel(codice_fiscale)
        font_codice_fiscale = label_codice_fiscale.font()
        font_codice_fiscale.setPointSize(30)
        label_codice_fiscale.setFont(font_codice_fiscale)
        v_layout.addWidget(label_codice_fiscale)

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        v_layout.addWidget(QLabel(f"Nome: {volontario.nome}"))
        v_layout.addWidget(QLabel(f"Cognome: {volontario.cognome}"))
        v_layout.addWidget(QLabel(f"Codice fiscale: {volontario.codice_fiscale}"))
        v_layout.addWidget(QLabel(f"Data di nascita: {volontario.data_nascita}"))
        v_layout.addWidget(QLabel(f"Email: {volontario.email}"))
        v_layout.addWidget(QLabel(f"Cellulare: {volontario.cellulare}"))
        v_layout.addWidget(QLabel(f"Idoneita 118: {volontario.idoneita118}"))

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        btn_elimina = QPushButton('Elimina')
        btn_elimina.clicked.connect(lambda: self.elimina_donatore_click(volontario))
        v_layout.addWidget(btn_elimina)

        self.setLayout(v_layout)
        self.setWindowTitle("Volontario")

    def elimina_donatore_click(self, volontario):
        amministratore = Amministratore(376, "AMMINISTRATORESTUPIDO", "Paniccia",
                                        2000 - 12 - 25, "osvaldopaniccia@boh.sium", "Osvaldo", "password")
        if isinstance(volontario, Volontario):
            amministratore.eliminaVolontario(volontario.codice_fiscale)
        self.elimina_callback()
        self.close()
