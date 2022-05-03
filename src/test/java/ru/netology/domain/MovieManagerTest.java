package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    @org.junit.jupiter.api.Test
    void shouldAddFirstMovie() {
        MovieManager manager = new MovieManager();
        String movie1 = "Boss-molokosos";
        manager.addMovie(movie1);

        String[] expected = {"Boss-molokosos"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldAddAnyMovies() {
        MovieManager manager = new MovieManager();
        String movie1 = "Zvezda rodilas";
        String movie2 = "I Robot";
        manager.addMovie(movie1);
        manager.addMovie(movie2);

        String[] expected = {"Zvezda rodilas", "I Robot"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldFindAllIfEmpty() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldFindAllIfExist() {
        MovieManager manager = new MovieManager();
        manager.addMovie("I Robot");
        manager.addMovie("Lord of rings");

        String[] expected = {"I Robot", "Lord of rings"};
        String[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldShowLastIfMoviesLengthLessThenLimitLast() {
        MovieManager manager = new MovieManager();
        manager.addMovie("I Robot");
        manager.addMovie("Lord of rings");
        manager.addMovie("Boss-molokosos");

        String[] expected = {"Boss-molokosos", "Lord of rings", "I Robot"};
        String[] actual = manager.showLast();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldShowLastIfMoviesLengthMoreThenLimitLast() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("I Robot");
        manager.addMovie("Lord of rings");
        manager.addMovie("Boss-molokosos");
        manager.addMovie("The star is born");
        manager.addMovie("Cars");
        manager.addMovie("Cars-2");
        manager.addMovie("Cars-3");
        manager.addMovie("Shrek");
        manager.addMovie("Shrek-2");
        manager.addMovie("Shrek-3");
        manager.addMovie("Flick");

        String[] expected = {
                "Flick",
                "Shrek-3",
                "Shrek-2",
                "Shrek",
                "Cars-3"
        };
        String[] actual = manager.showLast();

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldShowLastIfMoviesLengthEqualLimitLast() {
        MovieManager manager = new MovieManager(9);
        manager.addMovie("Lord of rings");
        manager.addMovie("Boss-molokosos");
        manager.addMovie("The star is born");
        manager.addMovie("Cars");
        manager.addMovie("Cars-2");
        manager.addMovie("Cars-3");
        manager.addMovie("Shrek");
        manager.addMovie("Shrek-2");
        manager.addMovie("Shrek-3");

        String[] expected = {
                "Shrek-3",
                "Shrek-2",
                "Shrek",
                "Cars-3",
                "Cars-2",
                "Cars",
                "The star is born",
                "Boss-molokosos",
                "Lord of rings",
        };
        String[] actual = manager.showLast();

        assertArrayEquals(expected, actual);
    }
}