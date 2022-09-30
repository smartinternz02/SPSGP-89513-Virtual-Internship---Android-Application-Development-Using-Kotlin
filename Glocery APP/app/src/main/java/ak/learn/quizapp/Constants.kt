package ak.learn.quizapp

object Constants {

    const val User_name : String = "user_name"
    const val Total_Question :String = "total_question"
    const val Correct_answer : String =  "correct_answer"



    fun getQuestions() : ArrayList<Question>{

        val questionslist = ArrayList<Question>()


        val ques7 = Question(
            1, "Which one of the following is an application of stack Data Structure?",
           R.drawable.pictorial,
            "Managing function Calls", " The stock span Problem "
            ,"Arithmetic Expression evaluation" ,"All of the above ",
            4
        )
        questionslist.add(ques7)

        val ques1 = Question(
            1, "A hash table of length 10 uses open addressing with hash function h(k)=k mod 10, and linear probing. After inserting 6 values into an empty hash table, the table is as shown below.",
            R.drawable.gate2010_1,
            "46, 42, 34, 52, 23, 33" ,"34, 42, 23, 52, 33, 46" ,
            "46, 34, 42, 23, 52, 33" , "46, 34, 42, 23, 52, 33" ,
             3
            )
        questionslist.add(ques1)

        val ques2 = Question(
            1, "What Country does this flag belong to?",
            R.drawable.ic_eng,
            "Sudan" ,"Jordan" ,
            "England" , "Austria" ,
            3
        )
        questionslist.add(ques2)

        val ques3 = Question(
            1, "What Country does this flag belong to?",
            R.drawable.ic_indiaflag,
            "Argentina" ,"India" ,
            "Armenia" , "Austria" ,
            2
        )
        questionslist.add(ques3)

        val ques4 = Question(
            1, "The keys 12, 18, 13, 2, 3, 23, 5 and 15 are inserted into an initially empty hash table of length 10 using open addressing with hash function h(k) = k mod 10 and linear probing. What is the resultant hash table?",
            R.drawable.gate_2009_hash,
            "A" ,"B" ,
            "C" , "D" ,
            3
        )
        questionslist.add(ques4)

        val ques5 = Question(
            1, "What Country does this flag belong to?",
            R.drawable.ic_argen,
            "UAE" ,"Australia" ,
            "Armenia" , "Argentina" ,
            4
        )
        questionslist.add(ques5)


        val ques6 = Question(

            1, "A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?" ,
             R.drawable.train ,
             "150 metres" , "180 metres" ,
             "324 metres" ,  "120 metres",
             1
        )
        questionslist.add(ques6)


        val ques8 = Question(

            1 , "Name the Father of the Indian Constitution?",
            R.drawable.dr ,
            " Dr. B. R. Ambedkar" , "APJ Abdul Kalam" ,
             "Arun Tiwari" , "Jawaharlal Nehru" ,
            1
        )

        questionslist.add(ques8)

     val ques9 = Question(

         1 , "............is the largest ocean in the world",
          R.drawable.pacific ,
         "Atlantic" , "Pacific" ,
          "Indian" , "Arctic" ,
          2
     )
        questionslist.add(ques9)

        val ques10 = Question(

         1 , "How is an array initialized in C language?" ,
           R.drawable.arrayn ,
         "int a[5] = {1,2,3,4,5};" , "int a = {1,2,3,4,5};",
            "int a[]= new int[5]" , "int a(5) = [1,2,3,4,5];" ,
             1
        )
        questionslist.add(ques10)

        val ques11 = Question(

            1 , "What will be the output of the following code snippet? " + "void solve() {\n" +
                    "   int a[] = {1, 2, 3, 4, 5};\n" +
                    "   int sum = 0;\n" +
                    "   for(int i = 0; i < 5; i++) {\n" +
                    "       if(i % 2 == 0) {\n" +
                    "           sum += *(a + i);\n" +
                    "       }\n" +
                    "       else {\n" +
                    "           sum -= *(a + i);\n" +
                    "       }\n" +
                    "   }\n" +
                    "   cout << sum << endl;\n" +
                    "}" ,
            R.drawable.arrayques ,

          "5" , "2" , "Syntax Error" ,
            "3" ,
        4

        )
        questionslist.add(ques11)

        val ques12 = Question(

            1 , " \n" +
                    "What will be the output of the following code snippet?\n" +
                    "\n" +
                    "void solve() {\n" +
                    "   int a[] = {1, 2, 3, 4, 5};\n" +
                    "   int sum = 0;\n" +
                    "   for(int i = 0; i < 5; i++) {\n" +
                    "       if(i % 2 == 0) {\n" +
                    "           sum += a[i];\n" +
                    "       }\n" +
                    "   }\n" +
                    "   cout << sum << endl;\n" +
                    "}" ,
            R.drawable.solve ,
            "3" , "9" , "18",
            "Syntax Error",
            2
        )
        questionslist.add(ques12)


        return questionslist

    }

}


