class TwoStack{
    int size=5;
    int InputStack[]=new int[size];
    int OutputStack[]=new int[size];
    int inputFront = -1;
    int outFront = -1;
    void InputStack_push(int item)
    {
        if(inputFront<=size) {
            inputFront++;
            InputStack[inputFront] = item;
            System.out.println("Item pushed:" + item);
        }
        else{
            System.out.println("Underflow Condition!!");
        }
    }
    void OutputStack_push()
    {
        for(int i=inputFront;i>=0;i--)
        {
            outFront++;
            OutputStack[outFront]=InputStack[i];
        }
    }
    void OutputStack_pop()
    {
        if(outFront>-1)
        {
            int item=OutputStack[outFront];
            outFront--;
            System.out.println("Item Deleted:"+item);
        }
        else{
            System.out.println("Underflow Condition !!");
        }
    }
    void OutputStack_show()
    {
        for (int i=outFront;i>-1;i--)
        {
            System.out.println("Item in Queue:"+OutputStack[i]);
        }
    }
}
public class TwoStackOneQueue {
    public static void main(String args[])
    {
        TwoStack Q = new TwoStack();
        Q.InputStack_push(93);
        Q.InputStack_push(89);
        Q.InputStack_push(65);
        Q.InputStack_push(234);
        Q.InputStack_push(231);
        Q.OutputStack_push();
        Q.OutputStack_show();
        Q.OutputStack_pop();
        Q.OutputStack_show();

    }
}
