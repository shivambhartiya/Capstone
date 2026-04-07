import java.util.*;

public class SIT_201 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(34);
        s.push(3);
        s.push(31);
        s.push(98);
        s.push(92);
        s.push(23);

        System.out.println("Input: "+s);
        sort(s);
        System.out.println("Output: "+s);
    }   

    static void sort(Stack<Integer> s){
        Stack<Integer> tempStack = new Stack<Integer>();

        // Loop run until the original stack becomes empty
        while(!s.isEmpty()){

            // Pop the top element from the original stack and store it in the variable temp
            int temp = s.pop();

            // While tempstack is not empty and the top element of tempstack is greater than temp, move back to the original code
            while(!tempStack.isEmpty() && tempStack.peek() > temp){
                s.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        while(!tempStack.isEmpty()){
            s.push(tempStack.pop());
        }
    }
}