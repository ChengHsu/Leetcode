
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
## Sorting Algorithms
### Comparison Sorting
#### Heapsort
1. Running time: **O(n lg n)**
2. Sorts **in-place**
```
HEAPSORT(A):
BUILD-MAX-HEAP(A)
for i = A.length downto 2
  exchange A[1] with A[i]
  A.heap_size = A.heap_size - 1
  MAX-HEAPIFY(A)
```
3. Running time analysis:
  - BUILD-MAX-HEAP takes time O(n)
  - Each of the n-1 calls to MAX-HEAPIFY takes time O(lg n)
  - T(n) = O(n) + T(n - 1) * O(lg n)
  
