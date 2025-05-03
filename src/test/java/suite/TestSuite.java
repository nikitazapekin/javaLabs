package suite;



import org.example.BlueRayDisc;

import org.example.BlueRayDiscTest.BlueRayDiscTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
/*
@Suite
@SelectClasses({StackTest.class, QueueTest.class,

})

 */
@Suite
@SelectClasses({  //PuppyTest.class
        BlueRayDiscTest.class

})
public class TestSuite {
}
