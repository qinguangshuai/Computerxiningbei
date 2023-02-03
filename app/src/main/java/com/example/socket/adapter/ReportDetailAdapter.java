package com.example.socket.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.socket.Activity.SendActivity;
import com.example.socket.Activity.TalkActivity;
import com.example.socket.Bean.Pocket;
import com.example.socket.R;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.socket.database.DiaoDan;
import com.example.socket.database.DiaoDanDatabase;

import java.util.List;
import static com.example.socket.fragment.AdjustmentFragment.gou_list;

public class ReportDetailAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private Context context;
    private OnItemClickListener mListener;


    //声明自定义的监听接口
    private OnRecyclerItemClickListener monItemClickListener;
    private int setcolor = 0;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    public interface OnItemClickListener {
        void onItemClick(int position, int setcolor);
    }

    private String target_diaohao = "test_place1";
    DiaoDanDatabase db = null;

    public ReportDetailAdapter(Context context, List<String> list) {
        db = Room.databaseBuilder(context,
                DiaoDanDatabase.class, "Diaodan_Database")
                .fallbackToDestructiveMigration()
                .build();
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1) {
            return new OneViewHolder(View.inflate(context, R.layout.oneviewitem, null));
        } else {
            return new TwoViewHolder(View.inflate(context, R.layout.twoviewitem, null));
        }

    }

    int pdd = 0;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        /*FindDatabase findDatabase = new FindDatabase();
        findDatabase.execute();*/
        if (getItemViewType(position) == 1) {
            OneViewHolder oneViewHolder = (OneViewHolder) holder;
            oneViewHolder.setData(position);
        } else {
            TwoViewHolder twoViewHolder = (TwoViewHolder) holder;
            twoViewHolder.setData(position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_danju;

        public OneViewHolder(View itemview) {
            super(itemview);
        }

        public void setData(int position) {
            tv_danju = (TextView) itemView.findViewById(R.id.tv_danju);
            tv_danju.setText(list.get(position));
        }
    }

    private class TwoViewHolder extends RecyclerView.ViewHolder {
        private TextView unit_tv;
        private TextView projectnum_tv;
        private TextView yearplaninvest_tv;
        private TextView nowmonthinvest_tv;
        private TextView onetonowinvest_tv;
        private TextView Investmentcompletion_tv;
        private TextView investmentgrowth_tv;
        private LinearLayout linerLayout_re;


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
            String[] str = list.get(position).split(",");
            unit_tv.setText(str[0]);
            projectnum_tv.setText(str[1]);
            yearplaninvest_tv.setText(str[2]);
            nowmonthinvest_tv.setText(str[3]);
            if (str.length < 5) {
            } else {
                onetonowinvest_tv.setText(str[4]);
            }
            try {
                if (!gou_list.isEmpty()) {
                    for (int i = 0; i < gou_list.size(); i++) {
                        if (gou_list.get(i).equals(String.valueOf(position))) {
                            linerLayout_re.setBackgroundColor(context.getResources().getColor(R.color.red));
                        }
                    }
                }
                if (SendActivity.caozuoyuan.matches("调车长")){
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                mListener.onItemClick(position, setcolor);
                            }catch (Exception e){}
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setIcon(R.drawable.ic_launcher_foreground);
                            builder.setTitle("是否确认勾" + position);
                            View view2 = LayoutInflater.from(context).inflate(R.layout.pop_up_dialog_send, null);
                            //    设置我们自己定义的布局文件作为弹出框的Content
                            builder.setView(view2);
                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println(position + "-----swy-----");
                                    linerLayout_re.setBackgroundColor(context.getResources().getColor(R.color.red));
                                    String danhao = list.get(0).substring(list.get(0).indexOf("第"), list.get(0).indexOf("号")).replace("第", "");
                                    if (danhao.length() == 1) {
                                        danhao = "0" + danhao;
                                    }
                                    gou_number = position + "";
                                    Pocket p = new Pocket();
                                    //多方
                                    //消钩
                                    //HookElimination
                                    p.setType("HookElimination");
                                    p.setTime(System.currentTimeMillis());
                                    p.setIpAdress("192.168.1.184");
                                    p.setImei(SendActivity.imei);
                                    p.setDataMessage(SendActivity.currnumber + "," + "BJXT" + "," + TalkActivity.diaohao + "," + danhao + "," + position + "," + SendActivity.time_date);
                                    Log.e("qgs", "onClick: " + "停车");
                                    TalkActivity.udpHelperServer.sendStrMessage(JSONObject.toJSONString(p), "36.110.196.90", 55001);
                                    //sendMessage(SendActivity.currnumber + "," + "SWY" + "," + SendActivity.diaohao + "," + danhao + "," + position + "," + SendActivity.time_date);
                                    UpdateDatabase updateDatabase = new UpdateDatabase();
                                    updateDatabase.execute();
                                }
                            });
                            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            builder.show();
                        }
                    });
                }
            } catch (Exception e) {
            }
        }

        public void setNewData(final int position) {
            linerLayout_re = (LinearLayout) itemView.findViewById(R.id.linerLayout_re);
            linerLayout_re.setBackgroundColor(context.getResources().getColor(R.color.red));
        }
    }

    String gou_number = "";

    private class UpdateDatabase extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String every_add = gou_number + "-";
            List<DiaoDan> users = db.DiaodanDAO().getAll();
            if (!(users.isEmpty() || users == null)) {
                String allUsers = "";
                for (DiaoDan temp : users) {
                    if (SendActivity.time_date.matches(temp.getCurrent_time())) {
                        DiaoDan diaodan = temp;
                        diaodan.setGou_number(temp.gou_number + every_add);
                        db.DiaodanDAO().updateDiaodan(diaodan);
                        allUsers = diaodan.gou_number;
                    }
                }
                System.out.println(gou_number + "---------------" + SendActivity.time_date + "----------" + allUsers);
                return allUsers;
            } else {
                return "";
            }
        }

        @Override
        protected void onPostExecute(String details) {

        }
    }
}