public class CountryMap {
    City[] cities;
    String[][] routes;
    int routeNumber;
    public CountryMap(City[] cities,String[][] routes,int routeNumber) {
        this.cities = new City[cities.length];
        for(int i = 0; i < cities.length; i++){
            this.cities[i] = cities[i];
        }
        this.routes=new String[routes.length][3];
        for(int i = 0; i < routes.length; i++){
            this.routes[i]=routes[i];
        }
        this.routeNumber=routeNumber;
    }
    public City[] getCities() {

        return cities;
    }
    public String[] getRoutes(String name) {
        int count = 0;
        for (int i = 0; i < routeNumber; i++) {
            if(routes[i][0]!=null && routes[i][1]!=null) {
                if (routes[i][0].equals(name) || routes[i][1].equals(name)) {
                    count++;
                }
            }
        }
        String[] route = new String[count];
        int index = 0;
        for (int i = 0; i <routeNumber ; i++) {
            if(routes[i][0]!=null && routes[i][1]!=null){
                if (routes[i][0].equals(name)) {
                    route[index] = routes[i][1] + " " + routes[i][2];
                    index++;
                } else if (routes[i][1].equals(name)) {
                    route[index] = routes[i][0] + " " + routes[i][2];
                    index++;
                }
            }
        }
        return route;
    }
}
