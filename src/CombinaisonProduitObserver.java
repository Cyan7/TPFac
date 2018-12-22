import java.util.ArrayList;

public class CombinaisonProduitObserver implements Observer {
    private Categorie categorie;
    private int nbProduits;
    private ArrayList<Produit> liste;
    private int tailleListePrec;

    public CombinaisonProduitObserver(Categorie categorie, int nbProduits){
        this.categorie = categorie;
        this.nbProduits = nbProduits;
        liste = new ArrayList<>();
        tailleListePrec = 0;
    }

    @Override
    public void update(Observable observable) {
        if(observable instanceof Panier){
            for(Produit p : ((Panier) observable).getMesProduits()){
                int indic = 0;
                if(p.getCategorie()==categorie) {
                    for(Produit pl : liste){
                        if(pl.equals(p)){
                            indic +=1;
                        }
                    }
                    if(indic==0){
                        liste.add(p);
                    }
                }
            }
            if(liste.size()>=nbProduits && tailleListePrec!=liste.size()) {
                System.out.println("Le panier contient " + liste.size() +" produit(s) de la catégorie " + categorie.getNom());
                tailleListePrec= liste.size();
            }
        }
    }
}
