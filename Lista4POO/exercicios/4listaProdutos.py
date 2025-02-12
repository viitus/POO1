class Produto:
    def __init__(self, nome, preco, estoque):
        self.nome = nome
        self.preco = preco
        self.estoque = estoque
    def __str__(self):
        return f"Nome: {self.nome}, Preço: R${self.preco:.2f}, Estoque: {self.estoque}"

def inserir_produto(lista_produtos):
    nome = input("Digite o nome do produto: ")
    preco = float(input("Digite o preço do produto: "))
    estoque = int(input("Digite a quantidade em estoque: "))
    produto = Produto(nome, preco, estoque)
    lista_produtos.append(produto)
    print("Produto adicionado com sucesso!")

def excluir_produto(lista_produtos):
    nome = input("Digite o nome do produto que deseja excluir: ")
    for produto in lista_produtos:
        if produto.nome == nome:
            print(produto)
            confirma = input("Deseja realmente excluir?(s/n)")
            if confirma == "s":
                lista_produtos.remove(produto)
                print("Produto removido com sucesso!")
                return
            else:
                print("Operação cancelada.")
                return
    print("Produto não encontrado.")

def procurar_produto(lista_produtos):
    nome = input("Digite o nome do produto que deseja procurar: ")
    for produto in lista_produtos:
        if produto.nome == nome:
            print(produto)
            return
    print("Produto não encontrado.")

def listar_produtos(lista_produtos):
    if not lista_produtos:
        print("Nenhum produto cadastrado.")
    else:
        for produto in lista_produtos:
            print(produto)

def main():
    lista_produtos = []
    while True:
        print("\nMenu:")
        print("1. Inserir Produto")
        print("2. Excluir Produto")
        print("3. Procurar Produto")
        print("4. Listar Produtos")
        print("5. Sair")
        escolha = input("Escolha uma opção: ")

        if escolha == "1":
            inserir_produto(lista_produtos)
        elif escolha == "2":
            excluir_produto(lista_produtos)
        elif escolha == "3":
            procurar_produto(lista_produtos)
        elif escolha == "4":
            listar_produtos(lista_produtos)
        elif escolha == "5":
            print("Saindo...")
            break
        else:
            print("Escolha inválida. Tente novamente.")

if __name__ == "__main__":
    main()