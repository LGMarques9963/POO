import java.util.*;
public class Trem{
    private int id_Trem;
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;

    public Trem(int id_Trem){
        this.id_Trem = id_Trem;
        locomotivas = new ArrayList<>();
        vagoes = new ArrayList<>();
    }
    public int getID(){
        return id_Trem;
    }
    public int getQntLocomotivas(){
        return locomotivas.size();
    }
    public int getQuantidadeVagoes(){
        return vagoes.size();
    }
    public Vagao getVagaoPosicao(int posicao){
        Vagao vag_Posi = null;
        for(int i=0;i < vagoes.size(); i++){
            if(posicao == vagoes.get(i).getId()){
                vag_Posi = vagoes.get(i);
            }
        }
        return vag_Posi;
    }
    public Locomotiva getLocomotivaPosicao(int posicao){
        Locomotiva loc_Pos = null;
        for(int i=0;i < locomotivas.size(); i++){
            if(posicao == locomotivas.get(i).getId()){
                loc_Pos = locomotivas.get(i);
            }
        }
        return loc_Pos;
    }
    public boolean engataLocomotiva(Locomotiva loc){
        locomotivas.add(loc);
        return true;
    }
    public boolean engataVagao(Vagao vag){
        if(locomotivas.size() > 0){
            vagoes.add(vag);
            return true;
        }else{
            return false;
        }
    }
    public boolean desengataVagao(){
        if(vagoes.size() == 0){
            return false;
        }else{
            vagoes.remove(vagoes.size()-1);
            return true;
        }
    }
    public boolean desengataLocomotiva(){
        if(locomotivas.size() == 0){
            return false;
        }else{
            locomotivas.remove(locomotivas.size()-1);
            return true;
        }
    }

}