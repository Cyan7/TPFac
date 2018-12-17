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
}
