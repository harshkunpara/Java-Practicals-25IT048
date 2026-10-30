class ExamSession implements AutoCloseable {
    private String studentName;
    public ExamSession(String studentName) {
        this.studentName = studentName;
        System.out.println(
            "Exam session opened for " + studentName
        );
    }
   public void startExam() {
       System.out.println(
            "Exam started for " + studentName
        );
    }
    @Override
    public void close() {

        System.out.println(
            "Exam session closed for " + studentName
        );}}
public class TryWithResourcesDemo{
    public static void main(String[] args) {
        try (ExamSession session =
                new ExamSession("Harsh")) {
            session.startExam();
            System.out.println(
                "Doing exam work...");
            throw new RuntimeException(
                "Something went wrong during the exam!");}
        catch (RuntimeException e) {
            System.out.println(
                "Caught error: " + e.getMessage());}}}