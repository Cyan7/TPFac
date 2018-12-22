public class Acheteur {
    private String nom, mdp;
    private boolean connecte = false;
    private Panier monPanier;
    private Statut monStatut;

    public Acheteur(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
        setMonStatut(new Client());
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

    public boolean seConnecter(String nomAch, String mdpAch){
        if(nomAch==nom && mdpAch==mdp && !connecte){
            connecte=true;
            //TODO changer statut
            return true;
        }
        return false;
    }

    public boolean seDeconnecter(){
        if(connecte){
            connecte = false;
            //TODO changer statut
            return true;
        }
        return false;
    }
}
