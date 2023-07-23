import CodicePython.Model.Donatore

allDatePrenotate = []
contatore = 0


def __inserisciPrenotazione__(self, data):
    if __verificaIdoneita__(self,
                            "k") == 1:  # ID a caso deve essere implementato in "Donatore" quando si lavora sui pickle
        if not allDatePrenotate.__contains__(data):
            allDatePrenotate.append(data)
        else:
            print("\nData già prenotata")
    else:
        print("\nNon sei idoneo a Donare :-(")


def __verificaIdoneita__(self, Id):
    if CodicePython.Model.Donatore.Donatore.__getIdoneita__(self) == 1:
        return 1
    else:
        return 0


def __verificaPrenotazioneEsistente__(self, Id):
    pass
    # Non so come implementare una verifica senza avere un codice
    # identificativo. AIUTO!!


"""
Il metodo "__verificaDisponibilitaData__" NON SERVE (si deve togliere da "Enterprise")
"""

"""
DEVE ESSERE IMPLEMENTATO IL METODO "__modificaPrenotazione__"
--> Possibile metodo

    def __modificaPrenotazione__(self, dataVecchia, dataNuova):
        if not allDatePrenotate.__contains__(dataNuova):
            if allDatePrenotate.__contains__(dataVecchia):
                for index, value in enumerate(allDatePrenotate):
                    if value == dataVecchia:
                        allDatePrenotazione[index] = dataNuova
                print("\nPrenotazione aggiornata:
                        \nda: " + dataVecchia + "a: " + dataNuova)
"""

"""
Metodo "__visualizzaDisponibilità__" (alternativo che stampa solo il file Orari.txt)
--> Per questo motivo bisognerà creare un metodo che permetta di salvare una data
    e fare in modo che non possa essere scelta ancora.

    def __visualizzaDisponibilita__(self):
            with open('Orari.txt') as f:
                lines = f.read()
                print(lines)

--> IMPORTANTE: QUESTO METODO SU ENTERPRISE CE L'HA SIA IL "DONATORE" CHE "GESTIONE PRENOTAZIONE"
                DEVE ESSERE TENUTO SOLO SU "GESTIONE PRENOTAZIONE"
                E DEVE ESSERE RINOMINATO COME:
                    "__stampaDisponibilitaData__"
"""
