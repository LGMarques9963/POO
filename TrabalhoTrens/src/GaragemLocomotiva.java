import java.util.ArrayList;
import java.util.Random;

public class GaragemLocomotiva{
    ArrayList<Locomotiva> locomotivas = new ArrayList<>();

    public boolean entraLocomotiva(Locomotiva locomotiva){
        Random r = new Random();
        locomotivas.add(new Locomotiva((r.nextInt(100)*10/2), r.nextInt(r.nextInt(50)+10)));
        return true;
    }

    public boolean removeLocomotiva(Locomotiva locomotiva){
        int id;
        for(int i=0;i<locomotivas.size();i++){
            if(locomotivas.get(i).getId() == locomotiva.getId()) id = locomotiva.getId();
        }
        
    }
}