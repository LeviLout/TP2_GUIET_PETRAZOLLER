package enregistrement;

import lombok.Getter;
import utilisateurtab.UtilisateurTab;

import java.util.Date;

//Classe stockant toutes les informations (prénom/ nom / email / date / moyenne / médiane)
public class Enregistrement {

    @Getter
    private UtilisateurTab utilisateurTab;
    private Date date;
    private Integer nbEtudiants;
    private double moyenne;
    private double mediane;

    public Enregistrement(UtilisateurTab utilisateurTab, Date date, Integer nbEtudiants, double moyenne, double mediane) {
        this.utilisateurTab = utilisateurTab;
        this.date = date;
        this.nbEtudiants = nbEtudiants;
        this.moyenne = moyenne;
        this.mediane = mediane;
    }

    //Retourne l'utilisateur
    public UtilisateurTab getUtilisateurTab() {
        return utilisateurTab;
    }

    //Set l'utilisateur
    public void setUtilisateurTab(UtilisateurTab utilisateurTab) {
        this.utilisateurTab = utilisateurTab;
    }

    //Retourne la date
    public Date getDate() {
        return date;
    }

    //Set la date
    public void setDate(Date date) {
        this.date = date;
    }

    //Retourne le nombre d'étudiant
    public Integer getNbEtudiants() {
        return nbEtudiants;
    }

    //Set le nombre d'étudiant
    public void setNbEtudiants(Integer nbEtudiants) {
        this.nbEtudiants = nbEtudiants;
    }

    //Retourne la moyenne des notes
    public double getMoyenne() {
        return moyenne;
    }

    //Set la moyenne
    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    //Retourne la médiane des notes
    public double getMediane() {
        return mediane;
    }

    //Set la médiane
    public void setMediane(double mediane) {
        this.mediane = mediane;
    }
}
