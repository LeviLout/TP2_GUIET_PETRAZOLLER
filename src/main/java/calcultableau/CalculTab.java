package calcultableau;
import java.util.*;
import java.util.ArrayList;
// Somme des éléments d'un tableau d'entiers
public class CalculTab {

    private ArrayList<Integer> tableau;

    public CalculTab(ArrayList<Integer> tableau) {
        this.tableau = tableau;
    }

    //Retourne la tableau des notes
    public ArrayList<Integer> getTableau() {
        return tableau;
    }

    //Set le tableau des notes
    public void setTableau(ArrayList<Integer> tableau) {
        this.tableau = tableau;
    }

    //Calcul la moyenne des notes
    public double moyenne() {
        double sum = 0;
        int size = tableau.size();
        for (int i = 0; i < size; i++) {
            sum += tableau.get(i);
        }
        return sum / size;
    }

    //Retourne la médiane
    public double mediane() {
        Collections.sort(tableau); // Tri du tableau
        if (tableau.size()%2 == 0) {
            int noteMiddle1 = tableau.get(tableau.size()/2 - 1);
            int noteMiddle2 = tableau.get(tableau.size()/2);
            return (double)(noteMiddle1 + noteMiddle2)/2;
        } else {
            return tableau.get(tableau.size()/2);
        }
    }

    //Retourne le total des notes
    public int total() {
        int total = 0;
        for (int i = 0; i < tableau.size(); i++) {
            total += tableau.get(i);
        }
        return total;
    }

    //Retourne le nombre d'étudiants/de notes
    public int getNombreEtudiant() {
        return tableau.size();
    }

    //Affiche les notes
    public void affichageTableau() {
        for (int i = 0; i < tableau.size(); i++) {
            System.out.println("Note " + i + ":" + tableau.get(i));
        }
    }
}