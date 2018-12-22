import java.util.ArrayList;

public class OffreProduit extends Offre {

    public OffreProduit(ArrayList<Produit> produits, typeReduction typeReduc, float reduction) {
        if(produits.size() == 1) {
            this.produits = produits;
            this.reduction = reduction;
            this.typeReduc = typeReduc;
        }
    }

    public float calculReduc(){
        if (typeReduc == typeReduction.rabais){
            return reduction;
        }
        return reduction * produits.get(0).getPrix();
    }
}
