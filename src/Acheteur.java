import java.util.ArrayList;

public class Acheteur {
    private String nom, mdp;
    private boolean connecte = false;
    private Panier monPanier;
    private Statut monStatut;

    public Acheteur(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
        setMonStatut(new Client());
        setMonPanier(new Panier(this));
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean estConnecte(){
        return connecte;
    }

    public Statut getMonStatut() {
        return monStatut;
    }

    public void setMonStatut(Statut monStatut) {
        this.monStatut = monStatut;
    }

    public Panier getMonPanier(){
        return monPanier;
    }

    public void setMonPanier(Panier monPanier){
        this.monPanier=monPanier;
    }

    public boolean seConnecter(String nomAch, String mdpAch, Statut stat){
        if(nomAch.equals(nom) && mdpAch.equals(mdp) && !connecte && !(stat instanceof Client)){
            connecte=true;
            stat.changeStatut(this);
            return true;
        }
        return false;
    }


    public boolean seDeconnecter(){
        if(connecte){
            connecte = false;
            Client c = new Client();
            c.changeStatut(this);
            return true;
        }
        return false;
    }

    public boolean creerUnCompteAdherent(){
        if(this.getMonStatut() instanceof Client){
            CarteFidelite carte = new CarteFidelite(0);
            ArrayList<CarteFidelite> liste = new ArrayList<>();
            liste.add(carte);
            Adherent adherent = new Adherent(liste);
            this.setMonStatut(adherent);
            return true;
        }
        System.out.println("Vous avez déjà un compte");
        return false;
    }

    public boolean supprimerCompteAdherent(){
        if(this.getMonStatut() instanceof Adherent){
            Client client = new Client();
            this.setMonStatut(client);
            return true;
        }
        System.out.println("Vous ne pouvez supprimer ce compte adhérent");
        return false;
    }

    public boolean etreEmbauche(){
        if(this.getMonStatut() instanceof Client){
            Personnel personnel = new Personnel();
            this.setMonStatut(personnel);
            return true;
        }
        System.out.println("Vous avez déjà un compte");
        return false;
    }

    public boolean rompreUnContrat(){
        if(this.getMonStatut() instanceof Personnel){
            Client client = new Client();
            this.setMonStatut(client);
            return true;
        }
        System.out.println("Vous ne pouvez supprimer ce compte de personnel");
        return false;
    }
}
