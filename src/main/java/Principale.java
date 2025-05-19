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

        ArrayList<Integer> tableau = new ArrayList<>();
        int n = 0;
        Scanner sc = new Scanner(System.in);
        int i;

        do {
            logger.info("Veuillez entrer la taille du tableau (entre 1 et 50) :");
            try {
                n = sc.nextInt();
                if (n <= 0 || n > 50) {
                    logger.warning("Taille invalide. Entrez un entier entre 1 et 50.");
                }
            } catch (Exception e) {
                logger.warning("Entrée invalide. Veuillez entrer un entier.");
                sc.nextLine();
                n = 0; // pour garder la condition du do-while fausse
            }
        } while (n <= 0 || n > 50);

        // REMPLISSAGE DE TABLEAU
        for (i = 0; i < n; i++) {
            int note = -1;
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
            tableau.add(note);
        }

        CalculTab calculTab = new CalculTab(tableau);

        logger.info("****Affichage Tableau****");
        calculTab.affichageTableau();
        logger.info("****Total****");
        System.out.println(calculTab.total());
        logger.info("****Moyenne****");
        System.out.println(calculTab.moyenne());
        logger.info("****Médiane****");
        System.out.println(calculTab.mediane());

        logger.info("Voulez-vous enregistrer ces résultats ? (O/N");
        Scanner sc2 = new Scanner(System.in);
        String reponse = sc2.nextLine();
        if (reponse.equalsIgnoreCase("O")) {
            UtilisateurTab utilisateurTab;
            logger.info("Entrez votre prénom");
            Scanner sc3 = new Scanner(System.in);
            String prenom = sc3.nextLine();
            logger.info("Entrez votre nom");
            Scanner sc4 = new Scanner(System.in);
            String nom = sc4.nextLine();
            logger.info("Entrez votre e-mail");
            Scanner sc5 = new Scanner(System.in);
            String email = sc5.nextLine();

            utilisateurTab = new UtilisateurTab(prenom, nom, email);

            logger.info("Entrez la date d'examen (AAAA-MM-JJ)");
            Scanner sc6 = new Scanner(System.in);
            String date = sc6.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // évite les erreurs silencieuses
            Date dateExamen = sdf.parse(date);

            Enregistrement enregistrement = new Enregistrement(utilisateurTab, dateExamen, calculTab.getNombreEtudiant(), calculTab.moyenne(), calculTab.mediane());
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Pour avoir une date lisible

            mapper.writeValue(new File("enregistrement.json"), enregistrement);

            System.out.println("✅ Fichier JSON enregistré avec succès !");

        } else if (reponse.equalsIgnoreCase("N")) {
            logger.info("****FIN PROGRAMME****");
        }
    }
}
