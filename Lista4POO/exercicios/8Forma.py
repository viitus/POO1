from abc import ABC, abstractmethod
import math

class Forma(ABC):
    @abstractmethod
    def area(self):
        pass

class Retangulo(Forma):
    def __init__(self, largura, altura):
        self.largura = largura
        self.altura = altura
    def area(self):
        return self.largura * self.altura

class Circulo(Forma):
    def __init__(self, raio):
        self.raio = raio
    def area(self):
        return math.pi * (self.raio ** 2)

class Triangulo(Forma):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura
    def area(self):
        return (self.base * self.altura) / 2

def encontrar_maior_area(lista):
    maior = lista[0]
    for item in lista:
        if item.area() > maior.area():
            maior = item
    return maior

def main():
    formas = []
    while True:
        print("\nEscolha a forma cadastrar e calcular a área:")
        print("1. Retângulo")
        print("2. Círculo")
        print("3. Triângulo")
        print("4. Exibir lista de formas cadastradas")
        print("5. Calcular forma com maior área")
        print("6. Sair")
        opcao = input("Digite a opção: ")

        if opcao == "1":
            largura = float(input("Digite a largura do retângulo: "))
            altura = float(input("Digite a altura do retângulo: "))
            retangulo = Retangulo(largura, altura)
            print(f"Área do retângulo: {retangulo.area()}")
            formas.append(retangulo)
        elif opcao == "2":
            raio = float(input("Digite o raio do círculo: "))
            circulo = Circulo(raio)
            print(f"Área do círculo: {circulo.area():.2f}")
            formas.append(circulo)
        elif opcao == "3":
            base = float(input("Digite a base do triângulo: "))
            altura = float(input("Digite a altura do triângulo: "))
            triangulo = Triangulo(base, altura)
            print(f"Área do triângulo: {triangulo.area()}")
            formas.append(triangulo)
        elif opcao == "4":
            print("\nFormas cadastradas:")
            for forma in formas:
                print(f"\nForma: {forma.__class__.__name__}")
                print(f"Área: {forma.area()}")
        elif opcao == "5":
            forma_maior_area = encontrar_maior_area(formas)
            print(f"A forma com maior área é um {forma.__class__.__name__} e tem área {forma_maior_area.area()}")
        elif opcao == "6":
            print("Saindo...")
            break
        else:
            print("Opção inválida! Tente novamente.")

if __name__ == "__main__":
    main()
