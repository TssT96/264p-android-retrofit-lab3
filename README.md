# android-retrofit-tutorial 264p Lab 3

This tutorial/lab aims to provide hands-on experience of building an Android app that retrieves and displays data with REST API. We will first introduce how to:

1. Use [Retrofit](https://square.github.io/retrofit/) to retrieve data of single movie from [The Movie DB](https://www.themoviedb.org/) and display the data in an Activity.
2. Use [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) to display a list of textual data

You will then be asked to modify the provided classes to show a list of top-rated movies, as illustrated below.


![lab3-resized](lab3-resized.gif)

## Lab: Complete the Provided Classes to Display Top-rated Movies

This lab asks you to display top-rated movies in `MovieListActivity`. The data can be retrieved from here:

https://api.themoviedb.org/3/movie/top_rated?api_key=YOUR_API_KEY

You have to display the 20 movies in the results returned by the above REST API.

All required class and layout files are provided in the project. Specifically, you have to modify the following four files:

* `MovieApiService.java`: add one more method for the above API
* `TopRatedResponse.java`: implement it as the `Movie` class
* `MovieListAdapter.java`: implement it as the `ProgramListAdadpter` class
* `MovieListActivity.java`: implement it as the `ProgramListActivity` class

Besides, you need to check `movie_row.xml` to know where to place the data when you modify `MovieListAdapter`. Note that, `movie_row.xml` contains a `ImageView` field for displaying the poster of a movie. The poster image can be retrieved with the following URL (refer to [here](https://developers.themoviedb.org/3/getting-started/images)):

https://image.tmdb.org/t/p/w500/POSTER_PATH

You also need to use [Picasso](https://square.github.io/picasso/) to download the poster image from the above URL and put it into the `ImageView` in your `MovieListAdapter`. 

## To run the app on android studio
1. Download android studio
2. import project from file directory
3. replace API_KEY from "api key" to your api key in MainActivity
4. run on the android emulator
