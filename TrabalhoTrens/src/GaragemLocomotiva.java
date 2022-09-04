import java.util.ArrayList;
import java.util.Random;

public class GaragemLocomotiva{
    ArrayList<Locomotiva> locomotivas = new ArrayList<>();

    public boolean entraLocomotiva(Locomotiva locomotiva){
        Random r = new Random();
        //Peso Max - Num de Vagoes
        locomotivas.add(locomotiva);
        return true;
    }

    public boolean removeLocomotiva(Locomotiva locomotiva){
        int id = 0;
        for(int i=0;i<locomotivas.size();i++){
            if(locomotivas.get(i).getId() == locomotiva.getId()){
                id = locomotiva.getId();
                locomotivas.remove(i);
                break;
            }
        }
        System.out.println("A locomotiva de id "+id+" foi removida");
        return true;
    }

    public ArrayList getLocomotivas(){
        return locomotivas;
    }
}