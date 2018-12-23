import java.util.ArrayList;

public class OffreAdhérent extends Offre {

    public OffreAdhérent(ArrayList<Produit> produits, typeReduction typeReduc, float reduction) {
        if(produits.size() == 1) {
            this.produits = produits;
            this.reduction = reduction;
            this.typeReduc = typeReduc;
        }
    }

    public float calculReduc(Statut statut){
        if (!(statut instanceof Adherent)) return 0;
        if (typeReduc == typeReduction.rabais){
            return reduction;
        }
        return reduction * produits.get(0).getPrix() / 100;
    }
}
