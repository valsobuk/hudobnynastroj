package orchester;

public class StrunovyNastroj extends Nastroj {
    private int pocetStrun;
    private String ladenie;

    public StrunovyNastroj(String druh, double cena, String zvuk, int pocet, int pocetStrun,String ladenie) {
        super(druh, cena, zvuk, pocet);
        this.pocetStrun = pocetStrun;
        this.ladenie = ladenie;
    }
    public String getLadenie() { 
        return ladenie;
     }
    public void setLadenie(String ladenie) { 
        if(ladenie!=""){
            this.ladenie = ladenie;
        }else{
            this.ladenie = "neznamy ladenie";
        }

    }
    public int getPocetStrun() { return pocetStrun; }

    public void setPocetStrun(int pocetStrun) { 
        if(pocetStrun>0){
            this.pocetStrun = pocetStrun;
        }else{
            this.pocetStrun = 0;
        }
    }
 

    @Override
    public String toString() {
        return String.format("StrunovyNastroj[%s, struny=%d]", super.toString(), pocetStrun);
    }
}
