
import java.util.ArrayList;

public class Main {
    public static void main(String [] args){

        Manager.getInstance(); //création de l'unique instance de manager
        Manager.creerCategorie("DVD", true);
        Manager.creerProduit("DVD", 1, 25,"Star Wars V", 15);
        Manager.ajouterProduits(1, 9);
        Manager.creerCategorie("Livre", false);
        Manager.creerProduit("Livre", 2, 10,"Aerkaos",5);
        ArrayList<Produit> pOffre = new ArrayList<Produit>();
        pOffre.add(Manager.getMesProduits().get(0));
        Manager.creerOffre(pOffre, typeReduction.pourcentage, 50, typeOffre.adherent);

        Acheteur elian = new Acheteur("Elian","123");
        Adherent adherent = new Adherent();
        CarteFidelite carte = new CarteFidelite(20);
        ArrayList<CarteFidelite> cartesListe = new ArrayList<>();
        cartesListe.add(carte);
        adherent.setMesCartes(cartesListe);
        boolean connect = elian.seConnecter("Elian","123",adherent);
        System.out.println(connect);

        elian.getMonPanier().ajouterProduit(1);
        System.out.println(elian.getMonPanier().getMesProduits().get(0).toString());
        float prixTotal = elian.getMonPanier().calculerPrixTotal();
        System.out.println(prixTotal);

        elian.getMonPanier().payer(true);
        System.out.println(((Adherent)elian.getMonStatut()).getMesCartes().get(0).getPtFidel());
        elian.seDeconnecter();
    }
}