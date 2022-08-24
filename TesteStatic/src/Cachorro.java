public class Cachorro {
    private String nome;
    private double peso;

    //Atributos de classe
    private static int contaCachorro=0;
    public Cachorro(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
        contaCachorro++;
    }
    public String getNome() {
        return nome;
    }
    public int getContaCachorro(){
        return contaCachorro;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public static boolean rapido(int velocidade) {
        if(velocidade>5) return true;
        else return false;
    }

    @Override
    public String toString(){
        String aux = "[" +nome+","+peso+", "+contaCachorro+"]";
        return aux;
    }
    
}
