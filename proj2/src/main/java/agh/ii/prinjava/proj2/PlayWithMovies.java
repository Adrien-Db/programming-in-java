package agh.ii.prinjava.proj2;
import agh.ii.prinjava.proj2.dal.ImdbTop250;
import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.utils.Utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;
interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     * we initialize a List movie_director which will contain at the end all movie title directed by the given director
     *
     */
    static List<String> ex01(String director) {
        final Optional<List<Movie>> my_movies = ImdbTop250.movies();
        List<String> movie_director = my_movies.orElseThrow().stream()
                .filter(movie -> movie.directors().contains(director))
                .map(Movie::title)
                .collect(Collectors.toList());
        return movie_director;
    }

    /**
     * Returns the movies (only titles) in which an actor played
     * it's the same as the exercice1 but with the actors
     */
    static List<String> ex02(String actor) {
        final Optional<List<Movie>> my_movies = ImdbTop250.movies();
        List<String> actors_list=my_movies.orElseThrow().stream()
                .filter(movie -> movie.actors().contains(actor))
                .map(Movie::title)
                .collect(Collectors.toList());
        return actors_list;

    }

    /**
     * Returns the number of movies per director (as a map)
     *
     * we will use the function oneToManyByDirector
     * we unify the list of director and movie with the flatmap
     * then, we groupe our movie director ( movie -> movie.directors ) and we count them
     */
    static Map<String, Long> ex03() {
        final Optional<List<Movie>> my_movies = ImdbTop250.movies();
        Map<String,Long> list_number_movies = my_movies.orElseThrow().stream()
                .map(Utils::oneToManyByDirector)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(movie -> movie.directors().get(0),Collectors.counting()));
        return list_number_movies;

    }
    /**
     * Returns the 10 directors with the most films on the list
     * we will need the previous function to get the list of directors and movies
     * next, we sorted the list comparing director value between them, then we take the top 10
     * we inverse director1 and director2 because we want a list for the bigger value to the smallest
     * so we put director2,director1 to inverse the sorted
     */
    static List<Map.Entry<String,Long>> ex04() {
        Map <String,Long> best_director;
        best_director = ex03();
        return best_director.entrySet().stream()
                .sorted((director2,director1) -> Long.compare(director1.getValue(),director2.getValue()))
                .limit(10)
                .toList();
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     * i think this exercice needed fonction 1 and 4 but i couldn't manage how to run it
     */
    static Map<String, Set<String>> ex05() {
        /*List<Map.Entry<String,Long>> best_director_movie;
        best_director_movie = ex04();
        best_director_movie.stream()
                .map(director->ex01(director.getKey()))
                .toList();

        return best_director_movie;*/
        throw new RuntimeException("ex06 is not implemented!");

    }

    /**
     * Returns the number of movies per actor (as a map)
     * same as the function 3 but now, we are using oneToManyActors function
     * flatmap : we unify the list, we take only the actors and we count how many movie they have made
     */
    static Map<String, Long> ex06() {
        final Optional<List<Movie>> my_movies = ImdbTop250.movies();
        Map<String,Long> list_movie_per_actor = my_movies.orElseThrow().stream()
                .map(Utils::oneToManyByActor)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(movie -> movie.actors().get(0),Collectors.counting()));
        return list_movie_per_actor;
    }

    /**
     * Returns the 9 actors with the most films on the list
     * we need the previous function to do that
     * we call function 6, we sorted started from the top part and limit to 9
     */
    static List<Map.Entry<String,Long>> ex07() {
        Map <String,Long> best_actors;
        best_actors = ex06();
        return best_actors.entrySet().stream()
                .sorted((actors2,actors1) -> Long.compare(actors1.getValue(),actors2.getValue()))
                .limit(9)
                .toList();


    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     * i have the same problem as the exercice 5
     */
    static Map<String, Set<String>> ex08() {
        throw new RuntimeException("ex08 is not implemented!");
    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     * first, we call the function oneTo...ActorDuo and we unify the list as usual.
     * First, we will need to count all the actor duo and then we will be able to sorted it.
     */
    static Map<String, Long> ex09() {
        final Optional<List<Movie>> my_movies = ImdbTop250.movies();
        Map<String,Long> list_duo = my_movies.orElseThrow().stream()
                .map(Utils::oneToManyByActorDuo)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(movie -> movie.actors().get(0),Collectors.counting()));
        list_duo.entrySet().stream()
                .sorted((actors2,actors1)->Long.compare(actors1.getValue(),actors2.getValue()))
                .limit(5)
                .toList();
        return list_duo;
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {
        throw new RuntimeException("ex10 is not implemented!");
    }
}

