import java.util.ArrayList;

public abstract class Produit {
    private int id, ptFidel;
    private float prix;
    private boolean offrable;
    private String titre;
    private Panier monPanier;
    private Categorie<Produit> categorie;

    public Produit() {
    }

    public Produit(int id, String titre, int ptFidel, float prix, boolean offrable) {
        this.id = id;
        this.titre = titre;
        this.ptFidel = ptFidel;
        this.prix = prix;
        this.offrable = offrable;
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

    public Categorie<Produit> getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie<Produit> categorie) {
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
