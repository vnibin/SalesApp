package com.vnibin.salesapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ItemAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        var cat:String=intent.getStringExtra("cat")
        var url:String="http://192.168.1.10/Companyweb/salesweb/get_cat.php?category="+cat

    }
}
