package com.example.triviaapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaapp.Models.GameData;
import com.example.triviaapp.R;
import com.example.triviaapp.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GameData> gameDataList;
    private Activity mactivity;

    public HistoryRvAdapter(Activity activity) {
        this.gameDataList = new ArrayList<>();
        mactivity=activity;

    }

    public void update(List<GameData> gameDataList){
        this.gameDataList.clear();
        this.gameDataList.addAll(gameDataList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row, parent, false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof RvViewHolder) {
            ((RvViewHolder) holder).bind(gameDataList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return gameDataList.size();
    }


    class RvViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_date)
        TextView txtdate;
        @BindView(R.id.tv_name)
        TextView txtname;
        @BindView(R.id.tv_answerone)
        TextView txtanswerone;
        @BindView(R.id.tv_answertwo)
        TextView txtanswertwo;

        public RvViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final GameData gamedata) {

            String startdate_time = null;
            if(gamedata.getDateandTime()!=null){
                startdate_time= Utils.getOnlyDateString(gamedata.getDateandTime())+" - "+Utils.getOnlyTimeString(gamedata.getDateandTime());
            }else {
                startdate_time="";
            }
            txtdate.setText("Game :"+startdate_time);
            txtname.setText(gamedata.getName()==null?"":"Name : "+gamedata.getName());
            txtanswerone.setText(gamedata.getAnswerOne()==null?"":"Answer : "+gamedata.getAnswerOne());
            txtanswertwo.setText(gamedata.getAnswerTwo()==null?"":"Answer : "+gamedata.getAnswerTwo());

        }
    }
}
