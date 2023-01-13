public class MovieOrdering {
    public static void main(String[] args) {
        Movie a = new Movie("Squid Game", "Thriller", 7.6, 120);
        Movie b = new Movie("Spider-Man", "Action", 8.5, 110);
        Movie c = new Movie("The Matrix Resurrections", "Action", 6.2, 140);
        MovieOrdering mo = new MovieOrdering();
        mo.addMovie(a);
        mo.addMovie(b);
        mo.addMovie(c);
        System.out.println(mo.currentJoyfulness()); // return 230
        System.out.println(mo.maxJoyfulness());
        System.out.println(mo.currentJoyfulness());
    }

    static int mostNumOfMovies = 9;
    static Movie[] movies = new Movie[mostNumOfMovies];
    int currentIdx = 0;

    // addMovie complexity = O(1)
    public void addMovie(Movie m) {
        movies[currentIdx++] = m;
    }

    // currentJoyfulness complexity = O(N)
    public int currentJoyfulness() {
        int currentJoy = 0;
        if (movies[0] != null) {
            currentJoy += movies[0].duration;
        }

        for (int i = 1; i < currentIdx; i++) {
            if (movies[i] != null) {
                if (!movies[i].genre.equals(movies[i - 1].genre) && movies[i].rating > movies[i - 1].rating) {
                    currentJoy += movies[i].duration;
                }
            }
        }

        return currentJoy;
    }

    private int permute(int[] input, boolean[] taken, int[] current, int idx, int max) {
        if (idx == input.length) {
            return process(current, max);
        }

        for (int i = 0; i < input.length; i++) {
            if (taken[i]) {
                continue;
            }
            current[idx] = input[i];
            taken[i] = true;
            max = permute(input, taken, current, idx + 1, max);
            taken[i] = false;
        }

        return max;
    }

    private int process(int[] permutation, int max) {
        int currentJoy = 0;
        if (movies[permutation[0]] != null) {
            currentJoy += movies[permutation[0]].duration;
        }

        for (int i = 1; i < permutation.length; i++) {
            int currentMovieIdx = permutation[i];
            int prevMovieIdx = permutation[i - 1];
            if (movies[currentMovieIdx] != null) {
                if (!movies[currentMovieIdx].genre.equals(movies[prevMovieIdx].genre) && movies[currentMovieIdx].rating > movies[prevMovieIdx].rating) {
                    currentJoy += movies[currentMovieIdx].duration;
                }
            }
        }

        if (currentJoy > max) {
            max = currentJoy;
        }

        return max;
    }

    // maxJoyfulness complexity = O(N!)
    public int maxJoyfulness() {
        int[] input = new int[currentIdx];
        for (int i = 0; i < currentIdx; i++) {
            input[i] = i;
        }

        int[] current = {0, 0, 0};
        boolean[] taken = {false, false, false};

        int maxJoy = Integer.MIN_VALUE;
        return permute(input, taken, current, 0, maxJoy);
    }

    public static class Movie {
        String title;
        String genre;
        double rating;
        int duration;

        public Movie(String title, String genre, double rating, int duration) {
            this.title = title;
            this.genre = genre;
            this.rating = rating;
            this.duration = duration;
        }
    }
}