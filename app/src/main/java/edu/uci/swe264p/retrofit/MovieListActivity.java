package edu.uci.swe264p.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    static final String TAG = MovieListActivity.class.getSimpleName();
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    static final String API_KEY = "4ac87555c3fc02d4c40a54d6e5c0485e";
    static final String Image_base_url = "https://image.tmdb.org/t/p/w500";

    static List<String> image_path = new ArrayList<>();
    static List<String> titles = new ArrayList<>();
    static List<String> releasedate = new ArrayList<>();
    static List<String> vote = new ArrayList<>();
    static List<String> overview = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        connect();

    }

    private  void setRecyclerView() {
        recyclerView  = findViewById(R.id.rvMovieList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MovieListAdapter(image_path, titles, releasedate, vote, overview));
    }

    private void connect() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MovieApiService movieApiService = retrofit.create(MovieApiService.class);
        Call<TopRatedResponse> TopRatedcall = movieApiService.getTopratedMovie(API_KEY);


        TopRatedcall.enqueue(new Callback<TopRatedResponse>() {
            @Override
            public void onResponse(Call<TopRatedResponse> TopRatedcall, Response<TopRatedResponse> response) {

                for(JsonObject i : response.body().getResult()){
                    vote.add(i.get("vote_average").getAsString());
                    titles.add(i.get("title").getAsString());
                    image_path.add(i.get("poster_path").getAsString());
                    releasedate.add(i.get("release_date").getAsString());
                    overview.add(i.get("overview").getAsString());
                }

                setRecyclerView();

            }

            @Override
            public void onFailure(Call<TopRatedResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

}
