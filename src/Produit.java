import java.util.ArrayList;

public class Produit implements Cloneable{
    private int id, ptFidel;
    private float prix;
    private boolean offrable;
    private String titre;
    private Panier monPanier;
    private Categorie categorie;

    public Produit() {
    }

    public Produit(Categorie categorie, int id, String titre, int ptFidel, float prix) {
        this.id = id;
        this.titre = titre;
        this.ptFidel = ptFidel;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){}
        return null;
    }

    //Getter et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    //toString
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", titre=" + titre +
                ", ptFidel=" + ptFidel +
                ", prix=" + prix +
                ", offrable=" + offrable +
                '}';
    }


}
