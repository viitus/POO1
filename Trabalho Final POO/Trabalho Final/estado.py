class Estado:
    def __init__(self, num_sujeiras):
        self.num_sujeiras = num_sujeiras
        self.sujeiras_limpas = 0
    
    def get_num_sujeiras(self):
        return self.num_sujeiras
    
    def get_sujeiras_limpas(self):
        return self.sujeiras_limpas
    
    def set_sujeiras_limpas(self, valor):
        self.sujeiras_limpas = valor