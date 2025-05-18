package itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Třída SpravcePojistenych slouží jako správce seznamu pojištěných osob.
 * Poskytuje metody pro přidání, vyhledání a zobrazení všech pojištěných.
 */
public class SpravcePojistenych {
    private ArrayList<PojistenaOsoba> pojisteneOsoby;  // Seznam všech pojištěných osob

    /**
     * Konstruktor, který inicializuje seznam pojištěných osob.
     */
    public SpravcePojistenych() {
        pojisteneOsoby = new ArrayList<>();
    }

    /**
     * Přidá novou pojištěnou osobu do seznamu.
     *
     * @param jmeno Jméno pojištěné osoby
     * @param prijmeni Příjmení pojištěné osoby
     * @param vek Věk pojištěné osoby
     * @param telefonniCislo Telefonní číslo pojištěné osoby
     */
    public void pridatPojisteneho(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        System.out.println("Přidávám pojištěného: " + jmeno + " " + prijmeni);
        pojisteneOsoby.add(new PojistenaOsoba(jmeno, prijmeni, vek, telefonniCislo));
    }

    /**
     * Vyhledá pojištěné osoby podle jména a příjmení.
     * Vyhledávání je přesné – rozlišuje velikost písmen.
     *
     * @param jmeno Jméno hledané osoby
     * @param prijmeni Příjmení hledané osoby
     * @return Seznam nalezených pojištěných osob odpovídajících zadaným údajům
     */
    public ArrayList<PojistenaOsoba> vyhledatPojisteneho(String jmeno, String prijmeni) {
        ArrayList<PojistenaOsoba> nalezene = new ArrayList<>();

        // Prochází seznam pojištěných a hledá osoby, které odpovídají zadaným údajům
        for (PojistenaOsoba pojistenaOsoba : pojisteneOsoby) {
            if (pojistenaOsoba.getJmeno().equals(jmeno) && pojistenaOsoba.getPrijmeni().equals(prijmeni)) {
                nalezene.add(pojistenaOsoba);
            }
        }
    return nalezene;
    }

    /**
     * Vrátí celý seznam pojištěných osob.
     *
     * @return Seznam všech pojištěných osob
     */
    public ArrayList<PojistenaOsoba> zobrazitSeznamPojistenych() {
        return pojisteneOsoby;
    }
}
