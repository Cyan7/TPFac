import java.util.ArrayList;

public class Panier {
    private ArrayList<Produit> mesProduits;
    private Acheteur monAcheteur;

    public Panier(Acheteur monAcheteur) {
        this.monAcheteur = monAcheteur;
    }

    public ArrayList<Produit> getMesProduits() {
        return mesProduits;
    }

    public void setMesProduits(ArrayList<Produit> mesProduits) {
        this.mesProduits = mesProduits;
    }

    public Acheteur getMonAcheteur() {
        return monAcheteur;
    }

    public void setMonAcheteur(Acheteur monAcheteur) {
        this.monAcheteur = monAcheteur;
    }

    public float calculerPrixTotal(){
        //TODO
        return 0;
    }
}
