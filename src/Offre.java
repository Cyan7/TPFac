import java.util.ArrayList;

public class Offre {

    protected float reduction;
    protected typeReduction typeReduc;
    protected ArrayList<Produit> mesProduits;

    //getters et setters
    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public typeReduction getTypeReduc() {
        return typeReduc;
    }

    public void setTypeReduc(typeReduction typeReduc) {
        this.typeReduc = typeReduc;
    }

    //ToString
    @Override
    public String toString() {
        return "Offre{" +
                "reduction=" + reduction +
                ", typeReduc=" + typeReduc +
                '}';
    }

}
