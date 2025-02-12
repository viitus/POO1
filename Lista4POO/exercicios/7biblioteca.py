class MaterialBiblioteca:
    def __init__(self, titulo, ano):
        self.titulo = titulo
        self.ano = ano
    def exibir_informacoes(self):
        print(f"Título: {self.titulo}")
        print(f"Ano: {self.ano}")

class Livro(MaterialBiblioteca):
    def __init__(self, titulo, ano, autor, num_paginas):
        super().__init__(titulo, ano)
        self.autor = autor
        self.num_paginas = num_paginas
    def exibir_informacoes(self):
        super().exibir_informacoes()
        print(f"Autor: {self.autor}")
        print(f"Número de Páginas: {self.num_paginas}")

class Revista(MaterialBiblioteca):
    def __init__(self, titulo, ano, volume, edicao):
        super().__init__(titulo, ano)
        self.volume = volume
        self.edicao = edicao
    def exibir_informacoes(self):
        super().exibir_informacoes()
        print(f"Volume: {self.volume}")
        print(f"Edição: {self.edicao}")

class DVD(MaterialBiblioteca):
    def __init__(self, titulo, ano, duracao):
        super().__init__(titulo, ano)
        self.duracao = duracao
    def exibir_informacoes(self):
        super().exibir_informacoes()
        print(f"Duração: {self.duracao} minutos")

def exibir_materiais(materiais):
    print("\nMateriais cadastrados:")
    for material in materiais:
        print("\n")
        material.exibir_informacoes()

def main():
    materiais = []
    
    while True:
        print("\nEscolha o tipo de material para adicionar:")
        print("1. Livro")
        print("2. Revista")
        print("3. DVD")
        print("4. Sair")
        print("5. Exibir lista de materiais cadastrados")
        opcao = input("Digite a opção: ")
        
        if opcao == "1":
            titulo = input("Digite o título do livro: ")
            ano = int(input("Digite o ano de publicação: "))
            autor = input("Digite o nome do autor: ")
            num_paginas = int(input("Digite o número de páginas: "))
            materiais.append(Livro(titulo, ano, autor, num_paginas))
        elif opcao == "2":
            titulo = input("Digite o título da revista: ")
            ano = int(input("Digite o ano de publicação: "))
            volume = int(input("Digite o volume: "))
            edicao = int(input("Digite a edição: "))
            materiais.append(Revista(titulo, ano, volume, edicao))
        elif opcao == "3":
            titulo = input("Digite o título do DVD: ")
            ano = int(input("Digite o ano de lançamento: "))
            duracao = int(input("Digite a duração em minutos: "))
            materiais.append(DVD(titulo, ano, duracao))
        elif opcao == "4":
            break
        elif opcao == "5":
            exibir_materiais(materiais)
        else:
            print("Opção inválida! Tente novamente.")

if __name__ == "__main__":
    main()
