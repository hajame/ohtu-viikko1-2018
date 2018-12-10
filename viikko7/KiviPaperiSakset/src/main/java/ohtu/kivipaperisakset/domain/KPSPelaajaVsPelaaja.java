package ohtu.kivipaperisakset.domain;

import java.util.Scanner;

/**
 * KPS peli pelaaja vs pelaaja
 */
public class KPSPelaajaVsPelaaja extends KPS {

    public KPSPelaajaVsPelaaja(Scanner scanner, Tuomari tuomari) {
        super(scanner, tuomari);
    }

    @Override
    public void pelaa() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        System.out.print("Toisen pelaajan siirto: ");
        String tokanSiirto = scanner.nextLine();
        while (onLaillinen(ekanSiirto) && onLaillinen(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari+"\n");
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = scanner.nextLine();
        }
        System.out.println("\nKiitos!\n"+tuomari);
    }
}
