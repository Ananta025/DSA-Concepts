/*
    *What is DP?
        DP is optimized recursion

    *How to identify DP?        
        a. Optimal Problem (Whenever we want to find least most maximum minimum largest smallest type of thing.. )
        b. some choice is given (multiple branches in recursion tree)

    *DP Definition
        Dynamic Programming is a technique in computer programming that helps to efficiently
        solve a class of problems that have overlapping subproblems and optimal substructure
        property.

    *ways of DP
        *Memoization (Top Down)                                                          Tabulation (Bottom Up)
            
        1. Normal recursion                                                         1. Stores the results of subproblems in a table
        2. Store subproblem's solution                                              2. Iterative implementation
           for reuse                                                                3. Well-suited for problems with a large set of inputs
        3. Well-suited for problems with a relatively small set of inputs           4. Used when the subproblems do not overlap
        4. Used when the subproblems have overlapping subproblems  

        *Important Qs
            1. Fibonacci
            2. 0-1 Knapsack
            3. Unbounded Knapsack
            4. LCS (Longest Common Subsequence)
            5. Kadane's Algorithm (Arrays)
            6. Catalan Number
            7. DP on Grid (2D Arrays)
*/
import java.util.*;
public class fibonacci {
    // Memoization O(n)
    public static int fib(int n,int f[]){
        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }
    // Tabulation O(n)
    public static int fibTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main (String args[]){
        int n = 5;
        int f[] = new int[n+1];
        System.out.println(fib(n,f));
        System.out.println(fibTabulation(n));
    }
}
