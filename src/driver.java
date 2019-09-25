package src;
import src.Matrix;
import java.util.Scanner;
import java.io.IOException;

/**
 * driver
 */
public class driver {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner scan = new Scanner(System.in);
        Matrix M = new Matrix(100,100);
        M.readFile("tst.txt");
        M.tulisMatrix();
        /*
        int a,b,c,d;
        System.out.println("Jumlah baris: ");
        a = scan.nextInt();
        System.out.println("Jumlah kolom: ");
        b = scan.nextInt();
        System.out.println("Jumlah baris: ");
        c = scan.nextInt();
        System.out.println("Jumlah kolom: ");
        d = scan.nextInt();
        Matrix A = new Matrix(a,b);
        Matrix B = new Matrix(c,d);
//        M.makeMatrixIdentitas();
//        M.tulisMatrix(M);
        A.bacaMatrix();
        A.tulisMatrix();
        System.out.println();
        B.bacaMatrix();
        B.tulisMatrix();
        System.out.println();
        A.getCramer(B);*/
//        Matrix AinvC = A.inversC();
//        AinvC.tulisMatrix();
//        System.out.println();
//        Matrix hasil = AinvC.kaliMatrix(B);
        //hasil.tulisMatrix();
//        Matrix  AinvG = A.inversG();
//        AinvG.tulisMatrix();
//        Matrix AId = A.makeIdentitas();
//        AId.tulisMatrix();
 //       B.bacaMatrix();
 //       B.tulisMatrix();
/*        Matrix Agauss = new Matrix(A.tBrs, A.tKol);
        A.copyMatrix(Agauss);
        Agauss.gaussElim();
        Agauss.tulisMatrix();
        System.out.println();
        A.tulisMatrix();*/
//        Agauss.solGauss();*/
//        Matrix Ajordan = A.gaussJordanElim();
//        Ajordan.tulisMatrix();
//        System.out.println();*/
//        Matrix Ainvers = A.invers();
//        Ainvers.tulisMatrix();   
//        double[][]copy=A.tab;
//        System.out.println("Determinan: "+ A.determinanC(copy));
//        System.out.println("Determinan: "+ A.determinanG());
//        A.gaussElim();
//        A.tulisMatrix();
//        System.out.println();
/*        tab.gaussElim();
        tab.tulisMatrix();
        System.out.println();
        tab.gaussJordanElim();
        tab.tulisMatrix();
        tab.getSolMatrix();*/
//        System.out.println(M.determinan(M.tab));
    }
}