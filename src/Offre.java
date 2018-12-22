import java.util.ArrayList;

abstract public class Offre {

    protected float reduction;
    protected typeReduction typeReduc;
    protected ArrayList<Produit> produits;

    //getters et setters


    public ArrayList<Produit> getProduits() {
        return produits;
    }

    abstract public float calculReduc();

}
