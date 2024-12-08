public class CountryMap {
    private City[] cities;
    private String[][] routes;
    public CountryMap(City[] cities, String[][] routes) {
        this.cities = cities;
        this.routes = routes;
    }
    public City[] getCities() {
        return cities;
    }
    public String[][] getRoutes() {
        return routes;
    }
    public String[] getRoutes(String city) {
        String[]cityRoutes = new String[routes.length];
        int index=0;
        for(String[] route : routes) {
            if(route[0].equals(city)) {
                cityRoutes[index] = route[1]+" "+route[2];
                index++;
            }
        }
        return cityRoutes;
    }


}