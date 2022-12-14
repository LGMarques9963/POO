import java.util.ArrayList;

public class Trem {
    private int idTrem;
    private int usadosVagoes;
    private int usadosLocomotivas;
    private long vagoesPermitidos = 0;
    private double pesoMaximo = 0;
    private double pesoTotal = 0;
    private boolean estado;

    ArrayList<Object> lst = new ArrayList<>();

    private static int ultimoId = 0;

    public Trem(Locomotiva locomotiva) {
        this.idTrem = ultimoId + 1;
        ultimoId = this.idTrem;

        if (locomotiva.getEstado()) {
            lst.add(locomotiva);
            locomotiva.setEstado(false);
            this.usadosLocomotivas = 1;
            this.vagoesPermitidos += locomotiva.getNroMaxVagoes();
            this.pesoMaximo += locomotiva.getCapacidadeMaxima();

        } else {
            System.out.println("Locomotiva ja esta em uso em outro trem");
        }

        this.usadosVagoes = 0;
        this.estado = true;

        System.out.println("Trem Criado com Sucesso");
    }

    public int getID() {
        return this.idTrem;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getQntLocomotivas() {
        return this.usadosLocomotivas;
    }

    public int getQuantidadeVagoes() {
        return this.usadosVagoes;
    }

    public long getVagoesPermitidos() {
        return this.vagoesPermitidos;
    }

    public double getPesoMax() {
        return this.pesoMaximo;
    }

    public double getPesoTotal() {
        return this.pesoTotal;
    }

    public boolean engataLocomotiva(Locomotiva locomotiva) {

        if (getQuantidadeVagoes() == 0 && locomotiva.getEstado()) {
            double fator = 1 - (this.getQntLocomotivas() * 0.1);
            lst.add(locomotiva);
            locomotiva.setEstado(false);
            locomotiva.setTrem(this);
            this.usadosLocomotivas++;
            this.vagoesPermitidos += Math.round(Math.floor((locomotiva.getNroMaxVagoes() * fator)));
            this.pesoMaximo += locomotiva.getCapacidadeMaxima();

            return true;
        } else {

            return false;
        }
    }

    public boolean engataVagao(Vagao vagao) {
        double pesoMaximoVagao = this.getPesoTotal() + vagao.getCapacidadeMaxima();

        if (this.getQntLocomotivas() <= 0) {
            System.out.println("N??o ?? poss??vel adicionar um vag??o sem que haja uma locomotiva engatada.");
            return false;
        } else if ( (vagao.getEstado()) && 
                    (this.getVagoesPermitidos() > this.getQuantidadeVagoes()) && 
                    (pesoMaximoVagao <= this.getPesoMax())) {
                        
                        lst.add(vagao);
                        this.usadosVagoes++;
                        this.pesoTotal = pesoMaximoVagao;

                        vagao.setEstado(false);
                        return true;
        } else {
            System.out.println("Nao e possivel adicionar esse vagao");
            return false;
        }
    }

    public boolean desengataVagao() {
        if (getQuantidadeVagoes() == 0) {
            return false;
        } else {
            System.out.println("->" + (getQuantidadeVagoes() - 1));
            System.out.println("->" + (getQuantidadeVagoes()));
            Vagao vagao = (Vagao) lst.get(lst.size() - 1);
            if (lst.remove(vagao)) {
                vagao.setEstado(true);
                System.out.println("(Removido Vagao) -> " + vagao.toString());
                this.usadosVagoes--;
                return true;
            } else
                return false;
        }
    }

    public boolean desengataLocomotiva() {
        if (getQntLocomotivas() == 0) {
            System.out.println("N??o h?? locomotivas engatadas");
            return false;
        } else {
            Locomotiva locomotiva = (Locomotiva) lst.get(lst.size() - 1);
            if (lst.remove(locomotiva)) {
                locomotiva.setEstado(true);
                System.out.println("(Removida Locomotiva) -> " + locomotiva.toString());
                this.usadosLocomotivas--;
                return true;
            } else
                return false;
        }
    }

    public boolean removerTrem() {

        if (this.getQuantidadeVagoes() != 0) {
            while (this.getQuantidadeVagoes() > 0) {
                this.desengataVagao();
            }

            if (this.getQuantidadeVagoes() == 0)
                System.out.println("Todos Vagoes foram removidos com sucesso");

        } else if (this.getQntLocomotivas() != 0) {
            while (this.getQntLocomotivas() > 0) {
                this.desengataLocomotiva();
                if (this.getQntLocomotivas() == 0) {
                    System.out.println("Todas Locomotivas foram removidas com sucesso");
                }
            }
        }
        return true;
    }

    public String toString() {
        return "id Trem: " + idTrem + " | Qnt Locomotivas:" + getQntLocomotivas() + " | Qnt Vagoes: "
                + getQuantidadeVagoes() +
                " | Vag_Permitidos: " + getVagoesPermitidos() + " | Peso Max Permitido: " + getPesoMax();
    }

}