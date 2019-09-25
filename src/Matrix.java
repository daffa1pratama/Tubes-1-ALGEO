package src;

import java.util.Scanner;
import java.io.File;

public class Matrix{
    public double[][]tab;
    public int tBrs;
    public int tKol;

    public Matrix (int brs , int kol){
    //Konstruktor Matriks
    //I.S. Matriks kosong sembarang
    //F.S. Matriks tersedia dengan panjang brs x kol
        tab=new double[brs+1][kol+1];
        this.tBrs=brs;
        this.tKol=kol;
    }
    public Matrix makeIdentitas(){
    //Membuat matriks identitas dengan panjang brs x kol, dimana brs = kol (persegi)
    //I.S. Matriks sembarang
    //F.S. Matriks identitas N x N
    //contoh:
    /*  1   0   0
        0   1   0
        0   0   1
    */
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
    //I.S. Matriks terdefinisi
    //F.S. Mengembalikan panjang baris
        return this.tBrs;
    }
    public int getLastIdxKol(){
    //I.S. Matriks terdefinisi
    //F.S. Mengembalikan panjang kolom
        return this.tKol;
    }
    public void bacaMatrix(){
    //I.S. Matriks kosong terdefinisi
    //F.S. Matriks telah terisi sesuai input dari keyboard
        Scanner scan = new Scanner(System.in);
        System.out.println("Elemen matrix: ");
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                this.tab[i][j]=scan.nextDouble();
            }
        }   
    }
    public void tulisMatrix(){
    //I.S. Matriks telah terisi
    //F.S. Menuliskan matriks ke layar
    /*contoh:
        5   7   8
        1   8   1
        4   1   5
    */
        for(int i=1; i<=getLastIdxBrs(); i++){
            for(int j=1; j<=getLastIdxKol(); j++){
                System.out.print(String.format("%.2f",this.tab[i][j])+"\t");
            }
            System.out.println();
        }
    }
    public void transpose(){
    //Transpose adalah mengubah matriks dari elemen ke-i,j menjadi elemen ke-j,i
    //I.S. Matriks persegi terdefinisi
    //F.S. Mengubah bentuk matriks menjadi matriks transpose
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
    //I.S. Matriks terdefinisi
    //F.S. Mengembalikan indeks kolom dari leading number
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
    //Mengecek apakah semua elemen pada satu baris adalah 0 semua
    //I.S. Matriks terdefinisi
    //F.S. Mengembalikan boolean hasil pengecekan 0 pada baris
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
    public Matrix copyMatrix(Matrix B){
        for(int i=1; i<=this.tBrs; i++){
            for(int j=1; j<=this.tKol; j++){
                B.tab[i][j]=this.tab[i][j];
            }
        }
        return B;
    }
    public void interchange(int brs1, int brs2){
    //Menukar baris ke-i dengan baris ke-j pada matriks
    //I.S. Matriks terdefinisi
    //F.S. Matriks hasil penukaran baris1 dengan baris2
        for(int i=1; i<=getLastIdxKol(); i++){
            double temp=this.tab[brs1][i];
            this.tab[brs1][i]=this.tab[brs2][i];
            this.tab[brs2][i]=temp;
        }
    }
    public void urutMatrix(){
    //Mengurutkan baris matriks sesuai dengan leading number
    //I.S. Matriks terdefinsi
    //F.S. Matriks telah urut sesuai leading numbernya
    /*contoh:
        1   9   5               1   9   5
        0   3   1   menjadi->   7   1   5
        7   1   5               0   3   1
    */
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
    //Metode gauss eliminataion: membuat matriks segitiga atas
    //I.S. Matriks terdefinisi
    //F.S. 
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
        Matrix hasil = new Matrix(this.tBrs, 1);
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
        if(checkSol){
            int countZero = 0;
            for(int i=1; i<=this.tBrs; i++){
                if(isZero(i)){
                    countZero++;
                }
            }
            for(int i=1; i<=this.tBrs; i++){
                String solution = "";
                if(countZero==0){
                    solution=("X"+i+" = "+String.format("%.2f",tab[i][this.tKol]));
                }
                else{
                    if(!isZero(i)){
                        solution=("X"+i+" = "+String.format("%.2f",tab[i][this.tKol]));
                        for(int j=i+1; j<this.tKol; j++){
                            if(tab[i][j]>0){
                                if(tab[i][j]==1){
                                    solution=solution+(" - "+"X"+j);
                                }
                                else{
                                    solution=solution+(" -"+tab[i][j]+"X"+j);
                                }
                            }
                            else if(tab[i][j]<0){
                                if(tab[i][j]==-1){
                                    solution=solution+(" + "+"X"+j);
                                }
                                else{
                                    solution=solution+(" + "+Math.abs(tab[i][j])+"X"+j);
                                }
                            }
                        }
                    }
                    else{
                        solution=("X"+i+" = X"+i);
                    }
                }
                System.out.println(solution);
            }
        }
        else{
            System.out.println("Tidak ada solusi penyelesaian");
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
        if(checkSol){
            int countZero = 0;
            for(int i=1; i<=this.tBrs; i++){
                if(isZero(i)){
                    countZero++;
                }
            }
            for(int i=1; i<=this.tBrs; i++){
                double sum=this.tab[i][this.tKol];
                String solution="";
                for(int j=i+1; j<this.tKol; j++){
                    if(!isZero(j)){
                        sum = sum+(this.tab[i][j]*(-1)*this.tab[j][this.tKol]);
                    }
                }
                if(countZero==0){
                    solution=("X"+i+" = "+String.format("%.2f",sum));
                }
                else{
                    if(!isZero(i)){
                        solution=("X"+i+" = "+String.format("%.2f",sum));
                        for(int j=i+1; j<this.tKol; j++){
                            if(tab[i][j]>0){
                                solution=solution+(" - "+tab[i][j]+"X"+j);
                            }
                            else{
                                solution=solution+(" + "+Math.abs(tab[i][j])+"X"+j);
                            }
                        }
                    }
                    else{
                        solution=("X"+i+" = X"+i);
                    }
                }
                System.out.println(solution);
            }
        }
        else{
            System.out.println("Tidak ada solusi penyelesaian");
        }
    }
    public Matrix gantiKolom(Matrix B, int kol){
        Matrix cramer = new Matrix(this.tBrs, this.tKol);
        copyMatrix(cramer);
        for(int i=1; i<=this.tBrs; i++){
            cramer.tab[i][kol]=B.tab[i][1];
        }
        return cramer;
    }
    public void getCramer(Matrix B){
        double det = this.determinanC(this.tab);
        for(int i=1; i<=this.tKol; i++){
            double X=0;
            Matrix makeCramer = this.gantiKolom(B,i);
            double detX = makeCramer.determinanC(makeCramer.tab);
            X = detX/det;
            System.out.println("X"+i+" = "+ String.format("%.2f",X));
        }
    }
    public Matrix readFile(String namaFile)throws FileNotFoundException{
        try{
            File file = new File("C:\\Users\\ASUS\\Desktop\\tst.txt");
            Scanner scanKol = new Scanner(file);
            Scanner scanBrs = new Scanner(file);
            Scanner scanElm = new Scanner(file);
            int countKol = 0;
            int countBrs = 0;
            while (scanKol.hasNextLine()){
                countKol++;
            }
            while (scanBrs.hasNextLine()){
                countBrs++;
            }
            countKol=countKol/countBrs;
            Matrix fileMatrix = new Matrix(countBrs, countKol);
            int i=1;
            int j=1;
            while (scanElm.hasNextLine()){
                fileMatrix.tab[i][j]=ScanElm.nextDouble();
                j++;
                if(j>countKol){
                    i++;
                    j=j-countKol;
                }
            }
            return fileMatrix;
        }catch(Exception e){
            return null;
        }
    }
/*
    public void bacaInterpolasi(){  //membaca matriks dengan ukuran N x 2
        Scanner scan = new Scanner(System.in);
        System.out.println("Banyaknya titik: ");
        Int N = scan.nextInt();
        Matrix MBacaInter = new Matrix(N, 2);
        System.out.println("Elemen matrix: ");
        for(int x=1; x<=getLastIdxBrs(); x++){
            for(int y=1; y<=getLastIdxKol(); y++){
                MBacaInter.tab[x][y]=scan.nextDouble();
            }
        }    
    }
    
    public double Pangkat(double basis, int pangkat)
    {
        double kuadrat = basis * basis, hasil;
        if(pangkat % 2 == 1){
            hasil = basis;
            for (int i = 0; i <pangkat/2 ; i++) {
                hasil = hasil * kuadrat;
            }
        }else{
            hasil = 1;
            for (int i = 0; i <pangkat/2 ; i++) {
                hasil = hasil * kuadrat;
            }
        }
        return hasil;
    }
    
    
    public void Interpolasi(){      //membuat matriks N x N+1 berdasarkan matriks N x 2 diatas, kemudian menggunakan metode solusi gauss jordan untuk mencari nilai koefisien a
        bacaInterpolasi();
        Matrix MInter = new Matrix(this.tBrs, this.tKol+1);
        for (int x = 0; x <= getLastIdxBrs(); x++){
            MInter.tab[x][y] = this.tab[x][y];
            MInter.tab[x][y] = Pangkat(this.tab[x][y], x);
        }
    } 
    
    public void printInterpolasi() { //mencetak polinom hasil interpolasi bentuk : a0 + 9.5a1 + 90.25a2 = 2.2513
        for(int x=1; x <= getLastIdxBrs(); x++){
            for(int y=1; y <= getLastIdxKol(); y++){
                System.out.print(Pangkat(this.tab[x][y],x)+"a"+x); //
            }
        }    
    }
    */
}