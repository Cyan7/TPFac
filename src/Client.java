public class Client implements Statut {

    public Client() {
    }

    @Override
    public void changeStatut(Acheteur monAcheteur) {
        monAcheteur.setMonStatut(this);
    }
}
