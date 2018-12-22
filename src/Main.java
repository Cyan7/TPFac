import java.util.ArrayList;

public class Main {
    public static void main(String [] args){

        Manager ourInstance = Manager.getInstance();
        Produit p1 = new Produit(1,"Aerkaos",10,14.32f,false);
        ourInstance.getMesProduits().add(p1);

        Acheteur elian = new Acheteur("Elian","123");
        Adherent adherent = new Adherent();
        CarteFidelite carte = new CarteFidelite(20);
        ArrayList<CarteFidelite> cartesListe = new ArrayList<>();
        cartesListe.add(carte);
        adherent.setMesCartes(cartesListe);
        boolean connect = elian.seConnecter("Elian","123",adherent);
        System.out.println(connect);

        elian.getMonPanier().ajouterProduit(1);
        float prixTotal = elian.getMonPanier().calculerPrixTotal();
        System.out.println(prixTotal);

        elian.getMonPanier().payer(true);
        System.out.println(((Adherent)elian.getMonStatut()).getMesCartes().get(0).getPtFidel());
        elian.seDeconnecter();
    }
}
