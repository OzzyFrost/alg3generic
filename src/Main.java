/**
 * @author KusyapkulovFanzil (5kla@mail.ru)
 */
public class Main {
    public static void main(String[] args) {
        //new Main().testQueue();
        //new Main().testDec();
        new Main().testPriorityQueue();
        String word = "I like to solve programming problems";
        System.out.println(new Main().reverse(word));
        System.out.println(new Main().reverseVer2(word));
        System.out.println(new Main().reverseVer3(word));
    }


    public String reverse(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public String reverseVer2(String s) {
        StringBuilder sb = new StringBuilder();
        MyStack stack = new MyStack();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public String reverseVer3(String s) {
        char[] symbols = s.toCharArray();
        for (int i = 0; i < symbols.length / 2; i++) {
            char c = symbols[symbols.length - i - 1];
            symbols[symbols.length - i - 1] = symbols[i];
            symbols[i] = c;
        }
        return new String(symbols);
    }


    public void testQueue() {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < 5; i++) {
            queue.add(i + 1);
            queue.info();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("remove " + queue.remove());
            queue.info();
        }
        for (int i = 10; i < 15; i++) {
            queue.add(i);
            queue.info();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("remove " + queue.remove());
            queue.info();
        }
        for (int i = 20; i < 25; i++) {
            queue.add(i);
            queue.info();
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("remove " + queue.remove());
            queue.info();
        }
    }

    public void testDec() {
        MyDec dec = new MyDec();
        for (int i = 10; i < 13; i++) {
            dec.addLeft(i);
            dec.info();
        }
        System.out.println(dec.removeRight());
        System.out.println(dec.removeRight());
        for (int i = 20; i < 25; i++) {
            dec.addRight(i);
            dec.info();
        }

        System.out.println("peekRight " + dec.peekRight() + " peekLeft " + dec.peekLeft());
        System.out.println(dec.removeRight());
        System.out.println(dec.removeRight());
        System.out.println(dec.removeRight());
        System.out.println(dec.removeLeft());
        System.out.println("peekRight " + dec.peekRight() + " peekLeft " + dec.peekLeft());
        dec.info();
        System.out.println(dec.removeLeft());
        System.out.println(dec.removeLeft());
        dec.info();
    }

    public void testPriorityQueue() {
        MyPriorityQueue pq = new MyPriorityQueue();
        pq.add(6);
        pq.info();
        pq.add(1);
        pq.info();
        pq.add(3);
        pq.info();
        pq.add(4);
        pq.info();
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        pq.add(3);
        pq.info();
        pq.add(7);
        pq.info();
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        pq.add(2);
        pq.info();
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
    }
}