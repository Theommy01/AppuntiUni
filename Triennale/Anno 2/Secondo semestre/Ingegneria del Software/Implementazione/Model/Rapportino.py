import datetime


class Rapportino:
    def __init__(self, data_servizio: datetime.datetime, KM_inizio: int, KM_fine):
        self.data_servizio = data_servizio
        self.KM_fine = KM_fine
        self.KM_inizio = KM_inizio

    def __getDataServizio__(self):
        return self.data_servizio

    def __setDataServizio__(self, data: datetime.datetime):
        self.data_servizio = data

    def __getKMFine__(self):
        return self.KM_fine

    def __setKMFine__(self, KM_fine: int):
        self.KM_fine = KM_fine

    def __getKMInizio__(self):
        return self.KM_inizio

    def __setKMInizio__(self, KM_inizio: int):
        self.KM_inizio = KM_inizio

    def __getInfoRapportino__(self):
        return {
            "data: ": self.data_servizio,
            "KM Iniziali: ": self.KM_inizio,
            "KM Finali: ": self.KM_fine,
            "KM Percorsi: ": self.KM_fine - self.KM_inizio
        }

    def __setInfoRapportino__(self, data: datetime.datetime, KM_inizio: int, KM_fine: int):
        Rapportino.__setDataServizio__(self, data)
        Rapportino.__setKMInizio__(self, KM_inizio)
        Rapportino.__setKMFine__(self, KM_fine)
