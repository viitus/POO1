class Estado:
    def __init__(self, num_sujeiras):
        self.num_sujeiras = num_sujeiras
        self.sujeiras_limpas = 0
    
    def get_num_sujeiras(self):
        return self.num_sujeiras
    
    def get_sujeiras_limpas(self):
        return self.sujeiras_limpas
    
    def set_sujeiras_limpas(self, valor):
        self.sujeiras_limpas = valor

    def calcular_distancia(self, x1, y1, x2, y2):
        return abs(x1 - x2) + abs(y1 - y2)
    
    def encontrar_sujeira_mais_proxima(self, matriz, x_robo, y_robo):
        menor_distancia = float('inf')
        posicao_mais_proxima = None
        for i in range(len(matriz)):
            for j in range(len(matriz[i])):
                if matriz[i][j] == 1:  # Sujeira encontrada
                    distancia = self.calcular_distancia(x_robo, y_robo, i, j)
                    if distancia < menor_distancia:
                        menor_distancia = distancia
                        posicao_mais_proxima = (i, j)
        return posicao_mais_proxima

    def verificar_caminho_livre_para_sujeira(self, matriz, x_robo, y_robo):
        posicao_sujeira = self.encontrar_sujeira_mais_proxima(matriz, x_robo, y_robo)
        if posicao_sujeira is None:
            return False  # Nenhuma sujeira encontrada
        x_destino, y_destino = posicao_sujeira
        if x_robo == x_destino:
            for y in range(min(y_robo, y_destino), max(y_robo, y_destino) + 1):
                if matriz[x_robo][y] == 2:  # Obstáculo encontrado
                    return False
        elif y_robo == y_destino:  
            for x in range(min(x_robo, x_destino), max(x_robo, x_destino) + 1):
                if matriz[x][y_robo] == 2:  # Obstáculo encontrado
                    return False
        return True