package orchester.hudobnynastroj;

public class RytmickyNastroj extends Nastroj {
    private int pocetZvukov;

    public RytmickyNastroj(String druh, double cena, String zvuk, int pocet, int pocetZvukov) {
        super(druh, cena, zvuk, pocet);
        this.pocetZvukov = pocetZvukov;
    }

    public int getPocetZvukov() {
        return pocetZvukov;
    }

    public void setPocetZvukov(int pocetZvukov) {
        if(pocetZvukov >= 1) {
            this.pocetZvukov = pocetZvukov;
        } else {
            this.pocetZvukov = 1;
        }
    }

    @Override
    public String toString() {
        return String.format("RytmickyNastroj[%s, pocetZvukov=%d]", super.toString(), pocetZvukov);
    }
}
