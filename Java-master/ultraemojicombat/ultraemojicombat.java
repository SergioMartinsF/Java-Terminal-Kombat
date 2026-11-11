// Define que pertence ao pacote ultraemojicombat
package ultraemojicombat;

// Importa a ferramenta Scanner para ler o que o usuário digita no teclado pelo terminal
import java.util.Scanner;

// Declaração da classe principal do programa
public class ultraemojicombat {
    // Método 'main': é a porta de entrada que o Java procura para iniciar a execução do programa
    public static void main(String[] args) {
        // Cria um vetor (array) chamado 'l' capaz de guardar 6 objetos do tipo 'lutador' (posições de 0 a 5)
        lutador l[] = new lutador[6];
        
        // --- CATEGORIA LEVE (Até 70.3kg) ---
        // Cria o lutador da posição 0 passando: Nome, País, Idade, Altura (f = float), Peso (f = float), Vitórias, Derrotas, Empates
        l[0] = new lutador("Charles 'Do Backend' Oliveira", "Brasil", 34, 1.78f, 69.5f, 11, 2, 1);
        
        // Cria o lutador da posição 1 (Peso Leve)
        l[1] = new lutador("Coder McGregor", "Irlanda", 35, 1.75f, 70.0f, 14, 2, 3);
        
        // --- CATEGORIA MÉDIO (Até 83.9kg) ---
        // Cria o lutador da posição 2 (Peso Médio)
        l[2] = new lutador("Anderson 'Spider' Web", "Brasil", 48, 1.88f, 83.5f, 12, 2, 1);

        // Cria o lutador da posição 3 (Peso Médio)
        l[3] = new lutador("Georges 'Script'-Pierre", "Canadá", 42, 1.78f, 81.6f, 13, 0, 2);

        // --- CATEGORIA PESADO (Até 120.2kg) ---
        // Cria o lutador da posição 4 (Peso Pesado)
        l[4] = new lutador("Jon 'Bytes' Jones", "EUA", 36, 1.93f, 112.0f, 27, 1, 0); 

        // Cria o lutador da posição 5 (Peso Pesado)
        l[5] = new lutador("Block Lesnar", "EUA", 46, 1.91f, 119.5f, 12, 2, 4);
    
        // Inicializa o Scanner 'teclado' conectado à entrada do sistema (System.in)
        Scanner teclado = new Scanner(System.in);
        // Instancia um objeto 'UEC01' da classe 'luta' para organizar o evento
        luta UEC01 = new luta();
        
        // Cria uma variável booleana começando em 'false' para controlar o loop do menu
        boolean lutaAprovada = false;
        
        // Imprime o banner inicial de boas-vindas do jogo
        System.out.println("=======================================");
        System.out.println("   BEM-VINDO AO ULTRA EMOJI COMBAT!    ");
        System.out.println("=======================================");
        
        // Estrutura de repetição: enquanto 'lutaAprovada' NÃO (!) for verdadeira, repete todo o bloco abaixo
        while (!lutaAprovada) {
            // Imprime o título da lista de lutadores
            System.out.println("\nLista de lutadores disponíveis:");
            // Loop 'for' que vai de i = 0 até o tamanho do vetor (l.length, que é 6), aumentando de 1 em 1 (i++)
            for (int i = 0; i < l.length; i++) {
                // Imprime o número do índice [0 a 5], seguido do Nome e da Categoria de cada lutador
                System.out.println("[" + i + "] - " + l[i].getNome() + " (Peso " + l[i].getCategoria() + ")");
            }
            // Imprime linha divisória abaixo da lista
            System.out.println("---------------------------------------");
            
            // --- ESCOLHA DO 1º LUTADOR (DESAFIADO) ---
            // Pede ao usuário para digitar o número do primeiro lutador (usando 'print' sem 'ln' para digitar na mesma linha)
            System.out.print("Digite o número do lutador DESAFIADO (0 a 5): ");
            // Lê o número inteiro digitado pelo usuário e guarda na variável 'idDesafiado'
            int idDesafiado = teclado.nextInt(); 
            // Trava de validação: enquanto o número digitado for menor que 0 OU (||) maior que 5, pede de novo
            while (idDesafiado < 0 || idDesafiado > 5) {
                System.out.print("Opção inválida! Digite um número válido entre 0 e 5: ");
                idDesafiado = teclado.nextInt(); // Lê novamente até o usuário digitar um índice existente no vetor
            }
            
            // --- ESCOLHA DO 2º LUTADOR (DESAFIANTE) ---
            // Pede ao usuário para digitar o número do segundo lutador
            System.out.print("Digite o número do lutador DESAFIANTE (0 a 5): ");
            // Lê o número inteiro e guarda na variável 'idDesafiante'
            int idDesafiante = teclado.nextInt(); 
            // Trava de validação: garante que 'idDesafiante' também esteja entre 0 e 5
            while (idDesafiante < 0 || idDesafiante > 5) {
                System.out.print("Opção inválida! Digite um número válido entre 0 e 5: ");
                idDesafiante = teclado.nextInt(); // Lê novamente se for inválido
            }
            
            // Avisa que vai tentar agendar a luta
            System.out.println("\n>>> PREPARANDO O COMBATE <<<");
            
            // Passa os dois objetos lutadores escolhidos (l[idDesafiado] e l[idDesafiante]) para o método marcarLuta()
            UEC01.marcarLuta(l[idDesafiado], l[idDesafiante]);
            
            // Verifica se a luta cumpriu as regras olhando o método isAprovada() do objeto UEC01
            if (UEC01.isAprovada()) {
                // Muda a variável para 'true': isso faz com que o loop 'while (!lutaAprovada)' encerre após a luta!
                lutaAprovada = true; 
                // Chama o método que apresenta os lutadores, sorteia o vencedor e atualiza os cartéis
                UEC01.lutar();
                
                // Exibe o cabeçalho pós-luta para mostrar como ficaram os cartéis atualizados
                System.out.println("\n--- STATUS ATUALIZADO DOS LUTADORES ---");
                l[idDesafiado].status();  // Mostra o novo cartel do desafiado
                System.out.println("");   // Pula uma linha em branco
                l[idDesafiante].status(); // Mostra o novo cartel do desafiante
            } else {
                // Caso isAprovada() retorne 'false', a luta foi barrada pelas regras!
                System.out.println("\n❌ A LUTA NÃO PÔDE ACONTECER!");
                
                // Verifica qual regra foi quebrada para explicar o motivo exato ao usuário:
                if (idDesafiado == idDesafiante) {
                    // Motivo 1: Escolheu o mesmo índice para os dois lutadores
                    System.out.println("Motivo: Um lutador não pode enfrentar a si mesmo.");
                } else if (!l[idDesafiado].getCategoria().equals(l[idDesafiante].getCategoria())) {
                    // Motivo 2: As categorias de peso dos dois não são iguais (ex: Leve vs Pesado)
                    System.out.println("Motivo: Lutadores de categorias diferentes (" + l[idDesafiado].getCategoria() + " vs " + l[idDesafiante].getCategoria() + ") não podem se enfrentar.");
                } else {
                    // Motivo 3: Algum lutador está fora dos limites de peso permitidos ("Inválido")
                    System.out.println("Motivo: Um dos lutadores está com categoria Inválida.");
                }
                
                // Imprime aviso de reinício. Como 'lutaAprovada' continua 'false', o 'while' volta ao topo automaticamente!
                System.out.println("Reiniciando o sistema de combate...\n");
                System.out.println("=======================================");
            }
        }
        
        // Fecha o leitor Scanner ao final do programa para liberar memória (boa prática em Java)
        teclado.close();
    }
}