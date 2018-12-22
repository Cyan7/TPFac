import java.util.ArrayList;

public class Categorie {
    private String nom;
    private ArrayList<Produit> produitsCategorie;
    private boolean offresAuthorisees;

    public Categorie(String nom, boolean offresAuthorisees){
        this.nom = nom;
        this.offresAuthorisees = offresAuthorisees;
        this.produitsCategorie = new ArrayList<Produit>();
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

    @Override
    public String toString() {
        return "Categorie{" +
                "nom=" + nom +
                ", offresAuthorisees=" + offresAuthorisees +
                '}';
    }
}
