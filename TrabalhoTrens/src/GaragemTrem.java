import java.util.ArrayList;

public class GaragemTrem {
    ArrayList<Trem> trens = new ArrayList<>();

    public boolean addTrem(Trem trem){
        return trens.add(trem);
    }

    public boolean removeTrem(Trem trem){
        return trens.remove(trem);
    }

    public void listarTrens(){
        for(Trem trem : trens){
            if(trem.getEstado()) System.out.println(trem);
        }

    }

    public Trem getTrem(int idTrem){
        Trem tremNull = null;

        for(Trem trem : trens){
            if(idTrem == trem.getID()) return trem;
        }
        
        return tremNull;
    }
}

