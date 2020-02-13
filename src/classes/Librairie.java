package classes;

import java.util.*;
import data.*;


public class Librairie {
    private List <Membre> lesMembres;
    private List <Auteur> lesAuteurs;
    private List <Editeur> lesEditeurs;
    private List <Employe> lesEmployes;
    private List <Statut> lesStatus;
    private List <Transporteur> lesTransporteurs;
    private List <Commande> lesCommandes;
    private List <Commentaire> lesCommentaires;
    private List <Evenement> lesEvenements;
    private List <Ligne_commande> lesLigne_commandes;
    private List <Mot_clef> lesMot_clefs;
    private List <Ouvrage> lesOuvrages;
    private List <Sous_theme> lesSous_themes;
    private List <Theme> lesThemes;
    private List <Adresse> lesAdresses;
    private List <Livraison> lesLivraisons;
    private List <Organisme_Paiement> lesOrganisme_Paiements;
    private List <Paiement> lesPaiements;
    private DAOsous_theme daoSt = new DAOsous_theme();
    private DAOtheme daoTh = new DAOtheme();
    private DAOauteur daoAuth = new DAOauteur();    
    private DAOediteur daoEdt = new DAOediteur();
    private DAOevenement daoEvt = new DAOevenement();
            
    
    public Librairie() {
    }
    /*Chargement des Arraylist de la base*/
    public void load(){
        this.lesThemes = daoTh.select();
        this.lesSous_themes = daoSt.select();
        this.lesAuteurs = daoAuth.select();
        this.lesEditeurs = daoEdt.select();
        this.lesEvenements = daoEvt.select();
    }
    
    public void loadAuteur(){
        this.lesAuteurs = daoAuth.select();
    }
    
    public void loadAuteur(String recherche){
        this.lesAuteurs = daoAuth.select(recherche);
    }
    
    public void loadTheme(){
        this.lesThemes = daoTh.select();
    }
    
    public void loadTheme(String recherche){
        this.lesThemes = daoTh.select(recherche);
    }
    
   /* GETTERS AND SETTERS -----------------------------------------------------------------------------------------------------------------------------------------------------------*/
    
    public List<Membre> getLesMembres() {
        return lesMembres;
    }

    public void setLesMembres(List<Membre> lesMembres) {
        this.lesMembres = lesMembres;
    }

    public List<Auteur> getLesAuteurs() {
        return lesAuteurs;
    }

    public void setLesAuteurs(List<Auteur> lesAuteurs) {
        this.lesAuteurs = lesAuteurs;
    }

    public List<Editeur> getLesEditeurs() {
        return lesEditeurs;
    }

    public void setLesEditeurs(List<Editeur> lesEditeurs) {
        this.lesEditeurs = lesEditeurs;
    }

    public List<Employe> getLesEmployes() {
        return lesEmployes;
    }

    public void setLesEmployes(List<Employe> lesEmployes) {
        this.lesEmployes = lesEmployes;
    }

    public List<Statut> getLesStatus() {
        return lesStatus;
    }

    public void setLesStatus(List<Statut> lesStatus) {
        this.lesStatus = lesStatus;
    }

    public List<Transporteur> getLesTransporteurs() {
        return lesTransporteurs;
    }

