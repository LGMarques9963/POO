import java.util.ArrayList;

public class Garagem {
    ArrayList<ElementoTrem> elementos = new ArrayList<>();

    public boolean adicionaElemento(ElementoTrem elemento){
        return elementos.add(elemento);
    }

    public boolean removeElemento(ElementoTrem elemento){
        return elementos.remove(elemento);
    }

    public void listarElementos(){
        for(ElementoTrem elemento : elementos){
            if(elemento.getEstado()) System.out.println(elemento);
        }

    }
    public void listarLocomotivas(){
        for(ElementoTrem elemento : elementos){
            if(elemento.getEstado() & elemento instanceof Locomotiva) System.out.println(elemento);
        }

    }
    public void listarVagoes(){
        for(ElementoTrem elemento : elementos){
            if(elemento.getEstado() & elemento instanceof Vagao) System.out.println(elemento);
        }

    }
    public ElementoTrem getElemento(int idElemento){
        ElementoTrem locNull = null;

        for(ElementoTrem elementoTrem : elementos){
            if(idElemento == elementoTrem.getCodigo()) return (ElementoTrem) elementoTrem;
        }
        
        return locNull;
    }
}
