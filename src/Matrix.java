package src;

import java.util.Scanner;

public class Matrix{
    public float[][]tab;
    public int tBrs;
    public int tKol;

    public void makeMatrix(int brs , int kol){
        tab=new float[brs+1][kol+1];
        this.tBrs=brs;
        this.tKol=kol;
    }
    public int getLastIdxBrs(){
        return this.tBrs;
    }
    public int getLastIdxKol(){
        return this.tKol;
    }
    public float getElmt(int brs, int kol, float[][]tab){
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
                this.tab[i][j]=scan.nextFloat();
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
        float[][]temp=new float[this.tBrs+1][this.tKol+1];
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
    public void interchange(int brs1, int brs2){
        for(int i=1; i<=getLastIdxKol(); i++){
            float temp=this.tab[brs1][i];
            this.tab[brs1][i]=this.tab[brs2][i];
            this.tab[brs2][i]=temp;
        }
    }
    public void urutMatrix(){
        if (this.tBrs>1){
            for(int i=1; i<getLastIdxBrs(); i++){
                int brsMax=i;
                for(int j=i+1; j<=getLastIdxBrs(); j++){
                    if(getKolLead(j)<getKolLead(brsMax)){
                        brsMax=j;
                    }
                }
                interchange(i,brsMax);
            }
        }
    }
    public void gaussElim(){
        urutMatrix();
        for(int i=1; i<getLastIdxBrs(); i++){
            if(!isZero(i)){
                for(int j=i+1; j<=getLastIdxBrs(); j++){
                    if(!isZero(j)){
                        float x = (this.tab[j][getKolLead(i)]/this.tab[i][getKolLead(i)])*(-1);
                        for(int k=1; k<=getLastIdxKol(); k++){
                            this.tab[j][k]=this.tab[j][k]+(x*this.tab[i][k]);
                        }
                    }
                }
            }
        }
        for(int i=1; i<=getLastIdxBrs(); i++){
            if(!isZero(i)){
                float x = this.tab[i][getKolLead(i)];
                for(int j=1; j<=getLastIdxKol(); j++){
                    this.tab[i][j]=(this.tab[i][j]/x);
                }
            }
        }
    }     
    public void gaussJordanElim(){
        this.gaussElim();
        for (int i = getLastIdxBrs(); i>1; i--){
            if (!isZero(i)){
                for (int j = i-1; j>=1; j--){
                    if (!isZero(j)){
                        float x = this.tab[j][getKolLead(i)]*(-1);                        
                        for(int k=1; k<=getLastIdxKol(); k++){
                            this.tab[j][k]=this.tab[j][k]+(x*this.tab[i][k]);
                        }
                    }
                }
            }
        }
    }
    public float determinan(float[][]matrix){
        float [][]temp;
        float det=0;
        if(getLastIdxBrs()==1){
            det=getElmt(1, 1, tab);
            return det;
        }
        else if(getLastIdxBrs()==2){
            det=((tab[1][1]*tab[2][2])-(tab[1][2]*tab[2][1]));
            return det;
        }
        else{
            for(int i=1; i<=getLastIdxBrs(); i++){
                temp=new float[this.tBrs-1][this.tKol-1];
                for(int j=2; j<=getLastIdxBrs(); j++){
                    for(int k=1; k<=getLastIdxKol(); k++){
                        if(k<i){
                            temp[j-1][k]=tab[j][k];
                        }
                        else if(k>i){
                            temp[j-1][k-1]=tab[j][k];
                        }
                    }
                }
                if(i%2==0){
                    det = det+((-1)*tab[1][i]*determinan(temp));
                }
                else{
                    det = det+(tab[1][i]*determinan(temp));
                }
            }
            return det;
        }
    }
    public void getSolMatrix(){
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                if(!isZero(i)){
                    if(j==getLastIdxKol()){
                        System.out.println(getElmt(i, j, tab));
                    }
                }
            }
        }
    }
}