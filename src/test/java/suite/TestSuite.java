package suite;

//import org.example.point.PointAssertions;
import org.example.point.PointTest;
import org.example.triangle.TriangleTest;
import org.example.triangleUtils.TriangleUtilsTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
//@SuiteDisplayName("Test Suite for All Tests")
@SelectClasses({PointTest.class, TriangleTest.class,
        TriangleUtilsTest.class
})
public class TestSuite {
}