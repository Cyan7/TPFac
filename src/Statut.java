public interface Statut {
    public void changeStatut(Acheteur monAcheteur);
    public void payer(boolean utiliserPtFidel, float prixTotal) throws ErreurPaiement;
}
