package com.example.quiz

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestion() : ArrayList<Question>{

        val questionList=ArrayList<Question>()
        val que1=Question(
            1,
            "What country does this flag belong to?",
            R.drawable.argentina,
            "Argentina",
            "Germany",
            "Brazil",
            "Jamaica",
            1
            )
        questionList.add(que1)
        val que2=Question(
            2,
            "What country does this flag belong to?",
            R.drawable.italy,
            "Brazil",
            "France",
            "Italy",
            "Argentina",
            3
        )
        questionList.add(que2)

        val que3=Question(
            3,
            "What country does this flag belong to?",
            R.drawable.france,
            "Netherlands",
            "France",
            "Turkey",
            "China",
            2
        )
        questionList.add(que3)
        val que4=Question(
            4,
            "What country does this flag belong to?",
            R.drawable.morocco,
            "Portugal",
            "China",
            "Turkey",
            "Morocco",
            4
        )
        questionList.add(que4)
        val que5=Question(
            5,
            "What country does this flag belong to?",
            R.drawable.japan,
            "Japan",
            "SouthKorea",
            "Mexico",
            "Hungary",
            1
        )
        questionList.add(que5)
        val que6=Question(
            6,
            "What country does this flag belong to?",
            R.drawable.jamaica,
            "Ghana",
            "Jamaica",
            "Jordan",
            "Mexico",
            2
        )
        questionList.add(que6)

        val que7=Question(
            7,
            "What country does this flag belong to?",
            R.drawable.greece,
            "Argentina",
            "Chile",
            "Greece",
            "Austria",
            3
        )
        questionList.add(que7)
        val que8=Question(
            8,
            "What country does this flag belong to?",
            R.drawable.albania,
            "Jersey",
            "Greece",
            "Morocco",
            "Albania",
            4
        )
        questionList.add(que8)
        val que9=Question(
            9,
            "What country does this flag belong to?",
            R.drawable.cameron,
            "Cameron",
            "Ghana",
            "Kosovo",
            "Romania",
            1
        )
        questionList.add(que9)

        val que10=Question(
            10,
            "What country does this flag belong to?",
            R.drawable.croatia,
            "Monaco",
            "Netherlands",
            "Nepal",
            "Croatia",
            4
        )
        questionList.add(que10)

        val que11=Question(
            11,
            "What country does this flag belong to?",
            R.drawable.hungary,
            "Romania",
            "Hungary",
            "Italy",
            "Russia",
            2
        )
        questionList.add(que11)

        val que12=Question(
            12,
            "What country does this flag belong to?",
            R.drawable.nigeria,
            "Nigeria",
            "India",
            "Albania",
            "Macedonia",
            1
        )
        questionList.add(que12)
        val que13=Question(
            13,
            "What country does this flag belong to?",
            R.drawable.chile,
            "Philippines",
            "Peru",
            "Chile",
            "Kosovo",
            3
        )
        questionList.add(que13)
        val que14=Question(
            14,
            "What country does this flag belong to?",
            R.drawable.colombia,
            "Romania",
            "Spain",
            "Colombia",
            "Serbia",
            3
        )
        questionList.add(que14)
        val que15=Question(
            15,
            "What country does this flag belong to?",
            R.drawable.denmark,
            "England",
            "Peru",
            "Ukraine",
            "Denmark",
            4
        )
        questionList.add(que15)

        return questionList
    }

}