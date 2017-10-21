import com.mycompany.mapper.Iterable;
import com.mycompany.mapper.NonIterable;
import com.mycompany.mapper.SourceTargetMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SourceToTargetMapperTest {

    @Test
    public void testToTarget() {

        NonIterable nonIterable = new NonIterable();
        nonIterable.setMyInteger(1);
        nonIterable.setMyString("hello");

        Iterable iterable = SourceTargetMapper.MAPPER.toTarget(nonIterable);

        assertEquals(iterable.getMyIntegers().get(0), nonIterable.getMyInteger());
        assertEquals(iterable.getMyStrings().get(0), nonIterable.getMyString());
    }
}
