from CodicePython.Model.Rapportino import Rapportino
from CodicePython.Model.Service.Emergenza import Emergenza


class ___118(Emergenza):

    def __init__(self, spesa: int, stato: bool, tipo: ""):
        Emergenza.__init__(self, spesa, stato, tipo)

    def __getSpesa__(self):
        return self.spesa

    def __setSpesa__(self, spesa: int):
        self.spesa = spesa

    def __getStato__(self):
        return self.stato

    def __setStato__(self, stato: bool):
        self.stato = stato

    def __getTipo__(self):
        return self.tipo

    def __setTipo__(self, tipo: ""):
        self.tipo = tipo

    def __verificaIdoneitaPersonale__(self, personale):
        if personale.idoneita118 == True:
            return True
        else:
            return False

    def __assegnaPersonale__(self, dipendente: Dipendente, volontario1: Volontario, volontario2: Volontario):
        if self.__verificaIdoneitaPersonale__(dipendente) == True:
            dipendente = Dipentente()
        if self.__verificaIdoneitaPersonale__(volontario1) == True:
            volontario1 = Volontario()
        if self.__verificaIdoneitaPersonale__(volontario2) == True:
            volontario2 = Volontario()

    def __assegnaRapportino__(self, data: datetime.datetime, inizio: int, fine: int):
        rapportino = Rapportino(data_servizio=data, KM_inizio=inizio, KM_fine=fine)
