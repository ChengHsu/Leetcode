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

#### Quicksort
```
// choose A[r] as pivot
QUICKSORT(A,p,r):
if p < r
  q = PARTITION(A,p,r)
  QUICKSORT(A,p,q-1) // divide & conquer
  QUICKSORT(A,q+1,r)

PARTITION(A,p,r):
x = A[r]
i = p-1
for j = p to r-1:
  if A[j] <= x
    i = i+1
    swap(A[i],A[j])
swap(A[i+1],A[r])
return i+1
```
1. Running Time analysis:
  - worst-case: O(n^2)
  - expected: O(n lgn)
2. Sorts **in-place**
3. The running time of QUICKSORT is dominated by the time spent in the PARTITION procedure

### Sorting in Linear Time
Any comparison sort algorithm requires Ω(n lgn) comparisons in the worst case.
#### Counting sort
1. Counting sort assumes that each of the *n* input elements is an integer in the range 0 to k, for some integer k.
2. Instead of comparison, Counting sort determines, for each input element *x*, the number of elements less than *x*. It uses this info to place element *x* directly into its position in the output array.
3. Running Time analysis: Θ(n)

```
// A: input array to be sorted
// B: output array after sorting
// k: integer k >= each elements in A
// C: auxiliary array that stores the ranking for each element at last
COUNTING-SORT(A,B,k):
let C[0..k] be a new array
for i = 0 to k:
  C[i] = 0
for j = 1 to A.len:
  C[A[j]] += 1
// C[i] now contains the number of elements == i.
for i = 1 to k:
  C[i] = C[i] + C[i-1]
// C[i] now contains the number of elelments <= i.
for j = A.len downto 1:
// the index in B should be the ranking of each elment, which is C[A[j]] (stores the number of elements <= A[j])
  B[C[A[j]]] = A[j] 
// Because the elements might not be distinct,we decrement C[A[j]] each time we place a value A[j] into B.
// Decrementing causes the next input element with the value equal to A[j], if one exists, to go to the position immediately // before A[j] in B.
  C[A[j]] -= 1
```
