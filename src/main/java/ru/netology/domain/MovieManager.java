package ru.netology.domain;

public class MovieManager {
    int limitLast = 10;
    public String movie;
    public String[] movies = new String[0];

    public MovieManager(int limitLast) {
        this.limitLast = limitLast;
    }

    public MovieManager() {
    }

    public void addMovie(String movie) {
        int length = movies.length + 1;
        String[] tmp = new String[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] showLast() {
        int resultLength;
        String[] movies = findAll();
        if (movies.length < this.limitLast) {
            resultLength = movies.length;
        } else {
            resultLength = this.limitLast;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;
    }
}