import math

class Triangulo:
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura
    def area(self):
        return (self.base * self.altura) / 2

class Circulo:
    def __init__(self, raio):
        self.raio = raio
    def area(self):
        return math.pi * (self.raio ** 2)

def encontrar_maior_area(lista):
    maior = lista[0]
    for item in lista:
        if item.area() > maior.area():
            maior = item
    return maior

def main():
    triangulos = []
    circulos = []

    print("Preencha os dados para 5 triângulos:")
    for i in range(5):
        base = float(input(f"\nDigite a base do triângulo {i+1}: "))
        altura = float(input(f"Digite a altura do triângulo {i+1}: "))
        triangulo = Triangulo(base, altura)
        triangulos.append(triangulo)

    print("\nPreencha os dados para 5 círculos:")
    for i in range(5):
        raio = float(input(f"\nDigite o raio do círculo {i+1}: "))
        circulo = Circulo(raio)
        circulos.append(circulo)

    triangulo_maior_area = encontrar_maior_area(triangulos)
    circulo_maior_area = encontrar_maior_area(circulos)

    print(f"\nO triângulo com a maior área tem base {triangulo_maior_area.base}, altura {triangulo_maior_area.altura} e área {triangulo_maior_area.area():.2f}.")
    print(f"O círculo com a maior área tem raio {circulo_maior_area.raio} e área {circulo_maior_area.area():.2f}.")

if __name__ == "__main__":
    main()    