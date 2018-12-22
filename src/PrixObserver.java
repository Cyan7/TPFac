public class PrixObserver implements Observer {

    private float prixAObserver;
    private boolean alerteLancee;

    public PrixObserver(float prix){
        prixAObserver = prix;
        alerteLancee=false;
    }

    @Override
    public void update(Observable observable) {
        if(observable instanceof Panier) {
            float prix = ((Panier) observable).getPrixTotal();
            if (prix > prixAObserver && !alerteLancee) {
                System.out.println("Montant panier supérieur à €" + prixAObserver);
                alerteLancee = true;
            }
        }
    }
}
