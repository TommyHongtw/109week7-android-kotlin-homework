package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity2 : AppCompatActivity() {
    private lateinit var Btn_confirm: Button; //declare send Button
    private lateinit var Ed_item: EditText; //declare EditText item
    private lateinit var Rbg_sweet: RadioGroup; //declare RadioButtonGroup_sweet
    private lateinit var Rbg_ice: RadioGroup; //declare RadioButtonGroup_ice
    private var sweet:String="半糖"; //預設是半糖
    private var ice:String="少冰"; //預設是微冰
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_main3)
        Rbg_sweet=findViewById(R.id.Rbg_sweet); //連結到Xml的Rbg_sweet
        //當RadioButtonGroup中發生變化就執行
        Rbg_sweet.setOnCheckedChangeListener{Rbg_sweet,i -> //when(i)跟switch的用處是一樣的,i代表被選取的id,並將對應的值丟入sweet
            sweet= when(i){
                R.id.Rb_full -> "全糖"
                R.id.Rb_middle -> "半糖"
                R.id.Rb_less ->"少糖"
                R.id.Rb_no -> "無糖"
                else ->""
            }
        }
        Rbg_ice=findViewById(R.id.Rbg_ice); //連結到Xml的Rbg_ice
        Rbg_ice.setOnCheckedChangeListener{Rbg_ice,i -> //when(i)跟switch的用處是一樣的,i代表被選取的id,並將對應的值丟入ice
            ice= when(i){
                R.id.Rb_inormal -> "正常"
                R.id.Rb_ilittle -> "少冰"
                R.id.Rb_iless -> "微冰"
                R.id.Rb_ino -> "去冰"
                else ->""
            }
        }
        Btn_confirm=findViewById(R.id.Btn_confirm); //連結到Xml的Btn_confirm
        //在Btn_confirm按下時執行
        Btn_confirm.setOnClickListener{
            Ed_item=findViewById(R.id.Ed_item); //連結到Xml的Ed_item
            var drink=Ed_item.text.toString(); //將Ed_item上的字放入drink並指派為變數
            val detail=Bundle(); //新增一個Bundle來放東西
            detail.putString("sweet",sweet); //放入Key:sweet,value:sweet
            detail.putString("ice",ice); //放入Key:ice,value:ice
            detail.putString("drink",drink); //放入Key:drink,value:drink
            val intent=Intent(); //新增一個Intent物件來開啟傳送
            intent.putExtras(detail); //將資料放入intent中
            setResult(2,intent); //建立結果,代碼:2
            finish(); //結束
        }
    }
}