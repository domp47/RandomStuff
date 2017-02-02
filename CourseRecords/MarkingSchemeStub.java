package CourseRecords;

public class MarkingSchemeStub implements MarkingScheme {
    
    public int getNumWork ( ) {
        System.out.println("MarkingScheme.getNumWork returned 4");
        return 4;
    };
    
    public String getName ( int num ) {
        System.out.println("MarkingScheme.getName("+num+") returned Work");
        return "Work";
    }
    
    public double getBase ( int num ) {
        System.out.println("MarkingScheme.getBase("+num+") returned 10");
        return 10;
    }
    
    public double getWeight ( int num ) {
        System.out.println("MarkinhScheme.getWeight("+num+") returned 25");
        return 25;
    }
    
    public double apply ( Student theStudent ) {
        System.out.println("MarkingScheme.apply("+theStudent+") returned 75");
        return 75;
    };
    
} // MarkingScheme
