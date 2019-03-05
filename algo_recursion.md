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
## Duplicate Calulation in Recursion
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


