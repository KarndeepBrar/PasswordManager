package model;

import exception.PasswordLengthException;
import exception.UsernameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CombinationListTest {
    private CombinationList testList;
    private Combination testCombo1 = new Combination("user1", "pw1", "test1.com");
    private Combination testCombo2 = new Combination("user1", "pw2", "test2.com");
    private Combination testCombo3 = new Combination("user2", "pw3", "test3.com");
    private Combination testCombo4 = new Combination("user3", "pw4", "test4.com");
    private Combination testCombo5 = new Combination("user4", "pw4", "test5.com");
    private Combination testCombo6 = new Combination("user4", "pw5", "test5.com");

    public CombinationListTest() throws PasswordLengthException, UsernameLengthException {
    }

    @BeforeEach
    void runBefore() {
        testList = new CombinationList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testList.getSize());
    }

    @Test
    void testAddOneCombination() {
        testList.addCombination(testCombo1);
        assertEquals(1, testList.getSize());
    }

    @Test
    void testToString() {
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        assertEquals("1. Username: user1 Password: pw1 URL: test1.com\n" +
                "2. Username: user1 Password: pw2 URL: test2.com\n", testList.toString());
    }

    @Test
    void testSearchByUser() {
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo3);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo4);
        testList.addCombination(testCombo5);
        testList.addCombination(testCombo6);

        assertEquals("1. Username: user1 Password: pw1 URL: test1.com\n" +
                "3. Username: user1 Password: pw2 URL: test2.com\n", testList.searchByUser("user1"));
    }

    @Test
    void testSearchByPassword() {
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo3);
        testList.addCombination(testCombo4);
        testList.addCombination(testCombo5);
        testList.addCombination(testCombo6);

        assertEquals("4. Username: user3 Password: pw4 URL: test4.com\n" +
                "5. Username: user4 Password: pw4 URL: test5.com\n", testList.searchByPassword("pw4"));
    }

    @Test
    void testSearchByWebsite() {
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo3);
        testList.addCombination(testCombo4);
        testList.addCombination(testCombo5);
        testList.addCombination(testCombo6);

        assertEquals("5. Username: user4 Password: pw4 URL: test5.com\n" +
                "6. Username: user4 Password: pw5 URL: test5.com\n", testList.searchByWebsite("test5.com"));
    }


    @Test
    void testChangeComboUser() {
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo3);
        testList.changeComboUser(2,"testChange");

        assertEquals("testChange", testList.getCombo(2).getUsername());
    }

    @Test
    void testChangeComboPass() {
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo3);
        testList.changeComboPassword(2,"testChange");

        assertEquals("testChange", testList.getCombo(2).getPassword());
    }

    @Test
    void testChangeComboURL() {
        testList.addCombination(testCombo1);
        testList.addCombination(testCombo2);
        testList.addCombination(testCombo3);
        testList.changeComboWebsite(1,"testChange.com");

        assertEquals("testChange.com", testList.getCombo(1).getWebsite());
    }

    @Test
    void testRemoveCombo() {
        testList.addCombination(testCombo1);
        testList.removeCombo(0);
        assertEquals(0,testList.getSize());
    }
}
