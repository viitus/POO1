from collections import deque

class Estado:
    def __init__(self, num_sujeiras):
        self.num_sujeiras = num_sujeiras
        self.sujeiras_limpas = 0
        self.sujeiras_inacessiveis = []  # Lista de sujeiras inacessíveis

    def get_num_sujeiras(self):
        return self.num_sujeiras

    def get_sujeiras_limpas(self):
        return self.sujeiras_limpas

    def set_sujeiras_limpas(self, valor):
        self.sujeiras_limpas = valor

    def calcular_distancia(self, x1, y1, x2, y2):
        return abs(x1 - x2) + abs(y1 - y2) # Distância de Manhattan

    def listar_sujeiras(self, matriz):
        sujeiras = []
        for i in range(len(matriz)):
            for j in range(len(matriz[i])):
                if matriz[i][j] == 1:  # Sujeira encontrada
                    sujeiras.append((i, j))
        return sujeiras

    def encontrar_caminho_para_sujeira(self, matriz, x_robo, y_robo, destino): # Busca o caminho para uma sujeira
        x_destino, y_destino = destino 
        fila = deque([(x_robo, y_robo, [])])  # Fila de busca, recebe a posição inicial e o caminho  
        visitados = set() # Conjunto de visitados
        while fila: # Enquanto a fila não estiver vazia
            x, y, caminho = fila.popleft() # Pega o primeiro elemento da fila
            if (x, y) == (x_destino, y_destino):
                return caminho  # Retorna o caminho encontrado
            if (x, y) in visitados:
                continue
            visitados.add((x, y))
            for direcao_x, direcao_y, direcao in [(-1, 0, 'W'), (1, 0, 'S'), (0, -1, 'A'), (0, 1, 'D')]:
                novo_x, novo_y = x + direcao_x, y + direcao_y
                if 0 <= novo_x < len(matriz) and 0 <= novo_y < len(matriz[0]) and matriz[novo_x][novo_y] != -1:  # Evita obstáculos
                    fila.append((novo_x, novo_y, caminho + [direcao]))
        return None  # Nenhum caminho encontrado

    def encontrar_caminho_para_qualquer_sujeira(self, matriz, x_robo, y_robo):
        sujeiras = self.listar_sujeiras(matriz)  # Lista todas as sujeiras
        if not sujeiras:  # Se nenhuma sujeira encontrada
            return None
        chave = lambda s: self.calcular_distancia(x_robo, y_robo, s[0], s[1])  # Chave de ordenação
        sujeiras_ordenadas = sorted(sujeiras, key=chave)  # Ordena as sujeiras pela distância
        for sujeira in sujeiras_ordenadas:
            if sujeira in self.sujeiras_inacessiveis: # Verifica se a sujeira já é inacessível
                continue
            caminho = self.encontrar_caminho_para_sujeira(matriz, x_robo, y_robo, sujeira)           
            if caminho:  # Se encontrou um caminho
                return caminho
            else:
                self.sujeiras_inacessiveis.append(sujeira) # Adiciona a sujeira à lista de inacessíveis
        return None  # Nenhum caminho encontrado para qualquer sujeira
