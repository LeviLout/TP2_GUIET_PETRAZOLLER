package calcultableau;
import java.util.*;
import java.util.ArrayList;
// Somme des éléments d'un tableau d'entiers
public class CalculTab {

    private ArrayList<Integer> tableau;

    public CalculTab(ArrayList<Integer> tableau) {
        this.tableau = tableau;
    }

    public ArrayList<Integer> getTableau() {
        return tableau;
    }

    public void setTableau(ArrayList<Integer> tableau) {
        this.tableau = tableau;
    }

    public double moyenne() {
        double Sum = 0;
        for (int i = 0; i < tableau.size(); i++) {
            Sum += tableau.get(i);
        }
        return Sum/tableau.size();
    }

    public double mediane() {
        Collections.sort(tableau);
        if (tableau.size()%2 == 0) {
            int noteMiddle1 = tableau.get(tableau.size()/2 - 1);
            int noteMiddle2 = tableau.get(tableau.size()/2);
            return (double)(noteMiddle1 + noteMiddle2)/2;
        } else {
            return tableau.get(tableau.size()/2);
        }
    }

    public int total() {
        int total = 0;
        for (int i = 0; i < tableau.size(); i++) {
            total += tableau.get(i);
        }
        return total;
    }

    public int getNombreEtudiant() {
        return tableau.size();
    }

    public void affichageTableau() {
        for (int i = 0; i < tableau.size(); i++) {
            System.out.println(tableau.get(i));
        }
    }
}