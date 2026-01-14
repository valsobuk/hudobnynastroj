package orchester.hudobnynastroj;

public class DychovyNastroj extends Nastroj {
    private int pocetDier;
    private String ladenie;

    public DychovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetDier, String ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetDier = pocetDier;
        this.ladenie = ladenie;
    }

    public int getPocetDier() {
        return pocetDier;
    }

    public void setPocetDier(int pocetDier) {
        if(pocetDier >= 1) {
            this.pocetDier = pocetDier;
        } else {
            this.pocetDier = 1;
        }
    }

    public String getLadenie() {
        return ladenie;
    }

    public void setLadenie(String ladenie) {
        if(ladenie != null && !ladenie.equals("")) {
            this.ladenie = ladenie;
        } else {
            this.ladenie = "nezname ladenie";
        }
    }

    @Override
    public String toString() {
        return String.format("DychovyNastroj[%s, pocetDier=%d, ladenie=%s]", super.toString(), pocetDier, ladenie);
    }
}
