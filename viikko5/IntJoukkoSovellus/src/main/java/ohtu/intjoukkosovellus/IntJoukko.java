package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kasvatuskoko ei voi olla negatiivinen");
        }
        joukko = new int[kapasiteetti];
        for (int i = 0; i < joukko.length; i++) {
            joukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public int[] getJoukko() {
        return joukko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % joukko.length == 0) {
                kasvata();
            }
            return true;
        }
        return false;
    }

    private void kasvata() {
        int[] vanhaJoukko = new int[joukko.length];
        vanhaJoukko = joukko;
        kopioiJoukko(joukko, vanhaJoukko);
        joukko = new int[alkioidenLkm + kasvatuskoko];
        kopioiJoukko(vanhaJoukko, joukko);
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int poistettavanIndeksi = -1;
        poistettavanIndeksi = etsiPoistettavanIndeksi(luku, poistettavanIndeksi);
        if (poistettavanIndeksi != -1) {
            siirraVasemmalle(poistettavanIndeksi);
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void siirraVasemmalle(int poistettavanIndeksi) {
        int apu;
        for (int j = poistettavanIndeksi; j < alkioidenLkm - 1; j++) {
            apu = joukko[j];
            joukko[j] = joukko[j + 1];
            joukko[j + 1] = apu;
        }
    }

    private int etsiPoistettavanIndeksi(int luku, int poistettavanIndeksi) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == joukko[i]) {
                poistettavanIndeksi = i; //siis luku löytyy tuosta kohdasta :D
                joukko[poistettavanIndeksi] = 0;
                break;
            }
        }
        return poistettavanIndeksi;
    }

    private void kopioiJoukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        }
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += joukko[i] + ", ";
        }
        tuotos += joukko[alkioidenLkm - 1] + "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.getJoukko().length; i++) {
            x.lisaa(a.getJoukko()[i]);
        }
        for (int i = 0; i < b.getJoukko().length; i++) {
            x.lisaa(b.getJoukko()[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.getJoukko().length; i++) {
            for (int j = 0; j < b.getJoukko().length; j++) {
                if (a.getJoukko()[i] == b.getJoukko()[j]) {
                    y.lisaa(b.getJoukko()[j]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.getJoukko().length; i++) {
            z.lisaa(a.getJoukko()[i]);
        }
        for (int i = 0; i < b.getJoukko().length; i++) {
            z.poista(i);
        }
        return z;
    }
}
