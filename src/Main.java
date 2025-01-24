import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate(1, "Alice", "alice@example.com");
        Candidate candidate2 = new Candidate(2, "Bob", "bob@example.com");

        Exam exam1 = new Exam(101, "Math");
        Exam exam2 = new Exam(102, "Science");

        System.out.println(candidate1);
        System.out.println(candidate2);
        System.out.println(exam1);
        System.out.println(exam2);

        System.out.println("Are candidates equal? " + candidate1.equals(candidate2));

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/aitu_zhaniya_oop",
                    "postgres",
                    "password"
            );

            String insertCandidate = "INSERT INTO Candidate (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt1 = conn.prepareStatement(insertCandidate);
            pstmt1.setInt(1, candidate1.getId());
            pstmt1.setString(2, candidate1.getName());
            pstmt1.setString(3, candidate1.getEmail());
            pstmt1.executeUpdate();

            String insertExam = "INSERT INTO Exam (examId, subject) VALUES (?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(insertExam);
            pstmt2.setInt(1, exam1.getExamId());
            pstmt2.setString(2, exam1.getSubject());
            pstmt2.executeUpdate();

            String readQuery = "SELECT * FROM Candidate";
            ResultSet rs = conn.createStatement().executeQuery(readQuery);
            while (rs.next()) {
                System.out.println("Candidate from DB: ID=" + rs.getInt("id") + ", Name=" + rs.getString("name") + ", Email=" + rs.getString("email"));
            }

            String updateQuery = "UPDATE Candidate SET email=? WHERE id=?";
            PreparedStatement pstmt3 = conn.prepareStatement(updateQuery);
            pstmt3.setString(1, "updated_email@example.com");
            pstmt3.setInt(2, 1);
            pstmt3.executeUpdate();

            String deleteQuery = "DELETE FROM Candidate WHERE id=?";
            PreparedStatement pstmt4 = conn.prepareStatement(deleteQuery);
            pstmt4.setInt(1, 2);
            pstmt4.executeUpdate();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
