public class App {
    public static void main(String[] args) throws Exception {
        Cachorro c = new Cachorro ("Perneta", 6);
        Cachorro c1 = new Cachorro("Laika", 20);

        System.out.println(c+", "+c1);
        System.out.println(c.getNome());
        System.out.println(c+", "+c1);
        
        Cachorro c2 = new Cachorro("Laika", 20);
        
        System.out.println(Cachorro.rapido(6));
    }
}
