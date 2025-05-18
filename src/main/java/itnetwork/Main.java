package itnetwork;

import java.util.Scanner;

/**
 * Hlavní třída programu, která slouží jako vstupní bod aplikace.
 * Spouští aplikaci pro správu pojištěných osob.
 */
public class Main {
    /**
     * Metoda main – hlavní metoda programu, která se spustí při startu aplikace.
     */
    public static void main(String[] args) {
        // Vytvoření instance třídy Aplikace, která spravuje logiku pojištění
        Aplikace aplikace = new Aplikace();

        // Vytvoření instance třídy pro zpracování vstupu uživatele
        VstupUzivatele vstupUzivatele = new VstupUzivatele();

        // Spuštění hlavního menu pro komunikaci s uživatelem
        vstupUzivatele.spustMenu(aplikace);
    }
}
