import math

def calcular_raizes(a, b, c):
    delta = b**2 - 4*a*c
    
    if delta < 0:
        return "A equação não possui raízes reais."
    elif delta == 0:
        x1 = -b / (2*a)
        return f"A equação possui uma única raiz real: X1 = {x1:.2f}"
    else:
        x1 = (-b + math.sqrt(delta)) / (2*a)
        x2 = (-b - math.sqrt(delta)) / (2*a)
        return f"As raízes da equação são: X1 = {x1:.2f}, X2 = {x2:.2f}"

print("Equação do segundo grau: Ax² + Bx + C = 0")
a = float(input("Digite o valor de A: "))
b = float(input("Digite o valor de B: "))
c = float(input("Digite o valor de C: "))

if a == 0:
    print("O valor de A não pode ser zero em uma equação do segundo grau.")
else:
    resultado = calcular_raizes(a, b, c)
    print(resultado)
