package collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class CollectionLearnTest {

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "3, 3, 6",
            "5, 7, 12"
    })
    void  test(int a,int b,int c) {
        CollectionLearn learn =  new CollectionLearn();
        assertEquals(c,learn.Sum(a,b));
    }

    @Test
    void  test2() {
        CollectionLearn learn =  new CollectionLearn();
        assertEquals(4,learn.Sum(1,2));
    }

    @TestFactory
    public Collection<DynamicTest> testFactory() {
        CollectionLearn learn =  new CollectionLearn();
        return Arrays.asList(
                DynamicTest.dynamicTest("Test 1", () -> assertEquals(4,learn.Sum(1,2))),
                DynamicTest.dynamicTest("Test 2", () -> assertEquals(4,learn.Sum(2,2))),
                DynamicTest.dynamicTest("Test 3", () -> assertEquals(4,learn.Sum(3,2))) // This will fail
        );
    }
}