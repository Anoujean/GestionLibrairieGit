package classes;


public class Gerer {
    private Employe employe;
    private Ouvrage ouvrage;

    public Gerer() {
    }

    public Gerer(Employe employe, Ouvrage ouvrage) {
        this.employe = employe;
        this.ouvrage = ouvrage;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    @Override
    public String toString() {
        return "Gerer{" + "employe=" + employe + ", ouvrage=" + ouvrage + '}';
    }

   
    
    
}
