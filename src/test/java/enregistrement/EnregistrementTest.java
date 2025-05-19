package enregistrement;

import junit.framework.TestCase;
import utilisateurtab.UtilisateurTab;

import java.util.Date;

public class EnregistrementTest extends TestCase {

    private Enregistrement enregistrement;
    private UtilisateurTab utilisateur;

    @Override
    protected void setUp() {
        utilisateur = new UtilisateurTab("Maurice", "Paul", "mauricedu22@dns.com");
        enregistrement = new Enregistrement(utilisateur, new Date(0), 25, 14.5, 15.0);
    }

    public void testGetUtilisateurTab() {
        assertEquals(utilisateur, enregistrement.getUtilisateurTab());
    }

    public void testSetUtilisateurTab() {
        UtilisateurTab newUser = new UtilisateurTab("Jean", "Jacques", "jj@test.com");
        enregistrement.setUtilisateurTab(newUser);
        assertEquals(newUser, enregistrement.getUtilisateurTab());
    }

    public void testGetDate() {
        assertEquals(new Date(0), enregistrement.getDate());
    }

    public void testSetDate() {
        Date newDate = new Date();
        enregistrement.setDate(newDate);
        assertEquals(newDate, enregistrement.getDate());
    }

    public void testGetNbEtudiants() {
        assertEquals((Integer) 25, enregistrement.getNbEtudiants());
    }

    public void testSetNbEtudiants() {
        enregistrement.setNbEtudiants(30);
        assertEquals((Integer) 30, enregistrement.getNbEtudiants());
    }

    public void testGetMoyenne() {
        assertEquals(14.5, enregistrement.getMoyenne(), 0.001);
    }

    public void testSetMoyenne() {
        enregistrement.setMoyenne(16.0);
        assertEquals(16.0, enregistrement.getMoyenne(), 0.001);
    }

    public void testGetMediane() {
        assertEquals(15.0, enregistrement.getMediane(), 0.001);
    }

    public void testSetMediane() {
        enregistrement.setMediane(17.0);
        assertEquals(17.0, enregistrement.getMediane(), 0.001);
    }
}
