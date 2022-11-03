package com.example.socket.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.socket.R;
import com.example.socket.Unit.CombineCommend;
import com.example.socket.Unit.SpUtil;
import com.example.socket.adapter.AFactory;
import com.example.socket.adapter.ReportDetailAdapter;
import com.example.socket.database.DiaoDan;
import com.example.socket.database.DiaoDanDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SendActivity extends Activity implements View.OnClickListener {

    private TextView tv_diaohao, tv_benji, receive;//显示;
    private Spinner spinner_diaodan;
    private Button bt_submit, bt_refrash_send;
    private SpUtil mSpPersonnelType;

    private String diaodan_number = "", path = "";
    public static String zhishiTrans, caozuoyuan, currnumber, peopleId, benJi, imei, signatureId;
    private ArrayAdapter<String> adapter1;
    public static ArrayList<String> gou_list = new ArrayList<>();
    private List<String> mList = new ArrayList<>();//调单部分内容
    private List<String> list_diao1 = new ArrayList<String>();//调单内容
    private List<String> list_diao2 = new ArrayList<String>();//下拉菜单的调单
    DiaoDanDatabase db = null;//调单db
    CombineCommend combineCommend = new CombineCommend();
    private RecyclerView report_detail_recyclerview;//调单
    private ReportDetailAdapter detailAdapter;
    public static String time_date = "";
    private BroadcastReceiver mBroadcastReceiver;
    private String name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        db = Room.databaseBuilder(getApplication(),
                DiaoDanDatabase.class, "Diaodan_Database")
                .fallbackToDestructiveMigration()
                .build();
        initView();
        initData();
        initListener();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("swy", "onKeyDown: " + keyCode + "--------" + event.getAction());
        if (keyCode == 285 && event.getAction() == KeyEvent.ACTION_DOWN) {
            //TalkActivity.doPlay();
            AFactory.sTalkActivity.doPlay();
            return true;
        }

        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.e("swy", "onKeyUp: " + keyCode + "--------" + event.getAction());
        if (keyCode == 285 && event.getAction() == KeyEvent.ACTION_UP) {
            //TalkActivity.doStop();
            AFactory.sTalkActivity.doStop();
            return true;
        }
        return false;
    }

    private void initView() {
        tv_diaohao = findViewById(R.id.tv_diaohao);
        spinner_diaodan = findViewById(R.id.spinner_diaodan);
        tv_benji = findViewById(R.id.tv_benji);
        bt_submit = findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(this);
        bt_refrash_send = findViewById(R.id.bt_refrash_send);
        bt_refrash_send.setOnClickListener(this);
        receive = findViewById(R.id.tv_receive_sendactivity);
        /*findViewById(R.id.bt_tigou_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendActivity.this,PointActivity.class);
                startActivity(intent);
            }
        });*/

        mSpPersonnelType = new SpUtil(getApplication(), "PersonnelType");
        caozuoyuan = mSpPersonnelType.getName();
        zhishiTrans = mSpPersonnelType.getStandard();
        signatureId = mSpPersonnelType.getSignatureId();
        peopleId = mSpPersonnelType.getPeopleId();
        benJi = mSpPersonnelType.getBenJi();
        imei = mSpPersonnelType.getIMEI();
        tv_diaohao.setText("调号:" + signatureId + "号");
        tv_benji.setText("本机号码:" + benJi + "  人员号:" + peopleId);
    }

    private void initData() {
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (intent.getAction()) {
                    case "adjustment":
                        String name = intent.getStringExtra("name");
                        Log.i("接收广播", "成功:" + name);
                        try {
                            DisplayDiaodanLayout(name);
                        } catch (Exception e) {
                            Log.i("异常", "异常:" + e);
                        }
                        break;
                    case "HookElimination":
                        name2 = intent.getStringExtra("name2");
                        Log.i("接收广播", "成功:" + name2);
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
        registerReceiver(mBroadcastReceiver, mif);
    }

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

    private void initListener() {
        list_diao2.add("调单");
        adapter1 = new ArrayAdapter<String>(this, R.layout.custom_spinner_dropdown_item, list_diao2);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_submit:
                FindDatabase findDatabase = new FindDatabase();
                findDatabase.execute();
                break;
            case R.id.bt_refrash_send:
                ReadDatabase readDatabase = new ReadDatabase();
                readDatabase.execute();
                break;
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
            report_detail_recyclerview = (RecyclerView) findViewById(R.id.report_detail_recyclerview);
            /*report_detail_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            report_detail_recyclerview.setAdapter(new ReportDetailAdapter(this,mList));*/

            //设置layoutmanager
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            report_detail_recyclerview.setLayoutManager(layoutManager);

            //设置adapter
            detailAdapter = new ReportDetailAdapter(this, mList);
            report_detail_recyclerview.setAdapter(detailAdapter);
            TextView tv_jishi_content = findViewById(R.id.tv_jishi_content);
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

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
        }
    }
}