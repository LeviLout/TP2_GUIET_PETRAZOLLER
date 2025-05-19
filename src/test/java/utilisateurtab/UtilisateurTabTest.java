package utilisateurtab;

import junit.framework.TestCase;

public class UtilisateurTabTest extends TestCase {

    private UtilisateurTab utilisateur;

    @Override
    protected void setUp() {
        utilisateur = new UtilisateurTab("Alice", "Dupont", "alice@example.com");
    }

    public void testGetPrenom() {
        assertEquals("Alice", utilisateur.getPrenom());
    }

    public void testSetPrenom() {
        utilisateur.setPrenom("Bob");
        assertEquals("Bob", utilisateur.getPrenom());
    }

    public void testGetNom() {
        assertEquals("Dupont", utilisateur.getNom());
    }

    public void testSetNom() {
        utilisateur.setNom("Martin");
        assertEquals("Martin", utilisateur.getNom());
    }

    public void testGetEmail() {
        assertEquals("alice@example.com", utilisateur.getEmail());
    }

    public void testSetEmail() {
        utilisateur.setEmail("bob@example.com");
        assertEquals("bob@example.com", utilisateur.getEmail());
    }

    public void testEmailValide() {
        assertTrue(UtilisateurTab.isValidEmail("valid.email@example.com"));
    }

    public void testEmailInvalideSansArobase() {
        assertFalse(UtilisateurTab.isValidEmail("invalid.email.com"));
    }

    public void testEmailInvalideSansDomaine() {
        assertFalse(UtilisateurTab.isValidEmail("invalid@com"));
    }

    public void testEmailInvalideAvecCaractereSpecial() {
        assertFalse(UtilisateurTab.isValidEmail("invalid!email@example.com"));
    }

    public void testConstructeurEmailInvalide() {
        try {
            new UtilisateurTab("Jean", "Durand", "invalidemail.com");
            fail("Une exception aurait dû être levée pour un email invalide.");
        } catch (IllegalArgumentException e) {
            assertEquals("Email invalide : invalidemail.com", e.getMessage());
        }
    }
}
