import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
public class MainTest {

      @Test
      public void test()
      {
          assertArrayEquals(new long[]{-1,1,2,2,4},new Solve().findNextGreater(new long[]{2,3,1,4,5},new long[5]));
      }
}
