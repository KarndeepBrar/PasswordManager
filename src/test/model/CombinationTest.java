package model;

import exception.PasswordLengthException;
import exception.UsernameLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationTest {
    Combination testCombination;

    @Test
    void createCombinationNoException() {
        try {
            testCombination = new Combination("asdf", "asdf", "asdf");
        } catch (UsernameLengthException e) {
            fail("UsernameLengthException should not have been thrown.");
        } catch (PasswordLengthException e) {
            fail("PasswordLengthException should not have been thrown.");
        }
    }

    @Test
    void createCombinationThrowUsernameLengthException() {
        try {
            testCombination = new Combination("", "asdf", "asdf");
            fail("UsernameLengthException should have been thrown.");
        } catch (UsernameLengthException e) {
        } catch (PasswordLengthException e) {
            fail("PasswordLengthException should not have been thrown.");
        }
    }

    @Test
    void createCombinationThrowPasswordLengthException() {
        try {
            testCombination = new Combination("asdf", "", "asd");
            fail("PasswordLengthException should have been thrown.");
        } catch (UsernameLengthException e) {
            fail("UsernameLengthException should not have been thrown.");
        } catch (PasswordLengthException e) {
        }
    }
}
