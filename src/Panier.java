import java.util.ArrayList;

public class Panier {
    private float prixTotal=0;
    private ArrayList<Produit> mesProduits;
    private Acheteur monAcheteur;

    public Panier(Acheteur monAcheteur) {
        this.monAcheteur = monAcheteur;
        mesProduits = new ArrayList<>();
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

    public float calculerPrixTotal(){
        float prixTot = 0;
        for(Produit p : mesProduits){
            prixTot += p.getPrix();
        }
        Manager ourInstance = Manager.getInstance();
        prixTot -= ourInstance.calculReduc(this);
        prixTotal = prixTot;
        return prixTotal;
    }

    public void ajouterProduit(int id){
        Manager ourInstance = Manager.getInstance();
        int count=0;
        for (Produit prod : ourInstance.getMesProduits()){
            if(prod.getId()==id){
                mesProduits.add(prod);
                break;
            }
            else{count+=1;}
        }
        if(count==ourInstance.getMesProduits().size()){
            System.out.println("Cet id ne correspond à aucun produit");
        }
    }

    public void payer(boolean utiliserPtFidel){
        calculerPrixTotal();
        try {
            monAcheteur.getMonStatut().payer(utiliserPtFidel, prixTotal);
            if(monAcheteur.getMonStatut() instanceof Adherent){
                CarteFidelite carte = ((Adherent) monAcheteur.getMonStatut()).getMesCartes().get(0);
                carte.setPtFidel(carte.getPtFidel()+calculerPtsFidelite());
            }
        }catch(ErreurPaiement e){
            System.out.println(e.getMessage());
        }
    }

    public int calculerPtsFidelite(){
        int total=0;
        for(Produit p : mesProduits){
            total += p.getPtFidel();
        }
        return total;
    }
}
