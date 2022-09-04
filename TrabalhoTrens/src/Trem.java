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
    //Soma do total de vagoes que as locomotivas aguentam
    public long somaTotalVagoes(){
        long vag_permitidos = 0;
        double porcentagem = 0;
        for(int i = 0; i < locomotivas.size(); i++){
            if(i == 0){
                vag_permitidos += locomotivas.get(i).getNroMaxVagoes(); 
            }else{
                vag_permitidos += locomotivas.get(i).getNroMaxVagoes();
                porcentagem = Math.floor(vag_permitidos-(vag_permitidos/10));//->joga a porcentagem para baixo
                vag_permitidos = Math.round(porcentagem);//converte para long
            }
        }
        return vag_permitidos;
    }
    //Soma do total de peso que as locomotivas aguentam
    public double somaTotalPeso(){
        double peso_max = 0;
        for(int i = 0; i < locomotivas.size(); i++){
            peso_max += locomotivas.get(i).getPesoMax(); 
        }
        return peso_max;
    }

    public boolean engataVagao(Vagao vag){
        double peso_max_vag = 0;
        for(int i = 0; i < vagoes.size(); i++){
            peso_max_vag += vagoes.get(i).getCapMax();
        }
        peso_max_vag += vag.getCapMax();
        if(locomotivas.size() > 0 & vag.getEstado() & somaTotalVagoes() > vagoes.size() & peso_max_vag <= somaTotalPeso()){
            vagoes.add(vag);
            this.usadosVagoes++;
            vag.setEstado(false);
            return true;
        }else{
            System.out.println("Nao e possível adicionar esse vagao"); 
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
        return "id Trem: "+id_Trem+" | Qnt Locomotivas:"+getQntLocomotivas()+" | Qnt Vagoes: "+getQuantidadeVagoes() +
         " | Vag_Permitidos: "+ somaTotalVagoes() + " | Peso Max Permitido: "+ somaTotalPeso();
    }

}