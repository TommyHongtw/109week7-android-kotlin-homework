package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var Btn_choice: Button; //declare meal button
    private lateinit var Tv_condition: TextView; //declare meal detail text



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Tv_condition = findViewById(R.id.Tv_condition); //connect to xml object Text
        Btn_choice = findViewById(R.id.Btn_choice); //connect to xml object Button
        //Btn_choic按下時執行
        Btn_choice.setOnClickListener{
            startActivityForResult(Intent(this,MainActivity2::class.java),1);
            //this指當前這個Activity,要開啟Activity2,要求碼是1
        }
    }
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { //data為Intent物件中的一個屬性(data可為空直)
        super.onActivityResult(requestCode, resultCode, data) //獲得requestCode,resultCode,data
        //使用extras獲取data中回傳的資料,let可將獲取出來的東西放入it(?. 如果data為空值就不做)
        data?.extras?.let {
            if(requestCode==1) //確定是不適自己的要求
            {
                if(resultCode==2) //確定回覆者是誰
                {
                    //用key來獲取標籤內的資料
                    Tv_condition.text=
                        "飲料:${it.getString("drink")}\n\n甜度:" +
                                "${it.getString("sweet")}\n\n冰量:${it.getString("ice")}";
                }
            }
        }

    }

}