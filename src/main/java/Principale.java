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

        System.out.println("****Affichage Tableau****");
        calculTab.affichageTableau();
        System.out.println("****Total****");
        System.out.println(calculTab.total());
        System.out.println("****Moyenne****");
        System.out.println(calculTab.moyenne());

        System.out.println("****Médiane****");
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
