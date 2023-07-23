from CodicePython.View.VistaAmministratore import VistaAmministratore
from PyQt5.QtWidgets import QVBoxLayout, QPushButton, QLabel, QLineEdit, QWidget, QMessageBox


class LoginAmministratore(QWidget):

    def __init__(self, callback):
        super(LoginAmministratore, self).__init__()
        self.callback = callback
        self.v_layout = QVBoxLayout()
        self.qLines = {}
        self.add_info_text("username", "Username")
        self.add_info_text("password", "Password")
        self.setWindowTitle("Login")
        self.setLayout(self.v_layout)
        btn_ok = QPushButton("Ok")
        btn_ok.clicked.connect(self.log)
        self.qLines["btn_ok"] = btn_ok
        self.v_layout.addWidget(btn_ok)

    def add_info_text(self, param, label):
        self.v_layout.addWidget(QLabel(label))
        current_text = QLineEdit()
        self.qLines[param] = current_text
        self.v_layout.addWidget(current_text)

    def log(self):
        username = self.qLines["username"].text()
        password = self.qLines["password"].text()
        print(username)
        if username == "username" and password == "password":
            self.vista_amministratore = VistaAmministratore()
            self.vista_amministratore.show()
        else:
            QMessageBox.critical(self, 'Errore', 'Username e/o password errati', QMessageBox.Ok, QMessageBox.Ok)
