package orchester.hudobnynastroj;

public class KlavesovyNastroj extends Nastroj {
    private int pocetKlavesov;

    public KlavesovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetKlavesov) {
        super(druh, cena, zvuk, pocet);
        this.pocetKlavesov = pocetKlavesov;
    }

    public int getPocetKlavesov() {
        return pocetKlavesov;
    }

    public void setPocetKlavesov(int pocetKlavesov) {
        if(pocetKlavesov >= 1) {
            this.pocetKlavesov = pocetKlavesov;
        } else {
            this.pocetKlavesov = 1;
        }
    }

    @Override
    public String toString() {
        return String.format("KlavesovyNastroj[%s, pocetKlavesov=%d]", super.toString(), pocetKlavesov);
    }
}
