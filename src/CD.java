public class CD extends Produit implements Offrable {

    private String artiste;

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    @Override
    public float getReduction() {
        //TODO
        return 0;
    }
}
