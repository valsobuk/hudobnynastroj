package orchester.hudobnynastroj;

public class Lod implements ZvukovyPrvok {
    private String nazov;
    private String zvuk;
    private boolean naVode;

    public Lod(String nazov, String zvuk) {
        this.nazov = nazov;
        this.zvuk = zvuk;
        this.naVode = false;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        if (nazov != null && !nazov.equals("")) {
            this.nazov = nazov;
        } else {
            this.nazov = "neznamy nazov";
        }
    }

    public String getZvuk() {
        return zvuk;
    }

    public void setZvuk(String zvuk) {
        if (zvuk != null && !zvuk.equals("")) {
            this.zvuk = zvuk;
        } else {
            this.zvuk = "neznamy zvuk";
        }
    }

    public boolean isNaVode() {
        return naVode;
    }

    public void spustNaVodu() {
        this.naVode = true;
    }

    @Override
    public String hraj() {
        return zvuk;
    }

    @Override
    public String toString() {
        return String.format("Lod[nazov=%s, naVode=%s]", nazov, naVode);
    }
}
