import java.util.*;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int width = image.length;
        int height = image[0].length;

        int ogColor = image[sr][sc];
        List<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        queue.add(new Pair(sr,sc));
        while (!queue.isEmpty()) {
            Pair pair = queue.remove(0);
            System.out.println(pair);
            if (image[pair.first][pair.second] == ogColor) {
                System.out.println(String.format("%s is matching color %s",pair,ogColor));
                image[pair.first][pair.second] = newColor;
                List<Pair> toAdd = new ArrayList<>();
                if (pair.first+1 < width) {
                    toAdd.add(new Pair(pair.first+1,pair.second));
                }
                if (pair.first-1 >= 0) {
                    toAdd.add(new Pair(pair.first-1,pair.second));
                }
                if (pair.second+1 < height) {
                    toAdd.add(new Pair(pair.first,pair.second+1));
                }
                if (pair.second-1 >= 0) {
                    toAdd.add(new Pair(pair.first,pair.second-1));
                }
                toAdd.stream().filter(p -> !visited.contains(pair)).forEach(p -> {
                    visited.add(p);
                    queue.add(p);
                });
            }
        }
        return image;
    }

    class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int hashCode() {
            return Objects.hash(first,second);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}
