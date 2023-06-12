package data.structure.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * 栈测试
 *
 * @author mexioex
 * @date 2023-06-13
 */
public class StackTest {
    @Test
    public void linkedStackTest() {
        LinkedStack<Object> stack = new LinkedStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        stack.push(3);
        assertEquals(3, stack.pop());
        stack.push(3);
        assertFalse(stack.push(4));
    }

    @Test
    public void arrayStackTest() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
        stack.push(3);
        assertEquals(3, stack.pop());
        stack.push(3);
        assertFalse(stack.push(4));
    }
}
