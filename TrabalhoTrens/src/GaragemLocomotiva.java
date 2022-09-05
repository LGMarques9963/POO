import java.util.ArrayList;

public class GaragemLocomotiva{
    ArrayList<Locomotiva> locomotivas = new ArrayList<>();

    public boolean entraLocomotiva(Locomotiva locomotiva){
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

    public ArrayList<Locomotiva> getLocomotivas(){
        return locomotivas;
    }
}