package ohtu.kivipaperisakset.main;

import java.util.Scanner;
import ohtu.kivipaperisakset.ui.UI;

public class Paaohjelma {


    public static void main(String[] args) {
        UI ui = new UI(new Scanner(System.in));
        ui.run();
    }

}
