package com.example.socket.Activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.telephony.TelephonyManager
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.example.socket.IO.GPIO
import com.example.socket.R
import com.example.socket.Unit.SpUtil
import kotlinx.android.synthetic.main.activity_login.*
import java.net.Inet6Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = "LoginActivity: "
    private val REQUESTCODE = 100
    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            Log.i(TAG, "没有权限进行申请")
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                REQUESTCODE
            )
        } else {
            Log.i(TAG, "已经有权限")
            val tm = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
            val imei = tm.deviceId
            Log.e("测试语音", "PDManager onConnectionState = $imei---")
        }
    }

    private val editip: CharSequence?
        get() {
            val textIp = edit_login1.text
            return textIp
        }

    override fun onClick(p0: View?) {
        when (p0?.id) {
//            R.id.image_login -> Toast.makeText(application, "......", Toast.LENGTH_SHORT).show()
            R.id.login_btn ->
                if (editip.toString() != null && edit_login2.text.toString() != null) {
                    startActivity(Intent(application, TalkActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(application, "账号密码为空", Toast.LENGTH_SHORT).show()
                }

        }
    }

    private val spUtil: SpUtil
        get() {
            val mSpUtil = SpUtil(application, "PersonnelType")
            return mSpUtil
        }

    private val ip: String?
        get() {
            val hostIP = getHostIP()
            return hostIP
        }

    private val deviceId: String?
        @SuppressLint("MissingPermission")
        get() {
            val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val deviceId = telephonyManager.deviceId
            return deviceId
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loadImage(img)
        val mSpUtil = spUtil
        image_login.setOnClickListener(this)
        login_btn.setOnClickListener(this)
        val hostIP = ip
        edit_login1.setText(hostIP)
        edit_login2.setText("bjxt")
        val textIp = editip
        if (textIp != null) {
            handler.postDelayed(rrrr(), 1000)
        }
        name_text.setText(R.string.jikongqi)

        val deviceId = deviceId

        val name = spUtil.name
        when (name) {
            "调车长" -> println("调车长")
            "机控器" -> println("机控器")
            "区长台" -> println("区长台")
            "差转台" -> {
                /*GPIO.gpio_crtl_out(128, 0) //pe0
                GPIO.gpio_crtl_out(140, 0) //pe12
                GPIO.gpio_crtl_out(141, 0) //pe13
                GPIO.gpio_crtl_out(142, 0) //pe14
                GPIO.gpio_crtl_out(143, 0) //pe15
                GPIO.gpio_crtl_out(144, 0) //pe16*/
                println("差转台")
            }
            else -> {
                println("制动员")
            }
        }
    }

    val handler = Handler()

    inner private class rrrr : Runnable {
        override fun run() {
            edit_login1.setText(ip)
            val text = name_text.text
            when (text) {
                "调车长" -> showSp("调车长", "B制式", "01", "20", ip.toString(), deviceId.toString())
                "机控器" -> showSp("机控器", "B制式", "01", "0A", ip.toString(), deviceId.toString())
                "区长台" -> showSp("区长台", "B制式", "01", "0B", ip.toString(), deviceId.toString())
                "差转台" -> showSp("差转台", "B制式", "01", "0C", ip.toString(), deviceId.toString())
                "制动员01号" -> showSp("制动员01号", "B制式", "01", "01", ip.toString(), deviceId.toString())
                "制动员02号" -> showSp("制动员02号", "B制式", "01", "02", ip.toString(), deviceId.toString())
                "制动员03号" -> showSp("制动员03号", "B制式", "01", "03", ip.toString(), deviceId.toString())
                "制动员04号" -> showSp("制动员04号", "B制式", "01", "04", ip.toString(), deviceId.toString())
                "制动员05号" -> showSp("制动员05号", "B制式", "01", "05", ip.toString(), deviceId.toString())
            }
            if (editip.toString().equals("")) {
                handler.postDelayed(rrrr(), 2000)
            } else {
                startActivity(Intent(application, TalkActivity::class.java))
                finish()
            }
        }
    }

    fun showSp(
        name: String,
        standard: String,
        signatureId: String,
        peopleId: String,
        benJi: String,
        imei: String
    ) {
        spUtil.name = name
        spUtil.standard = standard
        spUtil.signatureId = signatureId
        spUtil.peopleId = peopleId
        spUtil.benJi = benJi
        spUtil.imei = imei
    }

    fun getHostIP(): String? {

        var hostIp: String? = null
        try {
            val nis = NetworkInterface.getNetworkInterfaces()
            var ia: InetAddress? = null
            while (nis.hasMoreElements()) {
                val ni = nis.nextElement() as NetworkInterface
                val ias = ni.inetAddresses
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement()
                    if (ia is Inet6Address) {
                        continue// skip ipv6
                    }
                    val ip = ia!!.hostAddress
                    if ("127.0.0.1" != ip) {
                        hostIp = ia.hostAddress
                        break
                    }
                }
            }
        } catch (e: SocketException) {
            Log.i("yao", "SocketException")
            e.printStackTrace()
        }

        return hostIp
    }

    fun loadImage(imageView: ImageView?) {
//		String url="http://**********************";// 网络gif资源
        val url = "file:///android_asset/bb.gif"
        Glide.with(this)
            .asGif()
            .load(url)
            .into(imageView!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(rrrr())
    }
}
