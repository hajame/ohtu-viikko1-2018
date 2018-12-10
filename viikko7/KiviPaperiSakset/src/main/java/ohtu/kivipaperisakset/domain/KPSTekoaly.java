package ohtu.kivipaperisakset.domain;

import java.util.Scanner;


/**
 * KPS-peli tekoälyllä.
 */
public class KPSTekoaly extends KPS {
    private Tekoaly tekoaly;

    public KPSTekoaly(Scanner scanner, Tuomari tuomari) {
        super(scanner, tuomari);
        this.tekoaly = new Tekoaly();
    }

    @Override
    public void pelaa() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        
        while (onLaillinen(ekanSiirto) && onLaillinen(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari+"\n");
            
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);
        }
        System.out.println("\nKiitos!\n"+tuomari);
    }

}