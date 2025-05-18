package itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Třída Aplikace slouží jako prostředník mezi uživatelským rozhraním
 * a správou pojištěných osob. Obsahuje metody pro přidávání, výpis a vyhledávání pojištěných.
 */
public class Aplikace {

    // Instance správce pojištěných, který zajišťuje správu seznamu osob
    private SpravcePojistenych spravcePojistenych;

    /**
     * Konstruktor inicializuje správce pojištěných osob.
     */
    public Aplikace() {
        spravcePojistenych = new SpravcePojistenych();
    }

    /**
     * Přidá nového pojištěného do systému.
     *
     * @param jmeno    Jméno pojištěného
     * @param prijmeni Příjmení pojištěného
     * @param vek      Věk pojištěného
     * @param telefon  Telefonní číslo pojištěného
     */
    public void pridejPojisteneho(String jmeno, String prijmeni, int vek, String telefon) {
        // Přidá nového pojištěného do seznamu
        spravcePojistenych.pridatPojisteneho(jmeno, prijmeni, vek, telefon);
    }

    /**
     * Vrací seznam všech pojištěných osob.
     *
     * @return Seznam pojištěných osob jako ArrayList
     */
    public ArrayList<PojistenaOsoba> vypisPojistene() {
        return spravcePojistenych.zobrazitSeznamPojistenych();
    }

    /**
     * Vyhledá pojištěné osoby podle jména a příjmení.
     *
     * @param jmeno    Jméno hledané osoby
     * @param prijmeni Příjmení hledané osoby
     * @return Seznam nalezených osob jako ArrayList
     */
    public ArrayList<PojistenaOsoba> vyhledatPojisteneho(String jmeno, String prijmeni) {
        return spravcePojistenych.vyhledatPojisteneho(jmeno, prijmeni);
    }

    /**
     * Metoda pro výpis úvodní obrazovky
     */
    public void vypisUvodniObrazovku() {
        System.out.println("--------------------");
        System.out.println(" Správa pojištěných ");
        System.out.println("--------------------");
    }
}
