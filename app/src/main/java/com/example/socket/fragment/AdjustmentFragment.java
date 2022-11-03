package com.example.socket.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.socket.Activity.SendActivity;
import com.example.socket.Activity.TalkActivity;
import com.example.socket.R;
import com.example.socket.Unit.CombineCommend;
import com.example.socket.Unit.SpUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import com.example.socket.adapter.ReportDetailAdapter;
import com.example.socket.database.DiaoDan;
import com.example.socket.database.DiaoDanDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjustmentFragment extends Fragment {

    private View mView;
    private TextView tv_diaohao, tv_benji, receive;//显示;
    private Spinner spinner_diaodan;
    private Button bt_submit, bt_refrash_send;
    private SpUtil mSpPersonnelType;
    public static String zhishiTrans, caozuoyuan, currnumber, peopleId, benJi, signatureId;
    private BroadcastReceiver mBroadcastReceiver;
    private String name2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_adjustment, container, false);
        initView();
        initListener();
        return mView;
    }

    private void initView() {
        db = Room.databaseBuilder(getActivity(),
                DiaoDanDatabase.class, "Diaodan_Database")
                .fallbackToDestructiveMigration()
                .build();

        tv_diaohao = mView.findViewById(R.id.tv_diaohao);
        spinner_diaodan = mView.findViewById(R.id.spinner_diaodan);
        tv_benji = mView.findViewById(R.id.tv_benji);
        bt_submit = mView.findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindDatabase findDatabase = new FindDatabase();
                findDatabase.execute();
            }
        });
        bt_refrash_send = mView.findViewById(R.id.bt_refrash_send);
        bt_refrash_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadDatabase readDatabase = new ReadDatabase();
                readDatabase.execute();
            }
        });
        receive = mView.findViewById(R.id.tv_receive_sendactivity);

        mSpPersonnelType = new SpUtil(getActivity(), "PersonnelType");
        caozuoyuan = mSpPersonnelType.getName();
        zhishiTrans = mSpPersonnelType.getStandard();
        signatureId = mSpPersonnelType.getSignatureId();
        peopleId = mSpPersonnelType.getPeopleId();
        benJi = mSpPersonnelType.getBenJi();
        tv_diaohao.setText("调号:" + signatureId + "号");
        tv_benji.setText("本机号码:" + benJi + "  人员号:" + peopleId);

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (intent.getAction()) {
                    case "adjustment":
                        String name = intent.getStringExtra("name");
                        Log.i("接收广播", "成功:"+name);
                        try {
                            DisplayDiaodanLayout(name);
                        } catch (Exception e) {
                            Log.i("异常", "异常:"+e);
                        }
                        break;
                    case "HookElimination":
                        name2 = intent.getStringExtra("name2");
                        Log.i("接收广播", "成功:"+ name2);
                        try {
                            ListDatabase listDatabase = new ListDatabase();
                            listDatabase.execute();
                        } catch (Exception e) {
                        }
                        break;
                }
            }
        };
        IntentFilter mif = new IntentFilter();
        mif.addAction("adjustment");
        mif.addAction("HookElimination");
        getActivity().registerReceiver(mBroadcastReceiver, mif);
    }
    /*@Subscribe(threadMode = ThreadMode.MAIN)
    public void getMessage(String msg) {
        Log.e("fragment",msg);
    }*/

    private List<String> mList = new ArrayList<>();//调单部分内容
    private RecyclerView report_detail_recyclerview;//调单
    private ReportDetailAdapter detailAdapter;
    public static String time_date = "";
    CombineCommend combineCommend = new CombineCommend();
    //调单显示方法
    public void DisplayDiaodanLayout(String str) {
        receive.setVisibility(View.GONE);
        Log.e("swy", str);
        mList = new ArrayList<>();
        ArrayList<String> diaocan_list = new ArrayList<>();
        try {
            if (combineCommend.CRC_Test(str)) {
                diaocan_list.addAll(combineCommend.Decode_diaodan(str));
            } else {
            }
            mList.add("第" + diaocan_list.get(5) + "号  机车: " + diaocan_list.get(11) + "\r\n" + "编制人: " + diaocan_list.get(8) + "--调车长: " + diaocan_list.get(9) + "\r\n" + "计划内容: " + diaocan_list.get(10) + "\r\n" + "计划时间: 自" + diaocan_list.get(6).substring(0, 2) + "时" + diaocan_list.get(6).substring(2, 4) + "分" + "至" + diaocan_list.get(7).substring(0, 2) + "时" + diaocan_list.get(6).substring(2, 4) + "分");
            Log.e("swy", diaocan_list.get(1));
            for (int i = 0; i < Integer.valueOf(diaocan_list.get(2)); i++) {
                mList.add(i + 1 + "," + diaocan_list.get(13 + (i * 3)) + "," + diaocan_list.get(14 + (i * 3)).substring(0, 1) + "," + diaocan_list.get(14 + (i * 3)).substring(1) + "," + diaocan_list.get(15 + (i * 3)));//红色 #FF0000 //牡丹红 #FF00FF
            }
            Log.e("swy", "11");
            report_detail_recyclerview = (RecyclerView) mView.findViewById(R.id.report_detail_recyclerview);
            /*report_detail_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            report_detail_recyclerview.setAdapter(new ReportDetailAdapter(this,mList));*/

            //设置layoutmanager
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            report_detail_recyclerview.setLayoutManager(layoutManager);

            //设置adapter
            detailAdapter = new ReportDetailAdapter(getActivity(), mList);
            report_detail_recyclerview.setAdapter(detailAdapter);
            TextView tv_jishi_content = mView.findViewById(R.id.tv_jishi_content);
            time_date = diaocan_list.get(1);
            tv_jishi_content.setText("注意事项: " + diaocan_list.get(12) + "\n\r" + "编制时间: " + diaocan_list.get(1).substring(0, 2) + "年" + diaocan_list.get(1).substring(2, 4) + "月" + diaocan_list.get(1).substring(4, 6) + "日" + diaocan_list.get(1).substring(6, 8) + "时" + diaocan_list.get(1).substring(8, 10) + "分" + diaocan_list.get(1).substring(10, 12) + "秒");

            //initViews();
            clickListener();//加入按键方法
        } catch (Exception e) {
        }

    }

    private void clickListener() {
        detailAdapter.setOnItemClickListener(new ReportDetailAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final int position, final int setcolor) {
            }
        });

    }

    public static ArrayList<String> gou_list = new ArrayList<>();
    DiaoDanDatabase db = null;//调单db
    private class ListDatabase extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            gou_list.clear();
            List<DiaoDan> users = db.DiaodanDAO().getAll();
            if (!(users.isEmpty() || users == null)) {
                String allUsers = "";
                String refresh_data = "";
                for (DiaoDan temp : users) {
                    //String userstr = temp.gou_number;
                    if (name2.matches(temp.getCurrent_time())) {
                        allUsers = temp.gou_number;
                        refresh_data = temp.str;
                    }
                }
                String[] strings = allUsers.split("-");
                for (int i = 0; i < strings.length; i++) {
                    gou_list.add(strings[i]);
                }
                System.out.println(gou_list + "-111111111111---" + gou_list);
                return refresh_data;
            } else
                return "";
        }

        @Override
        protected void onPostExecute(String details) {
            DisplayDiaodanLayout(details);
            //System.out.println(details + "----1111111411111---");
            //System.out.println(gou_list + "111111111411");
            /*if (mList.isEmpty()) {
                DisplayDiaodanLayout(details);
                System.out.println(details + "----1111111411111---");
                System.out.println(gou_list + "111111111411");
            } else {
                initViews();
                System.out.println(details + "----1111111151111---");
                System.out.println(gou_list + "111111151111");
            }*/
        }
    }

    private List<String> list_diao1 = new ArrayList<String>();//调单内容
    private List<String> list_diao2 = new ArrayList<String>();//下拉菜单的调单
    private ArrayAdapter<String> adapter1;
    private String diaodan_number = "", path = "";
    private void initListener() {
        list_diao2.add("调单");
        adapter1 = new ArrayAdapter<String>(getActivity(), R.layout.custom_spinner_dropdown_item, list_diao2);
        //第三步：设置下拉列表下拉时的菜单样式
        adapter1.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        spinner_diaodan.setAdapter(adapter1);
        //第五步：添加监听器，为下拉列表设置事件的响应
        spinner_diaodan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                diaodan_number = adapter1.getItem(i).replace("/", "").replace("-", "").replace(":", "");
                // TODO Auto-generated method stub
                adapterView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapterView.setVisibility(View.VISIBLE);
            }
        });
        //将spinnertext添加到OnTouchListener对内容选项触屏事件处理
        spinner_diaodan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // 将mySpinner隐藏
                view.setVisibility(View.VISIBLE);
                return false;
            }
        });
        //焦点改变事件处理
        spinner_diaodan.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                view.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(mBroadcastReceiver);
    }

    int event_cout = 0, event_index = 0;

    private class ReadDatabase extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            list_diao1.clear();
            List<DiaoDan> users = db.DiaodanDAO().getAll();
            if (!(users.isEmpty() || users == null)) {
                String allUsers = "";
                for (DiaoDan temp : users) {
                    list_diao1.add(temp.getCurrent_time());
                }
                Collections.sort(list_diao1, Collections.reverseOrder());
                if (list_diao1.size() > 20) {
                    list_diao2.clear();
                    list_diao2.add("调单");
                    for (int i = 0; i < 20; i++) {
                        list_diao2.add(list_diao1.get(i).substring(0, 2) + "/" + list_diao1.get(i).substring(2, 4) + "/" + list_diao1.get(i).substring(4, 6) +
                                "-" + list_diao1.get(i).substring(6, 8) + ":" + list_diao1.get(i).substring(8, 10) + ":" + list_diao1.get(i).substring(10, 12));
                    }
                    for (DiaoDan temp : users) {
                        if (list_diao2.contains(temp.current_time)) {
                        } else {
                            db.DiaodanDAO().delete(temp);
                        }
                    }
                } else {
                    list_diao2.clear();
                    list_diao2.add("调单");
                    for (int i = 0; i < list_diao1.size(); i++) {
                        list_diao2.add(list_diao1.get(i).substring(0, 2) + "/" + list_diao1.get(i).substring(2, 4) + "/" + list_diao1.get(i).substring(4, 6) +
                                "-" + list_diao1.get(i).substring(6, 8) + ":" + list_diao1.get(i).substring(8, 10) + ":" + list_diao1.get(i).substring(10, 12));
                    }
                }
                return "";
            } else {
                return "";
            }

        }


        @Override
        protected void onPostExecute(String details) {
        }
    }

    private class FindDatabase extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            gou_list.clear();
            List<DiaoDan> users = db.DiaodanDAO().getAll();
            if (!(users.isEmpty() || users == null)) {
                String allUsers = "";
                String refresh_data = "";
                for (DiaoDan temp : users) {
                    //String userstr = temp.gou_number;
                    if (diaodan_number.matches(temp.getCurrent_time())) {
                        allUsers = temp.gou_number;
                        refresh_data = temp.str;
                    }
                }
                String[] strings = allUsers.split("-");
                for (int i = 0; i < strings.length; i++) {
                    gou_list.add(strings[i]);
                }
                return refresh_data;
            } else
                return "";
        }

        @Override
        protected void onPostExecute(String details) {
            //System.out.println(details);
            if (details.isEmpty() || details.length() == 0) {
            } else {
                DisplayDiaodanLayout(details);
            }
        }
    }
}