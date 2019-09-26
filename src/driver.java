package src;
import src.Matrix;
import java.util.Scanner;
import java.io.IOException;

/**
 * driver
 */
public class driver {
    public static void main(String[] args)throws Exception{
        Scanner scan = new Scanner(System.in);
/*        Matrix M = new Matrix(10,10);
        M.readFile("tst.txt");
        M.tulisMatrix();
        double[][]temp = new double[M.tBrs+1][M.tKol+1];
        for(int i=1; i<=M.tBrs; i++){
            for(int j=1; j<=M.tKol; j++){
                temp[i][j]=M.tab[i][j];
            }
        }
        System.out.println(M.determinanC(temp));
        M.writeFile("tst.txt", M.determinanC(temp));
        M.gaussJordanElim();
        M.writeFileMatrix("tst.txt");*/
//        double[][]temp=M.tab;

        int N;
        System.out.println("Banyaknya titik: ");
        N = scan.nextInt();
        Matrix M = new Matrix(N,2);
        M.bacaInterpolasi();
        Matrix Minter = new Matrix(N, N+1);
        M.copyMatrix(Minter);
        Minter.matrixInterpolasi();
        Minter.tulisMatrix();
        System.out.println();
        Minter.gaussJordanElim();
        Minter.tulisMatrix();
        System.out.println(Minter.cetakInterpolasi());
        System.out.println();
        System.out.println(Minter.taksirInterpolasi(9.2));
/*
        int a,b,c,d;
        System.out.println("Jumlah baris: ");
        a = scan.nextInt();
        System.out.println("Jumlah kolom: ");
        b = scan.nextInt();*/
/*        System.out.println("Jumlah baris: ");
        c = scan.nextInt();
        System.out.println("Jumlah kolom: ");
        d = scan.nextInt();*/
//        Matrix A = new Matrix(a,b);
//        Matrix B = new Matrix(c,d);
//        M.makeMatrixIdentitas();
//        M.tulisMatrix(M);
//        A.bacaMatrix();
//        A.tulisMatrix();
//        System.out.println();
/*        B.bacaMatrix();
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