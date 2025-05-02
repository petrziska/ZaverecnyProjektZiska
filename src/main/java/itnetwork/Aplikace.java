package itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplikace {
    private SpravcePojistenych spravcePojistenych;
    private Scanner scanner = new Scanner(System.in);

    // Konstruktor inicializuje správce pojištěných
    public Aplikace() {
        spravcePojistenych = new SpravcePojistenych();
    }

    // Metoda pro přidání nového pojištěného
    public void pridejPojisteneho() {
        String jmeno;
        do {
            System.out.println("Zadej jméno pojistného:");
            jmeno = scanner.nextLine().trim();

            // Validace jména: nesmí být prázdné a smí obsahovat pouze písmena
            if (jmeno.isEmpty()) {
                System.out.println("Jméno nesmí být prázdné.");
            } else if (!jmeno.matches("[a-zA-Zá-žÁ-Ž]+")){
                System.out.println("Jméno smí obsahovat pouze písmena.");
                jmeno = ""; // zneplatní se, aby cyklus pokračoval
            }
        } while (jmeno.isEmpty()); // Cyklus pokračuje, dokud není jméno platné

        String prijmeni;
        do {
            System.out.println("Zadej příjmení:");
            prijmeni = scanner.nextLine();

            // Validace příjmení: nesmí být prázdné a smí obsahovat pouze písmena
            if (prijmeni.isEmpty()) {
                System.out.println("Příjmení nesmí být prázdné");
            } else if (!prijmeni.matches("[a-zA-Zá-žÁ-Ž]+")){
                System.out.println("Příjmené smí obsahovat pouze písmena");
                prijmeni = ""; // zneplatní se, aby cyklus pokračoval
            }
        } while (prijmeni.isEmpty());  // Cyklus pokračuje, dokud není příjmení platné

        String telefon;
        boolean validni;
        do {
            System.out.println("Zadej telefonní číslo:");
            telefon = scanner.nextLine().trim();
            validni = true;

            // Validace telefonního čísla: nesmí být prázdné a musí mít 9 až 13 číslic
            if(telefon.isEmpty()) {
                System.out.println("Telefonní číslo nesmí být prázdné.");
                validni = false;
            } else if (telefon.length() < 9 || telefon.length() > 13){
                System.out.println("Telefonní číslo musí mít 9 až 13 číslic.");
                validni = false;
            } else {

                // Kontrola, zda telefonní číslo obsahuje pouze číslice
                for (int i = 0; i < telefon.length(); i++) {
                    if (!Character.isDigit(telefon.charAt(i))) {
                        System.out.println("Telefoní číslo smí obsahovat pouze číslice.");
                        validni = false;
                        break;
                    }
                }
            }
        } while (!validni); // Cyklus pokračuje, dokud není telefonní číslo platné

        int vek = -1;
        // Validace věku: musí být mezi 0 a 100
        while (vek < 0 || vek > 100) {
            System.out.println("Zadej věk (0 - 100):");
            try {
                vek = Integer.parseInt(scanner.nextLine());
                if (vek < 0 || vek > 100) {
                    System.out.println("Věk musí být mezi 0 a 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Neplatný vstup, zadej celé číslo");
            }
        }
        // Přidá nového pojištěného do seznamu
        spravcePojistenych.pridatPojisteneho(jmeno, prijmeni, vek, telefon);
    }

    // Metoda pro výpis seznamu pojištěných
    public void vypisPojistene() {
        ArrayList<PojistenaOsoba> seznamOsob = spravcePojistenych.zobrazitSeznamPojistenych();
        if (seznamOsob == null) { // Ověření, zda seznam pojištěných není prázdný nebo nezainicializovaný
            System.out.println("Seznam osob není inicializován.");
        }
    }

    // Metoda pro vyhledání pojištěného podle jména a příjmení
    public void vyhledatPojisteneho() {
        ArrayList<PojistenaOsoba> seznamOsob = spravcePojistenych.vyhledatPojisteneho();
        if (seznamOsob.size() > 0) {  // Pokud byly nalezeny nějaké osoby
            System.out.println("Nalezené osoby: ");
            for (PojistenaOsoba pojistenaOsoba: seznamOsob) {
                System.out.println(pojistenaOsoba);  // Vytiskne každou nalezenou pojištěnou osobu
            }
        } else {
            System.out.println("Nebyly nalezeny žádné osoby."); // Pokud nebyly nalezeny žádné osoby
        }
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
