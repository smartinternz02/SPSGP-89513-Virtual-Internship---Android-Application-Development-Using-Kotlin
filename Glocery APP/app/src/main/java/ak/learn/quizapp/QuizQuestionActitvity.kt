package ak.learn.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActitvity : AppCompatActivity(), View.OnClickListener{

    private var  mCurrentPosition: Int = 1
    private var mQuestionPosition:ArrayList<Question>? = null
    private var mSelectorOptionPosition : Int = 0
    private var mUsername : String? = null
    private var mCorrectAnswer : Int = 0


    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var tvImage : ImageView? = null

    private var tvOptionone : TextView? = null
    private var tvOptiontwo : TextView? = null
    private var tvOptionthree : TextView? = null
    private var tvOptionfour : TextView? = null
    private var btnSubmit : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_actitvity)

        mUsername = intent.getStringExtra(Constants.User_name)

        progressBar = findViewById(R.id.progress)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        tvImage = findViewById(R.id.iv_image)
        tvOptionone = findViewById(R.id.tv_option_one)
        tvOptiontwo  = findViewById(R.id.tv_option_two)
        tvOptionthree = findViewById(R.id.tv_option_three)
        tvOptionfour = findViewById(R.id.tv_option_four)
       btnSubmit = findViewById(R.id.btn_submit)


        tvOptionone?.setOnClickListener(this)
        tvOptiontwo?.setOnClickListener(this)
        tvOptionthree?.setOnClickListener(this)
        tvOptionfour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)



          mQuestionPosition = Constants.getQuestions()

        setQuestion()


    }

     private fun setQuestion() {
        defaultOptionView()

        val question: Question = mQuestionPosition!![mCurrentPosition - 1]

        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition"
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)
        tvOptionone?.text = question.OptionOne
        tvOptiontwo?.text = question.OptionTwo
        tvOptionthree?.text = question.OptionThree
        tvOptionfour?.text = question.OptionFour

        if(mCurrentPosition == mQuestionPosition!!.size){

            btnSubmit?.text = "Finish"
        }else{
            btnSubmit?.text = "Submit"
        }
    }


     private fun defaultOptionView() {
         val options = ArrayList<TextView>()
         tvOptionone?.let {
             options.add(0 , it)
         }

         tvOptiontwo?.let {
             options.add(1 , it)
         }
         tvOptionthree?.let {
             options.add(2 , it)
         }
         tvOptionfour?.let {
             options.add(3 , it)
         }

         for(option in options){
             option.setTextColor(Color.parseColor("#7A8089"))
             option.typeface = Typeface.DEFAULT
             option.background = ContextCompat.getDrawable(
                 this , R.drawable.default_option_border_bg
             )
         }

     }

      private fun selectedOptionView(tv:TextView , selectedOptionNum : Int ){

        defaultOptionView()

        mSelectorOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
          tv.background =  ContextCompat.getDrawable(
              this , R.drawable.selected_option_border_bg
          )

    }

    override fun onClick(view: View?) {
      when(view?.id){

      R.id.tv_option_one -> {

          tvOptionone?.let{
              selectedOptionView(it , 1)
          }

      }

          R.id.tv_option_two -> {

              tvOptiontwo?.let{
                  selectedOptionView(it , 2)
              }

          }
          R.id.tv_option_three -> {

              tvOptionthree?.let{
                  selectedOptionView(it , 3)
              }

          }
          R.id.tv_option_four -> {

              tvOptionfour?.let{
                  selectedOptionView(it , 4)
              }
          }
          R.id.btn_submit ->{

          if(mSelectorOptionPosition == 0){
              mCurrentPosition++

              when{
                  mCurrentPosition <= mQuestionPosition!!.size ->{
                      setQuestion()
                  }else ->{

                      val intent = Intent(this, ResultActivity::class.java)
                      intent.putExtra(Constants.User_name , mUsername)
                      intent.putExtra(Constants.Correct_answer , mCorrectAnswer )
                      intent.putExtra(Constants.Total_Question , mQuestionPosition?.size)
                      startActivity(intent)
                       finish()
                  }
              }
          }else {
               val question = mQuestionPosition?.get(mCurrentPosition - 1)
              if(question!!.correctAnswer != mSelectorOptionPosition){
                  answerView(mSelectorOptionPosition , R.drawable.wrong_option_border_bg)
              }else{

                  mCorrectAnswer++
              }
              answerView(question.correctAnswer , R.drawable.correct_option_border_bg)

            if(mCurrentPosition == mQuestionPosition!!.size){
                btnSubmit?.text = "Finish"
            }else{
                btnSubmit?.text = " Go To Next Question"
            }

              mSelectorOptionPosition = 0;
          }
          }
      }
    }

    private fun answerView(answer :Int , drawableView  : Int){
    when(answer){
         1 -> {
             tvOptionone?.background = ContextCompat.getDrawable(
                 this,
                 drawableView
             )
         }

            2 -> { tvOptiontwo?.background = ContextCompat.getDrawable(
                this@QuizQuestionActitvity,
                drawableView
            )
        }

          3 -> {  tvOptionthree?.background = ContextCompat.getDrawable(
                this@QuizQuestionActitvity,
                drawableView
            )
        }

           4 -> {
              tvOptionfour?.background = ContextCompat.getDrawable(
                this@QuizQuestionActitvity,
                drawableView
             )
          }
        }
     }
}