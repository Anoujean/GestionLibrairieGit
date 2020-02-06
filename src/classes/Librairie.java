package classes;

import java.util.ArrayList;


public class Librairie {
    private ArrayList <Membre> lesMembres;
    private ArrayList <Auteur> lesAuteurs;
    private ArrayList <Editeur> lesEditeurs;
    private ArrayList <Employe> lesEmployes;
    private ArrayList <Statut> lesStatus;
    private ArrayList <Transporteur> lesTransporteurs;
    private ArrayList <Commande> lesCommandes;
    private ArrayList <Commentaire> lesCommentaires;
    private ArrayList <Evenement> lesEvenements;
    private ArrayList <Ligne_commande> lesLigne_commandes;
    private ArrayList <Mot_clef> lesMot_clefs;
    private ArrayList <Ouvrage> lesOuvrages;
    private ArrayList <Sous_theme> lesSous_themes;
    private ArrayList <Theme> lesThemes;
    private ArrayList <Adresse> lesAdresses;
    private ArrayList <Livraison> lesLivraisons;
    private ArrayList <Organisme_Paiement> lesOrganisme_Paiements;
    private ArrayList <Paiement> lesPaiements;
    private ArrayList <Etre_facture> lesEtre_factures;
    private ArrayList <Etre_livre> lesEtre_livres;
    private ArrayList <Gerer> lesGerers;

    public Librairie() {
    }
    
   /* GETTERS AND SETTERS*/
    
    public ArrayList<Membre> getLesMembres() {
        return lesMembres;
    }

    public void setLesMembres(ArrayList<Membre> lesMembres) {
        this.lesMembres = lesMembres;
    }

    public ArrayList<Auteur> getLesAuteurs() {
        return lesAuteurs;
    }

    public void setLesAuteurs(ArrayList<Auteur> lesAuteurs) {
        this.lesAuteurs = lesAuteurs;
    }

    public ArrayList<Editeur> getLesEditeurs() {
        return lesEditeurs;
    }

    public void setLesEditeurs(ArrayList<Editeur> lesEditeurs) {
        this.lesEditeurs = lesEditeurs;
    }

    public ArrayList<Employe> getLesEmployes() {
        return lesEmployes;
    }

    public void setLesEmployes(ArrayList<Employe> lesEmployes) {
        this.lesEmployes = lesEmployes;
    }

    public ArrayList<Statut> getLesStatus() {
        return lesStatus;
    }

    public void setLesStatus(ArrayList<Statut> lesStatus) {
        this.lesStatus = lesStatus;
    }

    public ArrayList<Transporteur> getLesTransporteurs() {
        return lesTransporteurs;
    }

    public void setLesTransporteurs(ArrayList<Transporteur> lesTransporteurs) {
        this.lesTransporteurs = lesTransporteurs;
    }

