package src;

import java.util.Scanner;

public class SPL extends Matrix{
    public Matrix gantiKolom(int kol){
        Matrix cramer = new Matrix(this.tBrs, this.tKol);
        Matrix B = new Matrix(this.tBrs, 1);
        cramer.tab = this.tab;
        for(int i=1; i<=this.tBrs; i++){
            cramer.tab[i][kol]=B.tab[i][kol];
        }
        return cramer;
    }

}