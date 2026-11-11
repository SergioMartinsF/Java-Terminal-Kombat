// Define que pertence ao mesmo pacote ultraemojicombat
package ultraemojicombat;

// Importa a classe Random do Java para sortear números aleatórios (decidir quem vence a luta)
import java.util.Random;

// Declaração da classe 'luta'
public class luta {
    // Atributos privados da luta. Note que 'desafiado' e 'desafiante' são objetos do tipo 'lutador' (Agregação)
    private lutador desafiado;  // O lutador do corner vermelho
    private lutador desafiante; // O lutador do corner azul
    private int rounds;         // Quantidade de rounds da luta
    private boolean aprovada;   // Guarda true (se a luta for válida) ou false (se for barrada pelas regras)

    // Método que valida se dois lutadores (l1 e l2) podem se enfrentar
    public void marcarLuta(lutador l1, lutador l2){
        // Regra: a categoria de l1 deve ser IGUAL (.equals) à de l2, E (&&) l1 deve ser DIFERENTE (!=) de l2
        if (l1.getCategoria().equals(l2.getCategoria()) && l1 != l2){
            this.aprovada = true;   // Luta liberada!
            this.desafiado = l1;    // Define l1 como desafiado
            this.desafiante = l2;   // Define l2 como desafiante
        } else {
            // Caso sejam de categorias diferentes ou seja o mesmo lutador contra si mesmo:
            this.aprovada = false;  // Luta bloqueada!
            this.desafiado = null;  // Deixa o corner vermelho vazio
            this.desafiante = null; // Deixa o corner azul vazio
        }
    }

    // Método que executa a luta de fato
    public void lutar(){
        // Verifica primeiro se a luta foi aprovada pelo método marcarLuta()
        if (this.aprovada) {
            // Imprime cabeçalho do Corner Vermelho e chama o método apresentar() do lutador desafiado
            System.out.println("\n      [ NO CORNER VERMELHO (DESAFIADO) ]");
            this.desafiado.apresentar();
            
            // Imprime separador de "Versus"
            System.out.println("                    X VS X\n");
            
            // Imprime cabeçalho do Corner Azul e chama o método apresentar() do lutador desafiante
            System.out.println("      [ NO CORNER AZUL (DESAFIANTE) ]");
            this.desafiante.apresentar();

            // Cria um objeto gerador de números aleatórios chamado 'aleatorio'
            Random aleatorio = new Random();
            // Sorteia um número inteiro entre 0, 1 ou 2 (nextInt(3) gera 3 números possíveis começando do 0)
            int vencedor = aleatorio.nextInt(3);
            
            // Imprime o cabeçalho do resultado
            System.out.println("\n >>> ======= RESULTADO DA LUTA ======= <<<");
            // Estrutura condicional switch para tratar o número sorteado na variável 'vencedor'
            switch (vencedor) {
                case 0: // Caso o número sorteado seja 0: Empate!
                    System.out.println("   Empatou! Uma luta muito equilibrada!");
                    this.desafiado.empatarLuta();  // Soma +1 empate no cartel do desafiado
                    this.desafiante.empatarLuta(); // Soma +1 empate no cartel do desafiante
                    break; // Sai do switch
                case 1: // Caso o número sorteado seja 1: Desafiado vence!
                    System.out.println("   Vitoria esmagadora de " + this.desafiado.getNome() + "!");
                    this.desafiado.ganharLuta();   // Soma +1 vitória para o desafiado
                    this.desafiante.perderLuta();  // Soma +1 derrota para o desafiante
                    break; // Sai do switch
                case 2: // Caso o número sorteado seja 2: Desafiante vence!
                    System.out.println("   Vitoria esmagadora de " + this.desafiante.getNome() + "!");
                    this.desafiado.perderLuta();   // Soma +1 derrota para o desafiado
                    this.desafiante.ganharLuta();  // Soma +1 vitória para o desafiante
                    break; // Sai do switch
            }
            // Imprime linha de fechamento do resultado
            System.out.println(" =========================================\n");
        } else {
            // Se this.aprovada for false, avisa que a luta não pode ocorrer
            System.out.println("A luta não pôde acontecer!");
        }
    }

    // --- MÉTODOS GETTERS E SETTERS DA LUTA ---

    // Retorna o objeto lutador desafiado
    public lutador getDesafiado() {
        return desafiado;
    }

    // Define manualmente o objeto lutador desafiado
    public void setDesafiado(lutador desafiado) {
        this.desafiado = desafiado;
    }

    // Retorna o objeto lutador desafiante
    public lutador getDesafiante() {
        return desafiante;
    }

    // Define manualmente o objeto lutador desafiante
    public void setDesafiante(lutador desafiante) {
        this.desafiante = desafiante;
    }

    // Retorna o número de rounds
    public int getRounds() {
        return rounds;
    }

    // Define o número de rounds
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    // Retorna se a luta está aprovada (true ou false)
    public boolean isAprovada() {
        return aprovada;
    }

    // Altera o status de aprovação da luta
    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
     
}