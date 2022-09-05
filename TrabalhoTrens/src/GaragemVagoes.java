import java.util.ArrayList;

public class GaragemVagoes {
    ArrayList<Vagao> vagoes = new ArrayList<>();

    public boolean entradaVagao(Vagao vagao){
        return vagoes.add(vagao);
    }
    public boolean removeVagao(Vagao vagao){
        return vagoes.remove(vagao);
    }

    public void listarVagoes(){
        for(Vagao vagao : vagoes){
            if(vagao.getEstado()) System.out.println(vagao);
        }
    }

    public Vagao getVagao(int idVagao){
        Vagao vagNull = null;

        for(Vagao vagao : vagoes){
            if(idVagao == vagao.getId()) return vagao;
        }
        
        return vagNull;
    }

}
