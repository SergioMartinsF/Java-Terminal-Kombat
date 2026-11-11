// Define que este arquivo pertence ao pacote (pasta) ultraemojicombat
package ultraemojicombat;

// Declaração da classe pública 'lutador', que servirá de molde para criar cada objeto lutador
public class lutador {
    // Atributos privados (Encapsulamento: só podem ser acessados/alterados por métodos desta própria classe)
    private String nome;          // Guarda o nome do lutador (ex: "Charles 'Do Backend' Oliveira")
    private String nacionalidade; // Guarda o país de origem
    private int idade;            // Guarda a idade (número inteiro)
    private float altura;         // Guarda a altura em metros (número real/decimal)
    private float peso;           // Guarda o peso em kg (número real/decimal)
    private String categoria;     // Guarda a categoria calculada automaticamente (Leve, Médio, Pesado, Inválido)
    private int vitorias;         // Guarda o total de vitórias no cartel
    private int derrotas;         // Guarda o total de derrotas no cartel
    private int empates;          // Guarda o total de empates no cartel

    // Método público sem retorno (void) que exibe a ficha completa do lutador na tela
    public void apresentar(){
        // Imprime uma linha divisória visual no console
        System.out.println("===============================================");
        // Busca o nome via getNome(), transforma tudo em maiúsculas com .toUpperCase() e imprime
        System.out.println(" >>> CHEGOU A HORA!! Diante de vocês: " + this.getNome().toUpperCase());
        // Imprime outra linha divisória
        System.out.println("===============================================");
        // Busca e imprime a nacionalidade do lutador atual (this)
        System.out.println(" [ Origem ]  " + this.getNacionalidade());
        // Busca e imprime a idade e a altura concatenadas na mesma linha
        System.out.println(" [ Fisico ]  " + this.getIdade() + " anos, " + this.getAltura() + "m de altura");
        // Busca e imprime o peso em kg e a categoria correspondente
        System.out.println(" [  Peso  ]  " + this.getPeso() + "kg (Peso " + this.getCategoria() + ")");
        // Busca e imprime todo o histórico de vitórias, derrotas e empates
        System.out.println(" [ Cartel ]  " + this.getVitorias() + " Vitorias | " + this.getDerrotas() + " Derrotas | " + this.getEmpates() + " Empates");
        // Imprime a linha final e pula uma linha extra com o \n
        System.out.println("===============================================\n");
    }

    // Método público que exibe um resumo rápido de 1 linha (usado após a luta para ver o cartel atualizado)
    public void status(){
        // Imprime Nome, Categoria e o cartel resumido (ex: 12V - 2D - 1E)
        System.out.println(" [+] " + this.getNome() + " [Peso " + this.getCategoria() + "]  -->  " + 
                           this.getVitorias() + "V - " + this.getDerrotas() + "D - " + this.getEmpates() + "E");
    }

    // Método chamado quando o lutador vence uma luta
    public void ganharLuta(){
        // Pega o número atual de vitórias (getVitorias()), soma 1 e salva o novo valor (setVitorias())
        this.setVitorias(this.getVitorias() + 1);
    }

    // Método chamado quando o lutador perde uma luta
    public void perderLuta(){
        // Pega o número atual de derrotas (getDerrotas()), soma 1 e salva o novo valor (setDerrotas())
        this.setDerrotas(this.getDerrotas() + 1);
    }

    // Método chamado quando a luta dá empate
    public void empatarLuta(){
        // Pega o número atual de empates (getEmpates()), soma 1 e salva o novo valor (setEmpates())
        this.setEmpates(this.getEmpates() + 1);
    }

    // MÉTODO CONSTRUTOR: Executado automaticamente quando fazemos "new lutador(...)" lá no main
    public lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitorias, int derrotas,
            int empates) {
        this.nome = nome;                   // Atribui o parâmetro 'nome' ao atributo 'this.nome' do objeto
        this.nacionalidade = nacionalidade; // Atribui a nacionalidade recebida ao atributo do objeto
        this.idade = idade;                 // Atribui a idade recebida ao atributo do objeto
        this.altura = altura;               // Atribui a altura recebida ao atributo do objeto
        this.setPeso(peso);                 // IMPORTANTE: Chama o método setPeso() em vez de atribuir direto, para engatilhar o cálculo da categoria
        this.vitorias = vitorias;           // Define as vitórias iniciais
        this.derrotas = derrotas;           // Define as derrotas iniciais
        this.empates = empates;             // Define os empates iniciais
    }

    // --- MÉTODOS GETTERS E SETTERS (Acesso controlado aos atributos privados) ---

    // Retorna o nome do lutador
    public String getNome() {
        return nome;
    }

    // Altera o nome do lutador recebendo um novo texto como parâmetro
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna a nacionalidade do lutador
    public String getNacionalidade() {
        return nacionalidade;
    }

    // Altera a nacionalidade do lutador
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    // Retorna a idade do lutador
    public int getIdade() {
        return idade;
    }

    // Altera a idade do lutador
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Retorna a altura do lutador
    public float getAltura() {
        return altura;
    }

    // Altera a altura do lutador
    public void setAltura(float altura) {
        this.altura = altura;
    }

    // Retorna o peso do lutador
    public float getPeso() {
        return peso;
    }

    // Altera o peso do lutador e já atualiza a categoria automaticamente
    public void setPeso(float peso) {
        this.peso = peso;    // Salva o novo peso no atributo
        this.setCategoria(); // Chama o método abaixo para recalcular a categoria baseada nesse novo peso
    }

    // Retorna a categoria do lutador (Leve, Médio, Pesado ou Inválido)
    public String getCategoria() {
        return categoria;
    }

    // Define a categoria internamente sem receber parâmetros, olhando apenas para o 'this.peso' atual
    public void setCategoria() {
        if (this.peso < 52.2) {               // Se pesar menos de 52.2 kg:
            this.categoria = "Inválido";      // Muito leve para competir
        } else if (this.peso <= 70.3) {       // Senão, se pesar de 52.2 até 70.3 kg:
            this.categoria = "Leve";          // Categoria Peso Leve
        } else if (this.peso <= 83.9) {       // Senão, se pesar acima de 70.3 até 83.9 kg:
            this.categoria = "Médio";         // Categoria Peso Médio
        } else if (this.peso <= 120.2) {      // Senão, se pesar acima de 83.9 até 120.2 kg:
            this.categoria = "Pesado";        // Categoria Peso Pesado
        } else {                              // Se passar de 120.2 kg:
            this.categoria = "Inválido";      // Acima do limite máximo de peso
        }
    }

    // Retorna o número de vitórias
    public int getVitorias() {
        return vitorias;
    }

    // Altera o número de vitórias
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    // Retorna o número de derrotas
    public int getDerrotas() {
        return derrotas;
    }

    // Altera o número de derrotas
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    // Retorna o número de empates
    public int getEmpates() {
        return empates;
    }

    // Altera o número de empates
    public void setEmpates(int empates) {
        this.empates = empates;
    }
    
}