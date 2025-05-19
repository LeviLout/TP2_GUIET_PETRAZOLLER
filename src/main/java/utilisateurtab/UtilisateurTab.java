package utilisateurtab;

import java.util.regex.Pattern;

public class UtilisateurTab {

    private String prenom;
    private String nom;
    private String email;

    // Regex pour valider un email
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );

    public UtilisateurTab(String prenom, String nom, String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email invalide : " + email);
        }
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    //méthode pour retourner une erreur si l'adresse email n'est pas valide
    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    //Retourne le prénom
    public String getPrenom() {
        return prenom;
    }

    //Set le prénom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //Retourne le nom
    public String getNom() {
        return nom;
    }

    //Set le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    //Retourne l'e-mail
    public String getEmail() {
        return email;
    }

    //Set l'e-mail
    public void setEmail(String email) {
        this.email = email;
    }
}
