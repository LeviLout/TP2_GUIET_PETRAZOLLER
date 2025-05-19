import calcultableau.CalculTab;

import java.util.ArrayList;
import java.util.Scanner;

public class Principale {

    public static void main(String[] args) {
        System.out.println("****DEBUT PROGRAMME****");

        ArrayList<Integer> tableau = new ArrayList<>();
        int n = 0;
        int i;

        do {
            System.out.println("Veuillez entrer la taille du tableau");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
        } while (n > 50);
        // REMPLISSAGE DE TABLEAU
        System.out.println("****DEBUT PROGRAMME****");
        for (i = 0; i < n; i++) {
            System.out.println("Veuillez entrer un nombre");
            Scanner sc1 = new Scanner(System.in);
            tableau.add(sc1.nextInt());
        }

        CalculTab calculTab = new CalculTab(tableau);


    }
}
