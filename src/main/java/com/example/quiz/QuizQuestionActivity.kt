package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.random.Random

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var myCurrentQuestionPosition:Int=1
    private var myQuestionList:List<Question>?=null
    private var mySelectedOptionPosition:Int=0
    private var myCorrectAnswers:Int=0
    private var myUserName:String?=null


    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var tvOptionOne:TextView?=null
    private var tvOptionTwo:TextView?=null
    private var tvOptionThree:TextView?=null
    private var tvOptionFour:TextView?=null
    private var btnSubmit:Button?=null
    private var canAnswer:Boolean=true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        myUserName=intent.getStringExtra(Constants.USER_NAME)

        val select: MediaPlayer =MediaPlayer.create(this,R.raw.select)
        val correct: MediaPlayer =MediaPlayer.create(this,R.raw.correct)
        val wrong: MediaPlayer =MediaPlayer.create(this,R.raw.wrong)
        val win: MediaPlayer =MediaPlayer.create(this,R.raw.win)

         tvQuestion=findViewById(R.id.tv_question)
         ivImage=findViewById(R.id.iv_image)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tv_progress)
         tvOptionOne=findViewById(R.id.tv_optionOne)
         tvOptionTwo=findViewById(R.id.tv_optionTwo)
         tvOptionThree=findViewById(R.id.tv_optionThree)
         tvOptionFour=findViewById(R.id.tv_optionFour)
         btnSubmit=findViewById(R.id.btn_answer)
         myQuestionList=Constants.getQuestion().shuffled()

        tvOptionOne!!.setOnClickListener(this)
        tvOptionTwo!!.setOnClickListener(this)
        tvOptionThree!!.setOnClickListener(this)
        tvOptionFour!!.setOnClickListener(this)
        btnSubmit?.setOnClickListener (this)

        setQuestion()
        win.start()
        btnSubmit?.setOnClickListener{
            if(mySelectedOptionPosition==0){
                myCurrentQuestionPosition++
                win.start()
                when{
                    myCurrentQuestionPosition <= myQuestionList!!.size ->{
                        setQuestion()
                    }else->{
                    val intent=Intent(this , ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME , myUserName)
                    intent.putExtra(Constants.CORRECT_ANSWERS,myCorrectAnswers.toString())
                    intent.putExtra(Constants.TOTAL_QUESTIONS,myQuestionList?.size.toString())
                    startActivity(intent)
                    finish()
                }
                }
            }else{
                val question=myQuestionList?.get(myCurrentQuestionPosition-1)
                if(question?.correctAnswer==mySelectedOptionPosition){
                    correct.start()
                    myCorrectAnswers++
                    answerView(mySelectedOptionPosition , R.drawable.correct_answer)
                }else{
                    wrong.start()
                    answerView(mySelectedOptionPosition , R.drawable.wrong_answer)
                    answerView(question!!.correctAnswer , R.drawable.correct_answer)
                }
                if (myCurrentQuestionPosition == myQuestionList!!.size) {
                    btnSubmit?.text = "FINISH"
                } else {

                    btnSubmit?.text = "GO TO NEXT QUESTION"
                    canAnswer=false
                }
                mySelectedOptionPosition=0


            }
        }
    }






    private fun setQuestion(){

        defaultOptionView()
        canAnswer=true
        var currentQuestion=myQuestionList!![myCurrentQuestionPosition-1]


        tvQuestion?.text=currentQuestion.question
        ivImage?.setImageResource(currentQuestion.image)
        progressBar?.progress=myCurrentQuestionPosition
        tvProgress?.text="$myCurrentQuestionPosition/${progressBar?.max}"
        tvOptionOne?.text=currentQuestion.optionOne
        tvOptionTwo?.text=currentQuestion.optionTwo
        tvOptionThree?.text=currentQuestion.optionThree
        tvOptionFour?.text=currentQuestion.optionFour

         currentQuestion=myQuestionList!![myCurrentQuestionPosition-1]


        if (myCurrentQuestionPosition == myQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        } else {
            btnSubmit?.text = "Submit"
        }

    }

    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        //options.add(tvOptionOne!!)
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options){

            option.setTextColor(Color.parseColor("#7A9089"))
            option.typeface=Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView , selectedOptionNum:Int){

        defaultOptionView()
        tv.typeface= Typeface.DEFAULT_BOLD
        mySelectedOptionPosition=selectedOptionNum
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    private fun answerView(answer:Int ,drawableView:Int){

        when(answer){
            1-> {tvOptionOne?.background=ContextCompat.getDrawable(this,drawableView)}
            2-> {tvOptionTwo?.background=ContextCompat.getDrawable(this,drawableView)}
            3-> {tvOptionThree?.background=ContextCompat.getDrawable(this,drawableView)}
            4-> {tvOptionFour?.background=ContextCompat.getDrawable(this,drawableView)}
        }

    }



    override fun onClick(view: View?) {


        if(canAnswer){
            when(view?.id){
                R.id.tv_optionOne ->{
                    tvOptionOne?.let {
                        selectedOptionView(it,1)
                    }
                }
                R.id.tv_optionTwo ->{
                    tvOptionTwo?.let {
                        selectedOptionView(it,2)
                    }
                }
                R.id.tv_optionThree ->{
                    tvOptionThree?.let {
                        selectedOptionView(it,3)
                    }
                }
                R.id.tv_optionFour ->{
                    tvOptionFour?.let {
                        selectedOptionView(it,4)
                    }
                }
                R.id.btn_answer ->{



                }
            }
        }


    }
}


