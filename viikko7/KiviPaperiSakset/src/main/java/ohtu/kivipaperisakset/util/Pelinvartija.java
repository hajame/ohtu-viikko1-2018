
package ohtu.kivipaperisakset.util;

import java.util.Scanner;
import ohtu.kivipaperisakset.domain.*;

/**
 *
 * @author hameha
 */
public class Pelinvartija {

    public static KPS luoPelaajaVsPelaaja(Scanner scanner) {
        return new KPSPelaajaVsPelaaja(scanner, new Tuomari());
    }

    public static KPS luoKPSTekoaly(Scanner scanner) {
        return new KPSTekoaly(scanner, new Tuomari());
    }

    public static KPS KPSParempiTekoaly(Scanner scanner) {
        return new KPSParempiTekoaly(scanner, new Tuomari());
    }

}
