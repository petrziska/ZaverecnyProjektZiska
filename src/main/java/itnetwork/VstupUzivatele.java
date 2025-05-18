package itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Třída VstupUzivatele slouží pro interakci s uživatelem přes konzoli.
 * Obsahuje menu a metody pro přidávání, výpis a vyhledávání pojištěných osob.
 */
public class VstupUzivatele {
    private Scanner scanner = new Scanner(System.in);


    /**
     * Spustí hlavní menu aplikace, umožní uživateli vybírat akce.
     * @param aplikace instance třídy Aplikace, která spravuje data
     */
    public void spustMenu(Aplikace aplikace) {
        String volba = ""; // Inicializace proměnné pro uchování volby uživatele

        // Hlavní smyčka, která pokračuje dokud uživatel nezvolí volbu "4" (konec)
        while (!volba.equals("4")) {
            aplikace.vypisUvodniObrazovku();  // Výpis nadpisu / úvodu
            System.out.println();
            System.out.println("Vyberte akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");
            System.out.println();
            volba = scanner.nextLine();  // Získání volby od uživatele
            System.out.println();

            // Zpracování uživatelské volby
            switch (volba) {
                case "1":
                    pridejPojisteneho(aplikace);
                    break;
                case "2":
                    vypisPojistene(aplikace);
                    break;
                case "3":
                    vyhledatPojisteneho(aplikace);
                    break;
                case "4":
                    System.out.println("Ukončil jsi správu pojištěných. Děkuji za použití mé aplikace.");
                    break;
                default:
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                    break;
            }
        }
    }

    /**
     * Načte údaje od uživatele a přidá novou pojištěnou osobu do aplikace.
     */
    private void pridejPojisteneho(Aplikace aplikace) {
        // Získání a ověření jména
        String jmeno;
        do {
            System.out.print("Zadej jméno: ");
            jmeno = scanner.nextLine().trim();
            if (jmeno.isEmpty()) {
                System.out.println("Jméno nesmí být prázdné.");
            } else if (!jmeno.matches("[a-zA-Zá-žÁ-Ž]+")) {
                System.out.println("Jméno smí obsahovat pouze písmena.");
                jmeno = "";
            }
        } while (jmeno.isEmpty());

        // Získání a ověření příjmení
        String prijmeni;
        do {
            System.out.print("Zadej příjmení: ");
            prijmeni = scanner.nextLine().trim();
            if (prijmeni.isEmpty()) {
                System.out.println("Příjmení nesmí být prázdné.");
            } else if (!prijmeni.matches("[a-zA-Zá-žÁ-Ž]+")) {
                System.out.println("Příjmení smí obsahovat pouze písmena.");
                prijmeni = "";
            }
        } while (prijmeni.isEmpty());

        // Získání a ověření věku
        int vek = -1;
        while (vek < 0 || vek > 120) {
            System.out.print("Zadej věk (0–120): ");
            try {
                vek = Integer.parseInt(scanner.nextLine());
                if (vek < 0 || vek > 120) {
                    System.out.println("Věk musí být v rozsahu 0 až 120.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadej prosím platné celé číslo.");
            }
        }

        // Získání a ověření telefonu
        String telefon;
        boolean validni;
        do {
            System.out.print("Zadej telefon (9–13 číslic): ");
            telefon = scanner.nextLine().trim();
            validni = true;

            if (telefon.isEmpty()) {
                System.out.println("Telefon nesmí být prázdný.");
                validni = false;
            } else if (!telefon.matches("\\d{9,13}")) {
                System.out.println("Telefon musí obsahovat pouze číslice (9 až 13 znaků).");
                validni = false;
            }
        } while (!validni);

        System.out.println("Volám aplikace.pridejPojisteneho");
        aplikace.pridejPojisteneho(jmeno, prijmeni, vek, telefon);
        System.out.println("Pojištěný byl úspěšně přidán.");
    }

    /**
     * Vypíše všechny pojištěné osoby uložené v aplikaci.
     */
    private void vypisPojistene(Aplikace aplikace) {
        System.out.println("Seznam pojištěných:");
        ArrayList<PojistenaOsoba> seznam = aplikace.vypisPojistene();
        if(seznam.isEmpty()) {
            System.out.println("Žádné osoby nejsou evidovány.");
        } else {
            for (PojistenaOsoba osoba : seznam) {
                System.out.println(osoba);
            }
        }
    }

    /**
     * Umožní uživateli vyhledat osobu podle jména a příjmení.
     */
    private void vyhledatPojisteneho(Aplikace aplikace) {
        // Získání a ověření jména
        String jmeno;
        do {
            System.out.print("Zadej jméno: ");
            jmeno = scanner.nextLine().trim();
            if (jmeno.isEmpty()) {
                System.out.println("Jméno nesmí být prázdné.");
            } else if (!jmeno.matches("[a-zA-Zá-žÁ-Ž]+")) {
                System.out.println("Jméno smí obsahovat pouze písmena.");
                jmeno = "";
            }
        } while (jmeno.isEmpty());

        // Získání a ověření příjmení
        String prijmeni;
        do {
            System.out.print("Zadej příjmení: ");
            prijmeni = scanner.nextLine().trim();
            if (prijmeni.isEmpty()) {
                System.out.println("Příjmení nesmí být prázdné.");
            } else if (!prijmeni.matches("[a-zA-Zá-žÁ-Ž]+")) {
                System.out.println("Příjmení smí obsahovat pouze písmena.");
                prijmeni = "";
            }
        } while (prijmeni.isEmpty());

        // Vyhledání osob
        ArrayList<PojistenaOsoba> nalezeni = aplikace.vyhledatPojisteneho(jmeno, prijmeni);
        if (nalezeni.isEmpty()) {
            System.out.println("Žádná osoba nebyla nalezena.");
        } else {
            for (PojistenaOsoba osoba : nalezeni) {
                System.out.println(osoba);
            }
        }
    }
}
