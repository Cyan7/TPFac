public interface Observable {
    public void ajouterObserver(Observer o);
    public void notifierObservers();
}
