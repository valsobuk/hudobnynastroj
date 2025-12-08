package orchester;

public class Hrac {
    private String meno;
    private String priezvisko;
    private Nastroj nastroj;
    private double hodinovaSadzba;

    public Hrac(String meno, String priezvisko, Nastroj nastroj, double hodinovaSadzba) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.nastroj = nastroj;
        this.hodinovaSadzba = hodinovaSadzba;
    }

    public String getMeno() {
        return meno;
    }
    public String getPriezvisko() { 
        return priezvisko; 
    }
    public Nastroj getNastroj() { 
        return nastroj; 
    }
    public double getHodinovaSadzba() { 
        return hodinovaSadzba; 
    }

    public void setNastroj(Nastroj nastroj) { 
        if(nastroj!=null){
            this.nastroj = nastroj;
        }else{
            this.nastroj = new Nastroj("neznamy nastroj", 0, "neznamy zvuk", 0);
        }
    }
    public void setHodinovaSadzba(double hodinovaSadzba) { 
        if(hodinovaSadzba>0){
            this.hodinovaSadzba = hodinovaSadzba;
        }else{
            this.hodinovaSadzba = 0;
        }
    }
    public void setMeno(String meno) { 
        if(meno!=""){
            this.meno = meno;
        }else{
            this.meno = "neznamy meno";
        }
    }
    public void setPriezvisko(String priezvisko) { 
        if(priezvisko!=""){
            this.priezvisko = priezvisko;
        }else{
            this.priezvisko = "neznamy priezvisko";
        }
    }

    public void hraj() {
        System.out.println(meno + " " + priezvisko + " hrá: " + nastroj.hraj());
    }

    @Override
    public String toString() {
        return meno + " " + priezvisko + " - " + nastroj.getDruh();
    }
}
