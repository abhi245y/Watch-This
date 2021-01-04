package com.abhi245y.watchthis.RecyclerviewAdaptors;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi245y.watchthis.Extra.EndlessRecyclerViewScrollListener;
import com.abhi245y.watchthis.Extra.MovieItemClickListener;
import com.abhi245y.watchthis.Models.HomeHorizontalListModel;
import com.abhi245y.watchthis.Models.HomeVerticalListModel;
import com.abhi245y.watchthis.Models.SimilarMoviesListModel;
import com.abhi245y.watchthis.R;
import com.abhi245y.watchthis.ui.MainActivity;
import com.abhi245y.watchthis.ui.MovieCardActivity;

import java.util.ArrayList;
import java.util.Map;

import static com.abhi245y.watchthis.Extra.Constants.getServices;

public class HomeRecyclerviewAdaptor extends RecyclerView.Adapter<HomeRecyclerviewAdaptor.ViewHolder> implements MovieItemClickListener {

    Context context;
    ArrayList<HomeVerticalListModel> homeVerticalListModels;
    MainActivity mainActivity;
    EndlessRecyclerViewScrollListener scrollListener;

    public HomeRecyclerviewAdaptor(Context context, ArrayList<HomeVerticalListModel> homeVerticalListModels, MainActivity mainActivity) {
        this.context = context;
        this.homeVerticalListModels = homeVerticalListModels;
        notifyDataSetChanged();
        this.mainActivity = mainActivity;
    }

    public HomeRecyclerviewAdaptor(Context context, ArrayList<HomeVerticalListModel> homeVerticalListModels) {
        this.context = context;
        this.homeVerticalListModels = homeVerticalListModels;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recylerview_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeVerticalListModel verticalListModel = homeVerticalListModels.get(position);


        for (Map.Entry services: getServices().entrySet()) {
            if (services.getKey().equals(verticalListModel.getService_code())) {
                holder.service_name.setText(services.getValue().toString());
                Log.d("Adaptor", "Vertical: " + services.getValue().toString());
            }
        }

        ArrayList<HomeHorizontalListModel> singleMovieInfo =verticalListModel.getHorizontalListModel();

        holder.movie_list_view.setHasFixedSize(true);
        holder.movie_list_view.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        HomeHorizontalViewAdaptor homeHorizontalViewAdaptor = new HomeHorizontalViewAdaptor(context,singleMovieInfo,this);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) holder.movie_list_view.getLayoutManager();
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d("MainActivity","Page in Load More: "+page);
                loadNextDataFromApi(page, verticalListModel,homeHorizontalViewAdaptor,singleMovieInfo);
            }
        };
        holder.movie_list_view.addOnScrollListener(scrollListener);
        holder.movie_list_view.setAdapter(homeHorizontalViewAdaptor);

    }

    private void loadNextDataFromApi(int page, HomeVerticalListModel verticalListModel, HomeHorizontalViewAdaptor homeHorizontalViewAdaptor, ArrayList<HomeHorizontalListModel> singleMovieInfo) {
        switch (verticalListModel.getService_code()) {
            case 1:
//                mainActivity.getYTS(verticalListModel, page, homeHorizontalViewAdaptor, singleMovieInfo, 30);
                break;
            case 2:
                mainActivity.getJustWatch(verticalListModel, page, homeHorizontalViewAdaptor, singleMovieInfo, 30);
                break;
            case 3:
//                mainActivity.getTMDb(tmDbService, verticalListModel, page, homeHorizontalViewAdaptor, singleMovieInfo, 30);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return homeVerticalListModels.size();
    }

    @Override
    public void onMovieClick(HomeHorizontalListModel movie_details, ImageView movieImage) {
        Intent intent = new Intent(context, MovieCardActivity.class);
        intent.putExtra("movie_name",movie_details.getTitle_name());
        intent.putExtra("poster_url", movie_details.getPoster_url());
        intent.putExtra("release_year",movie_details.getRelease_year() );
        intent.putExtra("rating",movie_details.getRating());
        Toast.makeText(context, "Clicked On "+movie_details.getTitle_name(), Toast.LENGTH_SHORT).show();

        ActivityOptions options =ActivityOptions.makeSceneTransitionAnimation(mainActivity,movieImage,"movieCardAnimation");
        context.startActivity(intent,options.toBundle());
    }

    @Override
    public void onSimilarMovieClick(SimilarMoviesListModel movie_details, ImageView movieImage) {

    }


    @Override
    public void AddMovieToList(ImageView favIcon,boolean isClicked) {
       if (isClicked){
           favIcon.setImageResource(R.drawable.added_to_fav);
           Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show();
       }else{
           favIcon.setImageResource(R.drawable.ic_baseline_favorite_24);
           Toast.makeText(context, "Removed", Toast.LENGTH_SHORT).show();
       }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView service_name;
        RecyclerView movie_list_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            service_name = itemView.findViewById(R.id.gener);
            movie_list_view = itemView.findViewById(R.id.movie_list);
        }
    }
}
