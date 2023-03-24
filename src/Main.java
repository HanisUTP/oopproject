import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

        public static void disp(){
                System.out.println("********************WELCOME TO LMG QUIZ********************\n");
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your name: ");
                String name = input.nextLine();
                System.out.print("Enter your student ID: ");
                int studentID = input.nextInt();
                System.out.println("welcome " + name + ", your student ID is " + studentID);
                System.out.println("    Please take note this quiz will determine whether you qualified to have your LAB MANAGEMENT LISENCE      ");
                input.nextLine();
                System.out.println("Do you want to start the quiz // enter yes or no: ");
                String yesno = input.nextLine();
                if (yesno.equals("yes")) {
                        System.out.println("LET'S START.");

                } else {
                        System.out.println("You entered no.");
                }

        }






    public static void main(String[] args) {
            Quiz quiz = new Quiz();
            // set 1
            quiz.addSet1(new Question("As laboratory users, which is NOT the responsibility of Students/Researchers/ Visitors / Vendors? ", new ArrayList<String>(Arrays.asList("Focus on own work and take minimal notice of any risk of health and safety on themselves or any other person", "Avoid, eliminate or minimize hazards of which they are aware", "Comply with all occupational health and safety instructions")), 0));
            quiz.addSet1(new Question("Students, Researchers, visitor and vendors are not permitted to enter any laboratory without approval from the laboratory personnel. Which is the correct channel to seek for approval?", new ArrayList<String>(Arrays.asList("Laboratory executive", "Laboratory manager", "iLab/ULAB")), 2));
            quiz.addSet1(new Question("Report all injuries and illness to the graduate assistant and laboratory personnel. First aid will be administered by:", new ArrayList<String>(Arrays.asList(".Trained first aider", "Graduate assistant", "Laboratory manager")), 0));
            quiz.addSet1(new Question("Defective equipment or broken glassware must be reported to:", new ArrayList<String>(Arrays.asList("Laboratory Manager", "Laboratory personnel", "Research Scientist")), 1));
            quiz.addSet1(new Question("We are not able to eliminate all risk but it must be:", new ArrayList<String>(Arrays.asList("Converted", "Reduce", "Control")), 2));
            quiz.addSet1(new Question("Define Mechanical hazard", new ArrayList<String>(Arrays.asList("Common work activities pose repetitive stress ergonomic hazards", "Refer to moving machinery that can cause injury or death", "Substances, mixtures and materials that can be classified according to their health and physicochemical risks and dangers")), 1));
            quiz.addSet1(new Question("The purpose of HIRARC is as below EXCEPT:", new ArrayList<String>(Arrays.asList("To identify the cost of hazards", "To consider what the chances are of that harm actually be falling anyone in the circumstances of a particular case and the possible severity that could come from it (the risks)", "To identify all the factors that may cause harm to employees and others (the hazards)")), 0));
            quiz.addSet1(new Question("This image on a container means that the contents inside are:", new ArrayList<String>(Arrays.asList("Very hot", "Harmful/Irritants", "Unstable/Volatile")), 1));
            quiz.addSet1(new Question("What does PPE stands for:", new ArrayList<String>(Arrays.asList("Personal protective equipment", "Personal protective essentials", "Personal protective examples")), 0));
            // set 2
            quiz.addSet2(new Question("An example of unsafe condition:", new ArrayList<String>(Arrays.asList("Wearing proper PPE before entering laboratory", "Performing experiment on faulty machine", "Performing housekeeping after finish experiment in laboratory")), 1));
            quiz.addSet2(new Question("UTP HSE Policy statement consists of", new ArrayList<String>(Arrays.asList("6 elements", "8 elements", "5 elements")), 0));
            quiz.addSet2(new Question("Working spaces are to be kept clean. Broken glass, sharp debris and laboratory waste must be placed", new ArrayList<String>(Arrays.asList("Outside the lab", "Inside plastic bag and handed over to cleaning worker", "In the marked bins in the laboratory")), 2));
            quiz.addSet2(new Question("What is the meaning of ‘horseplay’?", new ArrayList<String>(Arrays.asList("Enjoying during lab activities", "Rough play in which people push and hit each other, or behave in silly way", "A friendly, physical way to do lab activities")), 1));
            quiz.addSet2(new Question("In determining what is reasonably practicable, important key factors are as below EXCEPT:", new ArrayList<String>(Arrays.asList("Adhering to rules and regulations to ensure safety in laboratory", "Knowledge about ways of eliminating or minimizing the hazard", "The degree of harm from the hazard or risk")), 0));
            quiz.addSet2(new Question("The following are HIRARC steps EXCEPT:", new ArrayList<String>(Arrays.asList("Conduct risk assessment/ analysis", "Identify required Personnel Protective Equipment (PPE)", "Classify work activities")), 1));
            quiz.addSet2(new Question("What is HIRARC?", new ArrayList<String>(Arrays.asList("Hazard Identification, Risk Assessment & Risk Control", "Hazard Implementation, Risk Assessment & Risk Control", "Hazard Infectious, Risk Assessment & Risk Control")), 0));
            quiz.addSet2(new Question("The penalty of contravene the General Duties of Employees at work (Section 24), is", new ArrayList<String>(Arrays.asList("RM 1,500 or three months imprisonment or both", "RM 1,000 or three months imprisonment or both", "RM 1,400 or three months imprisonment or both")), 1));

            // set 3
            quiz.addSet3(new Question("What are the two main causes of incidents in the workplace?", new ArrayList<String>(Arrays.asList("Unsafe conditions and unsafe machines", "Unsafe people and unsafe machines", "Unsafe acts and unsafe conditions")), 2));
            quiz.addSet3(new Question("All laboratory users must be aware of the conditions required for the safe handling of hand tools, substances, chemicals, materials being handled. If in any doubt, whom is the right person to seek guidance?", new ArrayList<String>(Arrays.asList("The laboratory personnel", "IT personnel", "Classmates")), 0));
            quiz.addSet3(new Question("Which section in LABORATORY SAFETY RULES & REGULATIONS stating on the First Aid Measures?", new ArrayList<String>(Arrays.asList("Section A", "Section E", "Section F")), 2));
            quiz.addSet3(new Question("Why are jewellery and accessories are not allowed to be worn in the laboratory?", new ArrayList<String>(Arrays.asList(".Chemicals can become trapped under jewellery and cause injuries to the skin", "To prevent loss or theft", "To avoid other people from distracted")), 0));
            quiz.addSet3(new Question("What is the common way to determine what is practicable?", new ArrayList<String>(Arrays.asList("Cost performance analysis", "Cost–benefit evaluations", "Variable cost")), 1));
            quiz.addSet3(new Question("Biological hazard is defined as:", new ArrayList<String>(Arrays.asList("Refer to moving machinery that can cause injury or death", "Substances, mixtures and materials that can be classified according to their health and physicochemical risks and dangers", "Biological substance that poses a threat to the health of living organisms, primarily humans")), 2));
            quiz.addSet3(new Question("Ergonomic hazard is defined as:", new ArrayList<String>(Arrays.asList("Common work activities pose repetitive stress ergonomic hazards", "Substances, mixtures and materials that can be classified according to their health and physicochemical risks and dangers", "Common work activities pose repetitive stress ergonomic hazards")), 0));
            quiz.addSet3(new Question("A safety data sheet (SDS) is the most important source of chemical information needed. How much information that contains in SDS in minimum?", new ArrayList<String>(Arrays.asList("8", "12", "16")), 2));
            //quiz.addSet3(new Question("For all laboratory’s chemicals and equipment that you'll be working with, you should be familiar with:", new ArrayList<String>(Arrays.asList("Standard Operating Procedures (SOP) and hazards involved with the process", "Instructor’s and/or technologist’s name with the complete contact numbers", ".Make and model of the equipment being used and where it is located")), 0));
            //quiz.addSet3(new Question("Occupational Safety and Health Act (OSHA) was enacted on :", new ArrayList<String>(Arrays.asList("25th February 1994", "24th February 1994", "22nd February 1994")), 0));
            //quiz.addQuestion(new Question("", new ArrayList<String>(Arrays.asList("", "", "")), 0));

      QuizRunner quizRunner = new QuizRunner(quiz);
          /*


           */

            Main.disp();
            quizRunner.runQuiz();
            quizRunner.DispScore();
    }
}