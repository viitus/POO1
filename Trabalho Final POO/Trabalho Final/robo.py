import random
from estado import Estado

class Robo(Estado):
    def __init__(self, num_sujeiras):
        super().__init__(num_sujeiras)

    def run(self, matriz, x, y):
        print(f"Total de sujeiras: {self.get_num_sujeiras()}")
        print(f"Sujeiras limpas: {self.get_sujeiras_limpas()}")
        mov = random.choice(['W', 'S', 'A', 'D'])
        #mov = input("Digite uma direção (WASD) ou Q para sair: ").upper()
        return mov
