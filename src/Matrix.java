package src;

import java.util.Scanner;

public class Matrix{
    public double[][]tab;
    public int tBrs;
    public int tKol;

    public void makeMatrix(int brs , int kol){
        tab=new double[brs+1][kol+1];
        this.tBrs=brs;
        this.tKol=kol;
    }
    public int getLastIdxBrs(){
        return this.tBrs;
    }
    public int getLastIdxKol(){
        return this.tKol;
    }
    public double getElmt(int brs, int kol, double[][]tab){
        return this.tab[brs][kol];
    }
    public void bacaMatrix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Jumlah baris: ");
        this.tBrs = scan.nextInt();
        System.out.println("Jumlah kolom: ");
        this.tKol = scan.nextInt();
        makeMatrix(this.tBrs, this.tKol);
        System.out.println("Elemen matrix: ");
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                this.tab[i][j]=scan.nextDouble();
            }
        }    
    }
    public void tulisMatrix(){
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                System.out.print(this.tab[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void transpose(){
        double[][]temp=new double[this.tBrs+1][this.tKol+1];
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                temp[j][i]=this.tab[i][j];
            }
        }
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                this.tab[i][j]=temp[i][j];
            }
        }
    }
    public int getKolLead(int brs){
        int j=1;
        boolean found=false;
        while (!found && j<=getLastIdxKol()){
            if(this.tab[brs][j]!=0){
                found=true;
            }
            else{
                j++;
            }
        }
        return j;
    }
    public boolean isZero(int brs){
        int j=1;
        boolean found=true;
        while(j<=getLastIdxKol()&&found){
            if(this.tab[brs][j]!=0){
                found=false;
            }
            else{
                j++;
            }
        }
        return found;
    }
    public void gaussElim(){
        for(int i=1; i<getLastIdxBrs(); i++){
            if(!isZero(i)){
                for(int j=i+1; j<=getLastIdxBrs(); j++){
                    if(!isZero(j)){
                        double x = (this.tab[j][getKolLead(j)]/this.tab[i][getKolLead(i)])*(-1);
                        for(int k=1; k<=getLastIdxKol(); k++){
                            this.tab[j][k]=this.tab[j][k]+(x*this.tab[i][k]);
                        }
                    }
                }
            }
        }
        for(int i=1; i<=getLastIdxBrs(); i++){
            if(!isZero(i)){
                double x = this.tab[i][getKolLead(i)];
                for(int j=1; j<=getLastIdxKol(); j++){
                    this.tab[i][j]=(this.tab[i][j]/x);
                }
            }
        }
    }
<<<<<<< HEAD
    public double determinanG(){
        double det=1;
        for(int i=1; i<getLastIdxBrs(); i++){
            if(!isZero(i)){
                for(int j=i+1; j<=getLastIdxBrs(); j++){
                    if(!isZero(j)){
                        double x = (this.tab[j][getKolLead(j)]/this.tab[i][getKolLead(i)])*(-1);
                        det = det/x;
=======
    public void gaussJordanElim(){
        this.gaussElim();
        for (int i = getLastIdxBrs(); i>0; i--){
            if (isZero(i)){
                for (int j = i-1; j>=0; j--){
                    if (!isZero(j)){
                        double x = (this.tab[j][getKolLead(j)])*(-1);
>>>>>>> 686fcd04313f116f34d4411ef35d036dfbed8b44
                        for(int k=1; k<=getLastIdxKol(); k++){
                            this.tab[j][k]=this.tab[j][k]+(x*this.tab[i][k]);
                        }
                    }
                }
            }
        }
<<<<<<< HEAD
        for(int i=1; i<=getLastIdxBrs(); i++){
            det = det*getElmt(i, i, tab);
        }
        return det;
=======
        
>>>>>>> 686fcd04313f116f34d4411ef35d036dfbed8b44
    }
}