from robo_limpeza import RoboLimpeza

if __name__ == "__main__":
    jogo = RoboLimpeza(tamanho=20, num_obstaculos=120, num_sujeiras=20)
    jogo.iniciar_limpeza()