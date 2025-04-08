package suite;
import org.example.point.PointTest;
import org.example.triangle.TriangleTest;
import org.example.triangleUtils.TriangleUtilsTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({PointTest.class, TriangleTest.class,
        TriangleUtilsTest.class
})
public class TestSuite {
}