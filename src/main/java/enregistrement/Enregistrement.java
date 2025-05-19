package enregistrement;

import lombok.Getter;
import utilisateurtab.UtilisateurTab;

import java.util.Date;

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

    public UtilisateurTab getUtilisateurTab() {
        return utilisateurTab;
    }

    public void setUtilisateurTab(UtilisateurTab utilisateurTab) {
        this.utilisateurTab = utilisateurTab;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNbEtudiants() {
        return nbEtudiants;
    }

    public void setNbEtudiants(Integer nbEtudiants) {
        this.nbEtudiants = nbEtudiants;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public double getMediane() {
        return mediane;
    }

    public void setMediane(double mediane) {
        this.mediane = mediane;
    }
}
