import java.util.ArrayList;

public class Manager {
    private static Manager ourInstance;
    private static ArrayList<Produit> mesProduits;
    private static ArrayList<Offre> mesOffres;
    private static ArrayList<Categorie>  mesCategories;

    private Manager() {
        this.mesCategories = new ArrayList<Categorie>();
        this.mesProduits = new ArrayList<Produit>();
        this.mesOffres = new ArrayList<Offre>();
    }

    // Ici le getInstance() va uniquement servir à créer l'unique instance de Manager car toutes les méthodes et attribus sont static, c'est une classe utilitaire et on ne souhaite pas avoir à récupérer l'instance de Manager à chaque appel d'une fonction de cette classe.
    public static Manager getInstance() {
        if (ourInstance == null){
            ourInstance = new Manager();
        }
        return ourInstance;
    }

    public static boolean creerOffre(ArrayList<Produit> produits, typeReduction type, float reduction, typeOffre tOffre){
        for (Produit produit:produits) {
            if (!produit.getCategorie().isOffresAuthorisees()) return false; // On vérifie que les produits aient le droit de bénéficier d'une offre.
            boolean existe = false;
            for (Produit monProduit : mesProduits) {
                if (monProduit.getId() == produit.getId()) {
                    existe = true;
                }
            }
            if (!existe) return false;
        }
        Offre nouvelleOffre = null;
        switch (tOffre){
            case adherent:
                nouvelleOffre = new OffreAdhérent(produits, type, reduction);
            break;
            case flash:
                nouvelleOffre = new OffreFlash(produits, type, reduction);
            break;
            case produit:
                nouvelleOffre = new OffreProduit(produits, type, reduction);
            break;
            case personnel:
                nouvelleOffre = new OffrePersonnel(produits, type, reduction);
            break;
        }
        if (nouvelleOffre == null) return false;
        mesOffres.add(nouvelleOffre);
        // On indique sur les produits qu'ils bénéficient d'une offre et on ajoute l'offre
        for (Produit produit:produits) {
            for (Produit monProduit : mesProduits) {
                if (monProduit.getId() == produit.getId()) {
                    monProduit.setOffrable(true);
                }
            }
        }
        return true;
    }

    public static boolean creerProduit(String nomCategorie, int id, float prix, String titre, int ptFidel){
        Categorie categorie = null;
        boolean categorieExiste = false;
        for (Categorie c:mesCategories){
            if (c.getNom().equals(nomCategorie)){
                categorie = c;
                categorieExiste = true;
                break;
            }
        }
        if (!categorieExiste) return false;
        Produit nouveauProduit = new Produit(categorie, id, titre, ptFidel, prix);
        categorie.getProduitsCategorie().add(nouveauProduit);
        mesProduits.add(nouveauProduit);
        return true;
    }

    public static boolean ajouterProduits(int id, int nbreProduits){
        for (Produit produit:mesProduits){
            if (produit.getId() == id){
                for (int i=0; i<nbreProduits; i++){
                    Produit copie = (Produit) produit.clone();
                    mesProduits.add(copie);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean creerCategorie(String nom, boolean offresAuthorisees){
        for (Categorie c:mesCategories){
            if (c.getNom().equals(nom)){
                return false;
            }
        }
        Categorie nouvelleCategorie = new Categorie(nom, offresAuthorisees);
        mesCategories.add(nouvelleCategorie);
        return true;
    }

    public static float calculReduc(Panier p){
        ArrayList<Produit> produitsPanier = p.getMesProduits();
        float reduc = 0;
        for (Offre offre:mesOffres){
            boolean produitsPresents = true;
            for (Produit produit:offre.getProduits()){
                boolean produitPresent = false;
                for (Produit produitPanier:produitsPanier){
                    if(produitPanier.getId() == produit.getId()){
                        produitPresent = true;
                    }
                }
                if (!produitPresent) produitsPresents = false;
            }
            if (produitsPresents){
                reduc += offre.calculReduc();
            }
        }

        // On considère que les offres sont totalement cumulables (même dans le cas de plusieurs offres flash, toutes les réductions s'appliquent)

        return reduc;
    }

    public static void main(String args[]){
        getInstance();
        creerCategorie("DVD", true);
        creerProduit("DVD", 1, 25,"Star Wars V", 15);
        ajouterProduits(1, 9);
        creerProduit("DVD", 2, 20,"Star Wars I", 10);
        creerProduit("DVD", 3, 20,"Star Wars II", 10);
        creerProduit("DVD", 4, 20,"Star Wars III", 10);
        creerProduit("DVD", 5, 20,"Star Wars IV", 10);
        creerProduit("DVD", 6, 20,"Star Wars VI", 10);
        creerCategorie("Livre", false);
        creerProduit("Livre", 7, 10,"Aerkaos I", 5);
        creerProduit("Livre", 8, 10,"Aerkaos II", 5);
        creerProduit("Livre", 9, 10,"Aerkaos III", 5);


        for (Categorie c:mesCategories) {
            System.out.println(c.toString());
            for (Produit p : c.getProduitsCategorie()) {
                System.out.println("    " + p.toString());
            }
        }

        for (Produit p:mesProduits){
            System.out.println(p.toString());
        }

    }

}
