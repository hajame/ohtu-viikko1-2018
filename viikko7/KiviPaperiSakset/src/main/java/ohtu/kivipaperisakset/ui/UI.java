/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.ui;

import java.util.Scanner;
import ohtu.kivipaperisakset.util.Pelinvartija;

/**
 * Käyttöliittymä.
 */
public class UI {

    private final Scanner scanner;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        modeSelect();
    }

    private void modeSelect() {
        while (true) {
            System.out.println("\nValitse pelataanko" + 
                    "\n (a) ihmist\u00e4 vastaan " + 
                    "\n (b) teko\u00e4ly\u00e4 vastaan" + 
                    "\n (c) parannettua teko\u00e4ly\u00e4 vastaan" 
                    + "\nmuilla valinnoilla lopetataan");
            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Pelinvartija.luoPelaajaVsPelaaja(scanner).pelaa();
            } else if (vastaus.endsWith("b")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Pelinvartija.luoKPSTekoaly(scanner).pelaa();
            } else if (vastaus.endsWith("c")) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                Pelinvartija.KPSParempiTekoaly(scanner).pelaa();
            } else {
                break;
            }
        }
    }
    
}
