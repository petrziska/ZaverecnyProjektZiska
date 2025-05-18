package itnetwork;

/**
 * Třída reprezentuje jednu pojištěnou osobu v systému.
 * Obsahuje základní údaje jako jméno, příjmení, věk a telefonní číslo.
 */
public class PojistenaOsoba {

    // Jméno pojištěné osoby
    private String jmeno;

    // Příjmení pojištěné osoby
    private String prijmeni;

    // Věk pojištěné osoby
    private int vek;

    // Telefonní číslo pojištěné osoby
    private String telefonniCislo;

    /**
     * Konstruktor pro vytvoření nové pojištěné osoby.
     *
     * @param jmeno           Jméno osoby
     * @param prijmeni        Příjmení osoby
     * @param vek             Věk osoby
     * @param telefonniCislo  Telefonní číslo osoby
     */
    public PojistenaOsoba(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    /**
     * Vrací jméno pojištěné osoby.
     *
     * @return Jméno osoby
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Vrací příjmení pojištěné osoby.
     *
     * @return Příjmení osoby
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Přepsání metody toString pro lepší výpis pojištěné osoby
     * @return Vrací textový řetězec obsahující všechny údaje o pojištěné osobě
     */
    @Override
    public String toString() {
        return jmeno + "     " + prijmeni + "     " + vek + "     " + telefonniCislo;
    }
}
