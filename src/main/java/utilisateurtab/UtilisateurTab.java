package utilisateurtab;

public class UtilisateurTab {

    private String prenom;
    private String nom;
    private String email;
    private String mdp;

    public UtilisateurTab(String prenom, String nom, String email, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
