package br.com.rkendy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedDemoTest {
    Queue<String> queue; // A Queue of String

    @Test
    @DisplayName("is null")
    void isNotInstantiated() {
        assertNull(queue);
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewStack() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(queue.isEmpty());
        }

        @Test
        @DisplayName("return null element when polled")
        void returnNullWhenPolled() {
            assertNull(queue.poll());
        }

        @Test
        @DisplayName("return null element when peeked")
        void returnNullWhenPeeked() {
            assertNull(queue.peek());
        }

        @Nested
        @DisplayName("after offering an element")
        class AfterOffering {

            String anElement = "an element";

            @BeforeEach
            void offerAnElement() {
                queue.offer(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                assertFalse(queue.isEmpty());
            }

            @Test
            @DisplayName("returns the element when polled and is empty")
            void returnElementWhenPolled() {
                assertEquals(anElement, queue.poll());
                assertTrue(queue.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, queue.peek());
                assertFalse(queue.isEmpty());
            }
        }
    }
}