import java.util.ArrayList;
import java.util.Random;
public class GaragemVagoes {
    ArrayList<Vagao> vagoes = new ArrayList<>();

    public boolean entradaVagao(Vagao vagao){
        Random r = new Random();
        vagoes.add(vagao);
        return true;
    }
    public boolean removeVagao(Vagao vagao){
        int id = 0;
        for(int i=0; i< vagoes.size(); i++){
            if(vagoes.get(i).getId() == vagao.getId()){
                id = vagao.getId();
                vagoes.remove(i);
                break;
            }
        }
        System.out.println("O Vagão de id "+id+" foi removido");
        return true;
    }
    public ArrayList getVagoes(){
        return vagoes;
    }
}
