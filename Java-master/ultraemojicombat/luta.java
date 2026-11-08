package ultraemojicombat;

import java.util.Random;

public class luta {
    private lutador desafiado;
    private lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public void marcarLuta(lutador l1, lutador l2){
        if (l1.getCategoria().equals(l2.getCategoria()) && l1 != l2){
            this.aprovada = true;
            this.desafiado = l1;
            this.desafiante = l2;
        } else {
            this.aprovada = false;
            this.desafiado = null;
            this.desafiante = null;
        }
    }

    /**
     * 
     */
    public void lutar(){
        if (this.aprovada) {
            System.out.println("\n      [ NO CORNER VERMELHO (DESAFIADO) ]");
            this.desafiado.apresentar();
            
            System.out.println("                    X VS X\n");
            
            System.out.println("      [ NO CORNER AZUL (DESAFIANTE) ]");
            this.desafiante.apresentar();

            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3);
            
            System.out.println("\n >>> ======= RESULTADO DA LUTA ======= <<<");
            switch (vencedor) {
                case 0:
                    System.out.println("   Empatou! Uma luta muito equilibrada!");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                    break;
                case 1:
                    System.out.println("   Vitoria esmagadora de " + this.desafiado.getNome() + "!");
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                    break;
                case 2:
                    System.out.println("   Vitoria esmagadora de " + this.desafiante.getNome() + "!");
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                    break;
            }
            System.out.println(" =========================================\n");
        } else {
            System.out.println("A luta não pôde acontecer!");
        }
    }

    public lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(lutador desafiado) {
        this.desafiado = desafiado;
    }

    public lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
     
}
