package com.example.socket.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.socket.R;
import com.example.socket.Unit.SpUtil;
import com.example.socket.custom.data.Point3d;
import com.example.socket.custom.park.EightParkCar;
import com.example.socket.custom.park.EighteenParkCar;
import com.example.socket.custom.park.ElevenParkCar;
import com.example.socket.custom.park.FifteenParkCar;
import com.example.socket.custom.park.FiveParkCar;
import com.example.socket.custom.park.FourParkCar;
import com.example.socket.custom.park.FourteenParkCar;
import com.example.socket.custom.park.NineParkCar;
import com.example.socket.custom.park.NineteenParkCar;
import com.example.socket.custom.park.OneParkCar;
import com.example.socket.custom.park.SevenParkCar;
import com.example.socket.custom.park.SeventeenParkCar;
import com.example.socket.custom.park.SixParkCar;
import com.example.socket.custom.park.SixteenParkCar;
import com.example.socket.custom.park.TenParkCar;
import com.example.socket.custom.park.ThirteenParkCar;
import com.example.socket.custom.park.ThreeParkCar;
import com.example.socket.custom.park.TwelveParkCar;
import com.example.socket.custom.park.TwoParkCar;
import com.example.socket.custom.track.TrackDataUtil;
import com.example.socket.custom.xiningbei.BaiLiMap;
import com.example.socket.custom.xiningbei.ChangFengMap;
import com.example.socket.custom.xiningbei.XiNingBeiMap;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocationFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_location, container, false);
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}