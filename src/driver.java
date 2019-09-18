package src;
import src.Matrix;
import java.util.Scanner;

/**
 * driver
 */
public class driver {
    public static void main(String[] args) {
        Matrix tab = new Matrix();
        tab.bacaMatrix();
        tab.tulisMatrix();
//        System.out.println(tab.getKolLead(2));
        tab.gaussElim();
        tab.tulisMatrix();
    }
}