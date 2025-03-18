
import org.example.MainTest;
import org.example.MainTest1;
import org.example.Point.PointTest;
import org.example.Point.PointTestAssertions;
import org.example.Triangle.TriangleTest;
import org.example.Triangle.TriangleTestAssertions;
import org.example.Triangle.TriangleUtils;
import org.example.TriangleUtils.TriangleUtilsAssertionsTest;
import org.example.TriangleUtils.TriangleUtilsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.example.Point.Point;

@RunWith(Suite.class)

@Suite.SuiteClasses({

        PointTest.class,
        PointTestAssertions.class,
        TriangleTest.class,
        TriangleTestAssertions.class,
        TriangleUtilsTest.class,
        TriangleUtilsAssertionsTest.class

})
public class TestSuite {

}










/*
import Test.MyFirstTest;

import org.example.MainTest;
import org.example.MainTest1;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({MainTest1.class, MainTest.class})
public class TestSuite {
    // Этот класс не требует дополнительного кода.
}


 */
/*public class TestSuite {
}


 */