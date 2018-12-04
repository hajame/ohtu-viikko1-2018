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
public class Nollaa implements Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private String tulosmuisti;
    private String syotemuisti;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        tulosmuisti = tuloskentta.getText();
        syotemuisti = syotekentta.getText();
        sovellus.nollaa();

        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("0");

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);

    }

    @Override
    public void peru() {
        tuloskentta.setText(tulosmuisti);
        syotekentta.setText(syotemuisti);
        sovellus.setTulos(Integer.parseInt(tulosmuisti));
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
