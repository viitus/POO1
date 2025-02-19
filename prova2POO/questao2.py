class Corredor:
    def __init__(self, distancia):
        self.distancia = distancia  # Mantemos o nome distancia
    def provaCorrer(self):
        if self.distancia == 21:
            return "meia-maratona"
        elif self.distancia == 42:
            return "maratona"
        return f"{self.distancia} km de corrida"


class Nadador:
    def __init__(self, distancia, tipo):
        self.distancia = distancia  # Mantemos o nome distancia
        self.tipo = tipo
    def provaNadar(self):
        return f"{self.distancia} m de nado no {self.tipo}"


class Pedalar:
    def __init__(self, distancia, tipo):
        self.distancia = distancia  # Mantemos o nome distancia
        self.tipo = tipo
    def provaPedalar(self):
        return f"{self.distancia} km de ciclismo na {self.tipo}"


class TriAtleta(Corredor, Nadador, Pedalar):
    def __init__(self, nome, distancia_corrida, distancia_nado, tipo_nado, distancia_bike, tipo_bike):
        Corredor.__init__(self, distancia_corrida)
        self.distancia_corrida = self.distancia  # Salva o valor da corrida separadamente
        Nadador.__init__(self, distancia_nado, tipo_nado)
        self.distancia_nado = self.distancia  # Salva o valor da natação separadamente
        Pedalar.__init__(self, distancia_bike, tipo_bike)
        self.distancia_bike = self.distancia  # Salva o valor da bicicleta separadamente
        self.nome = nome  # Armazena o nome do atleta
    def prova(self):
        # Usa os atributos armazenados para fazer a verificação do Ironman
        if self.distancia_corrida == 42 and self.distancia_nado == 3000 and self.distancia_bike == 120:
            return "A prova será um Ironman."
        
        # Caso contrário, retorna os detalhes da prova
        return f"A prova será {self.provaCorrer()}, {self.provaNadar()} e {self.provaPedalar()}."


# Testes
triAtleta1 = TriAtleta("Juliana", 12, 100, "mar", 80, "rua")
print(triAtleta1.prova())
triAtleta2 = TriAtleta("Carlos", 42, 3000, "piscina", 120, "cidade")
print(triAtleta2.prova())
