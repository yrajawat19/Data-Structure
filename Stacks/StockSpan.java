package Stacks;

import java.util.Stack;

public class StockSpan {
    // Function to return stock span
    public static int[] stock_span(int[] stock_prices) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[stock_prices.length];
        // Iterating over stock prices
        for(int i=0; i < stock_prices.length;i++) {
            while(!stack.isEmpty() && stock_prices[stack.peek()] <= stock_prices[i])
                stack.pop();
            if(stack.empty())
                span[i] = i+1;
            else
                span[i] = i - stack.peek();
            stack.push(i);
        }
        return span;
    }
    //Function to print array
    public static void print(int[] prices, int[] span) {
        System.out.println("PRICES"+" STOCK SPAN");
        for(int i = 0 ; i < prices.length ; i++)
            System.out.println(prices[i]+" --> "+span[i]);
        System.out.println();
    }
    //Driver code
    public static void main(String[] args) {
        int[] stock_prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = stock_span(stock_prices);
        print(stock_prices,span);
    }
}
