public class ProduitObserver implements Observer {

    Produit produitAObserver;

    public ProduitObserver(Produit prod){
        produitAObserver = prod;
    }

    @Override
    public void update(Observable observable) {
        if(observable instanceof Panier) {
            int index = ((Panier)observable).getMesProduits().size()-1;
            Produit dernierProduit = ((Panier)observable).getMesProduits().get(index);
            if(dernierProduit.getId()==produitAObserver.getId()) {
                System.out.println("Ce produit a été ajouté au panier : "+dernierProduit.toString());
            }
        }
    }
}

