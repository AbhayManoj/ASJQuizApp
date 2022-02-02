package com.example.asjquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var pointText:TextView
    private lateinit var questionNoText:TextView
    private lateinit var questionText:TextView
    private lateinit var optionAText:RadioButton
    private lateinit var optionBText:RadioButton
    private lateinit var optionCText:RadioButton
    private lateinit var optionDText:RadioButton
    private lateinit var submitButton:Button

    private lateinit var questionBank:ArrayList<Question>

    private var questionNO=0
    private var answer:String=""
    private var score:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        pointText=findViewById(R.id.textView4)
        questionNoText=findViewById(R.id.textView5)
        questionText=findViewById(R.id.textView6)

        optionAText=findViewById(R.id.radioButton)
        optionBText=findViewById(R.id.radioButton2)
        optionCText=findViewById(R.id.radioButton3)
        optionDText=findViewById(R.id.radioButton4)

        submitButton=findViewById(R.id.button2)

        questionBank=ArrayList()
        questionNO=0

        setUPQuestions()
        initListeners()
        display(questionNO)
    }

    fun clearAll(){
        optionAText.isChecked=false
        optionBText.isChecked=false
        optionCText.isChecked=false
        optionDText.isChecked=false
    }
    @SuppressLint("SetTextI18n")
    fun display(index:Int){
        var questionObject=questionBank.get(index)
        questionNoText.text="Question No:"+(questionNO+1).toString()
        questionText.text=questionObject.question
        optionAText.text=questionObject.optionA
        optionBText.text=questionObject.optionB
        optionCText.text=questionObject.optionC
        optionDText.text=questionObject.optionD
    }

    fun setUPQuestions()
    {
        questionBank.add(
            Question(
                "What is JNI in Android?",
                "Java network interface",
                "Java interface",
                "Image editable tool",
                "Java native interface",
                "Java native interface"
            )
        )
        questionBank.add(
            Question(
                "What is the main difference between set and list in android?",
                "Both are same",
                "Set can't contain duplicate values",
                "List may contain duplicate values",
                "B and C",
                "B and C"
            )
        )
        questionBank.add(
            Question(
                "What are the layouts available in Android?",
                "Linear Layout",
                "Frame Layout",
                "Table Layout",
                "All of the above",
                "All of the above"
            )
        )
        questionBank.add(
            Question(
                "What is an anonymous class in Android?",
                "Interface class",
                "A class that does not have a name but have functionalities in it",
                "Java class",
                "Manifest class",
                "A class that does not have a name but have functionalities in it"
            )
        )
        questionBank.add(
            Question(
                "What is the package name of JSON?",
                "com.json",
                "in.json",
                "com.android.json",
                "org.json",
                "org.json"
            )
        )

    }
    fun isCorrect(value: String):Boolean{
        return answer==value
    }

    fun initListeners(){
       optionAText.setOnClickListener{
          clearAll()
           optionAText.isChecked=true
           answer=optionAText.text.toString()
       }
        optionBText.setOnClickListener{
          clearAll()
            optionBText.isChecked=true
            answer=optionBText.text.toString()
        }
        optionCText.setOnClickListener{
          clearAll()
            optionCText.isChecked=true
            answer=optionCText.text.toString()
        }
        optionDText.setOnClickListener{
          clearAll()
            optionDText.isChecked=true
            answer=optionDText.text.toString()
        }
        submitButton.setOnClickListener{
            clearAll()
            if(isCorrect(questionBank.get(questionNO).answer)){
                score=score+10;
                pointText.text=score.toString()
            }
            if (questionNO<questionBank.size-1)
            {
                questionNO++
            display(questionNO)}
            else{
                 var intent=Intent(this,MainActivity3::class.java)
                intent.putExtra("score",score.toString())
                startActivity(intent)
            }
        }
    }
}

data class Question(
    var question:String,
    var optionA:String,
    var optionB:String,
    var optionC:String,
    var optionD:String,
    var answer:String

)