# Recursion
## Principle of Recursion
> **Recursion is an approach to solving problems using a function that calls itself as a subroutine**    

A recursive function shold have :
* Simple **base case**  — a terminating condition that does not use recursion to produce an answer.
* A set of rules, i.e. **recurrence relation** that reduces all other cases towards the base case.

```
// Reverse a string using O(1) extra space.
public reverseString(s){
helper(0, s.length - 1, s);
}
// use O(1) extra space to modify the string
public void helper(int start, int end, char[] str){
// base case
if(start >= end)
  return;
char tmp = str[start];
str[start] = str[end];
str[end] = tmp;
helper(start+1, end-1, str);
}
```

```
// Swap Nodes in Pairs: Given a linked list, swap every two adjacent nodes and return its head.
// Given 1->2->3->4, you should return the list as 2->1->4->3.
public ListNode swapPairs(ListNode head){
if(head == null || head.next == null)
return head;
ListNode n = head.next;
head.next = swapPairs(head.next.next);
n.next = head;
return n;
}
```
## Duplicate Calulation in Recursion - Using Memoization
* Fibonacci Number
  * duplicate calculations: fib(4) = fib(3) + fib(2) = fib(2) + fib(1) + fib(1) + fib(0)
  * stupid codes:
  ```
  public static int fibonacci(int n) {
    if(n < 2)
      return n;

    return fibonacci(n-1) + (n-2);
  }
  ```
  * Reduce time in exchange for additional space:
  ```
  HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
  public static int fibonacci(int n) {
    if(cache.containsKey(n))
      return cache.get(n);
    int result;
    if(n < 2)
      result = n;
    else 
      result = fibonacci(n-1) + fibonacci(n-2);
      cache.put(n,result);
      return result;
  }
  ```
* Climing Stairs
  * duplicate calculations: F(0,4) = F(1,4) + F(2,4) = F(2,4) + F(3,4) + F(3,4) + F(4,4) 
  * stupid codes:
  ```
  //Time complexity : O(2^n). Size of recursion tree will be 2^n.
  public int climbStairs(int n) {
        helper(0, n);
    }
  public int helper(int step, int n) {
    if(step > n)
      return 0;
    if(step == n)
      return 1;
    return helper(step+1, n) + help(step+2, n);
  }
  ```
  * Reduce time in exchange for additional space:
  ```
  public int climbStairs(int n) {
    int[] memo = new int[n+1];
    helper(0, n, memo);
    }
  public int helper(int step, int n, int[] memo) {
    if(step > n)
      return 0;
    if(step == n)
      return 1;
    if(memo[step] > 0)
      return memo[step];
    memo[step] = helper(step+1, n) + help(step+2, n);
    return memo[step];
  }
  ```
  
## Time Complexity - Recursion
> Given a recursion algorithm, its time complexity O(T) is typically the product of **the number of recursion invocations**(R) and **the time complexity of calculation**(O(s)) that incurs along with rach recursion call:    
O(T) = R * O(s)
* For Fibonacci Example
  * Without memoization, time complexity is O(2^n) (According to the number of nodes of the execution tree)
  * With memoization, time complexity is O(n) (fib(n) would only be invoked n-1 times)

## Space Complexity - Recursion
* Recursion Related Sapce
  * refers to the memory cost that is incurred directly by the recursion, i.e. the stack to keeo track of recursion function calls.
  *  In order to complete a typical function call, the system should allocate some space in the stack to hold 3 important pieces of information:
    1. the returning address of the function call. Once the function call is completed, the program should know where to return to, i.e. the point before the function call; 
    2. the parameters that are passed to the function call; 
    3. the local variables within the function call.
  * The space in the stack is the minimal cost that is incurred during a function call. Once the function call is done, the space will be freed. However, for recursion algorithms, since the function calls would chain up successively until they reach a base case, wihch means that the space used for each function call will also accumulate.
  * **For a recursion algo, if thers is no other memory consumption, then this recursion incurred space would be the upper bound of the algo.**

* Non-Recursion Related Space
  * refers to the memory space that is not directly related to recursion, which typically includes the space (normally in heap) that is allocated for the global variables or for storing intermediate results(memoization).

## Tail recursion
* Tail recursion is a recursion where the **recursive call is the final instruction** in the recursion function. And there should be only one recursive call in the function. It's exempted from recursion related sapce.
* In tail recursion, we know that as soon as we return from the recursive call we are going to immediately return as well, so we can skip the entire chain of recursive calls returning and return straight to the original caller. That means we don't need a call stack at all for all of the recursive calls, which saves us space.
```
 // Sum
 private static int helper_non_tail_recursion(int start, int [] ls) {
    if (start >= ls.length) {
      return 0;
    }
    // not a tail recursion because it does some computation after the recursive call returned.
    return ls[start] + helper_non_tail_recursion(start+1, ls);
  }

  public static int sum_non_tail_recursion(int [] ls) {
    if (ls == null || ls.length == 0) {
      return 0;
    }
    return helper_non_tail_recursion(0, ls);
  }

  //---------------------------------------------

  private static int helper_tail_recursion(int start, int [] ls, int acc) {
    if (start >= ls.length) {
      return acc;
    }
    // this is a tail recursion because the final instruction is the recursive call.
    return helper_tail_recursion(start+1, ls, acc+ls[start]);
  }
    
  public static int sum_tail_recursion(int [] ls) {
    if (ls == null || ls.length == 0) {
      return 0;
    }
    return helper_tail_recursion(0, ls, 0);
  }
```



