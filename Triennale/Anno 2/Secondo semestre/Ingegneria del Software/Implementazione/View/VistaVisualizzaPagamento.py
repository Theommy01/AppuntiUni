from CodicePython.Model.Donatore import Donatore
from CodicePython.View.VistaTessera import VistaTessera
from PyQt5.QtWidgets import QWidget, QVBoxLayout, QLabel, QSpacerItem, QSizePolicy, QPushButton
from CodicePython.Model.Amministratore import Amministratore


class VistaVisualizzaPagamento(QWidget):
    def __init__(self, pagamento):  # gestione visualizza ed elimina donatore
        super(VistaVisualizzaPagamento, self).__init__()
        self.pagamento = pagamento

        v_layout = QVBoxLayout()
        payment = f"€{pagamento}"
        label_payment = QLabel(payment)
        font_payment = label_payment.font()
        font_payment.setPointSize(30)
        label_payment.setFont(font_payment)
        v_layout.addWidget(label_payment)

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        v_layout.addWidget(QLabel(f"IBAN AVIS: IT21V0335901600100000065611"))

        v_layout.addItem(QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding))

        self.setLayout(v_layout)
        self.setWindowTitle("Rimborso/Pagamento")