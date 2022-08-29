import java.util.*;
public class Trem{
    private int id_Trem;
    private ArrayList<Locomotiva> locomotivas;
    private ArrayList<Vagao> vagoes;
    private int usadosVagoes, usadosLocomotivas;

    private static int ultimoId = 0;

    public Trem(Locomotiva locomotiva){
        this.id_Trem = ultimoId + 1;
        ultimoId = this.id_Trem;

        locomotivas = new ArrayList<>();
        locomotivas.add(locomotiva);
        this.usadosLocomotivas = 1;

        vagoes = new ArrayList<>();
        this.usadosVagoes = 0;
    }

    public int getID(){
        return id_Trem;
    }

    public int getQntLocomotivas(){
        return this.usadosLocomotivas;
    }

    public int getQuantidadeVagoes(){
        return this.usadosVagoes;
    }

    // Precisa desse método?
    public Vagao getVagaoPosicao(int posicao){
        if(posicao < 0 || posicao >= usadosVagoes){
            return null;
        }else{
            return this.vagoes.get(posicao);
        }
        
       // return this.vagoes.get(posicao);
        
        // Vagao vag_Posi = null;
        // for(int i=0;i < vagoes.size(); i++){
        //     if(posicao == vagoes.get(i).getId()){
        //         vag_Posi = vagoes.get(i);
        //     }
        // }
        // return vag_Posi;
    }

    // Precisa desse método?
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
        if (getQuantidadeVagoes() == 0){
            locomotivas.add(loc);
            this.usadosLocomotivas++;
            return true;
        }else{
            System.out.println("Não é possível adicionar uma locomotiva se já há vagões engatados");
            return false;
        }
    }
    public boolean engataVagao(Vagao vag){
        if(locomotivas.size() > 0){
            vagoes.add(vag);
            this.usadosVagoes++;
            return true;
        }else{
            System.out.println("Primeiro adicione pelo menos uma locomotiva"); 
            return false;
        }
    }

    public boolean desengataVagao(){
        if(getQuantidadeVagoes() == 0){
            System.out.println("Não há vagões engatados para retirar");
            return false;
        }else{
            vagoes.remove(getQuantidadeVagoes());
            return true;
        }
    }
    
    public boolean desengataLocomotiva(){
        if(getQntLocomotivas() == 0){
            System.out.println("Não há locomotivas engatadas"); // Temos que chamar o destrutor nesse caso
            return false;
        }else{
            locomotivas.remove(getQntLocomotivas());
            return true;
        }
    }

}