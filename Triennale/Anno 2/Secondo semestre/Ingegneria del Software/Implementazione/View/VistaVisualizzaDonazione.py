from CodicePython.Model.Donazione import Donazione
from CodicePython.Model.Amministratore import Amministratore
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QSpacerItem, QSizePolicy, QPushButton


class VistaVisualizzaDonazione(QWidget):
    def __init__(self, donazione, modifica_callback):
        super(VistaVisualizzaDonazione, self).__init__()
        self.modifica_callback = modifica_callback

        v_layout = QVBoxLayout()
        id = f"{donazione.id_donazione}"
        label_id = QLabel(id)
        font_id = label_id.font()
        font_id.setPointSize(30)
        label_id.setFont(font_id)
        v_layout.addWidget(label_id)

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        v_layout.addWidget(QLabel(f"id: {donazione.id_donazione}"))
        v_layout.addWidget(QLabel(f"Data:  {donazione.day} / {donazione.month} / {donazione.year} ' ' {donazione.hour} : {donazione.minute}"))
        v_layout.addWidget(QLabel(f"Stato: {donazione.disponibile}"))

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        btn_modifica = QPushButton('Modifica')
        btn_modifica.clicked.connect(lambda: self.modifica_donazione_click(donazione))
        v_layout.addWidget(btn_modifica)

        self.setLayout(v_layout)
        self.setWindowTitle("Donazione")

    def modifica_donazione_click(self, donazione):

        if isinstance(donazione, Donazione):
            Amministratore.modificaStatoDonazione()  #INSERIRE ATTRIBUTI CORRETTI
        self.modifica_callback()
        self.close()