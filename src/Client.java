public class Client implements Statut {

    public Client() {
    }


    @Override
    public void changeStatut(Acheteur monAcheteur) {
        monAcheteur.setMonStatut(this);
    }

    @Override
    public void payer(boolean utiliserPtFidel, float prixTotal) throws ErreurPaiement{
        if(utiliserPtFidel){
            throw new ErreurPaiement("Vous n'êtes pas connecté.e : pas de points de fidélité à utiliser");
        }
        else {
            System.out.println("Paiment effectué");
        }
    }
}
