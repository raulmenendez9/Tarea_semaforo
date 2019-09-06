package com.example.tarea_semaforo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btn:Button
    lateinit var  texto:TextView
    private lateinit var mHandler: Handler
    private val mRunnable=object :Runnable{
        override fun run() {
            cambioColor()
            mHandler.postDelayed(this,5000)
        }
    }

    lateinit var lyt: LinearLayout
    var i:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn=findViewById<Button>(R.id.bottom)
        texto=findViewById<TextView>(R.id.titulo)
        lyt= findViewById<LinearLayout>(R.id.container)

        mHandler = Handler(Looper.getMainLooper())

        bottom.setOnClickListener{
            if (i==0){
                mHandler.post(mRunnable)
                i=1
                btn.setText(R.string.parar)
            }else {
                mHandler.removeCallbacks(mRunnable)
                i=0
                btn.setText(R.string.iniciar)
                lyt.setBackgroundColor(Color.GRAY)
            }

        }

    }

    fun cambioColor(){
        when(i){
            1->{
                texto.setText(R.string.Alto)
                lyt.setBackgroundColor(Color.RED)
                i++

            }
            2->{
                texto.setText(R.string.Precaucion)
                lyt.setBackgroundColor(Color.YELLOW)
                i++
            }
            3->{
                texto.setText(R.string.Adelante)
                lyt.setBackgroundColor(Color.GREEN)
                i=1

            }
        }


    }


}
