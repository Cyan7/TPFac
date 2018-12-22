import java.util.ArrayList;

public class OffreFlash extends Offre {

    public OffreFlash(ArrayList<Produit> produits, typeReduction typeReduc, float reduction) {
        if(produits.size() > 1) {
            this.produits = produits;
            this.reduction = reduction;
            this.typeReduc = typeReduc;
        }
    }

    public float calculReduc(){
        if (typeReduc == typeReduction.rabais){
            return reduction;
        }
        float prix = 0;
        for (int i = 0; i < produits.size(); i++){
            prix += produits.get(i).getPrix();
        }
        return reduction * prix;
    }
}
