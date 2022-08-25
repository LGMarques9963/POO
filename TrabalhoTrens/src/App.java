public class App {
    public static void main(String[] args) throws Exception {
        Trem trem = new Trem(1);
        Trem trem1 = new Trem(2);
        Locomotiva l = new Locomotiva(1,500.00, 7);
        Vagao v = new Vagao(1,100);
        Locomotiva l1 = new Locomotiva(2,450.00, 6);
        Vagao v1 = new Vagao(2,70);
        trem.engataLocomotiva(l);
        trem.engataVagao(v);
        trem.engataLocomotiva(l1);
        trem.engataVagao(v1);
        System.out.println(trem.getVagaoPosicao(1).getCapMax());
        System.out.println(trem.getLocomotivaPosicao(1).getNroMaxVagoes());
    }
}
