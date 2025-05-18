package suite;



import org.example.UserTest.UserTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({  //PuppyTest.class
        UserTest.class

})
public class TestSuite {
}
