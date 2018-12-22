import java.util.ArrayList;

public class Manager {
    private static Manager ourInstance;
    private static ArrayList<Produit> mesProduits;
    private static ArrayList<Offre> mesOffres;

    private Manager() {
        /*mesProduits = new ArrayList<>();
        mesOffres = new ArrayList<>();*/
    }

    // Ici le getInstance() va uniquement servir à créer l'unique instance de Manager car toutes les méthodes et attribus sont static, c'est une classe utilitaire et on ne souhaite pas avoir à récupérer l'instance de Manager à chaque appel d'une fonction de cette classe.
    public static Manager getInstance() {
        if (ourInstance == null){
            ourInstance = new Manager();
        }
        return ourInstance;
    }

    public ArrayList<Produit> getMesProduits(){
        return mesProduits;
    }

    public void setMesProduits(Produit p){
        mesProduits.add(p);
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
}
