/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset.domain;

import java.util.Scanner;

/**
 *
 * @author hameha
 */
public abstract class KPS {
    
    protected final Scanner scanner;
    protected final Tuomari tuomari;

    public KPS(Scanner scanner, Tuomari tuomari) {
        this.scanner = scanner;
        this.tuomari = tuomari;
    }
    
    
    /**
     * Tarkistaa, onko siirto laillinen.
     * 
     * @param siirto
     * @return 
     */
    protected boolean onLaillinen(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    /**
     * Käynnistää pelin.
     */
    public abstract void pelaa();
    
}
