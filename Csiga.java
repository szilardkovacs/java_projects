package main;

/**
 *
 * @author szilard.kovacs
 */
public class Csiga {
    private int tavolsag = 0;
    private String szin;
    private int sebesseg = 0;
    private boolean gyorsito = false;

    public int getTavolsag() {
        return tavolsag;
    }

    public void HozzaadTavolsag(int lepes) {
        this.tavolsag = tavolsag + lepes;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }
    
    public int getSebesseg() {
        return sebesseg;
    } 
    
    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }
    
    public boolean isGyorsito() {
        return gyorsito;
    }
    
    public void setGyorsito(boolean gyorsito) {
        this.gyorsito = gyorsito;
    }
}
