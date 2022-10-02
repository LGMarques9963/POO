public class Vagao extends ElementoTrem{

    public Vagao(double capacidadeMaxima){
        super(capacidadeMaxima);
    }


    @Override
    public String toString(){
        return "Id Vagao: "+super.getCodigo()+" | Capacidade Max: "+getCapacidadeMaxima();
    }
}
