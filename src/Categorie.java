import java.util.ArrayList;

public class Categorie<Produit> {
    private String nom;
    private ArrayList<Produit> produitsCategorie;
    private boolean offresAuthorisees;

    public Categorie(String nom, boolean offresAuthorisees){
        this.nom = nom;
        this.offresAuthorisees = offresAuthorisees;
    }

    public Categorie(String nom, ArrayList<Produit> produitsCategorie, boolean offresAuthorisees){
        this.nom = nom;
        this.produitsCategorie = produitsCategorie;
        this.offresAuthorisees = offresAuthorisees;
    }

    public boolean isOffresAuthorisees() {
        return offresAuthorisees;
    }

    public String getNom(){
        return nom;
    }

    public ArrayList<Produit> getProduitsCategorie() {
        return produitsCategorie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setOffresAuthorisees(boolean offresAuthorisees) {
        this.offresAuthorisees = offresAuthorisees;
    }

    public void setProduitsCategorie(ArrayList<Produit> produitsCategorie) {
        this.produitsCategorie = produitsCategorie;
    }
}
