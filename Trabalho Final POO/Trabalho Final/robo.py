from estado import Estado

class Robo(Estado):
    def __init__(self, num_sujeiras):
        super().__init__(num_sujeiras)

    def run(self, matriz, x, y):
        print(f"Total de sujeiras: {self.get_num_sujeiras()}")  # Exibe o total de sujeiras
        print(f"Sujeiras limpas: {self.get_sujeiras_limpas()}")  # Exibe o total de sujeiras limpas
        
        if self.get_sujeiras_limpas() == self.get_num_sujeiras():  # Verifica se todas as sujeiras foram limpas
            print("Todas as sujeiras foram limpas. :D ")
            return 'Q'  # Finaliza
        
        caminho = self.encontrar_caminho_para_qualquer_sujeira(matriz, x, y)  # Busca qualquer sujeira acessível
        
        if caminho:  # Se encontrou um caminho
            mov = caminho[0]  # Pega o próximo passo do caminho encontrado
            print(f"Movendo para a sujeira: {mov}")
            return mov
        else:  # Se não encontrou um caminho
            print("Nenhum caminho encontrado para sujeiras restantes. :C ")
            return 'Q'  # Finaliza
