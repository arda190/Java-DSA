public class CountryMap {
    private int countryCount=0;
    private City[] city;
    private int komsuSayısı;
    public CountryMap(int countryCount) {
        this.city=new City[countryCount];
        this.countryCount=countryCount;
        this.komsuSayısı=0;
    }
    public void addCity(City myCity) {
        city[komsuSayısı]=myCity;
        komsuSayısı++;
    }
    public City[] getCity() {
        return city;
    }


}