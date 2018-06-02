package com.vnibin.salesapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_total.*

class TotalAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)

        var url="http://192.168.1.4/Companyweb/salesweb/get_total.php?bill_no="+intent.getStringExtra("bno")
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var sr= StringRequest(Request.Method.GET,url, Response.Listener { response ->

            total_tv.text=response

        }, Response.ErrorListener { error ->

            Toast.makeText(this,error.message, Toast.LENGTH_SHORT).show()
        })

        rq.add(sr)

    }
}
