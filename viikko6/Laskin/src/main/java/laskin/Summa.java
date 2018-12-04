/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author hameha
 */
public class Summa implements Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        try {
            sovellus.plus(Integer.parseInt(syotekentta.getText()));
        } catch (Exception e) {
        }

        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);

    }

    @Override
    public void peru() {

    }

    public TextField getTuloskentta() {
        return tuloskentta;
    }

    public TextField getSyotekentta() {
        return syotekentta;
    }

    public Button getNollaa() {
        return nollaa;
    }

    public Button getUndo() {
        return undo;
    }

    public Sovelluslogiikka getSovellus() {
        return sovellus;
    }

}
