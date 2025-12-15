public class NastrojRytmicky extends Nastroj {
    private int pocetZvukov;

    public NastrojRytmicky(String druh, double cena, String zvuk, int pocet, int pocetZvukov) {
        super(druh, cena, zvuk, pocet);
        setPocetZvukov(pocetZvukov);
    }

    public int getPocetZvukov() {
        return pocetZvukov;
    }

    public void setPocetZvukov(int pocetZvukov) {
        if (pocetZvukov > 0) {
            this.pocetZvukov = pocetZvukov;
        } else {
            this.pocetZvukov = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("NastrojRytmicky[%s, zvuky=%d]", super.toString(), pocetZvukov);
    }
}

