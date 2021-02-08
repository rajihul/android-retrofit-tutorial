package edu.uci.swe264p.retrofit;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<Movie> mData;

    //Retrieved from the /Configuration API from TMDB for the purposes of Image
    //Base URL with w500 size
    String BASE_URL = "https://image.tmdb.org/t/p/w500";

    MovieListAdapter(List<Movie> data) {
        this.mData = data;
        //Log.d("LISTINFO", Integer.toString(mData.size()));
        //Log.println(Log.ASSERT, "LISTINFO", Integer.toString(mData.size()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //[RJ ADDED]
        TextView title, releaseDate, vote, overview;
        ImageView movie;

        ViewHolder(View itemView) {
            super(itemView);

            //[RJ ADDED]
            movie = itemView.findViewById(R.id.ivMovie);

            title = itemView.findViewById(R.id.tvTitle);
            releaseDate = itemView.findViewById(R.id.tvReleaseDate);
            vote = itemView.findViewById(R.id.tvVote);
            overview = itemView.findViewById(R.id.tvOverview);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie program = mData.get(position);

        //Download the image using Picasso.
        String posterURL = BASE_URL + program.getPosterPath();
        Picasso.get().load(posterURL).into(holder.movie);

        holder.title.setText(program.getTitle());
        holder.releaseDate.setText(program.getReleaseDate());
        holder.vote.setText(Float.toString(program.getVoteAverage()));
        holder.overview.setText(program.getOverview());




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
