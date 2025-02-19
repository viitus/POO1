import random
from estado import Estado

class Robo(Estado):
    def __init__(self, num_sujeiras):
        super().__init__(num_sujeiras)

    def run(self, matriz, x, y):
        print(f"Total de sujeiras: {self.get_num_sujeiras()}")
        print(f"Sujeiras limpas: {self.get_sujeiras_limpas()}")
        
        # Encontrar a sujeira mais próxima
        posicao_sujeira = self.encontrar_sujeira_mais_proxima(matriz, x, y)
        
        if posicao_sujeira is None:
            print("Não há mais sujeira para limpar.")
            return 'Q'  # Retorna 'Q' para indicar que o robô terminou
        
        x_destino, y_destino = posicao_sujeira

        # Verificar se o caminho até a sujeira está livre
        if self.verificar_caminho_livre_para_sujeira(matriz, x, y):
            direcoes = []
            if x < x_destino:  # Pode mover para baixo
                direcoes.append('S')
            elif x > x_destino:  # Pode mover para cima
                direcoes.append('W')
            if y < y_destino:  # Pode mover para a direita
                direcoes.append('D')
            elif y > y_destino:  # Pode mover para a esquerda
                direcoes.append('A')
            mov = random.choice(direcoes)
            print(f"Movendo para a sujeira: {mov}")
            return mov
        
        else:
            if y > y_destino:  # Caminho bloqueado à esquerda
                mov = 'W'
            elif y < y_destino:  # Caminho bloqueado à direita
                mov = 'S'
            elif x > x_destino:  # Caminho bloqueado acima
                mov = 'D'
            elif x < x_destino:  # Caminho bloqueado abaixo
                mov = 'A'
            return mov

