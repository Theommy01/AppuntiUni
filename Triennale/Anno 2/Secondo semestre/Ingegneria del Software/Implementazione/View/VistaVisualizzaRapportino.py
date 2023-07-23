from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QSpacerItem, QSizePolicy


class VistaVisualizzaRapportino(QWidget):
    def __init__(self, rapportino):
        super(VistaVisualizzaRapportino, self).__init__()

        v_layout = QVBoxLayout()
        giorno = f"{rapportino.data_servizio}"
        label_giorno = QLabel(giorno)
        font_giorno = label_giorno.font()
        font_giorno.setPointSize(30)
        label_giorno.setFont(font_giorno)
        v_layout.addWidget(label_giorno)

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        v_layout.addWidget(QLabel(f"Data: {rapportino.data_servizio}"))
        v_layout.addWidget(QLabel(f"KM Iniziali: {rapportino.KM_inizio}"))
        v_layout.addWidget(QLabel(f"KM Finali: {rapportino.KM_fine}"))

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        self.setLayout(v_layout)
        self.setWindowTitle("Rapportino")