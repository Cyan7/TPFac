public class Personnel implements Statut {

    public Personnel() {
    }


    @Override
    public void changeStatut(Acheteur monAcheteur) {
        monAcheteur.setMonStatut(this);
    }

    @Override
    public void payer(boolean utiliserPtFidel, float prixTotal) throws ErreurPaiement{
        if(utiliserPtFidel){
            throw new ErreurPaiement("Vous n'êtes pas adhérent.e : pas de points de fidélité à utiliser");
        }
        else {
            System.out.println("Paiment effectué");
        }
    }
}
