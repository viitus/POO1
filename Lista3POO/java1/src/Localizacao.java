public class Localizacao {
    private int idAnimal;
    private double latitude;
    private double longitude;

    public Localizacao(int idAnimal, double latitude, double longitude) {
        this.idAnimal = idAnimal;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //getters e setters
    public int getIdAnimal() {
        return idAnimal;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "[Latitude: " + latitude + ", Longitude: " + longitude + "]";
    }
}
