def calcular_imc(peso, altura):
    imc = peso / altura**2
    return imc

print ("Cálculo do IMC")
peso = float(input("Digite o seu peso (kg): "))
altura = float(input("Digite a sua altura (cm): ")) / 100

if peso <= 0 or altura <= 0:
    print("Peso e altura devem ser valores positivos.")
else:
    imc = calcular_imc(peso, altura)
    print(f"Seu IMC é: {imc:.2f}")