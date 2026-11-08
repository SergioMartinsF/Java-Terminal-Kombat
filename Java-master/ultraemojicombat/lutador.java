package ultraemojicombat;

public class lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;

    public void apresentar(){
        System.out.println("===============================================");
        System.out.println(" >>> CHEGOU A HORA!! Diante de vocês: " + this.getNome().toUpperCase());
        System.out.println("===============================================");
        System.out.println(" [ Origem ]  " + this.getNacionalidade());
        System.out.println(" [ Fisico ]  " + this.getIdade() + " anos, " + this.getAltura() + "m de altura");
        System.out.println(" [  Peso  ]  " + this.getPeso() + "kg (Peso " + this.getCategoria() + ")");
        System.out.println(" [ Cartel ]  " + this.getVitorias() + " Vitorias | " + this.getDerrotas() + " Derrotas | " + this.getEmpates() + " Empates");
        System.out.println("===============================================\n");
    }

    public void status(){
        System.out.println(" [+] " + this.getNome() + " [Peso " + this.getCategoria() + "]  -->  " + 
                           this.getVitorias() + "V - " + this.getDerrotas() + "D - " + this.getEmpates() + "E");
    }

    public void ganharLuta(){
        this.setVitorias(this.getVitorias() + 1);
    }

    public void perderLuta(){
        this.setDerrotas(this.getDerrotas() + 1);
    }

    public void empatarLuta(){
        this.setEmpates(this.getEmpates() + 1);
    }

    public lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitorias, int derrotas,
            int empates) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        this.setPeso(peso);
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        if (this.peso < 52.2) {
            this.categoria = "Inválido";
        } else if (this.peso <= 70.3) {
            this.categoria = "Leve";
        } else if (this.peso <= 83.9) {
            this.categoria = "Médio";
        } else if (this.peso <= 120.2) {
            this.categoria = "Pesado";
        } else {
            this.categoria = "Inválido";
        }
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
    
}
