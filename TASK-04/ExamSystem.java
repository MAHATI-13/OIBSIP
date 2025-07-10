
import java.util.*;

public class ExamSystem {
    private User user = new User("mahati", "1234", "Mahati");
    private Scanner sc = new Scanner(System.in);
    private int timer = 60; // seconds

    public void start() {
        System.out.print("Enter Username: ");
        String username = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

        if (user.login(username, password)) {
            System.out.println("Login successful! Welcome " + user.getName());
            menu();
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void menu() {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Update Profile");
            System.out.println("2. Start Exam");
            System.out.println("3. Logout");
            System.out.print("Choose option: ");
            int opt = sc.nextInt();

            switch (opt) {
                case 1: updateProfile(); break;
                case 2: startExam(); break;
                case 3: System.out.println("Session closed. Logging out."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void updateProfile() {
        System.out.print("Enter new name: ");
        String name = sc.next();
        System.out.print("Enter new password: ");
        String pwd = sc.next();
        user.setName(name);
        user.setPassword(pwd);
        System.out.println("Profile updated successfully!");
    }

    private void startExam() {
        System.out.println("\nStarting Exam. You have " + timer + " seconds.");
        TimerThread timerThread = new TimerThread(timer);
        timerThread.start();

        int score = 0;
        String[] questions = {
            "Q1: What is 2+2?\nA. 3  B. 4  C. 5  D. 6",
            "Q2: Capital of India?\nA. Mumbai  B. Delhi  C. Kolkata  D. Chennai",
            "Q3: Java is...\nA. Platform  B. OS  C. Language  D. Software"
        };
        char[] answers = {'B', 'B', 'C'};

        for (int i = 0; i < questions.length && !timerThread.isTimeUp(); i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            char ans = sc.next().toUpperCase().charAt(0);
            if (ans == answers[i]) score++;
        }

        timerThread.interrupt(); // stop timer thread
        System.out.println("Exam over. Your score: " + score + "/" + questions.length);
    }
}
