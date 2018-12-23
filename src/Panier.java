import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;

public class Panier implements Observable {
    private float prixTotal=0;
    private ArrayList<Produit> mesProduits;
    private Acheteur monAcheteur;
    private ArrayList<Observer> mesObservers;

    public Panier(Acheteur monAcheteur) {
        this.monAcheteur = monAcheteur;
        mesProduits = new ArrayList<>();
        mesObservers = new ArrayList<>();
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
            System.out.println(p.toString());
            prixTot += p.getPrix();
        }
        prixTot -= Manager.calculReduc(this);
        prixTotal = prixTot;
        notifierObservers();
        return prixTotal;
    }

    public void ajouterProduit(int id){
        int count=0;
        for (Produit prod : Manager.getMesProduits()){
            if(prod.getId()==id){
                mesProduits.add(prod);
                notifierObservers();
                break;
            }
            else{count+=1;}
        }
        if(count==Manager.getMesProduits().size()){
            System.out.println("Cet id ne correspond à aucun produit");
        }
    }

    public void payer(boolean utiliserPtFidel){
        calculerPrixTotal();
        try {
            monAcheteur.getMonStatut().payer(utiliserPtFidel, prixTotal);
            //ajouter à la carte de fidélité les points cumulés
            if(monAcheteur.getMonStatut() instanceof Adherent){
                CarteFidelite carte = ((Adherent) monAcheteur.getMonStatut()).getMesCartes().get(0);
                carte.setPtFidel(carte.getPtFidel()+calculerPtsFidelite());
            }
            for (Produit produitPanier:this.getMesProduits()){
                for (Produit produit:Manager.getMesProduits()){
                    if (produitPanier.getId() == produit.getId()) {
                        Manager.getMesProduits().remove(produit);
                        break;
                    }
                }
            }
            //vider le panier et remettre le prixTotal à 0
            for(Produit p:mesProduits){
                mesProduits.remove(p);
            }
            prixTotal=0;
        }catch(ErreurPaiement e){
            System.out.println(e.getMessage());
        }
    }

    public int calculerPtsFidelite(){
        int total=0;
        for(Produit p : mesProduits){
            System.out.println("Pt fidel : " + p.getPtFidel());
            total += p.getPtFidel();
        }
        return total;
    }

    @Override
    public void ajouterObserver(Observer o) {
        mesObservers.add(o);
    }

    @Override
    public void notifierObservers() {
        for(Observer o : mesObservers){
            o.update(this);
        }
    }
}
