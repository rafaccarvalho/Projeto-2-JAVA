
    class Gerente extends Funcionario {
        private String senha;
        
        public Gerente(String nome, String senha, int id){
            super(nome, id);
            this.senha = senha;
        }
        
        public void exibirFuncionario() {
            System.out.println("Gerente: " + nome + " | ID: " + id);
        }
    }

    class Atendente extends Funcionario {
        public Atendente(String nome, int id) {
            super(nome, id);
        }
        
        public void exibirFuncionario() {
            System.out.println("Atendente: " + nome + " | ID: " + id);
        }
    }
   
    class Caixa extends Funcionario {
        public Caixa(String nome, int id) {
            super(nome, id);
        }
        
        public void exibirFuncionario() {
            System.out.println("Caixa: " + nome + " | ID: " + id);
        }
    }