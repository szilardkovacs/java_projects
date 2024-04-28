package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author szilard.kovacs
 */
public class CsigaJatek {
    
    private static final int maxLepes = 3;
    private static final int korokSzama = 5;
    private static Random rnd = new Random();
    private static Random rnd2 = new Random();
    private static Csiga csigaLista[] = new Csiga[3]; 
    private static int sebesseg;

    
    public void start(){
        
        Csiga csiga1 = new Csiga();
        Csiga csiga2 = new Csiga();
        Csiga csiga3 = new Csiga();
         
        csiga1.setSzin("piros");
        csiga2.setSzin("zold");
        csiga3.setSzin("kek");
        
        csigaLista[0] = csiga1;
        csigaLista[1] = csiga2;
        csigaLista[2] = csiga3;
        
        // beolvassuk konzolrol, hogy milyen szinu csigára tippel a jatekos a fogadas nevu valtozoba
        Scanner scan= new Scanner(System.in);
        System.out.println("Melyik csiga for nyerni? " + csiga1.getSzin() + ", " + csiga2.getSzin() + ", " + csiga3.getSzin());
        String fogadas= scan.nextLine();
        
        // olyan ID beallitasa amilyen tombindex biztosan nem letezik
        int fogadasid = csigaLista.length;

        // megkeressuk hogy milyen tombindex tartozik a kivalasztott szinhez
        for (int i=0; i < 3; i++) {
            if (csigaLista[i].getSzin().equals(fogadas)) {
                fogadasid = i;
            }
        }
        
        // korok lejatszasa, minden kor elejen kiírjuk hogy hanyadik kor van es milyen tavolsagot ertek el a csigak
        for (int i=0; i < korokSzama; i++) {
            System.out.println("");
            System.out.println("A " + (i+1) + ".kor allasa: ");
            
            // random kivalasztunk egy tombindexet es ha 20%-os eselyen belul vagyunk, akkor a kivalasztott indexxel
            // rendelkezo csiga megkapja a gyorsitot, majd ezt ki is irjuk a konzolra
            int j = rnd.nextInt(csigaLista.length);
            if (rnd2.nextInt(10) < 2) {
                csigaLista[j].setGyorsito(true);
                System.out.println(csigaLista[j].getSzin() + " szinu csiga kapott gyorsitot");
            }
            
            // vegigmegyunk a csigalistan es ha valamelyiknek van gyorsitoja akkor az 2x akkor sebesseget kap
            // egyebkent pedig csak random valasztunk egy szamot 0 és 3 kozott es az lesz a sebesseg
            // a sebesseget beallitjuk a csigakak, majd ki is irjuk, hogy ki milyen messzire jutott
            for (Csiga elem : csigaLista) {
                
                if (elem.isGyorsito()) {
                    sebesseg = rnd.nextInt(maxLepes+1) * 2;
                    elem.setGyorsito(false);
                }
                else {
                    sebesseg = rnd.nextInt(maxLepes+1);
                }
                elem.HozzaadTavolsag(sebesseg);
                System.out.println(elem.getSzin()+ " csiga: " + elem.getTavolsag());
            }
        }
        
        // mikor lement mind az 5 kor, utana megkeressuk hogy mi a legnagyobb tavolsag amig valamelyik csiga eljutott
        int maxtavolsag = 0;
        for (Csiga elem : csigaLista) {
            if (maxtavolsag < elem.getTavolsag() ) {
                maxtavolsag = elem.getTavolsag();
            }
        }
        
        // ha arra a csigara fogadtunk akinel a tavolsag megegyezik a maxtavolsaggal, 
        // es ha az is igaz, hogy az ID egy valid listaindex, akkor nyertunk
        System.out.println("");
        if (csigaLista[fogadasid].getTavolsag() == maxtavolsag && fogadasid < csigaLista.length) {
            System.out.println("Az on csigaja nyert!");
        } else {
            System.out.println("Nem az on csigaja nyert!");
        }
    }
}
