// Q01

// a)
class Course {
    protected String courseID;
    protected String courseName;
    protected int durationWeeks;

    // b)
    public Course() {
        this("N/A", "N/A", 0);
    }


    public Course(String courseID, String courseName, int durationWeeks) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.durationWeeks = durationWeeks;
    }

    // c)
    public void displayCourseDetails() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + durationWeeks + " weeks");
    }

    // d) i)
    public double calculateTotalFee() {
        return 10000.00;
    }

    // d) ii)
    public double calculateTotalFee(double discountPercentage) {
        double fee = calculateTotalFee();
        return fee - (fee * discountPercentage / 100.0);
    }
}

// e)
class RegularCourse extends Course {

    // e) i)
    private boolean hasLiveSessions;

    // e) ii)
    public RegularCourse() {
        super();
        hasLiveSessions = false;
    }


    public RegularCourse(String courseID, String courseName,
                         int durationWeeks, boolean hasLiveSessions) {
        super(courseID, courseName, durationWeeks);
        this.hasLiveSessions = hasLiveSessions;
    }

    // e) iii)
    @Override
    public double calculateTotalFee() {
        return 100.0 * durationWeeks;
    }

    // e) iv)
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Live Sessions Included: " + hasLiveSessions);
        System.out.println("Total Fee: $" + calculateTotalFee());
    }
}

// f)
class PremiumCourse extends Course {

    // f) i)
    private boolean includeCertification;

    // (f) ii)
    public PremiumCourse() {
        super();
        includeCertification = false;
    }


    public PremiumCourse(String courseID, String courseName,
                         int durationWeeks, boolean includeCertification) {
        super(courseID, courseName, durationWeeks);
        this.includeCertification = includeCertification;
    }

    // f) iii)
    @Override
    public double calculateTotalFee() {
        double fee = 150.0 * durationWeeks;

        if (includeCertification) {
            fee += 50.0;
        }

        return fee;
    }

    // f) iv)
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Certification Included: " + includeCertification);
        System.out.println("Total Fee: $" + calculateTotalFee());
    }
}

// g)
public class CourseApp {
    public static void main(String[] args) {

        // g) i) - RegularCourse using default constructor
        RegularCourse regular = new RegularCourse();

        // g) ii) - PremiumCourse using parameterized constructor
        PremiumCourse premium = new PremiumCourse(
                "PC202", "Machine Learning", 6, true
        );

        System.out.println("Regular Course (Default Constructor)");

        // g) iv)
        regular.displayCourseDetails();

        // g) iii)
        System.out.println("Basic Fee: $" + regular.calculateTotalFee());
        System.out.println("Discounted Fee (10%): $"
                + regular.calculateTotalFee(10));

        System.out.println();
        System.out.println("Premium Course (Parameterized Constructor)");

        // g) iv)
        premium.displayCourseDetails();

        // g) iii)
        System.out.println("Basic Fee: $" + premium.calculateTotalFee());
        System.out.println("Discounted Fee (20%): $"
                + premium.calculateTotalFee(20));
    }
}