package orchester.hudobnynastroj;

import java.io.*;
import java.util.*;

public class OrchesterLoader {
    private ArrayList<Nastroj> nastrojList;
    private ArrayList<Hrac> hracList;

    public OrchesterLoader() {
        this.nastrojList = new ArrayList<>();
        this.hracList = new ArrayList<>();
    }

    public void nacitajZoSuboru(String nazovSuboru) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nazovSuboru))) {
            String riadok;
            int cisloRiadku = 0;
            
            while ((riadok = br.readLine()) != null) {
                cisloRiadku++;
                riadok = riadok.trim();
                if (riadok.isEmpty()) continue;
                
                String[] casti = riadok.split(",");
                if (casti.length < 2) {
                    System.err.println("Chyba na riadku " + cisloRiadku + ": nedostatok údajov");
                    continue;
                }

                String typ = casti[0].trim();
                
                try {
                    switch (typ) {
                        case "S": // Sláčikový nástroj
                            if (casti.length >= 8) {
                                String druh = casti[1].trim();
                                double cena = Double.parseDouble(casti[2].trim());
                                String zvuk = casti[3].trim();
                                int pocet = Integer.parseInt(casti[4].trim());

                                int pocetStrun = Integer.parseInt(casti[5].trim());
                                String ladenie = casti[6].trim();
                                String sekcia = casti[7].trim();
                                
                                if (validujNastroj(druh, cena, zvuk, pocet) && 
                                    validujPocet(pocetStrun) && validujString(ladenie) && validujString(sekcia)) {
                                    Nastroj nastroj = new SlacikovyNastroj(druh, cena, zvuk, pocet, pocetStrun, ladenie, sekcia);
                                    nastrojList.add(nastroj);
                                } else {
                                    System.err.println("Chyba na riadku " + cisloRiadku + ": neplatné údaje pre sláčikový nástroj");
                                }
                            } else {
                                System.err.println("Chyba na riadku " + cisloRiadku + ": nedostatok údajov pre sláčikový nástroj");
                            }
                            break;

                        case "s": // Strunový nástroj
                            if (casti.length >= 7) {
                                String druh = casti[1].trim();
                                double cena = Double.parseDouble(casti[2].trim());
                                String zvuk = casti[3].trim();
                                int pocet = Integer.parseInt(casti[4].trim());

                                int pocetStrun = Integer.parseInt(casti[5].trim());
                                String ladenie = casti[6].trim();
                                
                                if (validujNastroj(druh, cena, zvuk, pocet) && 
                                    validujPocet(pocetStrun) && validujString(ladenie)) {
                                    Nastroj n = new StrunovyNastroj(druh, cena, zvuk, pocet, pocetStrun, ladenie);
                                    nastrojList.add(n);
                                } else {
                                    System.err.println("Chyba na riadku " + cisloRiadku + ": neplatné údaje pre strunový nástroj");
                                }
                            } else {
                                System.err.println("Chyba na riadku " + cisloRiadku + ": nedostatok údajov pre strunový nástroj");
                            }
                            break;
                        case "r": // Rytmický nástroj
                            if (casti.length >= 6) {
                                String druh = casti[1].trim();
                                double cena = Double.parseDouble(casti[2].trim());
                                String zvuk = casti[3].trim();
                                int pocet = Integer.parseInt(casti[4].trim());

                                int pocetZvukov = Integer.parseInt(casti[5].trim());
                                
                                if (validujNastroj(druh, cena, zvuk, pocet) && validujPocet(pocetZvukov)) {
                                    Nastroj r = new RytmickyNastroj(druh, cena, zvuk, pocet, pocetZvukov);
                                    nastrojList.add(r);
                                } else {
                                    System.err.println("Chyba na riadku " + cisloRiadku + ": neplatné údaje pre rytmický nástroj");
                                }
                            } else {
                                System.err.println("Chyba na riadku " + cisloRiadku + ": nedostatok údajov pre rytmický nástroj");
                            }
                            break;
                        case "d": // Dychový nástroj
                            if (casti.length >= 7) {
                                String druh = casti[1].trim();
                                double cena = Double.parseDouble(casti[2].trim());
                                String zvuk = casti[3].trim();
                                int pocet = Integer.parseInt(casti[4].trim());

                                int pocetDier = Integer.parseInt(casti[5].trim());
                                String ladenie = casti[6].trim();
                                
                                if (validujNastroj(druh, cena, zvuk, pocet) && 
                                    validujPocet(pocetDier) && validujString(ladenie)) {
                                    Nastroj d = new DychovyNastroj(druh, cena, zvuk, pocet, pocetDier, ladenie);
                                    nastrojList.add(d);
                                } else {
                                    System.err.println("Chyba na riadku " + cisloRiadku + ": neplatné údaje pre dychový nástroj");
                                }
                            } else {
                                System.err.println("Chyba na riadku " + cisloRiadku + ": nedostatok údajov pre dychový nástroj");
                            }
                            break;
                        case "k": // Klávesový nástroj
                            if (casti.length >= 6) {
                                String druh = casti[1].trim();
                                double cena = Double.parseDouble(casti[2].trim());
                                String zvuk = casti[3].trim();
                                int pocet = Integer.parseInt(casti[4].trim());

                                int pocetKlavesov = Integer.parseInt(casti[5].trim());
                                
                                if (validujNastroj(druh, cena, zvuk, pocet) && validujPocet(pocetKlavesov)) {
                                    Nastroj k = new KlavesovyNastroj(druh, cena, zvuk, pocet, pocetKlavesov);
                                    nastrojList.add(k);
                                } else {
                                    System.err.println("Chyba na riadku " + cisloRiadku + ": neplatné údaje pre klávesový nástroj");
                                }
                            } else {
                                System.err.println("Chyba na riadku " + cisloRiadku + ": nedostatok údajov pre klávesový nástroj");
                            }
                            break;
                        case "u": // Umelec (Hráč)
                            if (casti.length >= 5) {
                                String meno = casti[1].trim();
                                String priezvisko = casti[2].trim();
                                String nastrojRef = casti[3].trim();
                                double hodinovaSadzba = Double.parseDouble(casti[4].trim());
                                
                                if (validujString(meno) && validujString(priezvisko) && hodinovaSadzba >= 0) {
                                    Nastroj nastrojPreHraca = najdiNastroj(nastrojRef);
                                    if (nastrojPreHraca != null) {
                                        hracList.add(new Hrac(meno, priezvisko, nastrojPreHraca, hodinovaSadzba));
                                    } else {
                                        System.err.println("Chyba na riadku " + cisloRiadku + ": nástroj '" + nastrojRef + "' nebol nájdený");
                                    }
                                } else {
                                    System.err.println("Chyba na riadku " + cisloRiadku + ": neplatné údaje pre hráča");
                                }
                            } else {
                                System.err.println("Chyba na riadku " + cisloRiadku + ": nedostatok údajov pre hráča");
                            }
                            break;
                        default:
                            System.err.println("Chyba na riadku " + cisloRiadku + ": neznámy typ '" + typ + "'");
                            break;
                    }
                    
                } catch (NumberFormatException e) {
                    System.err.println("Chyba na riadku " + cisloRiadku + ": neplatný formát čísla");
                } catch (Exception e) {
                    System.err.println("Chyba na riadku " + cisloRiadku + ": " + e.getMessage());
                }
            }
        }
    }

    private boolean validujNastroj(String druh, double cena, String zvuk, int pocet) {
        return validujString(druh) && cena >= 0 && validujString(zvuk) && pocet >= 0;
    }

    private boolean validujString(String str) {
        return str != null && !str.equals("");
    }

    private boolean validujPocet(int pocet) {
        return pocet >= 1;
    }

    private Nastroj najdiNastroj(String referencia) {
        // Najprv hľadáme podľa sekcie (pre sláčikové nástroje)
        for (Nastroj n : nastrojList) {
            if (n instanceof SlacikovyNastroj) {
                SlacikovyNastroj sn = (SlacikovyNastroj) n;
                if (sn.getSekcia().equals(referencia)) {
                    return n;
                }
            }
        }
        // Potom hľadáme podľa druhu
        for (Nastroj n : nastrojList) {
            if (n.getDruh().equals(referencia)) {
                return n;
            }
        }
        return null;
    }

    public ArrayList<Nastroj> getNastrojList() {
        return nastrojList;
    }

    public ArrayList<Hrac> getHracList() {
        return hracList;
    }
}
