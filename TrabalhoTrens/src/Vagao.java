public class Vagao {
    private int id_Vagao;
    private double cap_max;
    private Trem trem;
    private static int ultimoId = 0;

    public Vagao(double cap_max){
        this.id_Vagao = ultimoId + 1;
        ultimoId = this.id_Vagao;
        this.cap_max = cap_max;
    }

    public int getId(){
        return id_Vagao;
    }
    public double getCapMax(){
        return cap_max;
    }
    public int getComposicao(){
        return trem.getID();
    }
}