    public ArrayList<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(ArrayList<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    public ArrayList<Commentaire> getLesCommentaires() {
        return lesCommentaires;
    }

    public void setLesCommentaires(ArrayList<Commentaire> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }

    public ArrayList<Evenement> getLesEvenements() {
        return lesEvenements;
    }

    public void setLesEvenements(ArrayList<Evenement> lesEvenements) {
        this.lesEvenements = lesEvenements;
    }

    public ArrayList<Ligne_commande> getLesLigne_commandes() {
        return lesLigne_commandes;
    }

    public void setLesLigne_commandes(ArrayList<Ligne_commande> lesLigne_commandes) {
        this.lesLigne_commandes = lesLigne_commandes;
    }

    public ArrayList<Mot_clef> getLesMot_clefs() {
        return lesMot_clefs;
    }

    public void setLesMot_clefs(ArrayList<Mot_clef> lesMot_clefs) {
        this.lesMot_clefs = lesMot_clefs;
    }

    public ArrayList<Ouvrage> getLesOuvrages() {
        return lesOuvrages;
    }

    public void setLesOuvrages(ArrayList<Ouvrage> lesOuvrages) {
        this.lesOuvrages = lesOuvrages;
    }

    public ArrayList<Sous_theme> getLesSous_themes() {
        return lesSous_themes;
    }

    public void setLesSous_themes(ArrayList<Sous_theme> lesSous_themes) {
        this.lesSous_themes = lesSous_themes;
    }

    public ArrayList<Theme> getLesThemes() {
        return lesThemes;
    }

    public void setLesThemes(ArrayList<Theme> lesThemes) {
        this.lesThemes = lesThemes;
    }

    public ArrayList<Adresse> getLesAdresses() {
        return lesAdresses;
    }

    public void setLesAdresses(ArrayList<Adresse> lesAdresses) {
        this.lesAdresses = lesAdresses;
    }

    public ArrayList<Livraison> getLesLivraisons() {
        return lesLivraisons;
    }

    public void setLesLivraisons(ArrayList<Livraison> lesLivraisons) {
        this.lesLivraisons = lesLivraisons;
    }

    public ArrayList<Organisme_Paiement> getLesOrganisme_Paiements() {
        return lesOrganisme_Paiements;
    }

    public void setLesOrganisme_Paiements(ArrayList<Organisme_Paiement> lesOrganisme_Paiements) {
        this.lesOrganisme_Paiements = lesOrganisme_Paiements;
    }

    public ArrayList<Paiement> getLesPaiements() {
        return lesPaiements;
    }

    public void setLesPaiements(ArrayList<Paiement> lesPaiements) {
        this.lesPaiements = lesPaiements;
    }

    public ArrayList<Etre_facture> getLesEtre_factures() {
        return lesEtre_factures;
    }

    public void setLesEtre_factures(ArrayList<Etre_facture> lesEtre_factures) {
        this.lesEtre_factures = lesEtre_factures;
    }

    public ArrayList<Etre_livre> getLesEtre_livres() {
        return lesEtre_livres;
    }

    public void setLesEtre_livres(ArrayList<Etre_livre> lesEtre_livres) {
        this.lesEtre_livres = lesEtre_livres;
    }

    public ArrayList<Gerer> getLesGerers() {
        return lesGerers;
    }

    public void setLesGerers(ArrayList<Gerer> lesGerers) {
        this.lesGerers = lesGerers;
    }
   
    
     /* METHODE POUR AJOUTER DES OBJETS AUX TABLEAUX*/
    
    public void AjouterAdresse (Adresse adresse){
        this.lesAdresses.add(adresse);
    }

    
    public void AjouterAuteur (Auteur auteur){
        this.lesAuteurs.add(auteur);
    }
    
    public void AjouterCommande (Commande commande){
        this.lesCommandes.add(commande);
    }
    
    public void AjouterCommentaire (Commentaire commentaire){
        this.lesCommentaires.add(commentaire);
    }
    

    
    public void AjouterEditeur (Editeur editeur){
        this.lesEditeurs.add(editeur);
    }
    
    public void AjouterEmploye (Employe employe){
        this.lesEmployes.add(employe);
    }
    
    public void AjouterEtre_facture (Etre_facture etre_facture){
        this.lesEtre_factures.add(etre_facture);
    }
    
    public void AjouterEtre_livre (Etre_livre etre_livre){
        this.lesEtre_livres.add(etre_livre);
    }
     
    public void AjouterEvenement (Evenement evenement){
        this.lesEvenements.add(evenement);
    }
     
    public void AjouterGerer (Gerer gerer){
        this.lesGerers.add(gerer);
    } 
     
    public void AjouterLigne_commande (Ligne_commande ligne_commande){
        this.lesLigne_commandes.add(ligne_commande);
    } 
     
    public void AjouterLivraison (Livraison livraison){
        this.lesLivraisons.add(livraison);
    } 
     
    public void AjouterMembre (Membre membre){
        this.lesMembres.add(membre);
    } 
     
    public void AjouterMot_clef (Mot_clef mot_clef){
        this.lesMot_clefs.add(mot_clef);
    }
     
    public void AjouterOrganisme_paiement (Organisme_Paiement organisme_paiement){
        this.lesOrganisme_Paiements.add(organisme_paiement);
    } 
     
    public void AjouterOuvrage(Ouvrage ouvrage){
        this.lesOuvrages.add(ouvrage);
    }
     
    public void AjouterPaiement (Paiement paiement){
        this.lesPaiements.add(paiement);
    } 

     
    public void AjouterSous_theme(Sous_theme sous_theme){
        this.lesSous_themes.add(sous_theme);
    }
     
    public void AjouterStatut(Statut statut){
        this.lesStatus.add(statut);
    }
     
    public void AjouterTheme (Theme theme){
        this.lesThemes.add(theme);
    }
     
    public void AjouterTransporteur (Transporteur transporteur){
        this.lesTransporteurs.add(transporteur);
    }
    
    /* METHODE POUR SUPPRIMER DES OBJETS AUX TABLEAUX*/
    
    public void SupprimerAdresse (Adresse adresse){
        this.lesAdresses.add(adresse);
    }

    
    public void SupprimerAuteur (Auteur auteur){
        this.lesAuteurs.remove(auteur);
    }
    
    public void SupprimerCommande (Commande commande){
        this.lesCommandes.remove(commande);
    }
    
    public void SupprimerCommentaire (Commentaire commentaire){
        this.lesCommentaires.remove(commentaire);
    }
    

    
    public void SupprimerEditeur (Editeur editeur){
        this.lesEditeurs.remove(editeur);
    }
    
    public void SupprimerEmploye (Employe employe){
        this.lesEmployes.remove(employe);
    }
    
    public void SupprimerEtre_facture (Etre_facture etre_facture){
        this.lesEtre_factures.remove(etre_facture);
    }
    
    public void SupprimerEtre_livre (Etre_livre etre_livre){
        this.lesEtre_livres.remove(etre_livre);
    }
     
    public void SupprimerEvenement (Evenement evenement){
        this.lesEvenements.remove(evenement);
    }
     
    public void SupprimerGerer (Gerer gerer){
        this.lesGerers.remove(gerer);
    } 
     
    public void SupprimerLigne_commande (Ligne_commande ligne_commande){
        this.lesLigne_commandes.remove(ligne_commande);
    } 
     
    public void SupprimerLivraison (Livraison livraison){
        this.lesLivraisons.remove(livraison);
    } 
     
    public void SupprimerMembre (Membre membre){
        this.lesMembres.remove(membre);
    } 
     
    public void SupprimerMot_clef (Mot_clef mot_clef){
        this.lesMot_clefs.remove(mot_clef);
    }
     
    public void SupprimerOrganisme_paiement (Organisme_Paiement organisme_paiement){
        this.lesOrganisme_Paiements.remove(organisme_paiement);
    } 
     
    public void SupprimerOuvrage(Ouvrage ouvrage){
        this.lesOuvrages.remove(ouvrage);
    }
     
    public void SupprimerPaiement (Paiement paiement){
        this.lesPaiements.remove(paiement);
    } 
     

     
    public void SupprimerSous_theme(Sous_theme sous_theme){
        this.lesSous_themes.remove(sous_theme);
    }
     
    public void SupprimerStatut(Statut statut){
        this.lesStatus.remove(statut);
    }
     
    public void SupprimerTheme (Theme theme){
        this.lesThemes.remove(theme);
    }
     
    public void SupprimerTransporteur (Transporteur transporteur){
        this.lesTransporteurs.remove(transporteur);
    }
    
    /* METHODE POUR MODIFIER DES OBJETS AUX TABLEAUX*/
    
    public void modifierAdresse(Adresse a){
        a.setRue(a.getRue());
        a.setCode_postal(a.getCode_postal());
        a.setVille(a.getVille());
        a.setPays(a.getPays());
    }
    
    public void modifierAuteur(Auteur a){
        a.setNom(a.getNom());
        a.setPrenom(a.getPrenom());
        a.setDate_de_naissance(a.getDate_de_naissance());
        a.setDate_de_deces(a.getDate_de_deces());
    }
    
    public void modifierCommande(Commande c){
        c.setDate(c.getDate());
        c.setFrais_de_port(c.getFrais_de_port());
        c.setNumero_commande(c.getNumero_commande());
        c.setAdresse_ip(c.getAdresse_ip());
    }
    
    public void modifierCommentaire(Commentaire c){
        c.setObjet(c.getObjet());
        c.setContenu(c.getContenu());
        c.setNote(c.getNote());
        c.setDate(c.getDate());
        c.setAdresse_ip(c.getAdresse_ip());
        c.setCommentaire(c.getCommentaire());
    }
    
    public void modifierEditeur(Editeur e){
        e.setNom(e.getNom());
        e.setEmail(e.getEmail());
        e.setTelephone(e.getTelephone());
    }
    
    public void modifierEmploye(Employe e){
        e.setNom(e.getNom());
        e.setPrenom(e.getPrenom());
        e.setDate_de_naissance(e.getDate_de_naissance());
        e.setLogin(e.getLogin());
        e.setPassword(e.getPassword());
    }
    
    public void modifierEvenement(Evenement e){
        e.setLibelle(e.getLibelle());
        e.setDate_debut(e.getDate_debut());
        e.setDate_fin(e.getDate_fin());
        e.setDescription(e.getDescription());
        e.setImage(e.getImage());
        e.setRemise(e.getRemise());
        e.setCommentaire(e.getCommentaire());
    }
    
    public void modifierLigne_Commande(Ligne_commande lc){
       lc.setQte(lc.getQte());
       lc.setPrix(lc.getPrix());
       lc.setTva(lc.getTva());
       lc.setRemise(lc.getRemise());
    }
    
    public void modifierLivraison(Livraison l){
        l.setDate_motif(l.getDate_motif());
        l.setMotif(l.getMotif());
        l.setCommentaire(l.getCommentaire());
    }
    
    public void modifierMembre(Membre m){
        m.setNom(m.getNom());
        m.setPrenom(m.getPrenom());
        m.setDate_de_naissance(m.getDate_de_naissance());
        m.setTelephone(m.getTelephone());
        m.setEmail(m.getEmail());
        m.setPassword(m.getPassword());
        m.setAdresse_ip(m.getAdresse_ip());
        m.setCommentaire(m.getCommentaire());
    }
    
    public void modifierMot_clef(Mot_clef mc){
        mc.setLibelle(mc.getLibelle());
    }
    
    public void modifierOrganisme_paiement(Organisme_Paiement op){
        op.setNom(op.getNom());
    }
    
    public void modifierOuvrage(Ouvrage o){
        o.setTitre(o.getTitre());
        o.setImage(o.getImage());
        o.setSous_titre(o.getSous_titre());
        o.setResume(o.getResume());
        o.setStock(o.getStock());
        o.setTva(o.getTva());
        o.setCommentaire(o.getCommentaire());
    }
    
    public void modifierPaiement(Paiement p){
       p.setNumero_transaction(p.getNumero_transaction());
       p.setDate(p.getDate());
    }
    
    
    public void modifierSous_theme(Sous_theme st){
        st.setLibelle(st.getLibelle());
       
    }
    
    public void modifierStatut(Statut s){
        s.setNom_statut(s.getNom_statut());
       
    }
    
    public void modifierTheme(Theme t){
        t.setLibelle(t.getLibelle());
       
    }
    
    public void modifierTransporteur(Transporteur t){
       t.setLibelle(t.getLibelle());
       t.setTel(t.getTel());
       t.setMail(t.getMail());
    }
    
}