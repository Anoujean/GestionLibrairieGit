
package classes;


public class Employe extends Personne {
    private int id_employe = 0;
    private String login;
    private String password;

    

    public Employe() {
    }
    
    public Employe(String nom, String prenom, String date_de_naissance, String login, String password) {
        super(nom, prenom, date_de_naissance);
        this.login = login;
        this.password = password;
    }

    public Employe(int id_employe, String nom, String prenom, String date_de_naissance, String login, String password) {
        super(nom, prenom, date_de_naissance);
        this.id_employe = id_employe;
        this.login = login;
        this.password = password;
    }
    
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    @Override
    public String toString() {
        String s;
        if (id_employe>0){
            s= super.toString()+ "Employe{" + "id_employe=" + id_employe + ", login=" + login + ", password=" + password + '}';
        }else{
             s= super.toString()+ "Employe{" + ", login=" + login + ", password=" + password + '}';
        }
        return s;
        
    }
    
    
}
