import java.util.ArrayList;

public abstract class Produit {
    protected int id, ptFidel;
    protected float prix;
    protected boolean offrable;
    protected ArrayList<Offre> mesOffres;
    protected Panier monPanier;

    //Getter et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPtFidel() {
        return ptFidel;
    }

    public void setPtFidel(int ptFidel) {
        this.ptFidel = ptFidel;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean isOffrable() {
        return offrable;
    }

    public void setOffrable(boolean offrable) {
        this.offrable = offrable;
    }

    //toString
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", ptFidel=" + ptFidel +
                ", prix=" + prix +
                ", offrable=" + offrable +
                '}';
    }

    //TODO : problème so OffreFlash (aucun moyen de savoir que les autres Produits concernés doivent utiliser la mm Offre)
    public float calculerPrixReel(){
        //corps inutile car les produits implémentent Offrable ???
        /*typeReduction type;
        float reduc;
        float prixTemp, prixReel=-1;
        for (Offre o : mesOffres){
             if(o.getTypeReduc()==typeReduction.rabais){
                prixTemp=prix-o.getReduction();
             }
             else{
                 prixTemp = o.getReduction()*getPrix();
             }
             if (prixTemp<prixReel||prixReel<0){prixReel=prixTemp;}
        }
        return prixReel;*/
    }
}
