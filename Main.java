package orchester.hudobnynastroj;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OrchesterLoader loader = new OrchesterLoader();
        
        try {
            loader.nacitajZoSuboru("orchester/hudobnynastroj/orchester.txt");
            
            ArrayList<Nastroj> nastrojList = loader.getNastrojList();
            ArrayList<Hrac> hracList = loader.getHracList();
            
            // 1. Hromadný výpis "Zoznam hráčov"
            System.out.println("=== Zoznam hráčov ===");
            for (Hrac h : hracList) {
                System.out.println(h);
            }
            
            // 2. Hromadný výpis "Databáza nástrojov"
            System.out.println("\n=== Databáza nástrojov ===");
            for (Nastroj n : nastrojList) {
                System.out.println("druh: " + n.getDruh() + ", pocet: " + n.getPocet() + ", cena: " + n.getCena());
            }
            
            // 3. Výpis "Cena skladu"
            System.out.println("\n=== Cena skladu ===");
            double cenaSkladu = 0;
            for (Nastroj n : nastrojList) {
                cenaSkladu += n.getPocet() * n.getCena();
            }
            System.out.println(cenaSkladu);
            
            // 4. Výpis "Cena vystúpenia"
            System.out.println("\n=== Cena vystúpenia ===");
            double pocetHodin = 2.0; // Predpokladáme 2 hodiny vystúpenia
            double sumaSadzieb = 0;
            for (Hrac h : hracList) {
                sumaSadzieb += h.getHodinovaSadzba();
            }
            double cenaVystupenia = pocetHodin * sumaSadzieb;
            System.out.println(cenaVystupenia);
            
            // 5. Hromadný výpis "Sklad hraj" 
            System.out.println("\n=== Sklad hraj ===");
            for (Nastroj n : nastrojList) {
                for (int i = 0; i < n.getPocet(); i++) {
                    System.out.println(n.hraj());
                }
            }
            
            // Vytvorenie lode
            Lod lod = new Lod("MC zloba Titanic", "kuuuuupil som sebe listek že še povožim na Titaniiiku,netušil som že skončim na dne atlantiiiiku");
            
            // 6. Hromadný výpis "Akord"
            System.out.println("\n=== Akord ===");
            for (Nastroj n : nastrojList) {
                System.out.println(n.hraj());
            }
            System.out.println(lod.hraj());
            
            // 7. Hromadná služba "Náklady vystúpenia" 
            System.out.println("\n=== Náklady vystúpenia ===");
            double pocetHodinVystupenia = 2.0;
            double sumaHonorarov = 0;
            for (Hrac h : hracList) {
                sumaHonorarov += h.getHodinovaSadzba();
            }
            double honorare = pocetHodinVystupenia * sumaHonorarov;
            
            double odpisyNastrojov = 0;
            for (Nastroj n : nastrojList) {
                odpisyNastrojov += n.getCena() * 0.02; // 2% z ceny nástroja
            }
            
            double celkoveNaklady = honorare + odpisyNastrojov;
            System.out.println("Honoráre hudobníkov: " + honorare);
            System.out.println("Odpisy nástrojov: " + odpisyNastrojov);
            System.out.println("Celkové náklady: " + celkoveNaklady);
            
            // 8. Hromadný výpis "Obsadenie orchestra"
            System.out.println("\n=== Obsadenie orchestra ===");
            for (Hrac h : hracList) {
                System.out.println(h.getMeno() + " " + h.getPriezvisko() + " - " + h.getNastroj().getDruh());
            }
            
            // 9. Hromadný výpis "Orchester hraj" 
            System.out.println("\n=== Orchester hraj ===");
            for (Hrac h : hracList) {
                h.hraj();
            }
            
            // 10. Hromadný výpis "Krst lode"
            System.out.println("\n=== Krst lode ===");
            for (Hrac h : hracList) {
                h.hraj();
            }
            System.out.println(lod.hraj());
            lod.spustNaVodu();
            System.out.println("Loď " + lod.getNazov() + " bola spustená na vodu." );
            
        } catch (IOException e) {
            System.err.println("Chyba pri načítaní súboru: " + e.getMessage());
        }
    }
}
