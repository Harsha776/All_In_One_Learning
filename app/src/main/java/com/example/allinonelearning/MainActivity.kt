package com.example.allinonelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.allinonelearning.di.components.DaggerActivityComponent
import com.example.allinonelearning.di.module.ActivityModule
import com.example.allinonelearning.room.entityPojo.Note
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var mainViewModel: MainViewModel
    lateinit var tvText:TextView
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText=findViewById(R.id.tvText)
        btn=findViewById(R.id.btn)
        DaggerActivityComponent.builder()
            .applicationComponent((application as (MyApplication)).applicationComponent)
            .activityModule(ActivityModule(this))
            .build().inject(this)
        tvText.setText("mainViewModel.getData()")
        mainViewModel.getData()

        Log.d("TAG", "onCreate: "+Date().time)

        /*val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        System.out.println(" C DATE is  "+currentDate)*/
        val notes=Note(noteText ="Harsha", date = Date())
        val myApplication=application as MyApplication
        val notesDao=myApplication.getInstance().noteDao()
        notesDao.addNote(notes)

        btn.setOnClickListener {
            Log.d("TAG", "onCreate: "+ notesDao.getNotes())
        }

    }
}