package com.example.demo;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.SoftBevelBorder;

class Questions extends JPanel {

    JLabel Q;

    JButton option1 , option2, option3,option4 ;

    String correct_answer;

    static boolean next = false ;
    static int score = 0 ;

    static JLabel timer = new JLabel ("00 : 00 : 000") ;
    static Counter count = new Counter();

    Questions (quiz2 obj , JFrame window) {

        Q = new JLabel (obj.question);
        option1 = new JButton (obj.op1) ;
        option2 = new JButton (obj.op2) ;
        option3 = new JButton (obj.op3) ;
        option4 = new JButton (obj.op4) ;
        correct_answer = obj.correct_answer ;

        JPanel pan = new JPanel () ;
        pan.setLayout(null);
        pan.setBorder(BorderFactory.createLineBorder(Color.gray));
        pan.setBackground(Color.DARK_GRAY);
        window.setContentPane(pan);
        setLayout(null);
        setBackground(Color.getHSBColor(154, 254, 25));
        setBounds(90,100,600,200);
        setBorder(BorderFactory.createLineBorder(Color.black));
        pan.add(this);

        add(Q); add(option1); add(option2); add(option3); add(option4);

        Q.setBounds(100,8,600,50);
        // Q.setHorizontalAlignment(JLabel.CENTER);
        option1.setBounds(90,70,200,40); option1.setBackground(new Color(255,255,255)) ;
        option2.setBounds(90,140,200,40); option2.setBackground(new Color(255,255,255)) ;
        option3.setBounds(330,70,200,40);  option3.setBackground(new Color(255,255,255)) ;
        option4.setBounds(330,140,200,40); option4.setBackground(new Color(255,255,255)) ;
        option1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        option2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        option3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        option4.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));

        timer.setBounds(250,400,300,50);
        timer.setFont(new Font("Verdana", Font.BOLD, 40));
        timer.setHorizontalAlignment(JLabel.CENTER);
        timer.setBorder(BorderFactory.createLineBorder(Color.white));
        timer.setForeground(Color.white);
        pan.add(timer);

    }

    void getAnswer (int time) throws InterruptedException {

        option1.addActionListener((ActionEvent e) -> {
            if (option1.getText().equals(correct_answer)) score++ ;
            next = true ;
        });

        option2.addActionListener((ActionEvent e) -> {
            if (option2.getText().equals(correct_answer)) score++ ;
            next = true ;
        });

        option3.addActionListener((ActionEvent e) -> {
            if (option3.getText().equals(correct_answer)) score++ ;
            next = true ;
        });

        option4.addActionListener((ActionEvent e) -> {
            if (option4.getText().equals(correct_answer)) score++ ;
            next = true ;
        });

        while (next == false ) {
            timer.setText(String.format("%02d", count.M)+" : "+String.format("%02d", count.S)+" : "+String.format("%03d", count.Ms));
            count.Ms++ ;
            Thread.sleep(1);
            if (count.Ms==999){
                count.S++ ;
                count.Ms=0 ;
            }
            if (count.S==60){ // base on time limit to answer
                count.M++ ;
                count.S=0;
            }

            if ((count.S + count.M*60) > time-3 ) {

                timer.setForeground(Color.red);

                if ((count.S + count.M*60)==time) {
                    return ;
                }
            }

        }
        next = false ;
    }

    int getScore() {return score ;}

    Counter getTime () {return count ;}

    void Reset () {
        count.M=0 ;
        count.Ms=0 ;
        count.S=0;
        score = 0 ;

    }
    public static void main(String[] args) throws InterruptedException {

        JFrame window = new JFrame ("Laboratory Management Quiz") ;
        window.setSize(800,500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        while (true) {

            int nbr =0 , score=0 , m=0 , s=0 ;
            int time = 60 ; //sec to set time limit

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

