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
        if(nomAch==nom && mdpAch==mdp && !connecte){
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
}
