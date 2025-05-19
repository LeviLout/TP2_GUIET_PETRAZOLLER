import calcultableau.CalculTab;
import enregistrement.Enregistrement;
import utilisateurtab.UtilisateurTab;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Scanner;

public class Principale {

    //utilisation des logger pour les affichages
    private static final Logger logger = Logger.getLogger(Principale.class.getName());

    public static void main(String[] args) throws Exception {

        logger.info("****DEBUT PROGRAMME****");
        //ArrayList pour enregistrer les notes
        ArrayList<Integer> tableau = new ArrayList<>();
        int n = 0;
        Scanner sc = new Scanner(System.in);
        int i;

        //Le nombre de notes doit être comprit entre 1 et 50
        do {
            logger.info("Veuillez entrer la taille du tableau (entre 1 et 50) :");
            try {
                n = sc.nextInt();
                //Si la saisie n'est pas comprise entre 1 et 50, on redemande
                if (n <= 0 || n > 50) {
                    logger.warning("Taille invalide. Entrez un entier entre 1 et 50.");
                }
                //Si la saisie n'est pas un entier, on redemande
            } catch (Exception e) {
                logger.warning("Entrée invalide. Veuillez entrer un entier.");
                sc.nextLine();
                n = 0; // pour garder la condition du do-while fausse
            }
        } while (n <= 0 || n > 50);

        // REMPLISSAGE DE TABLEAU
        for (i = 0; i < n; i++) {
            int note = -1;
            //La note doit être comprise entre 0 et 20
            while (note < 0 || note > 20) {
                logger.info("Veuillez entrer une note entre 0 et 20 :");
                try {
                    Scanner sc1 = new Scanner(System.in);
                    note = sc1.nextInt();
                    if (note < 0 || note > 20) {
                        logger.warning("Note invalide. Entrez un entier entre 0 et 20.");
                    }
                } catch (Exception e) {
                    logger.warning("Entrée invalide. Veuillez entrer un entier.");
                    note = -1; // pour rester dans la boucle
                }
            }
            tableau.add(note); //Ajout de la note dans le tableau
        }

        CalculTab calculTab = new CalculTab(tableau); // Création de l'objet calculTab

        logger.info("****Affichage Tableau****");
        calculTab.affichageTableau();
        logger.info("****Total****");
        System.out.println("Total des notes :" + calculTab.total());
        logger.info("****Moyenne****");
        System.out.println("Moyenne :" + calculTab.moyenne());
        logger.info("****Médiane****");
        System.out.println("Médiane :" + calculTab.mediane());

        String reponse;
        //Demande à l'utilisateur si enregistrement
        logger.info("Voulez-vous enregistrer ces résultats ? (O/N)");
        do {
            reponse = sc.next().trim();
            //On vérifie si la saisie est valide
            if (!reponse.equalsIgnoreCase("O") && !reponse.equalsIgnoreCase("N")) {
                logger.warning("Réponse invalide. Entrez 'O' pour Oui ou 'N' pour Non.");
            }
        } while (!reponse.equalsIgnoreCase("O") && !reponse.equalsIgnoreCase("N"));

        //Si la réponse est O on enregistre
        if (reponse.equalsIgnoreCase("O")) {
            UtilisateurTab utilisateurTab;
            //On demande la prénom
            logger.info("Entrez votre prénom");
            Scanner sc3 = new Scanner(System.in);
            String prenom = sc3.nextLine();

            //On demande la nom
            logger.info("Entrez votre nom");
            Scanner sc4 = new Scanner(System.in);
            String nom = sc4.nextLine();

            //On demande l'e-mail et on teste si elle est valide
            String email = "";
            do {
                logger.info("Entrez votre e-mail");
                email = sc.nextLine();
                if (!UtilisateurTab.isValidEmail(email)) {
                    logger.warning("Email invalide. Veuillez entrer une adresse email valide.");
                }
            } while (!UtilisateurTab.isValidEmail(email));

            //On crée l'objet utilisateurTab
            utilisateurTab = new UtilisateurTab(prenom, nom, email);

            Date dateExamen = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // interdit les dates impossibles comme 2023-02-30

            //On test si la date est valide
            while (dateExamen == null) {
                logger.info("Entrez la date d'examen (AAAA-MM-JJ)");
                String dateStr = sc.next();
                try {
                    dateExamen = sdf.parse(dateStr);
                } catch (Exception e) {
                    logger.warning("Date invalide. Veuillez respecter le format AAAA-MM-JJ.");
                }
            }

            //On crée l'objet enregistrement
            Enregistrement enregistrement = new Enregistrement(utilisateurTab, dateExamen, calculTab.getNombreEtudiant(), calculTab.moyenne(), calculTab.mediane());
            //On enregistre en json
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Pour avoir une date lisible

            SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyyMMdd");
            String dateStr = fileDateFormat.format(dateExamen);
            String nomFichier = prenom.trim().toLowerCase() + "_" + nom.trim().toLowerCase() + "_" + dateStr + ".json";

            mapper.writeValue(new File(nomFichier), enregistrement);

            System.out.println("Fichier JSON enregistré avec succès !");
            logger.info("****FIN PROGRAMME****");
        } else if (reponse.equalsIgnoreCase("N")) {
            logger.info("****FIN PROGRAMME****");
        }
    }
}
