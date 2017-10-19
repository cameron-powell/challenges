import java.util.*;

public class HRQueuesATaleOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    private static class MyQueue<Integer> {
        Stack<Integer> enqueueStack;
        Stack<Integer> dequeueStack;

        public MyQueue() {
            enqueueStack = new Stack<>();
            dequeueStack = new Stack<>();
        }

        public void enqueue(Integer i) {
            enqueueStack.push(i);
        }

        public void dequeue() {
            if(!dequeueStack.empty()) {
                dequeueStack.pop();
            } else {
                // Push enqueue onto dequeue
                while(!enqueueStack.empty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
                if(!dequeueStack.empty()) {
                    dequeueStack.pop();
                }
            }
        }

        public String peek() {
            if(!dequeueStack.empty()) {
                return dequeueStack.peek().toString();
            } else {
                while(!enqueueStack.empty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
                if(!dequeueStack.empty()) {
                    return dequeueStack.peek().toString();
                }
            }
            return "";
        }
    }
}