package itnetwork;

import java.util.ArrayList;
import java.util.Scanner;

public class SpravcePojistenych {
    private ArrayList<PojistenaOsoba> pojisteneOsoby;  // Seznam všech pojištěných osob
    Scanner scanner = new Scanner(System.in);

    // Konstruktor pro inicializaci seznamu pojištěných osob
    public SpravcePojistenych() {
        pojisteneOsoby = new ArrayList<>();
    }

    // Metoda pro přidání nového pojištěného do seznamu
    public void pridatPojisteneho(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        pojisteneOsoby.add(new PojistenaOsoba(jmeno, prijmeni, vek, telefonniCislo));
    }

    // Metoda pro vyhledání pojištěného podle jména a příjmení
    public ArrayList<PojistenaOsoba> vyhledatPojisteneho() {
        ArrayList<PojistenaOsoba> nalezene = new ArrayList<>();
        System.out.println("Zadej jméno pojištěného:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadej příjmení pojištěného:");
        String prijmeni = scanner.nextLine();

        // Prochází seznam pojištěných a hledá osoby, které odpovídají zadaným údajům
        for (PojistenaOsoba pojistenaOsoba : pojisteneOsoby) {
            if (pojistenaOsoba.getJmeno().equals(jmeno) && pojistenaOsoba.getPrijmeni().equals(prijmeni)) {
                nalezene.add(pojistenaOsoba);
            }
        }
    return nalezene;
    }

    // Metoda pro zobrazení seznamu všech pojištěných osob
    public ArrayList<PojistenaOsoba> zobrazitSeznamPojistenych() {
        if (pojisteneOsoby.isEmpty()) {
            System.out.println("Seznam pojištěných je prázdý");
        } else {
            System.out.println("Seznam pojištěných: ");
            for (PojistenaOsoba pojistenaOsoba : pojisteneOsoby) {
                System.out.println(pojistenaOsoba);
            }
        }
        return pojisteneOsoby;
    }
}
