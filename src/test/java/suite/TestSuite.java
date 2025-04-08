package suite;


import org.example.Stack.StackTest;
import org.example.Queue.QueueTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({StackTest.class, QueueTest.class,

})
public class TestSuite {
}
