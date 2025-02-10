contatos = []

def adicionar_contato():
    nome = input("Digite o nome: ").strip().lower()
    telefone = input("Digite o telefone: ").strip()
    email = input("Digite o e-mail: ").strip().lower()
    if not validar_email(email):
        print("E-mail inválido!")
        return
    if not validar_telefone(telefone):
        print("Telefone inválido!")
        return
    contatos.append({"nome": nome, "telefone": telefone, "email": email})
    print("Contato adicionado com sucesso!")


def validar_email(email):
    if "@" in email and "." in email:
        return True
    return False


def validar_telefone(telefone):
    telefone_limpo = telefone.replace(" ", "").replace("-", "").replace("(", "").replace(")", "")
    return telefone_limpo.isdigit()


def buscar_contato_info():
    nome = input("Digite o nome do contato: ").strip().lower()
    for contato in contatos:
        if contato["nome"].lower() == nome:
            print(f"Nome: {contato['nome']}, Telefone: {contato['telefone']}, E-mail: {contato['email']}")
            return contato
    print("Contato não encontrado!")
    return None


def excluir_contato():
    contato = buscar_contato_info()
    if contato:
        confirmacao = input("Deseja excluir este contato? (sim/não): ").strip().lower()
        if confirmacao == "sim":
            contatos.remove(contato)
            print("Contato excluído com sucesso!")
        else:
            print("Exclusão cancelada.")


def main():
    while True:
        print("\nMenu:")
        print("1. Adicionar Contato")
        print("2. Excluir Contato")
        print("3. Buscar Contato")
        print("4. Sair")
        escolha = input("Digite sua escolha: ").strip()
        if escolha == '1':
            adicionar_contato()
        elif escolha == '2':
            excluir_contato()
        elif escolha == '3':
            buscar_contato_info()
        elif escolha == '4':
            print("Saindo...")
            break
        else:
            print("Escolha inválida! Tente novamente.")


if __name__ == "__main__":
    main()
