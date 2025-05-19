package calcultableau;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CalculTabTest {

    @Test
    public void testGetTableau() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        CalculTab calc = new CalculTab(list);
        assertEquals(list, calc.getTableau());
    }

    @Test
    public void testSetTableau() {
        CalculTab calc = new CalculTab(new ArrayList<>());
        ArrayList<Integer> newList = new ArrayList<>(Arrays.asList(5, 10, 15));
        calc.setTableau(newList);
        assertEquals(newList, calc.getTableau());
    }

    @Test
    public void testMoyenne() {
        CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(10, 20, 30)));
        assertEquals(20.0, calc.moyenne(), 0.001);
    }

    @Test
    public void testMedianeOdd() {
        CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(30, 10, 20)));
        assertEquals(20.0, calc.mediane(), 0.001);
    }

    @Test
    public void testMedianeEven() {
        CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(10, 30, 20, 40)));
        assertEquals(25.0, calc.mediane(), 0.001);
    }

    @Test
    public void testTotal() {
        CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(10, 20, 30)));
        assertEquals(60, calc.total());
    }

    @Test
    public void testGetNombreEtudiant() {
        CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(10, 20, 30)));
        assertEquals(3, calc.getNombreEtudiant());
    }

    @Test
    public void testAffichageTableau() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        CalculTab calc = new CalculTab(list);

        // Rediriger la sortie standard pour tester ce qui est affiché
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        calc.affichageTableau();

        String expectedOutput = "10\n20\n30\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void CalculMedianeDouble()
    {
        //Ne peut pas fonctionner car

        //CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(30.2, 10.1, 20.2)));
        //assertEquals(30.25, calc.mediane(), 0.001);
    }

}
