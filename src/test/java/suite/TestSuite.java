package suite;
//import org.example.UserTest.UserTest;
import org.example.SortTest.SortTest;
import org.example.StrokeProcessTest.StrokeProcessTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite
@SelectClasses({
        SortTest.class,
        StrokeProcessTest.class
})
public class TestSuite {
}
