package src;

import java.util.Scanner;

public class Matrix{
    public double[][]tab;
    public int tBrs;
    public int tKol;

    public Matrix (int brs , int kol){
        tab=new double[brs+1][kol+1];
        this.tBrs=brs;
        this.tKol=kol;
    }
    public Matrix makeIdentitas(){
        Matrix identitas = new Matrix(this.tBrs, this.tKol);
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                if(i==j){
                    identitas.tab[i][j]=1;
                }
                else{
                    identitas.tab[i][j]=0;
                }
            }
        }
        return identitas;
    }
    public int getLastIdxBrs(){
        return this.tBrs;
    }
    public int getLastIdxKol(){
        return this.tKol;
    }
    public void bacaMatrix(){
        Scanner scan = new Scanner(System.in);
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
    public void interchange(int brs1, int brs2){
        for(int i=1; i<=getLastIdxKol(); i++){
            double temp=this.tab[brs1][i];
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
    public Matrix gaussElim(){
        Matrix Mgauss = new Matrix(this.tBrs,this.tKol);
        Mgauss.tab = this.tab;
        Mgauss.urutMatrix();
        for(int i=1; i<getLastIdxBrs(); i++){
            if(!Mgauss.isZero(i)){
                for(int j=i+1; j<=getLastIdxBrs(); j++){
                    if(!Mgauss.isZero(j)){
                        double x = (Mgauss.tab[j][getKolLead(i)]/Mgauss.tab[i][getKolLead(i)])*(-1);
                        for(int k=1; k<=getLastIdxKol(); k++){
                            Mgauss.tab[j][k]=Mgauss.tab[j][k]+(x*Mgauss.tab[i][k]);
                        }
                    }
                }
            }
        }
        for(int i=1; i<=getLastIdxBrs(); i++){
            if(!Mgauss.isZero(i)){
                double x = Mgauss.tab[i][getKolLead(i)];
                for(int j=1; j<=getLastIdxKol(); j++){
                    Mgauss.tab[i][j]=(Mgauss.tab[i][j]/x);
                }
            }
        }
        return Mgauss;
    }
    public Matrix gaussJordanElim(){
        Matrix Mjordan = new Matrix(this.tBrs, this.tKol);
        Mjordan.tab=this.tab;
        Mjordan.gaussElim();
        for (int i = getLastIdxBrs(); i>1; i--){
            if (!Mjordan.isZero(i)){
                for (int j = i-1; j>=1; j--){
                    if (!Mjordan.isZero(j)){
                        double x = (Mjordan.tab[j][getKolLead(i)])*(-1);
                            for(int k=1; k<=getLastIdxKol(); k++){
                                Mjordan.tab[j][k]=Mjordan.tab[j][k]+(x*Mjordan.tab[i][k]);
                        }
                    }
                }
            }
        }
        return Mjordan;
    }
    public double[][] createSubMatrix(int brs, int kol){
        double[][]subM = new double[this.tBrs][this.tKol];
        int m=1;
        for(int i=1; i<=this.tBrs; i++){
            int n=1;
            for(int j=1; j<=this.tKol; j++){
                if(i!=brs && j!=kol){
                    subM[m][n]=this.tab[i][j];
                    n++;
                }
            }
            if(i!=brs){
                m++;
            }
        }
        return subM;
    }
    public Matrix cofactorMatrix(double[][]cofac){
        Matrix cofacM = new Matrix(this.tBrs, this.tKol);
        Matrix temp = new Matrix(this.tBrs, this.tKol);
        temp.tab=this.tab;
        for(int i=1; i<=this.tBrs; i++){
            for(int j=1; j<=this.tKol; j++){
                if((i+j)%2==0){
                    cofacM.tab[i][j]=temp.determinanC(createSubMatrix(i,j))*(-1);
                }
                else{
                    cofacM.tab[i][j]=temp.determinanC(createSubMatrix(i,j));
                }
            }
        }
        return cofacM;
    }
    public void kaliKons(double kons){
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                this.tab[i][j]*=kons;
            }
        }
    }
    public double determinanC(double[][]subMatrix){
        double [][]temp;
        double det=0;
        if(subMatrix.length==2){
            det=subMatrix[1][1];
        }
        else{
            temp=new double[subMatrix.length-1][subMatrix.length-1];
            for(int k=1; k<subMatrix.length; k++){
                int m=1;
                for(int i=2; i<subMatrix.length; i++){
                    int n=1;
                    for(int j=1; j<subMatrix[1].length; j++){
                        if(j!=k){
                            temp[m][n]=subMatrix[i][j];
                            n++;
                        }
                    }
                    m++;
                }
                if(k%2!=0){
                    det=det + ((-1)*determinanC(temp)*subMatrix[1][k]);
                }
                else{
                    det=det + (determinanC(temp)*subMatrix[1][k]);
                }
            }
        }
        return det;
    }   
    public double determinanG(){
        double det=0;
        Matrix copy = new Matrix(this.tBrs, this.tKol);
        copy.tab = this.tab;
        if(this.tBrs==1){
            det = copy.tab[1][1];
        }
        else{
            det = 1;
            //URUT MATRIX
            for(int i=1; i<copy.getLastIdxBrs(); i++){
                int brsMax=i;
                for(int j=i+1; j<=copy.getLastIdxBrs(); j++){
                    if(copy.getKolLead(j)<copy.getKolLead(brsMax)){
                        brsMax=j;
                    }
                }
                copy.interchange(i,brsMax);
                det = det*(-1);
            }
            //GAUSS ELIM
            for(int i=1; i<getLastIdxBrs(); i++){
                if(!copy.isZero(i)){
                    for(int j=i+1; j<=getLastIdxBrs(); j++){
                        if(!copy.isZero(j)){
                            double x = (copy.tab[j][getKolLead(i)]/copy.tab[i][getKolLead(i)])*(-1);
                            for(int k=1; k<=getLastIdxKol(); k++){
                                copy.tab[j][k]=copy.tab[j][k]+(x*copy.tab[i][k]);
                            }
                        }
                    }
                }
            }
            for(int i=1; i<=getLastIdxBrs(); i++){
                det = det * copy.tab[i][i];
            }
        }
        return det;
    }
    public Matrix inversG(){
        Matrix inv = new Matrix(this.tBrs, this.tKol);
        inv.tab = this.tab;
        Matrix id = new Matrix(this.tBrs, this.tKol);
        id = makeIdentitas();
        inv.urutMatrix();
        for(int i=1; i<getLastIdxBrs(); i++){
            if(!inv.isZero(i)){
                for(int j=i+1; j<=getLastIdxBrs(); j++){
                    if(!inv.isZero(j)){
                        double x = (inv.tab[j][getKolLead(i)]/inv.tab[i][getKolLead(i)])*(-1);
                        for(int k=1; k<=getLastIdxKol(); k++){
                            inv.tab[j][k]=inv.tab[j][k]+(x*inv.tab[i][k]);
                            id.tab[j][k]=id.tab[j][k]+(x*id.tab[i][k]);
                        }
                    }
                }
            }
        }
        for(int i=1; i<=getLastIdxBrs(); i++){
            if(!inv.isZero(i)){
                double x = inv.tab[i][getKolLead(i)];
                for(int j=1; j<=getLastIdxKol(); j++){
                    inv.tab[i][j]=(inv.tab[i][j]/x);
                    id.tab[i][j]=(id.tab[i][j]/x);
                }
            }
        }        
        for (int i = getLastIdxBrs(); i>1; i--){
            if (!inv.isZero(i)){
                for (int j = i-1; j>=1; j--){
                    if (!inv.isZero(j)){
                        double x = inv.tab[j][getKolLead(i)]*(-1);                        
                        for(int k=1; k<=getLastIdxKol(); k++){
                            inv.tab[j][k]=inv.tab[j][k]+(x*inv.tab[i][k]);
                            id.tab[j][k]=id.tab[j][k]+(x*id.tab[i][k]);
                        }
                    }
                }
            }
        }
        return id;
    }
    public Matrix inversC(){
        Matrix inversM = new Matrix(this.tBrs, this.tKol);
        inversM.tab=this.tab;
        double det = 1/(determinanC(inversM.tab));
        inversM = cofactorMatrix(inversM.tab);
        inversM.transpose();
        inversM.kaliKons(det);
        return inversM;
    }
    public Matrix kaliMatrix(Matrix B){
        Matrix hasil = new Matrix(B.tBrs, 1);
        for(int i=1; i<=this.tBrs; i++){
            for(int j=1; j<=B.tKol; j++){
                double sum=0;
                for(int k=1; k<=this.tKol; k++){
                    sum=sum+(this.tab[i][k] * B.tab[k][j]);
                }
                hasil.tab[i][j] = sum;
            }
        }
        return hasil;
    }
    public void solGaussJordan(){
    //    Matrix solution = new Matrix(this.tBrs,1)
        int countZero = 0;
        for(int i=1; i<=this.tBrs; i++){
            if(!this.isZero(i)){
    //            solution.tab[i][this.tKol]=this.tab[i][this.tKol];
                System.out.println(String.format("X"+i+" = %.2f"+tab[i][this.tKol]));
            }
            else{
                countZero++;
    //            solution.tab[i][this.tKol]=-9999
                System.out.println("X"+i+" = "+"s"+countZero);
            }
        }
    }
    public void solGauss(){
        boolean checkSol = true;
        for(int k=1; k<=this.tBrs; k++){
            boolean foundLead = false;
            for(int l=1; l<this.tKol; l++){
                if(this.tab[k][l]!=0){
                    foundLead = true;
                }
            }
            if(!foundLead && this.tab[k][this.tKol]!=0){
                checkSol = false;
                break;
            }
        }
        for(int i=1; i<=this.tBrs; i++){
            double sum=0;
            int countZero = 0;
            String solution = "";
            for(int j=i+1; j<this.tKol; j++){
                if(!isZero(j)){
                    sum = sum+(this.tab[i][j]*(-1)*this.tab[j][this.tKol]);
                }
                else{
                    countZero++;
                }
            }
            if(countZero==0){
               solution=String.format("X"+i+" = %.2f"+sum);
            }
            else{
                for(int k=1; k<=countZero; k++){
                    solution=solution+(String.format("X"+i+" = %.2f"+sum+"-s"+countZero));
                }
            }
            System.out.println(solution);
        }
    }
    public Matrix gantiKolom(int kol){
        Matrix cramer = new Matrix(this.tBrs, this.tKol);
        Matrix B = new Matrix(this.tBrs, 1);
        cramer.tab = this.tab;
        for(int i=1; i<=this.tBrs; i++){
            cramer.tab[i][kol]=B.tab[i][kol];
        }
        return cramer;
    }
    public double getCramer(){
        double det = this.determinanC(this.tab);
        double X=0;
        for(int i=1; i<=this.tKol; i++){
            Matrix makeCramer = this.gantiKolom(i);
            double detX = makeCramer.determinanC(makeCramer.tab);
            X = detX/det;
        }
        return X;
    }

}