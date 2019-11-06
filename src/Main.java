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
        int brsA = 0;
        int brsB = 0;
        int kolA = 0;
        int kolB = 0;

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
                                System.out.print("Pilih masukan: ");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dalam bentuk augmented matriks!");
                                    System.out.println("Jumlah baris: ");
                                    brsA = scan.nextInt();
                                    System.out.println("Jumlah kolom: ");
                                    kolA = scan.nextInt();
                                    Matrix A = new Matrix(brsA, kolA);
                                    A.bacaMatrix();
                                    A.tulisMatrix();
                                    A.gaussElim();
                                    System.out.println();
                                    System.out.println("Bentuk Matriks Echelon Form:");
                                    A.tulisMatrix();
                                    System.out.println();
                                    A.solGauss();
                                    System.out.println();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 2:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                System.out.print("Pilih masukan: ");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dalam bentuk augmented matriks!");
                                    System.out.println("Jumlah baris: ");
                                    brsA = scan.nextInt();
                                    System.out.println("Jumlah kolom: ");
                                    kolA = scan.nextInt();
                                    Matrix A = new Matrix(brsA, kolA);
                                    A.bacaMatrix();
                                    A.gaussJordanElim();
                                    System.out.println();
                                    System.out.println("Bentuk Matriks Reduce Echelon Form:");
                                    A.tulisMatrix();
                                    System.out.println();
                                    A.solGaussJordan();
                                    System.out.println();
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
                                System.out.print("Pilih masukan: ");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dengan N persamaan dan N peubah!");
                                    System.out.println("MATRIKS A");
                                    System.out.println("Jumlah baris/kolom: ");
                                    brsA = scan.nextInt();
                                    Matrix A = new Matrix(brsA, brsA);
                                    A.bacaMatrix();
                                    A.tulisMatrix();
                                    while(A.determinanC(A.tab)==0){
                                        System.out.println("Determinan matriks=0, Masukkan matriks lain!");
                                        A.bacaMatrix();
                                    }
                                    System.out.println("MATRIKS B");
                                    Matrix B = new Matrix(brsA, 1);
                                    B.bacaMatrix();
                                    System.out.println();
                                    for(int i=1; i<=brsA; i++){
                                        System.out.println(A.getCramer(B,i));
                                    }
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 4:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                System.out.print("Pilih masukan: ");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan SPL dalam bentuk matriks AX=B!, dimana A matriks persegi");
                                    System.out.println("MATRIKS A");
                                    System.out.println("Jumlah baris/kolom: ");
                                    brsA = scan.nextInt();
                                    Matrix A = new Matrix(brsA, brsA);
                                    A.bacaMatrix();
                                    while(A.determinanC(A.tab)==0){
                                        System.out.println("Determinan matriks=0, Masukkan matriks lain!");
                                        A.bacaMatrix();
                                    }
                                    System.out.println("MATRIKS B");
                                    Matrix B = new Matrix(brsA, 1);
                                    B.bacaMatrix();
                                    A = A.inversC();
                                    A = A.kaliMatrix(B);
                                    for(int i=1; i<=brsA; i++){
                                        System.out.println(A.solInvers(i));
                                    }
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
                        System.out.println("!DETERMINAN HANYA BISA DILAKUKAN UNTUK MATRIKS N x N!");
                        System.out.println();
                        System.out.print("Pilih sub-Menu: ");
                        submenu=scan.nextInt();                    
                        switch (submenu){
                            case 1:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                System.out.print("Pilih masukan: ");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan Matriks");
                                    System.out.println("Jumlah baris/kolom: ");
                                    brsA = scan.nextInt();
                                    Matrix A = new Matrix(brsA, brsA);
                                    A.bacaMatrix();
                                    while(A.determinanC(A.tab)==0){
                                        A.bacaMatrix();
                                    }
                                    System.out.println("Determinan: "+ A.determinanC(A.tab));
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 2:
                            System.out.println("* Cara Baca *");
                            System.out.println("1. Keyboard");
                            System.out.println("2. File");
                            System.out.print("Pilih masukan: ");
                            inputan = scan.nextInt();
                            if(inputan == 1){
                                System.out.println("Masukkan Matriks");
                                System.out.println("Jumlah baris: ");
                                brsA = scan.nextInt();
                                System.out.println("Jumlah kolom: ");
                                kolA = scan.nextInt();
                                Matrix A = new Matrix(brsA, kolA);
                                A.bacaMatrix();
                                System.out.println("Determinan: "+ A.determinanG());
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
                                System.out.print("Pilih masukan: ");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan Matriks");
                                    System.out.println("Jumlah baris/kolom: ");
                                    brsA = scan.nextInt();
                                    Matrix A = new Matrix(brsA, brsA);
                                    A.bacaMatrix();
                                    while(A.determinanG()==0){
                                        A.bacaMatrix();
                                    }
                                    A = A.inversG();
                                    A.tulisMatrix();
                                }
                                if(inputan == 2){
                                    System.out.println("SEK DURUNG ONOK COK");
                                }
                                break;
                            case 2:
                                System.out.println("* Cara Baca *");
                                System.out.println("1. Keyboard");
                                System.out.println("2. File");
                                System.out.print("Pilih masukan: ");
                                inputan = scan.nextInt();
                                if(inputan == 1){
                                    System.out.println("Masukkan Matriks");
                                    System.out.println("Jumlah baris/kolom: ");
                                    brsA = scan.nextInt();
                                    Matrix A = new Matrix(brsA, brsA);
                                    A.bacaMatrix();
                                    while(A.determinanG()==0){
                                        A.bacaMatrix();
                                    }
                                    A = A.inversC();
                                    A.tulisMatrix();
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
                        System.out.println("Jumlah baris/kolom: ");
                        brsA = scan.nextInt();
                        Matrix A = new Matrix(brsA, brsA);
                        A.bacaMatrix();
                        
                        copyA = A.cofactorMatrix(A.tab);
                        copyA.tulisMatrix();
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
                        brsA = scan.nextInt();
                        System.out.println("Jumlah kolom: ");
                        kolA = scan.nextInt();
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
                        brsA = scan.nextInt();
                        System.out.println("Jumlah kolom: ");
                        kolA = scan.nextInt();
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
                        brsA = scan.nextInt();
                        System.out.println("Jumlah kolom: ");
                        kolA = scan.nextInt();
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
                //KELUAR
                case 0:
                    exit=true;
                default:
                    System.out.println("!MASUKKAN INPUT DENGAN BENAR! (0-7)");
                    break;
            }
        } while (!exit);
    }
}