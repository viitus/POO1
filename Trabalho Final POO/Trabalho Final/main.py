from robo_limpeza import RoboLimpeza

if __name__ == "__main__":
    jogo = RoboLimpeza(tamanho=15, num_obstaculos=10, num_sujeiras=10)
    jogo.iniciar_limpeza()