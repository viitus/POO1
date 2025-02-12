class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
    def apresentar(self):
        print(f"Meu nome é {self.nome} e tenho {self.idade} anos.")

class Empregado:
    def __init__(self, cargo, salario):
        self.cargo = cargo
        self.salario = salario
    def exibir_dados(self):
        print(f"Cargo: {self.cargo}, Salário: {self.salario}")

class PessoaEmpregado(Pessoa, Empregado):
    def __init__(self, nome, idade, cargo, salario):
        Pessoa.__init__(self, nome, idade)
        Empregado.__init__(self, cargo, salario)

def main():
    nome = input("Digite o nome: ")
    idade = int(input("Digite a idade: "))
    cargo = input("Digite o cargo: ")
    salario = float(input("Digite o salário: "))
    
    pessoa_empregado = PessoaEmpregado(nome, idade, cargo, salario)
    pessoa_empregado.apresentar()
    pessoa_empregado.exibir_dados()

if __name__ == "__main__":
    main()