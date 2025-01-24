public class Exam {
    private int examId;
    private String subject;

    public Exam(int examId, String subject) {
        this.examId = examId;
        this.subject = subject;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Exam [Exam ID=" + examId + ", Subject=" + subject + "]";
    }
}
