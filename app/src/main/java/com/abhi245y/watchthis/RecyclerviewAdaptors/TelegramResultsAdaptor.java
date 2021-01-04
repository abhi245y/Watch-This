package com.abhi245y.watchthis.RecyclerviewAdaptors;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi245y.watchthis.Models.TelegramResultsModel;
import com.abhi245y.watchthis.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class TelegramResultsAdaptor extends RecyclerView.Adapter<TelegramResultsAdaptor.ViewHolder>  {

    ArrayList<TelegramResultsModel> telegramResultsModels;
    Context context;

    public TelegramResultsAdaptor(ArrayList<TelegramResultsModel> telegramResultsModels, Context context) {
        this.telegramResultsModels = telegramResultsModels;
        this.context = context;
    }

    private static float roundFloat(float f, int places) {

        BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        }
        catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.telegram_list_model,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TelegramResultsModel telegramResultsModel = telegramResultsModels.get(position);

        if (telegramResultsModel.getLink()!=null) {
            Log.d("SearchShows","Getting Size: "+telegramResultsModel.getSize());
            int size_bytes = telegramResultsModel.getSize();
            Log.d("SearchShows","Size in bytes: "+size_bytes);
            String cnt_size;
            float size_kb =roundFloat((size_bytes /1024), 2);
            Log.d("SearchShows","Size in KB: "+size_kb);
            float size_mb =roundFloat((size_kb /1024), 2);
            Log.d("SearchShows","Size in MB: "+size_mb);
            float size_gb =roundFloat((size_mb /1024), 2);
            Log.d("SearchShows","Size in GB: "+size_gb);


            if (size_mb < 1) {
                cnt_size = size_kb + " KB";
                Log.d("SearchShows","KB MB: "+cnt_size);
            }else if (size_gb < 1){
                cnt_size = size_mb + " MB";
                Log.d("SearchShows","Taken MB: "+cnt_size);
            }else {
                cnt_size = size_gb + " GB";
                Log.d("SearchShows","Taken GB: "+cnt_size);
            }

            holder.file_size.setText(cnt_size);
            holder.file_name.setText(telegramResultsModel.getFile_name());
            holder.caption.setText(telegramResultsModel.getCaption());
            String perma_link_id = telegramResultsModel.getLink().replace("https://t.me/pmudbdeivomargeletmoviedbdumppmu/", "");
            Log.d("SearchShows","perma_link_id: "+perma_link_id);
            Uri download_link = Uri.parse("https://mirrorstream.herokuapp.com/TGMoviesBot/"+perma_link_id+"/download");

            holder.open_tg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String service_link = telegramResultsModel.getLink();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(service_link));
                    context.startActivity(intent);
                }
            });

            holder.stream_now.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean vlcFound = isAppInstalled(context, "org.videolan.vlc");

                    if (vlcFound) {
                        Intent vlcIntent = new Intent(Intent.ACTION_VIEW);
                        vlcIntent.setPackage("org.videolan.vlc");
                        vlcIntent.setDataAndTypeAndNormalize(download_link, "video/*");
                        vlcIntent.putExtra("title", telegramResultsModel.getFile_name());
                        vlcIntent.putExtra("from_start", true);
                        vlcIntent.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
                        context.startActivity(vlcIntent);
                    }else {
                        Toast.makeText(context, "To stream movie please install vlc media player", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=org.videolan.vlc"));
                        context.startActivity(intent);
                    }
                }
            });

            holder.direct_download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(download_link);
                    context.startActivity(intent);
                }
            });

            holder.share_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(Intent.ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareBody = String.valueOf(download_link);
                    String shareSub = "Download link for: "+telegramResultsModel.getFile_name();
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    context.startActivity(Intent.createChooser(myIntent, "Share using"));
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return telegramResultsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView file_name,file_size,caption;
        Button stream_now,direct_download,open_tg,share_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            file_name = itemView.findViewById(R.id.file_name);
            file_size = itemView.findViewById(R.id.file_size);
            caption = itemView.findViewById(R.id.caption);

            stream_now = itemView.findViewById(R.id.stream_btn);
            direct_download = itemView.findViewById(R.id.direct_download);
            open_tg = itemView.findViewById(R.id.open_tg);
            share_btn = itemView.findViewById(R.id.share_btn);
        }
    }
}
