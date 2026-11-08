package ultraemojicombat;

import java.util.Scanner;

public class ultraemojicombat {
    public static void main(String[] args) {
        // Inicialização dos lutadores
        lutador l[] = new lutador[6];
        
        // --- CATEGORIA LEVE ---
        // Referência: Charles "Do Bronx" Oliveira + Backend
        l[0] = new lutador("Charles 'Do Backend' Oliveira", "Brasil", 34, 1.78f, 69.5f, 11, 2, 1);
        
        // Referência: Conor McGregor + Coder (Programador)
        l[1] = new lutador("Coder McGregor", "Irlanda", 35, 1.75f, 70.0f, 14, 2, 3);
        
        // --- CATEGORIA MÉDIO ---
        // Referência: Anderson "Spider" Silva + Web (Aranha / Internet)
        l[2] = new lutador("Anderson 'Spider' Web", "Brasil", 48, 1.88f, 83.5f, 12, 2, 1);

        // Referência: Georges St-Pierre (GSP) + Script
        l[3] = new lutador("Georges 'Script'-Pierre", "Canadá", 42, 1.78f, 81.6f, 13, 0, 2);

        // --- CATEGORIA PESADO ---
        // Referência: Jon "Bones" Jones + Bytes
        l[4] = new lutador("Jon 'Bytes' Jones", "EUA", 36, 1.93f, 112.0f, 27, 1, 0); 

        // Referência: Brock Lesnar + Block (de Blockchain ou Blocos de código)
        l[5] = new lutador("Block Lesnar", "EUA", 46, 1.91f, 119.5f, 12, 2, 4);
    
        Scanner teclado = new Scanner(System.in);
        luta UEC01 = new luta();
        
        boolean lutaAprovada = false;
        
        System.out.println("=======================================");
        System.out.println("   BEM-VINDO AO ULTRA EMOJI COMBAT!    ");
        System.out.println("=======================================");
        
        // Loop que mantém o programa rodando até uma luta ser aprovada
        while (!lutaAprovada) {
            System.out.println("\nLista de lutadores disponíveis:");
            for (int i = 0; i < l.length; i++) {
                System.out.println("[" + i + "] - " + l[i].getNome() + " (Peso " + l[i].getCategoria() + ")");
            }
            System.out.println("---------------------------------------");
            
            // Escolhendo o DESAFIADO com validação
            System.out.print("Digite o número do lutador DESAFIADO (0 a 5): ");
            int idDesafiado = teclado.nextInt(); 
            while (idDesafiado < 0 || idDesafiado > 5) {
                System.out.print("Opção inválida! Digite um número válido entre 0 e 5: ");
                idDesafiado = teclado.nextInt();
            }
            
            // Escolhendo o DESAFIANTE com validação
            System.out.print("Digite o número do lutador DESAFIANTE (0 a 5): ");
            int idDesafiante = teclado.nextInt(); 
            while (idDesafiante < 0 || idDesafiante > 5) {
                System.out.print("Opção inválida! Digite um número válido entre 0 e 5: ");
                idDesafiante = teclado.nextInt();
            }
            
            System.out.println("\n>>> PREPARANDO O COMBATE <<<");
            
            // Tenta marcar a luta
            UEC01.marcarLuta(l[idDesafiado], l[idDesafiante]);
            
            // Verifica se a luta foi aprovada
            if (UEC01.isAprovada()) {
                lutaAprovada = true; // A luta foi válida, isso quebra o loop while
                UEC01.lutar();
                
                System.out.println("\n--- STATUS ATUALIZADO DOS LUTADORES ---");
                l[idDesafiado].status();
                System.out.println("");
                l[idDesafiante].status();
            } else {
                // Se a luta não foi aprovada, descobrimos o motivo para avisar o usuário
                System.out.println("\n❌ A LUTA NÃO PÔDE ACONTECER!");
                
                if (idDesafiado == idDesafiante) {
                    System.out.println("Motivo: Um lutador não pode enfrentar a si mesmo.");
                } else if (!l[idDesafiado].getCategoria().equals(l[idDesafiante].getCategoria())) {
                    System.out.println("Motivo: Lutadores de categorias diferentes (" + l[idDesafiado].getCategoria() + " vs " + l[idDesafiante].getCategoria() + ") não podem se enfrentar.");
                } else {
                    System.out.println("Motivo: Um dos lutadores está com categoria Inválida.");
                }
                
                System.out.println("Reiniciando o sistema de combate...\n");
                System.out.println("=======================================");
                // Como lutaAprovada continua false, o programa volta sozinho para o topo do 'while'
            }
        }
        
        teclado.close();
    }
}