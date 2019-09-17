package src;
import java.util.Scanner;

public class Matrix {
    private double [][]tab;
    private int tBrs;
    private int tKol;

    public void makeMatrix(int tBrs, int tKol){
        tab=new double[tBrs+1][tKol+1];
        this.tBrs=tBrs;
        this.tKol=tKol;
    }
    public int getLastIdxBrs(){
        return this.tBrs;
    }
    public int getLastIdxKol(){
        return this.tKol;
    }
    public double getElmt(int brs, int kol, double[][]tab){
        return(tab[brs][kol]);
    }
    public void setElmt(int brs, int kol, double[][]tab){
        Scanner scan = new Scanner(System.in);
        tab[brs][kol] = scan.nextDouble();
    }
    public void bacaMatrix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Jumlah baris: ");
        int tBrs = scan.nextInt();
        System.out.println("Jumlah kolom: ");
        int tKol = scan.nextInt();
        makeMatrix(tBrs, tKol);
        System.out.println("Elemen matrix: ");
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                setElmt(i, j,tab);;
            }
        }
    }
    public void tulisMatrix(){
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                System.out.print(getElmt(i, j)+"\t");
            }
            System.out.println();
        }
    }
    public double[][] transpose() {
        double[][]temp=new double[getLastIdxBrs(),getLastIdxKol()];
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                setElmt(j, i, temp)=getElmt(i, j, tab);
            }
        }
        return temp;
    }

}