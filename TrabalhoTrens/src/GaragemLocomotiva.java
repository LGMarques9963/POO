import java.util.ArrayList;

public class GaragemLocomotiva{
    ArrayList<Locomotiva> locomotivas = new ArrayList<>();

    public boolean entraLocomotiva(Locomotiva locomotiva){
        return locomotivas.add(locomotiva);
    }

    public boolean removeLocomotiva(Locomotiva locomotiva){
        return locomotivas.remove(locomotiva);
    }

    public void listarLocomotivas(){
        for(Locomotiva locomotiva : locomotivas){
            if(locomotiva.getEstado()) System.out.println(locomotiva);
        }

    }

    public Locomotiva getLocomotiva(int idLocomotiva){
        Locomotiva locNull = null;

        for(ElementoTrem elementoTrem : locomotivas){
            if(idLocomotiva == elementoTrem.getCodigo()) return (Locomotiva)elementoTrem;
        }
        
        return locNull;
    }
}