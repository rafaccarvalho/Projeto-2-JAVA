 //Julia D'Agrela Araujo RA:10426655
//Rafael Carvalho RA:10437533  
 

class Gerente extends Funcionario {
        private String senha;
        
        public Gerente(String nome, String senha, int id){
            super(nome, id);
            this.senha = senha;
        }
        
        public boolean validarSenha(String senhaInformada) {
        return this.senha.equals(senhaInformada);
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