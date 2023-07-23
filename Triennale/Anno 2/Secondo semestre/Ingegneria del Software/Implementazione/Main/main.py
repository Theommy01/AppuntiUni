import sys

from PyQt5.QtWidgets import QApplication
from CodicePython.View.VistaHome import VistaHome

if __name__ == '__main__':
    app = QApplication(sys.argv)
    vista_home = VistaHome()
    vista_home.show()
    sys.exit(app.exec())
