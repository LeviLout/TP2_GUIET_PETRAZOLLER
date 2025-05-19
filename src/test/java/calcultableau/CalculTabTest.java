package calcultableau;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import static org.assertj.core.api.Assertions.*;

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
        //Ne peut pas fonctionner car la liste demande des int et non des doubles donc impossible à lancer

        //Arrange
        double premier=30.2;
        double deuxieme=10.1;
        double troisieme=20.2;

        //Act
        //CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(premier, deuxieme, troisieme)));

        //Assert
        //assertEquals(30.25, calc.mediane(), 0.001);
    }

    @Test
    public void CalculMedianeString()
        //test qui permet d'essayer de rentrer des strings dans le tableau
    {
        //Arrange
        String dix="10";
        String douze="12";
        String vingt="20";

        //Act
        //CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(dix, douze, vingt)));

        //Assert
        //assertEquals(31, calc.mediane(), 0.001);
        //le test ne fonctionne pas car on a besoin d'entier et non de string, donc c'est bon !
    }


    @Test
    public void CalculMedianeBoolean()
    {
        //Arrange

        boolean un=true;
        boolean deux=false;
        boolean trois=true;

        //Act
        //CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(un, deux, trois)));

        //Assert
        //assertEquals(31, calc.mediane(), 0.001);

        //le test ne fonctionne pas car on a besoin d'entier et non de boolean, donc c'est bon !
    }

    @Test
    public void CalculMedianeGrandsNombres()
    {
        BigInteger premier = new BigInteger("12345678901234568901856180498461531");
        BigInteger deuxieme = new BigInteger("274356123416506816801068408904849");
        BigInteger troisieme = new BigInteger("123016510865168534563116840984860");

        //CalculTab calc = new CalculTab(new ArrayList<>(Arrays.asList(premier, deuxieme, troisieme)));

        //assertEquals(31, calc.mediane(), 0.001);

        //le test ne fonctionne pas car on a besoin d'entier et non de BigInteger, ça ne passe pas
    }

    @Test
    public void MoyenneAvecAssertJ() {
        // Arrange
        ArrayList<Integer> valeurs = new ArrayList<>(Arrays.asList(10, 20, 30));
        CalculTab calc = new CalculTab(valeurs);

        // Act
        double moyenne = calc.moyenne();

        // Assert
        assertThat(moyenne)
                .as("la moyenne des valeurs 10, 20 et 30 est 20.0")
                .isEqualTo(20.0);
    }

    @Test
    public void testMoyenneAvecListeMockee() {
        // Arrange
        ArrayList<Integer> mockList = mock(ArrayList.class);

        when(mockList.size()).thenReturn(3);
        when(mockList.get(0)).thenReturn(10);
        when(mockList.get(1)).thenReturn(20);
        when(mockList.get(2)).thenReturn(30);

        CalculTab calc = new CalculTab(mockList);

        // Act
        double result = calc.moyenne();

        // Assert
        assertThat(result).isEqualTo(20.0);

        // vérification des interactions
        verify(mockList, times(1)).size();
        verify(mockList, times(3)).get(anyInt());
        verify(mockList).get(0);
        verify(mockList).get(1);
        verify(mockList).get(2);
    }

}