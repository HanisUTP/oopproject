package com.example.demo;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.SoftBevelBorder;

class Questions extends JPanel {

    JLabel Q;

    JButton option1 , option2, option3,option4 ;

    String correct_answer,
            hint  ;

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
            if (count.S==60){ // set time limit to answer
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

}

