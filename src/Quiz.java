import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;

    public Quiz() {
        questions = new ArrayList<Question>();
    }

    public void addSet1(Question question) {
        questions.add(question);
    }

    public void addSet2(Question question) {
        questions.add(question);
    }
    public void addSet3(Question question) {
        questions.add(question);
    }



    public int getNumQuestions() {
        return questions.size();
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }
}