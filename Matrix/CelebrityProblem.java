package Matrix;
/* ******************* PROBLEM STATEMENT ************************
 In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes,
  (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “.
  Find the stranger (celebrity) in the minimum number of questions.*/
/* Approach: There are some observations based on elimination technique .

If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be celebrity.
Repeat above two steps till there is only one person.
Ensure the remained person is a celebrity. (What is the need of this step?)
Algorithm:
1) Create a stack and push all the id’s in the stack.
2) Run a loop while there are more than 1 element in the stack.
3) Pop top two element from the stack (represent them as A and B)
4) If A knows B, then A can’t be a celebrity and push B in stack. Else if A doesn’t know B, then B can’t be a celebrity push A in stack.
5) Assign the remaining element in the stack as the celebrity.
6) Run a loop from 0 to n-1 and find the count of persons who knows the celebrity and the number of people whom the celebrity knows. if the count of persons who knows the celebrity is n-1 and the count of people whom the celebrity knows is 0 then return the id of celebrity else return -1.*/
import java.util.*;
public class CelebrityProblem {
    // Person 2 is celebrity .
    static int[][] matrix = { { 0, 1, 1, 0 },
                              { 0, 0, 0, 0 },
                              { 0, 1, 0, 0 },
                              { 0, 1, 0, 0 } };
    static boolean knows(int A, int B)
    {
        if(matrix[A][B] == 1)
            return true;
        return false;
    }

    static int findCelebrity(int n)
    {
        // stack to store people in party .
        Stack<Integer> stack = new Stack<Integer>();
        // Storing people in stack
        for(int i=0;i<n;i++)
            stack.push(i);

        while(stack.size() > 1)
        {
            int A = stack.pop();
            int B = stack.pop();

            if(knows(A,B))
                stack.push(B);
            else
                stack.push(A);
        }

        if(stack.empty())
            return -1;
        int C = stack.pop();
        for(int i=0;i<n;i++)
        {
            if(i != C && (knows(C,i) || !knows(i,C)))
                return -1;
        }

        return C;
    }

    public static void main(String[] args) {
        int n = 4; // No of celebrity
        int celebrity = findCelebrity(n);
        if(celebrity == -1)
            System.out.println("No celebrity in party . ");
        else
            System.out.println(celebrity+" is Celebrity");
    }
}
