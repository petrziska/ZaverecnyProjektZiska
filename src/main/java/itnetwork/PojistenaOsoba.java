package itnetwork;

public class PojistenaOsoba {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefonniCislo;

    // Konstruktor pro vytvoření nové pojištěné osoby
    public PojistenaOsoba(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    // Getter pro získání jmena pojištěného
    public String getJmeno() {
        return jmeno;
    }

    // Getter pro získání příjmení pojištěného
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
