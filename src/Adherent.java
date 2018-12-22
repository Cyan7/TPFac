import java.util.ArrayList;

public class Adherent implements Statut {
    ArrayList<CarteFidelite> mesCartes;

    public Adherent() {
    }

    public Adherent(ArrayList<CarteFidelite> mesCartes) {
        this.mesCartes = mesCartes;
    }

    public ArrayList<CarteFidelite> getMesCartes() {
        return mesCartes;
    }

    public void setMesCartes(ArrayList<CarteFidelite> mesCartes) {
        this.mesCartes = mesCartes;
    }


    @Override
    public void changeStatut(Acheteur monAcheteur) {
        monAcheteur.setMonStatut(this);
    }

    @Override
    public void payer(boolean utiliserPtFidel, float prixTotal) throws ErreurPaiement{
        float prixAPayer=prixTotal;
        if(utiliserPtFidel){
            int ptFid=0;
            //Calcul du total des pts de fidélité
            for(CarteFidelite c : mesCartes){
                ptFid += c.getPtFidel();
            }
            //on considère que 1€=10 points de fidélité
            if(Math.floor(ptFid/10)<=prixTotal){
                prixAPayer = prixTotal - (float)Math.floor(ptFid/10);
                for(CarteFidelite c : mesCartes){
                    c.setPtFidel(0);
                }
            }
            //Si toutes les cartes fidélité ne sont pas à débiter entièrement
            else{
                prixAPayer = 0;
                ptFid-=(int)Math.floor(prixTotal*10);
                for(CarteFidelite c : mesCartes){
                    if(c.getPtFidel()>ptFid) {
                        c.setPtFidel(c.getPtFidel()-ptFid);
                        break;
                    }
                    else{
                        ptFid -= c.getPtFidel();
                        c.setPtFidel(0);
                    }
                }
            }
            System.out.println("Paiment effectué de €" + prixAPayer);
        }
        else{
            System.out.println("Paiment effectué de €" + prixAPayer);
        }
    }
}
