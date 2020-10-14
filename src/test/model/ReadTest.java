package model;

import exception.PasswordLengthException;
import exception.UsernameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Read;
import persistence.Write;

import static org.junit.jupiter.api.Assertions.*;

public class ReadTest {
    private static final String TEST_PATH = "testCombos";
    private CombinationList testList;
    private Combination testCombo1 = new Combination("user1", "pw1", "test1.com");
    private Combination testCombo2 = new Combination("user1", "pw2", "test2.com");
    private Combination testCombo3 = new Combination("user2", "pw3", "test3.com");

    public ReadTest() throws PasswordLengthException, UsernameLengthException {
    }

    @BeforeEach
    void runBefore() {
        testList = new CombinationList();
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo3);
    }

    @Test
    void testRead() {
        try {
            Write.write(testList, TEST_PATH);
            testList = Read.read(TEST_PATH);

            Combination combo1 = testList.getCombo(0);
            assertEquals(combo1.getUsername(), testCombo1.getUsername());
            assertEquals(combo1.getPassword(), testCombo1.getPassword());
            assertEquals(combo1.getWebsite(), testCombo1.getWebsite());

            Combination combo2 = testList.getCombo(1);
            assertEquals(combo2.getUsername(), testCombo2.getUsername());
            assertEquals(combo2.getPassword(), testCombo2.getPassword());
            assertEquals(combo2.getWebsite(), testCombo2.getWebsite());

            Combination combo3 = testList.getCombo(2);
            assertEquals(combo3.getUsername(), testCombo3.getUsername());
            assertEquals(combo3.getPassword(), testCombo3.getPassword());
            assertEquals(combo3.getWebsite(), testCombo3.getWebsite());
            assertEquals(testList.getSize(), 3);
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testReadThrowException() {
        try {
            Read.read("./data/testComboNonExistent");
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
    }

    @Test
    void testLoadLastFile() {
        try {
            Read.readLastFile("testLastComboUsed.txt");
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testReadLastFileExceptionThrown() {
        try {
            Read.readLastFile("testLastComboUsedNotFound.txt");
            fail("Exception should have been thrown");
        } catch (Exception e) {
        }
    }

    @Test
    // needed as AutoBot does not consider the class name to be tested (Piazza post 637
    void testDefaultConstructor() {
        new Read();
    }
}