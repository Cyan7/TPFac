public class DVD extends Produit implements Offrable {

    private String realisateur;

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public float getReduction() {
        //TODO
        return 0;
    }
}
