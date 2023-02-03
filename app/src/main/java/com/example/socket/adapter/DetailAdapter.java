package com.example.socket.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.alibaba.fastjson.JSONObject;
import com.example.socket.Activity.TalkActivity;
import com.example.socket.Bean.Pocket;
import com.example.socket.R;
import com.example.socket.app.MyApp;
import com.example.socket.database.DiaoDan;
import com.example.socket.database.DiaoDanDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private Context context;
    private String detailsDan;
    private String gouTotal;
    private String current_time;
    //声明自定义的监听接口
    private String gou;
    private boolean aaa = false;
    private String diaodan;
    private List<Integer> xianList = new ArrayList<>();

    public void setMsg(List<String> msg, String gou_namber, String detailsDan, String gouTotal, String current_time) {
        this.list = msg;
        this.gou = gou_namber;
        this.detailsDan = detailsDan;
        this.gouTotal = gouTotal;
        this.current_time = current_time;
        aaa = false;
        Log.e("撤回销钩撤回销钩", "" + gou);
    }

    DiaoDanDatabase db = null;

    public DetailAdapter(Context context, List<String> list, String diaodan, String gouNumber, String gouTotal, String current_time) {
        db = Room.databaseBuilder(context,
                DiaoDanDatabase.class, "Diaodan_Database")
                .fallbackToDestructiveMigration()
                .build();
        this.context = context;
        this.list = list;
        this.diaodan = diaodan;
        this.gou = gouNumber;
        this.gouTotal = gouTotal;
        this.current_time = current_time;
        Log.e("撤回销钩撤回销钩", "" + gou);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //new OneViewHolder(LayoutInflater.from(context).inflate(R.layout.twoviewitem, parent, false))
        TwoViewHolder twoViewHolder = new TwoViewHolder(View.inflate(context, R.layout.twoviewitem, null));
        return twoViewHolder;
    }

    int pdd = 0;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        /*FindDatabase findDatabase = new FindDatabase();
        findDatabase.execute();*/
        TwoViewHolder twoViewHolder = (TwoViewHolder) holder;
        twoViewHolder.setData(position);
        twoViewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    private class TwoViewHolder extends RecyclerView.ViewHolder {
        private TextView unit_tv;
        private TextView projectnum_tv;
        private TextView yearplaninvest_tv;
        private TextView nowmonthinvest_tv;
        private TextView onetonowinvest_tv;
        private ImageView xiaogou;
        private TextView Investmentcompletion_tv;
        private TextView investmentgrowth_tv;
        private LinearLayout linerLayout_re;
        private int size;


        public TwoViewHolder(View itemView) {
            super(itemView);
        }


        public void setData(final int position) {

            linerLayout_re = (LinearLayout) itemView.findViewById(R.id.linerLayout_re);
            unit_tv = (TextView) itemView.findViewById(R.id.unit_tv);
            projectnum_tv = (TextView) itemView.findViewById(R.id.projectnum_tv);
            yearplaninvest_tv = (TextView) itemView.findViewById(R.id.yearplaninvest_tv);
            nowmonthinvest_tv = (TextView) itemView.findViewById(R.id.nowmonthinvest_tv);
            onetonowinvest_tv = (TextView) itemView.findViewById(R.id.onetonowinvest_tv);
            xiaogou = (ImageView) itemView.findViewById(R.id.xiaogou);
            String[] str = list.get(position).split(",");
            unit_tv.setText(str[0]);
            projectnum_tv.setText(str[1]);
            yearplaninvest_tv.setText(str[2]);
            nowmonthinvest_tv.setText(str[3]);
            if (str.length < 5) {
            } else {
                onetonowinvest_tv.setText(str[4]);
            }
            unit_tv.setTextColor(Color.parseColor("#ffffff"));
            projectnum_tv.setTextColor(Color.parseColor("#ffffff"));
            yearplaninvest_tv.setTextColor(Color.parseColor("#ffffff"));
            nowmonthinvest_tv.setTextColor(Color.parseColor("#ffffff"));
            onetonowinvest_tv.setTextColor(Color.parseColor("#ffffff"));

            try {
                String number = gou;
                Log.e("撤回销钩", "" + number);
                if (!number.equals("")) {
                    String[] split = number.split("-");
                    int length = split.length;
                    if (length >= 1) {
                        for (int i = 0; i < length; i++) {
                            Integer valueOf = Integer.valueOf(split[i]) - 1;
                            Log.e("撤回销钩1", "" + valueOf);
                            if (String.valueOf(valueOf).equals(String.valueOf(position))) {
                                xiaogou.setVisibility(View.VISIBLE);
                                xianList.add(Integer.valueOf(split[i]));
                            }
                        }
                        Log.e("显示", xianList.toString());
                    } else {
                        unit_tv.setTextColor(Color.parseColor("#ffffff"));
                        projectnum_tv.setTextColor(Color.parseColor("#ffffff"));
                        yearplaninvest_tv.setTextColor(Color.parseColor("#ffffff"));
                        nowmonthinvest_tv.setTextColor(Color.parseColor("#ffffff"));
                        onetonowinvest_tv.setTextColor(Color.parseColor("#ffffff"));
                    }
                    if (position == length) {
                        unit_tv.setTextColor(Color.parseColor("#F9DC43"));
                        projectnum_tv.setTextColor(Color.parseColor("#F9DC43"));
                        yearplaninvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                        nowmonthinvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                        onetonowinvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                    }
                    Integer max = Collections.max(xianList);
                    Integer min = Collections.min(xianList);
                    Log.e("最大值", max + "    " + min + "    " + xianList.toString());
                    if (position == TalkActivity.gouName) {
                        if (TalkActivity.switchType.equals("down")) {
                            if (TalkActivity.gouName > max) {
                                unit_tv.setTextColor(Color.parseColor("#F9DC43"));
                                projectnum_tv.setTextColor(Color.parseColor("#F9DC43"));
                                yearplaninvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                                nowmonthinvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                                onetonowinvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                            }
                        } else {
                            unit_tv.setTextColor(Color.parseColor("#ffffff"));
                            projectnum_tv.setTextColor(Color.parseColor("#ffffff"));
                            yearplaninvest_tv.setTextColor(Color.parseColor("#ffffff"));
                            nowmonthinvest_tv.setTextColor(Color.parseColor("#ffffff"));
                            onetonowinvest_tv.setTextColor(Color.parseColor("#ffffff"));
                        }
                    }
                } else {
                    if (position == 0) {
                        unit_tv.setTextColor(Color.parseColor("#F9DC43"));
                        projectnum_tv.setTextColor(Color.parseColor("#F9DC43"));
                        yearplaninvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                        nowmonthinvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                        onetonowinvest_tv.setTextColor(Color.parseColor("#F9DC43"));
                    }
                }
            } catch (Exception e) {
                Log.e("出现问题了2", "" + e.toString());
            }
        }
    }

    String gou_number = "";

    private int setMethos(List<String> xinList) {
        HashSet<String> set = new HashSet<>(xinList);
        System.out.println("去重集合:" + set);
        int size = set.size();
        return size;
    }

    private String getTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    private String getFormat() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }
}