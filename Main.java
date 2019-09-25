package src;
//import src.Matrix;
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
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dalam bentuk augmented matriks!");
                                    System.out.println("Jumlah persamaan: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah variabel: ");
                                    kol1 = scan.nextInt();
                                    //Matrix A = new Matrix(brs1, kol1);
                                    //A.bacaMatrix();
                                    //A.gaussElim();
                                    //A.solGauss();
                                    //A.tulisMatrix();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 2:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dalam bentuk augmented matriks!");
                                    System.out.println("Jumlah persamaan: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah variabel: ");
                                    kol1 = scan.nextInt();
                                    //Matrix A = new Matrix(brs1, kol1);
                                    //A.bacaMatrix();
                                    //A.gaussJordanElim();
                                    //A.solGaussJordan();
                                    //A.tulisMatrix();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 3:
                                System.out.println("!METODE CRAMER HANYA BISA DILAKUKAN UNTUK N PERSAMAAN DAN N PEUBAH");
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dengan N persamaan dan N peubah!");
                                    System.out.println("Jumlah persamaan: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah variabel: ");
                                    kol1 = scan.nextInt();
                                    //Matrix A = new Matrix(brs1, kol1);
                                    //A.bacaMatrix();
                                    //A.getCramer();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 4:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dalam bentuk matriks AX=B!");
                                    System.out.println("MATRIKS A");
                                    System.out.println("Jumlah baris: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah kolom: ");
                                    kol1 = scan.nextInt();
                                    //Matrix A = new Matrix(brs1, kol1);
                                    //A.bacaMatrix();
                                    System.out.println("MATRIKS B");
                                    System.out.println("Jumlah baris: ");
                                    brs2 = scan.nextInt();
                                    System.out.println("Jumlah kolom: ");
                                    kol2 = scan.nextInt();
                                    //Matrix B = new Matrix(brs2, kol2);
                                    //B.bacaMatrix();
                                    //A.inversC();
                                    //A.kaliMatrix(B);
                                    //A.tulisMatrix();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            default:
                                System.out.println("Masukkan pilihan dengan benar ! (0-4");
                        }
                    } while(submenu!=0);
                    break;
                case 2:
                    do{
                        System.out.println("*** Determinan ***");
                        System.out.println("1. Metode Gauss");
                        System.out.println("2. Metode Matriks Kofaktor");
                        System.out.println("0. Keluar");
                        System.out.println("!DETERMINAN HANYA BISA DILAKUKAN UNTUK MATRIKS NxN!");
                        System.out.println();
                        System.out.print("Pilih sub-Menu: ");
                        submenu=scan.nextInt();                    
                        switch (submenu){
                            case 1:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan Matriks");
                                    System.out.println("Jumlah baris: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah kolom: ");
                                    kol1 = scan.nextInt();
                                    //Matrix A = new Matrix(brs1, kol1);
                                    //A.bacaMatrix();
                                    //System.out.println("Determinan: "+ A.determinanC(copy));
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 2:
                            System.out.println("* Cara Baca *");
                            System.out.println("1. Keyboard");
                            System.out.println("2. File");
                            inputan = scan.nextInt();
                            if(inputan == 1){
                                System.out.println("Masukkan Matriks");
                                System.out.println("Jumlah baris: ");
                                brs1 = scan.nextInt();
                                System.out.println("Jumlah kolom: ");
                                kol1 = scan.nextInt();
                                //Matrix A = new Matrix(brs1, kol1);
                                //A.bacaMatrix();
                                //System.out.println("Determinan: "+ A.determinanG());
                            }
                            if(inputan == 2){
                                System.out.println("SEK DURUNG ONOK COK");
                            }
                                break;
                            default:
                                System.out.println("Masukkan pilihan dengan benar ! (0-2");
                        }
                    }while(submenu!=0);
                    break;
                case 3:
                    do{
                        System.out.println("*** Invers Matriks ***");
                        System.out.println("1. Metode Gauss-Jordan");
                        System.out.println("2. Metode Adjoin");
                        System.out.println("0. Keluar");
                        System.out.println("!INVERS HANYA BISA DILAKUKAN JIKA DETERMINAN != 0 DAN MATRIKS NxN");
                        System.out.println();
                        System.out.print("Pilih sub-Menu: ");
                        submenu=scan.nextInt();
                        switch (submenu){
                            case 1:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan Matriks");
                                    System.out.println("Jumlah baris: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah kolom: ");
                                    kol1 = scan.nextInt();
                                    //Matrix A = new Matrix(brs1, kol1);
                                    //A.bacaMatrix();
                                    //Matrix copyA = A.inversG();
                                    //copyA.tulisMatrix();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 2:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan Matriks");
                                    System.out.println("Jumlah baris: ");
                                    brs1 = scan.nextInt();
                                    System.out.println("Jumlah kolom: ");
                                    kol1 = scan.nextInt();
                                    //Matrix A = new Matrix(brs1, kol1);
                                    //A.bacaMatrix();
                                    //Matrix copyA = A.inversC();
                                    //copyA.tulisMatrix();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                                default:
                                    System.out.println("Masukkan pilihan dengan benar ! (0-2");
                        }
                    }while(submenu!=0);
                    break;
                case 4:
                    System.out.println("* Cara Baca *");
                    System.out.println("1. Keyboard");
                    System.out.println("2. File");
                    inputan = scan.nextInt();
                    if(inputan == 1){
                        System.out.println("Masukkan Matriks");
                        System.out.println("Jumlah baris: ");
                        brs1 = scan.nextInt();
                        System.out.println("Jumlah kolom: ");
                        kol1 = scan.nextInt();
                        //Matrix A = new Matrix(brs1, kol1);
                        //A.bacaMatrix();
                        //Matrix copyA = A.cofactorMatrix(A.tab);
                        //copyA.tulisMatrix();
                    }
                    if(inputan == 2){
                        System.out.println("SEK DURUNG ONOK COK");
                    }
                    break;   
                case 5:
                    System.out.println("* Cara Baca *");
                    System.out.println("1. Keyboard");
                    System.out.println("2. File");
                    inputan = scan.nextInt();
                    if(inputan == 1){
                        System.out.println("Masukkan Matriks");
                        System.out.println("Jumlah baris: ");
                        brs1 = scan.nextInt();
                        System.out.println("Jumlah kolom: ");
                        kol1 = scan.nextInt();
                        //Matrix A = new Matrix(brs1, kol1);
                        //A.bacaMatrix();
                        //A.transpose();
                        //A.tulisMatrix();
                    }
                    if(inputan == 2){
                        System.out.println("SEK DURUNG ONOK COK");
                    }
                    break;   
                case 6:
                    System.out.println("* Cara Baca *");
                    System.out.println("1. Keyboard");
                    System.out.println("2. File");
                    inputan = scan.nextInt();
                    if(inputan == 1){
                        System.out.println("Masukkan Matriks");
                        System.out.println("Jumlah baris: ");
                        brs1 = scan.nextInt();
                        System.out.println("Jumlah kolom: ");
                        kol1 = scan.nextInt();
                        //Matrix A = new Matrix(brs1, kol1);
                        //A.bacaMatrix();
                        //Matrix copyA = A.cofactorMatrix(A.tab);
                        //copyA.transpose();
                        //copyA.tulisMatrix();
                    }
                    if(inputan == 2){
                        System.out.println("SEK DURUNG ONOK COK");
                    }
                    break; 
                // INTERPOLASI 
                case 7:
                    System.out.println("* Cara Baca *");
                    System.out.println("1. Keyboard");
                    System.out.println("2. File");
                    inputan = scan.nextInt();
                    if(inputan == 1){
                        System.out.println("Masukkan Matriks");
                        System.out.println("Jumlah baris: ");
                        brs1 = scan.nextInt();
                        System.out.println("Jumlah kolom: ");
                        kol1 = scan.nextInt();
                        //Matrix A = new Matrix(brs1, kol1);
                        //A.bacaMatrix();
                        //Matrix copyA = A.cofactorMatrix(A.tab);
                        //copyA.transpose();
                        //copyA.tulisMatrix();
                    }
                    if(inputan == 2){
                        System.out.println("SEK DURUNG ONOK COK");
                    }
                break;
                default:
                    break;
            }
        } while (!exit);
    }
}