    public void setLesTransporteurs(List<Transporteur> lesTransporteurs) {
        this.lesTransporteurs = lesTransporteurs;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    public List<Commentaire> getLesCommentaires() {
        return lesCommentaires;
    }

    public void setLesCommentaires(List<Commentaire> lesCommentaires) {
        this.lesCommentaires = lesCommentaires;
    }

    public List<Evenement> getLesEvenements() {
        return lesEvenements;
    }

    public void setLesEvenements(List<Evenement> lesEvenements) {
        this.lesEvenements = lesEvenements;
    }

    public List<Ligne_commande> getLesLigne_commandes() {
        return lesLigne_commandes;
    }

    public void setLesLigne_commandes(List<Ligne_commande> lesLigne_commandes) {
        this.lesLigne_commandes = lesLigne_commandes;
    }

    public List<Mot_clef> getLesMot_clefs() {
        return lesMot_clefs;
    }

    public void setLesMot_clefs(List<Mot_clef> lesMot_clefs) {
        this.lesMot_clefs = lesMot_clefs;
    }

    public List<Ouvrage> getLesOuvrages() {
        return lesOuvrages;
    }

    public void setLesOuvrages(List<Ouvrage> lesOuvrages) {
        this.lesOuvrages = lesOuvrages;
    }

    public List<Sous_theme> getLesSous_themes() {
        return lesSous_themes;
    }

    public void setLesSous_themes(List<Sous_theme> lesSous_themes) {
        this.lesSous_themes = lesSous_themes;
    }

    public List<Theme> getLesThemes() {
        return lesThemes;
    }

    public void setLesThemes(List<Theme> lesThemes) {
        this.lesThemes = lesThemes;
    }

    public List<Adresse> getLesAdresses() {
        return lesAdresses;
    }

    public void setLesAdresses(List<Adresse> lesAdresses) {
        this.lesAdresses = lesAdresses;
    }

    public List<Livraison> getLesLivraisons() {
        return lesLivraisons;
    }

    public void setLesLivraisons(List<Livraison> lesLivraisons) {
        this.lesLivraisons = lesLivraisons;
    }

    public List<Organisme_Paiement> getLesOrganisme_Paiements() {
        return lesOrganisme_Paiements;
    }

    public void setLesOrganisme_Paiements(List<Organisme_Paiement> lesOrganisme_Paiements) {
        this.lesOrganisme_Paiements = lesOrganisme_Paiements;
    }

    public List<Paiement> getLesPaiements() {
        return lesPaiements;
    }

    public void setLesPaiements(List<Paiement> lesPaiements) {
        this.lesPaiements = lesPaiements;
    }

    
     /* METHODE POUR AJOUTER DES OBJETS AUX TABLEAUX -------------------------------------------------------------------------------------------------------------------------------*/
    
    public void AjouterAdresse (Adresse adresse){
        this.lesAdresses.add(adresse);
    }

    
    public void AjouterAuteur (Auteur auteur){
        this.lesAuteurs.add(auteur);
        daoAuth.insert(auteur);
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

     
    public void AjouterEvenement (Evenement evenement){
        this.lesEvenements.add(evenement);
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
        for (Theme leTheme : this.lesThemes){
            if (leTheme.getLibelle().equals(sous_theme.getTheme().getLibelle())){
                leTheme.add(sous_theme);
                break;
            }
        }
        daoSt.open();
        daoSt.insert(sous_theme);
        daoSt.close();
    }
     
    public void AjouterStatut(Statut statut){
        this.lesStatus.add(statut);
    }
     
    public void AjouterTheme (Theme theme){
        this.lesThemes.add(theme);
        daoTh.open();
        daoTh.insert(theme);
        daoTh.close();
    }
     
    public void AjouterTransporteur (Transporteur transporteur){
        this.lesTransporteurs.add(transporteur);
    }
    
    /* METHODE POUR SUPPRIMER DES OBJETS AUX TABLEAUX ------------------------------------------------------------------------------------------------------------------------------*/
    
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
     
    public void SupprimerEvenement (Evenement evenement){
        this.lesEvenements.remove(evenement);
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
//        a.setNom(a.getNom());
//        a.setPrenom(a.getPrenom());
//        a.setDate_de_naissance(a.getDate_de_naissance());
//        a.setDate_de_deces(a.getDate_de_deces());
        daoAuth.update(a);
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
//        st.setLibelle(st.getLibelle());
       daoSt.update(st);
    }
    
    public void modifierStatut(Statut s){
        s.setNom_statut(s.getNom_statut());
       
    }
    
    public void modifierTheme(Theme t){
//        t.setLibelle(t.getLibelle());
        daoTh.update(t);
       
    }
    
    public void modifierTransporteur(Transporteur t){
       t.setLibelle(t.getLibelle());
       t.setTel(t.getTel());
       t.setMail(t.getMail());
    }
    
}