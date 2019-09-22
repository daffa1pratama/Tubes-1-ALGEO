package src;
import src.Matrix;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        int menu = -9999;
        int submenu = -9999;
        int brs1 = 0;
        int brs2 = 0;
        int kol1 = 0;
        int kol2 = 0;
        int inputan = 0;
        do {
            System.out.println("***** MENU UTAMA *****");
            System.out.println("1. Sistem Persamaan Linear");
            System.out.println("2. Determinan");
            System.out.println("3. Invers Matriks");
            System.out.println("4. Matriks Kofaktor");
            System.out.println("5. Matriks Transpose");
            System.out.println("6. Matriks Adjoin");
            System.out.println("7. Interpolasi Polinom");
            System.out.println("0. Keluar");
            System.out.println();
            System.out.print("Pilih Menu: ");
            menu=scan.nextInt();

            switch (menu) {
                case 1:
                    do{
                        System.out.println("*** Sistem Persamaan Linear ***");
                        System.out.println("1. Metode Gauss");
                        System.out.println("2. Metode Gauss-Jordan");
                        System.out.println("3. Metode Cramer");
                        System.out.println("4. Metode Invers");
                        System.out.println("0. Keluar");
                        System.out.println();
                        System.out.print("Pilih sub-Menu: ");
                        submenu=scan.nextInt();
                        switch (submenu){
                            case 1:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                if(inputan = 1){
                                    System.out.println("Masukkan SPL dalam bentuk augmented matriks!");
                                    System.out.println("Jumlah persamaan: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah variabel: ");
                                    kol1 = scan.nextInt();
                                    Matrix A = new Matrix(brs1, kol1);
                                    A.bacaMatrix();
                                    A.gauss();
                                    A.solGauss();
                                }
                                if()
                        }
                    } while(submenu!=0);
                    
                    break;
            
                default:
                    break;
            }
        } while (!exit);
    }
}