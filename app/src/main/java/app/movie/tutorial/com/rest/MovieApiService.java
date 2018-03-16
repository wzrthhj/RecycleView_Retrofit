package app.movie.tutorial.com.rest;

import app.movie.tutorial.com.model.JsonEntry;
import app.movie.tutorial.com.model.PhotosResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Call;
import app.movie.tutorial.com.model.MovieResponse;

/**
 * Created by Gino Osahon on 13/03/2017.
 */
public interface MovieApiService {
//http://api.themoviedb.org/3/movie/top_rated?api_key=ef4dac9ea4c9fa12b32a2bb1af50bb7b
    @GET("? method=flickr.photos.search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsonca llback=1&text=kittens")
    Call<JsonEntry> getPhotos();

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
