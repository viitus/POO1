import os
import random
import time
from robo import Robo

class RoboLimpeza:
    def __init__(self, tamanho, num_obstaculos, num_sujeiras):
        self.tamanho = tamanho
        self.passos = 0
        self.robo = Robo(num_sujeiras)
        self.matriz, self.x, self.y = self.criar_matriz(num_obstaculos, num_sujeiras)
    
    def criar_matriz(self, num_obstaculos, num_sujeiras):
        matriz = [[0 for _ in range(self.tamanho)] for _ in range(self.tamanho)]
        
        for _ in range(num_obstaculos):
            while True:
                x, y = random.randint(0, self.tamanho-1), random.randint(0, self.tamanho-1)
                if matriz[x][y] == 0:
                    matriz[x][y] = 2  #-1
                    break
        
        for _ in range(num_sujeiras):
            while True:
                x, y = random.randint(0, self.tamanho-1), random.randint(0, self.tamanho-1)
                if matriz[x][y] == 0:
                    matriz[x][y] = 1
                    break
        
        while True:
            x, y = random.randint(0, self.tamanho-1), random.randint(0, self.tamanho-1)
            if matriz[x][y] == 0:
                matriz[x][y] = 'X'
                return matriz, x, y
    
    def exibir_matriz(self):
        fundo_cinza = "\033[48;5;233m"  # Fundo escuro
        reset = "\033[0m"  # Reset 
        
        cores = {
            "X": f"{fundo_cinza}\033[94m◆ {reset}",  # Lozango Azul
            "1": f"{fundo_cinza}\033[92m◉ {reset}",  # Ponto Verde
            "2": f"{fundo_cinza}\033[91m■ {reset}",  # Quadrado Vermelho
            "0": f"{fundo_cinza}  {reset}"
        }
        
        for linha in self.matriz:
            print("".join(cores.get(str(cel), str(cel)) for cel in linha))
        print()

    
    def mover_robo(self, direcao):
        dx, dy = {'W': (-1, 0), 'S': (1, 0), 'A': (0, -1), 'D': (0, 1)}.get(direcao, (0, 0))
        novo_x, novo_y = self.x + dx, self.y + dy
        
        if 0 <= novo_x < self.tamanho and 0 <= novo_y < self.tamanho and self.matriz[novo_x][novo_y] != 2:
            if self.matriz[novo_x][novo_y] == 1:
                self.robo.set_sujeiras_limpas(self.robo.get_sujeiras_limpas() + 1)
            
            self.matriz[self.x][self.y] = 0
            self.matriz[novo_x][novo_y] = 'X'
            self.x, self.y = novo_x, novo_y
        else:
            print("Movimento inválido! Há um obstáculo ou borda.")
        
        return self.robo.get_sujeiras_limpas() == self.robo.get_num_sujeiras()

    def iniciar_limpeza(self):
        while True:
            time.sleep(0.5)
            os.system('cls')
            self.exibir_matriz()
            self.passos += 1
            print(f"Passo: {self.passos}")
            direcao = self.robo.run(self.matriz, self.x, self.y)
            
            if direcao == 'Q':
                break

            if self.mover_robo(direcao):
                print("Todas as sujeiras foram limpas! Fim do jogo.")