package orchester.hudobnynastroj;

public class Nastroj implements ZvukovyPrvok {
    private String druh;
    private double cena;
    private String zvuk;
    private int pocet;

    public Nastroj(String druh, double cena, String zvuk, int pocet) {
        this.druh = druh;
        this.cena = cena;
        this.zvuk = zvuk;
        this.pocet = pocet;
    }

    public String getDruh() { 
        return druh; 
    }
    public void setDruh(String druh) { 
        if(druh != null && !druh.equals("")){
            this.druh = druh;
        }else{
            this.druh = "neznamy druh";
        }
    }
    public double getCena() { 
        return cena; 
    }
    public void setCena(double cena) { 
        if(cena >= 0){
            this.cena = cena;
        }else{
            this.cena = 0;
        }
    }
    public String getZvuk() { 
        return zvuk; 
    }
    public void setZvuk(String zvuk) { 
        if(zvuk != null && !zvuk.equals("")){
            this.zvuk = zvuk;
        }else{
            this.zvuk = "neznamy zvuk";
        }
    }
    public int getPocet() { 
        return pocet; 
    }
    public void setPocet(int pocet) { 
        if (pocet>0){
            this.pocet = pocet;
        }else{
            this.pocet = 0;
        }
    }
    public String hraj() {
        return zvuk;
    }

    @Override
    public String toString() {
        return String.format("Nastroj[druh=%s, cena=%.2f, zvuk=%s, pocet=%d]", druh, cena, zvuk, pocet);
    }
}
