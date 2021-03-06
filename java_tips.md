
#### Java create customize comparator to sort special data structure 
 > from LC56. Merge Intervals
```
 private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return (o1.start - o2.start == 0)? o1.end - o1.end : o1.start - o2.start;
        }
    }
 Collections.sort(intervals, new IntervalComparator());   
```

#### Modulo 10^9+7 (1_000_000_007)
> from LC923. 3Sum With Multiplicity
  ```
  int MOD = 1_000_000_007;
  ans %= MOD;
  ```
  In most of the programming competitions, problems are required to answer the result in 10^9+7 modulo. The reason behind this is to have problems for large integers so that only efficient algorithms can solve them in allowed limited time.

#### Initialize primitive type array
> from LC1. Two Sum
```
// allocate space
int[] arr = new int[arr.len];
// initialize with values
int[] arr = new int[]{val1,val2};
// return empty array
return new int[]{};
```

#### remove the leading whitespaces and tailing whitespaces of a string
```
str = str.trim();
```

#### LinkedHashmap: a HashMap with an additional feature of maintaining an order of elements inserted into it.
> from LC12. Integer to Roman

#### backtrack notes:
* if use StringBuilder instead of String to store the dynamic string during recursion, one has to clean the StringBuilder or use a new one when doing backtack
* add List<List<Integer>>
 ```
  res.add(Arrays.asList(val1, val2, val3);
 ```
 
#### division related problems, consider:
> from LC29. Divide Two Integers
 * sign +,-
   * sign checking
   ```
   // method 1:
   int sign = 1;
   if((dividend < 0 || divisor > 0) || (dividend > 0 || divisor < 0))
   sign = -1;
   return sign * quotient;
   // method 2:
   boolean isNegative = (dividend < 0 || divisor > 0) || (dividend > 0 || divisor < 0);
   return isNegative? -result : result;
   ```
* overflow
  ```
   if (dividend == Integer.MIN_VALUE && divisor == -1)
      return Integer.MAX_VALUE;
  ```
* dividend == 0, divisor == 0, quotient == 0
  ```
  if (divisor == 0)
     return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
  if (dividend == 0)
     return 0;
  ```

#### Generate combination C(L,N) (select N numbers from L numbers)
> from LC39. Combination Sum | LC40. Combination Sum II
Template:
```
// time: O(n^2)
// space: O()
C(nums, d, N, start, curr, ans):
 if d == N:
  ans.append(curr)
  return

 for i = s to L:
  curr.push(nums[i])
  C(nums, d+1, N, i+1, curr, ans)
  curr.pop()
```
#### 两整数乘积的位数
两整数(位数分别为m,n)乘积的位数最多为m+n位
> from LC43. Multiply Strings
```
int lenNum1 = num1.length();
int lenNum2 = num2.length();
int[] product = new int[lenNum1 + lenNum2];
```

#### Java中String s,t比较大小
```
int minLen = Math.min(s.length(),t.length());
for(int i = 0; i < minLen; i++){
if(s.charAt(i) != t.charAt(i))
  # 比较s.charAt(i)和t.charAt(i)的ascii大小,直接return比较结果
}
# for loop结束并没有不同的字符
return s.length() - t.length();
```
#### Java Arrays.sort
When use `Comparator` for `Arrays.sort()`, the implementation is **mergeSort**, which is stable. i.e.**keep the order if 2 elements are the same**
However, `Array.sort()` for primitive types array without using `Comparator`, the implementation is **quickSort**

  

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIwMTEwMzQwMTddfQ==
-->