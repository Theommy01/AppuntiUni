import datetime


class Tessera:

    def __init__(self, codice, nome_donatore, cognome_donatore, donazioni, numero_donazioni):
        self.codice = codice
        self.nome_donatore = nome_donatore
        self.cognome_donatore = cognome_donatore
        self.donazioni = donazioni
        self.numero_donazioni = numero_donazioni

    def __getCodice__(self):
        return self.codice

    def __setCodice__(self, contatore):
        self.codice = contatore

    def __getNomeDonatore__(self):
        return self.nome_donatore

    def __setNomeDonatore__(self, nome):
        self.nome_donatore = nome

    def __getCognomeDonatore__(self):
        return self.cognome_donatore

    def __setCognomeDonatore__(self, cognome):
        self.cognome_donatore = cognome

    def __getNumeroDonazioni__(self):
        return self.numero_donazioni

    def __setNumeroDonazioni__(self, numero_donazioni):
        numero_donazioni += 1

    def __getDonazioni(self):
        return self.donazioni

    def __setDonazioni__(self, year, month, day):
        data = datetime.datetime(year, month, day)
        self.donazioni.append(data)

    def __getInfoTessera__(self):
        return {
            "codice: ": self.codice,
            "nome: ": self.nome_donatore,
            "cognome: ": self.cognome_donatore,
            "elenco donazioni: ": self.donazioni,
            "donazioni svolte: ": self.numero_donazioni
        }

    def __setInfoTessera__(self, codice, nome, cognome, year, month, day, numero_donazioni):
        Tessera.__setCodice__(self, codice)
        Tessera.__setNomeDonatore__(self, nome)
        Tessera.__setCognomeDonatore__(self, cognome)
        Tessera.__setDonazioni__(self, year, month, day)
        Tessera.__setNumeroDonazioni__(self, numero_donazioni)
