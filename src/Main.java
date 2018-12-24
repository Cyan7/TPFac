
import java.util.ArrayList;

public class Main {
    public static void main(String [] args){

        // Création d'une situation ou les produits dispo en magasin sont 10 Star Wars V et 2 Aerkaos
        // On crée egalement une offre pour les adherents sur le produit d'id 1 (ici on se permet d'aller
        // le chercher en faisant get(0) des produits stockés dans le manager car on connait l'ordre de
        // remplissage mais normalement il faudrait le chercher à l'aide de son id).
        Manager.getInstance(); //création de l'unique instance de manager
        Manager.creerCategorie("DVD", true);
        Manager.creerProduit("DVD", 1, 25,"Star Wars V", 10);
        Manager.ajouterProduits(1, 9);
        Manager.creerCategorie("Livre", false);
        Manager.creerProduit("Livre", 2, 10,"Aerkaos",5);
        Manager.ajouterProduits(2, 1);
        ArrayList<Produit> pOffre = new ArrayList<Produit>();
        pOffre.add(Manager.getMesProduits().get(0));
        Manager.creerOffre(pOffre, typeReduction.pourcentage, 50, typeOffre.adherent);

        //test pour un adhérent
        Acheteur elian = new Acheteur("Elian","123");
        Adherent adherent = new Adherent();
        CarteFidelite carte = new CarteFidelite(20);
        ArrayList<CarteFidelite> cartesListe = new ArrayList<>();
        cartesListe.add(carte);
        adherent.setMesCartes(cartesListe);
        boolean connect = elian.seConnecter("Elian","123",adherent);
        System.out.println(connect);

        elian.getMonPanier().ajouterProduit(1);
        elian.getMonPanier().ajouterProduit(2);
        System.out.println(elian.getMonPanier().getMesProduits().get(0).toString());
        System.out.println(elian.getMonPanier().getMesProduits().get(1).toString());
        float prixTotal = elian.getMonPanier().calculerPrixTotal();
        System.out.println(prixTotal);

        System.out.println("Taille avant achat : " + Manager.getMesProduits().size());

        elian.getMonPanier().payer(true);
        System.out.println("Taille après achat : " + Manager.getMesProduits().size());
        System.out.println("Points de fidélité : " + ((Adherent)elian.getMonStatut()).getMesCartes().get(0).getPtFidel());
        elian.seDeconnecter();

        //test pour un client
        Acheteur mathilde = new Acheteur("Mathilde","123");
        Client client = new Client();
        //échec de connexion car mauvais identifiant
        connect = mathilde.seConnecter("Elian","123",client);
        System.out.println("Connexion réalisée : "+connect);
        //échec de connexion car mauvais statut
        connect = mathilde.seConnecter("Mathilde","123",client);
        System.out.println("Connexion réalisée : "+connect);
        mathilde.getMonPanier().ajouterProduit(1);
        //échec du paiement car un client ne peut utiliser de pts de fidélité puisqu'il n'en a pas
        mathilde.getMonPanier().payer(true);
        //succès du paiement
        mathilde.getMonPanier().payer(false);
        //échec de la déconnexion car le client n'est pas connecté
        connect = mathilde.seDeconnecter();
        System.out.println("Déconnexion réalisée : "+connect);


        //Création des Observers
        PrixObserver obs1 = new PrixObserver(20);
        ProduitObserver obs2 = new ProduitObserver(Manager.getMesProduits().get(7));
        CombinaisonProduitObserver obs3 = new CombinaisonProduitObserver(Manager.getMesCategories().get(1),1);

        //test pour un membre du personnel
        Personnel personnel = new Personnel();
        connect = mathilde.seConnecter("Mathilde","123",personnel);
        System.out.println("Connexion réalisée : "+connect);
        mathilde.getMonPanier().ajouterObserver(obs1);
        mathilde.getMonPanier().ajouterObserver(obs2);
        mathilde.getMonPanier().ajouterObserver(obs3);
        //échec de l'ajout car l'id de ce produit n'existe pas
        mathilde.getMonPanier().ajouterProduit(100);
        //succès de l'ajout
        mathilde.getMonPanier().ajouterProduit(1);
        mathilde.getMonPanier().ajouterProduit(2);
        //mathilde.getMonPanier().ajouterProduit(9);
        mathilde.getMonPanier().payer(false);
    }
}