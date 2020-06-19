package br.com.rkendy.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockingDemoTest {

    @Mock
    ClassToBeMocked classToMocked;

    @InjectMocks
    ClassToBeTested classToTested;

    @Test
    void test() {
        Mockito.when(classToMocked.multiplyByTwo(Mockito.anyInt())).thenReturn(100);
        int result = classToTested.multiplyByTwoAndAddTen(1);
        assertEquals(110, result, "Should be 110");
    }

    @Test
    void test2() {
        Mockito.when(classToMocked.multiplyByTwo(-5)).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> classToTested.multiplyByTwoAndAddTen(-5));
    }
}