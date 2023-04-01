package com.example.demo;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Quiz {
    public static void main(String[] args) throws InterruptedException {

        JFrame window = new JFrame ("Laboratory Management Quiz") ;
        window.setSize(800,500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        while (true) {

            int nbr =0 , score=0 , m=0 , s=0 ;
            int time = 60 ; //sec

            WelcomePage welcome = new WelcomePage (window);
            welcome.choose(time);

            quiz2 [] qObj = {
                    new quiz2("1. We are not able to eliminate all risk but it must be: ","Converted","Reduce","Control","Preserve","Control"),
                    new quiz2("2. UTP HSE Policy statement consists of: ","6 elements","8 elements","5 elements","7 elements","6 elements"),
                    new quiz2("3. First aid will be administered by:","Trained First Aider","Graduate Assistant","Laboratory Manager","Lecturer","Trained First Aider"),
                    new quiz2("4. Defective equipment or broken glassware must be reported to:","Laboratory Manager","Graduate Assistant","Research Scientist","Laboratory Personnel","Laboratory Personnel"),
                    new quiz2("5. Occupational Safety and Health Act (OSHA) was enacted on : ","24th February 1994","22nd February 1994","25th February 1994","23rd February 1994","25th February 1994"),
                    new quiz2("6. We are not able to eliminate all risk but it must be: ","Personal Protective Equipment","Personal Protective Essentials","Personal Protective Expert","Personal Protective Examples","Personal Protective Equipment"),
                    new quiz2("7. What is the common way to determine what is practicable? ","Cost Performance Analysis","Safety","Variable Cost","Cost–benefit Evaluations","Cost–benefit Evaluations"),
                    new quiz2("8. In which section stated the First Aid Measures? ","Section A","Section E","Section F","Section B","Section F"),
                    new quiz2("9. The exclamation mark symbol means that the contents inside are: ","Very hot","Harmful/Irritants","Unstable/Volatile","Radioactive","Harmful/Irritants"),
                    new quiz2("10. How much information that contains in SDS in minimum? ","8","12","14","16","16"),


            };

            while (nbr != qObj.length && s<time ) {
                Questions quiz = new Questions(qObj[nbr], window);
                quiz.getAnswer(time);
                m = quiz.getTime().M ;
                s = quiz.getTime().S ;
                score = quiz.getScore();
                if (nbr == qObj.length-1 || (s==time)) quiz.Reset();
                nbr++ ;
            }

            int nbrQ = qObj.length ;
            scorePane scorePane = new scorePane (window,score,nbrQ) ;
            scorePane.choose();

        }

    }
}