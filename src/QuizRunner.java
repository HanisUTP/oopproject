import java.util.ArrayList;
import java.util.Scanner;

public class QuizRunner {
    private Quiz quiz;
    private Scanner scanner;
    int score = 0;
    public QuizRunner(Quiz quiz) {
        this.quiz = quiz;
        this.scanner = new Scanner(System.in);
    }
    public void runQuiz() {

        for (int i = 0; i < quiz.getNumQuestions(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println(question.getPrompt());
            ArrayList<String> answerChoices = question.getAnswerChoices();
            for (int j = 0; j < answerChoices.size(); j++) {
                System.out.println((j+1) + ". " + answerChoices.get(j));
            }
            System.out.print("your answer : ");
            int userAnswer = scanner.nextInt() - 1;
            if (userAnswer == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

    }
    public void DispScore() {
        if (score >= 24 && score <=25) {System.out.println("You got " + score + " out of " + quiz.getNumQuestions() + "  perfect r u gifted or really hard working ");
        } else if (score >= 20 && score < 24) {
            System.out.println("You got " + score + " out of " + quiz.getNumQuestions() + " why so clever");
        } else if (score >= 10 && score < 20) {
            System.out.println("You got " + score + " out of " + quiz.getNumQuestions() + " not bad man");
        } else if (score < 10) {
            System.out.println("You got " + score + " out of " + quiz.getNumQuestions() + " haha try r u kiding");
        }
    }
    }
