public class Mamifero {
    protected void andar(){
        System.out.println("M and");
        ouvir();
    }
    protected void ver(){
        System.out.println("M vendo");
    }
    protected void ouvir(){
        System.out.println("M ouv");
        ver();
    }
}