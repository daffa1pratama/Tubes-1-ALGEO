package src;
import src.Matrix;
import java.util.Scanner;

/**
 * driver
 */
public class driver {
    public static void main(String[] args) {
        Matrix tab = new Matrix();
        tab.makeMatrixIdentitas();
        tab.tulisMatrix();
        tab.bacaMatrix();
        tab.tulisMatrix();
<<<<<<< HEAD
        System.out.println();
        tab.gaussElim();
        tab.tulisMatrix();
        System.out.println();
        tab.gaussJordanElim();
        tab.tulisMatrix();
        tab.getSolMatrix();
//        System.out.println(tab.determinan());
=======
        tab.gaussElim();
        tab.tulisMatrix();
        System.out.println(tab.determinanG());
>>>>>>> 517352e4f571b52a5c29cb2fcaee31c440650cb6
    }
}