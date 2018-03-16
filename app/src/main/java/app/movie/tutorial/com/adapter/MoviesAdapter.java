package app.movie.tutorial.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.movie.tutorial.com.R;
import app.movie.tutorial.com.model.Movie;


/**
 * Created by Gino Osahon on 14/03/2017.
 */
public class MoviesAdapter<T> extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private String TAG = "MoviesAdapter";
    private List<T> movies;
//    private List<Photo> movies;
    private int rowLayout;
    private Context context;
    public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";

    public MoviesAdapter(List<T> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    //A view holder inner class where we get reference to the views in the layout using their ID

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;

        ImageView movieImage;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);
        }
    }


    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
//        String formatBase = "http://farm%d.static.flickr.com/%s/%s_%s.jpg";
//        Photo photo = movies.get(position);
//        String photoURL = String.format(formatBase, photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret());
//        static Bar<T> createBar(Class<T> clazz) {
//            if (clazz==String.class) {
//
//            }

        String image_url = IMAGE_URL_BASE_PATH + ((Movie)movies.get(position)).getPosterPath();
//        Log.d(TAG, "position = " + position + ", " +image_url);
        Picasso.with(context)
                .load(image_url)
//                .load(photoURL)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.movieImage);

//        holder.movieTitle.setText(movies.get(position).getTitle());
//        holder.data.setText(movies.get(position).getReleaseDate());
//        holder.movieDescription.setText(movies.get(position).getOverview());
//        holder.rating.setText(movies.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
