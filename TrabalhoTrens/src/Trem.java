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
        if(posicao < 0 || posicao >= usadosLocomotivas){
            return null;
        }else{
            return this.locomotivas.get(posicao);
        }
    }

    public boolean engataLocomotiva(Locomotiva loc){
        if (getQuantidadeVagoes() == 0 & loc.getEstado()){
            locomotivas.add(loc);
            this.usadosLocomotivas++;
            loc.setEstado(false);
            loc.setTrem(this);
            return true;
        }else{
            System.out.println("Não é possível adicionar essa locomotiva");
            return false;
        }
    }

    public boolean engataVagao(Vagao vag){
        if(locomotivas.size() > 0 & vag.getEstado()){
            vagoes.add(vag);
            this.usadosVagoes++;
            vag.setEstado(false);
            return true;
        }else{
            System.out.println("Não é possível adicionar esse vagao"); 
            return false;
        }
    }

    public boolean desengataVagao(){
        if(getQuantidadeVagoes() == 0){
            return false;
        }else{
            Vagao vagao = vagoes.get(getQuantidadeVagoes()-1);
            vagao.setEstado(true);
            vagoes.remove(getQuantidadeVagoes()-1);
            this.usadosVagoes--;
            return true;
        }
    }
    
    public boolean desengataLocomotiva(){
        if(getQntLocomotivas() == 0){
            System.out.println("Não há locomotivas engatadas"); // Temos que chamar o destrutor nesse caso
            return false;
        }else{
            Locomotiva loc;
            loc = locomotivas.get(getQntLocomotivas()-1);
            loc.setEstado(true);
            locomotivas.remove(getQntLocomotivas()-1);
            this.usadosLocomotivas--;
            return true;
        }
    }
    public String toString(){
        return "id Trem: "+id_Trem+" | Qnt Locomotivas:"+getQntLocomotivas()+" | Qnt Vagoes:"+getQuantidadeVagoes();
    }

}