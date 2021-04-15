class stack{
    int size =10;
    int Arr[]=new int[size];
    int top1 = -1;
    int top2 = size;
    void stack_push1(int data){
        if(top1<top2-1)
        {
            top1++;
            Arr[top1]=data;
            System.out.print("\nItem pushed in Stack 1:"+data);
        }
        else{
            System.out.println("\nStack Overflow!!");
        }
    }
    void stack_push2(int data)
    {
        if(top2>top1+1)
    {
        top2--;
        Arr[top2] = data;
        System.out.println("\nItem pushed in Stack 2:"+data);
    }
        else{
            System.out.println("\nStack Overflow !!");
        }
    }
    void stack_pop1(){
        int item;
        if (top1>=0)
        {
            item = Arr[top1];
            top1--;
            System.out.println("\nPop item :"+item);
        }
        else{
            System.out.println("\nStack Underflow");
        }
    }
    void stack_pop2(){
        int item;
        if (top2>=size)
        {
            item = Arr[top2];
            top2++;
            System.out.println("\nPop item :"+item);
        }
        else{
            System.out.println("\nStack Underflow");
        }
    }
    void stack_show1()
    {
        for(int i=top1;i>=0;--i)
        {
            System.out.println("\nElement in Stack 1:"+Arr[i]);
        }
    }
    void stack_show2()
    {
        for(int i=top2;i<size;++i)
        {
            System.out.println("\nElement in Stack 2:"+Arr[i]);
        }
    }
}



public class TwoStackInOneArray {
    public static void main(String args[])
    {
        stack s = new stack();
        s.stack_push1(2);
        s.stack_push1(5);
        s.stack_push1(6);
        s.stack_push1(56);
        s.stack_push1(567);
        s.stack_push1(876);
        s.stack_push2(9876);
        s.stack_push2(678);
        s.stack_push2(567);
        s.stack_push2(345);
        s.stack_pop1();
        s.stack_push1(23);
        s.stack_show1();
        s.stack_show2();
    }
}
