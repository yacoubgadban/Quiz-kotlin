package com.example.quiz

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video.Media
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private var myUserName:String?=null
    private var myCorrectAnswers:String?=null
    private var myTotalQuestions:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val finish: MediaPlayer =MediaPlayer.create(this,R.raw.finish)
        finish.start()
         myUserName=intent.getStringExtra(Constants.USER_NAME)
        myCorrectAnswers=intent.getStringExtra(Constants.CORRECT_ANSWERS)
        myTotalQuestions=intent.getStringExtra(Constants.TOTAL_QUESTIONS.toString())
        val userName:TextView=findViewById(R.id.tv_name)
        userName.text=myUserName

        val tvScore:TextView=findViewById(R.id.tv_score)
        val btnFinish:Button=findViewById(R.id.btn_finish)
        tvScore.text="Your score is $myCorrectAnswers out of $myTotalQuestions"

        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}