package orchester;

public class Main {
    public static void main(String[] args) {
        Nastroj gitara = new StrunovyNastroj("gitara", 199.99, "hulahop", 1, 6, "hulahop");


        Hrac[] hraci = new Hrac[] {
            new Hrac("Jano", "Struny", gitara, 15.0),

        };

        System.out.println("Orchester:");
        for (Hrac h : hraci) {
            System.out.println(" - " + h);
            h.hraj();
        }
    }
}
