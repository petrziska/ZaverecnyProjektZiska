package itnetwork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Vytvoření objektu Scanner pro čtení uživatelského vstupu
        Aplikace aplikace = new Aplikace(); // Vytvoření objektu aplikace, která obsahuje logiku programu
        String volba = ""; // Inicializace proměnné pro uchování volby uživatele


        // Hlavní smyčka, která pokračuje dokud uživatel nezvolí volbu "4" (konec)
        while (!volba.equals("4")) {
            aplikace.vypisUvodniObrazovku();
            System.out.println();
            System.out.println("Vyberte akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojistného");
            System.out.println("4 - Konec");
            System.out.println();
            volba = scanner.nextLine();
            System.out.println();

            switch (volba) {
                case "1":
                    aplikace.pridejPojisteneho();
                    break;
                case "2":
                    aplikace.vypisPojistene();
                    break;
                case "3":
                    aplikace.vyhledatPojisteneho();
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
}
