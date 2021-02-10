package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder>{
    private List<String> imageData;
    private List<String> titleData;
    private List<String> dateData;
    private List<String> voteData;
    private List<String> overviewData;

    private static final String image_base_url = "https://image.tmdb.org/t/p/w500";

    MovieListAdapter(List<String> iData, List<String> tData, List<String> dData, List<String> vData, List<String> oData) {
        this.imageData = iData;
        this.titleData = tData;
        this.dateData = dData;
        this.voteData = vData;
        this.overviewData = oData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tvTitle;
        TextView tvDate;
        TextView tvVote;
        TextView tvOverveiw;

        ViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.ivMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvReleaseDate);
            tvVote = itemView.findViewById(R.id.tvVote);
            tvOverveiw = itemView.findViewById(R.id.tvOverview);
        }
    }

    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new MovieListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.ViewHolder holder, int position) {
        String image_url = image_base_url + imageData.get(position);
        String title = titleData.get(position);
        String date = dateData.get(position);
        String vote = voteData.get(position);
        String overview = overviewData.get(position);

        Picasso.get().load(image_url).into(holder.iv);
        holder.tvTitle.setText(title);
        holder.tvDate.setText(date);
        holder.tvVote.setText(vote);
        holder.tvOverveiw.setText(overview);
    }

    @Override
    public int getItemCount() {
        return titleData.size();
    }
}
