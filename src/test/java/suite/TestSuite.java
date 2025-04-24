package suite;

/*
import org.example.Stack.StackTest;
import org.example.Queue.QueueTest;

 */
import org.example.Animal.AnimalTest;
import org.example.Dog.DogTest;
import org.example.Puppy.PuppyTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
/*
@Suite
@SelectClasses({StackTest.class, QueueTest.class,

})

 */
@Suite
@SelectClasses({AnimalTest.class, DogTest.class, PuppyTest.class

})
public class TestSuite {
}
