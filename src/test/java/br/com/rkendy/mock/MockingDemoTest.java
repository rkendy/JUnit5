package br.com.rkendy.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockingDemoTest {

    @Mock
    ClassToBeMocked classToMock;

    @InjectMocks
    ClassToBeTested classToTest;

    // ************************************************************
    // *********** No need to mock
    // ************************************************************
    @Test
    void given10_whenMultiplyByFourOrFive_thenReturn40() {
        assertEquals(40, classToTest.multiplyByFourOrFive(10));
    }

    @Test
    void given20_whenMultiplyByFourOrFive_thenReturn100() {
        assertEquals(100, classToTest.multiplyByFourOrFive(20));
    }

    @Test
    void givenZero_whenMultiplyByTwoAndAddTen_thenThrowIllegalArgumentException() {
        // Act & Assert:
        Exception e = assertThrows(IllegalArgumentException.class, () -> classToTest.multiplyByTwoAndAddTen(0));
        assertEquals("Cannot be zero", e.getMessage());
    }

    // ************************************************************
    // *********** Need to Mock:
    // ************************************************************
    @Test
    void given50_whenMultiplyByTwoAndAddTen_thenReturn110() {
        // Arrange:
        Mockito.when(classToMock.multiplyByTwo(50)).thenReturn(100);

        // Act:
        int result = classToTest.multiplyByTwoAndAddTen(50);

        // Assert:
        assertEquals(110, result, "Should be 110");
    }

    @Test
    void givenAnyInt_whenMultiplyByTwoAndAddTen_thenThrowException() {
        // Arrange
        Mockito.when(classToMock.multiplyByTwo(-1)).thenThrow(new NumberFormatException());

        // Act & Assert:
        assertThrows(NumberFormatException.class, () -> classToTest.multiplyByTwoAndAddTen(-1));

        // Assert:
        Mockito.verify(classToMock, Mockito.atLeast(1)).multiplyByTwo(-1);
    }

    // ************************************************************
    // *********** Not possible to Mock:
    // ************************************************************
    void given_when_then() {

    }
}