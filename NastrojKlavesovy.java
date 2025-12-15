public class NastrojKlavesovy extends Nastroj {
    private int pocetKlavesov;

    public NastrojKlavesovy(String druh, double cena, String zvuk, int pocet, int pocetKlavesov) {
        super(druh, cena, zvuk, pocet);
        setPocetKlavesov(pocetKlavesov);
    }

    public int getPocetKlavesov() {
        return pocetKlavesov;
    }

    public void setPocetKlavesov(int pocetKlavesov) {
        if (pocetKlavesov > 0) {
            this.pocetKlavesov = pocetKlavesov;
        } else {
            this.pocetKlavesov = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("NastrojKlavesovy[%s, klavesy=%d]", super.toString(), pocetKlavesov);
    }
}

