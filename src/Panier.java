import java.util.ArrayList;

public class Panier {
    private float prixTotal=0;
    private ArrayList<Produit> mesProduits = new ArrayList<>();
    private Acheteur monAcheteur;

    public Panier(Acheteur monAcheteur) {
        this.monAcheteur = monAcheteur;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public ArrayList<Produit> getMesProduits() {
        return mesProduits;
    }

    public void setMesProduits(ArrayList<Produit> mesProduits) {
        this.mesProduits = mesProduits;
    }

    public Acheteur getMonAcheteur() {
        return monAcheteur;
    }

    public void setMonAcheteur(Acheteur monAcheteur) {
        this.monAcheteur = monAcheteur;
    }

    //TODO à tester car classe manager pas encore implémentée
    public float calculerPrixTotal(){
        float prixTot = 0;
        for(Produit p : mesProduits){
            prixTot += p.getPrix();
        }
        Manager manager = getInstance();
        prixTot -= manager.calculReduc(this);
        prixTotal = prixTot;
        return prixTotal;
    }

    public void ajouterProduit(Produit p){
        mesProduits.add(p);
    }

    public void payer(boolean utiliserPtFidel){
        calculerPrixTotal();
        try {
            monAcheteur.getMonStatut().payer(utiliserPtFidel, prixTotal);
        }catch(ErreurPaiement e){
            System.out.println(e.getMessage());
        }
    }
}
