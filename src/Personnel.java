public class Personnel implements Statut {

    public Personnel() {
    }

    @Override
    public void changeStatut(Acheteur monAcheteur) {
        monAcheteur.setMonStatut(this);
    }
}
