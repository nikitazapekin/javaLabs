
import org.example.MainTest;
import org.example.MainTest1;
import org.example.Point.PointTest;
import org.example.Point.PointTestAssertions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.example.Point.Point;

@RunWith(Suite.class)

@Suite.SuiteClasses({

      //  MainTest1.class,
       // MainTest.class,
        PointTest.class,
        PointTestAssertions.class
})
public class TestSuite {
    // Этот класс не требует дополнительного кода.
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