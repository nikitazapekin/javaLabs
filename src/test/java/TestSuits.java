import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test Suite for All Tests")
//@SelectClasses(org.example.Point.PointTest.class) // Указываем конкретный тестовый класс
@SelectClasses(org.example.Point.PointTest.class)
public class TestSuits {
    // Этот класс будет служить как набор тестов, включающий указанные тестовые классы.
}
/*
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test Suite for All Tests")
@SelectPackages("org.example.Point") // Указываем пакет, где находятся тесты
public class TestSuits {
    // Этот класс будет служить как набор тестов, включающий все тесты из указанного пакета и его подпакетов.
}
*/
/*
/*
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
*/





/*
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("test") // Указываем корневой пакет, где находятся все тесты
public class TestSuits {
    // Этот класс будет служить как набор тестов, включающий все тесты из указанного пакета и его подпакетов.
}


 */
/*
public class TestSuits {

}


 */