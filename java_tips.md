
* Java create customize comparator to sort special data structure 
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

* Modulo 10^9+7 (1_000_000_007)
> from LC923. 3Sum With Multiplicity
  In most of the programming competitions, problems are required to answer the result in 10^9+7 modulo. The reason behind this is to have problems for large integers so that only efficient algorithms can solve them in allowed limited time.
  ```
  int MOD = 1_000_000_007;
  ans %= MOD;
  ```

