public class WayFinder{
    CountryMap map;

    public WayFinder(CountryMap map) {

        this.map = map;
    }

    public String findFastestWay(String start, String end) {
        if (getIndex(start) == -1 || getIndex(end) == -1) {
            System.out.println("Invalid start or end city.");
            return null;
        }

        int numCities = map.getCities().length;
        int[] distances = new int[numCities];
        boolean[] visited = new boolean[numCities];
        String[] previousWay = new String[numCities];


        for (int i = 0; i < numCities; i++) {
            distances[i] = Integer.MAX_VALUE;
            visited[i] = false;
            previousWay[i] = null;
        }
        distances[getIndex(start)] = 0;


        for (int i = 0; i < numCities; i++) {
            int currentIndex = getMinimumDistanceIndex(distances, visited);
            if (currentIndex == -1) break;

            visited[currentIndex] = true;

            String[] routes = map.getRoutes(map.getCities()[currentIndex].getName());
            if (routes == null || routes.length == 0) continue; // Rota yoksa geç

            for (String route : routes) {
                if (route == null) continue;

                String[] parts = route.split(" ");
                int neighborIndex = getIndex(parts[0]);
                int time = Integer.parseInt(parts[1]);


                if (!visited[neighborIndex] && distances[currentIndex] != Integer.MAX_VALUE &&
                        distances[currentIndex] + time < distances[neighborIndex]) {
                    distances[neighborIndex] = distances[currentIndex] + time;
                    previousWay[neighborIndex] = map.getCities()[currentIndex].getName();
                }
            }
        }


        if (distances[getIndex(end)] == Integer.MAX_VALUE) {
            System.out.println("No possible route from " + start + " to " + end+" ");;
            return null;
        }


        String path = end;
        String timeEnd = end;
        while (previousWay[getIndex(end)] != null) {
            path = previousWay[getIndex(end)] + "->" + path;
            end = previousWay[getIndex(end)];
        }

        return "Fastest Way: " + path + "\nTotal Time: " + distances[getIndex(timeEnd)]+" min";
    }

    private int getMinimumDistanceIndex(int[] distances, boolean[] visited) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minValue) {
                minValue = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int getIndex(String city) {
        for (int i = 0; i < map.getCities().length; i++) {
            if (map.getCities()[i].getName().equals(city)) {
                return i;
            }
        }
        return -1;
    }
}
