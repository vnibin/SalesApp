    package com.vnibin.salesapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Downloader
import kotlinx.android.synthetic.main.activity_reg.*

    class RegAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

         reg_signup.setOnClickListener {


            if(reg_password.text.toString().equals(reg_confirm.text.toString())) {
//                    var url ="192.168.1.10/Companyweb/salesweb/add_user.php?moblie=" + reg_mobile.text.toString() +
//                        "&password=" + reg_password.text.toString() + "&name=" + reg_name.text.toString() +
//                        "&address=" + reg_address.text.toString()
                var url="http://192.168.1.10/Companyweb/salesweb/add_user.php?mobile="+reg_mobile.text.toString()+"&password="+
                        reg_password.text.toString()+"&name="+reg_name.text.toString()+"&address="+reg_address.text.toString()

                var rq:RequestQueue=Volley.newRequestQueue(this)
                var sr=StringRequest(Request.Method.GET,url,Response.Listener { response ->
                    if(response.equals("0"))
                        Toast.makeText(this,"Mobile already added",Toast.LENGTH_LONG).show()
                    else
                        Toast.makeText(this,"User Successfully added",Toast.LENGTH_LONG).show()



                },Response.ErrorListener { error ->

                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()


                })

                rq.add(sr)
            }

             else
            {
                Toast.makeText(this,"Password doesnt match",Toast.LENGTH_LONG).show()
            }


         }


    }
}
