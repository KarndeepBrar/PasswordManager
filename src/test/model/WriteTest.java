package model;

import exception.PasswordLengthException;
import exception.UsernameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Write;

import static org.junit.jupiter.api.Assertions.fail;

public class WriteTest {
    private static final String TEST_PATH = "testCombos";
    private CombinationList testList;
    private Combination testCombo1 = new Combination("user1", "pw1", "test1.com");
    private Combination testCombo2 = new Combination("user1", "pw2", "test2.com");
    private Combination testCombo3 = new Combination("user2", "pw3", "test3.com");

    public WriteTest() throws PasswordLengthException, UsernameLengthException {
    }

    @BeforeEach
    void runBefore() {
        testList = new CombinationList();
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo3);
    }

    @Test
    void testWrite() {
        try {
            Write.write(testList, TEST_PATH);
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    // needed as AutoBot does not consider the class name to be tested (Piazza post 637)
    void testDefaultConstructor() {
        new Write();
    }
}
