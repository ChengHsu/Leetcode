## Sorting Algorithms
### Comparison Sorting
#### Merge sort
```
MERGE-SORT(A,p,r):
if p < r
  q = floor((p+r)/2)
  MERGE-SORT(A,p,q)
  MERGE-SORT(A,q+1,r)
  MERGE(A,p,q,r)

MERGE(A,p,q,r):
n1 = q-p+1
n2 = r-q
let L[1...n1+1] and R[1...n2+1] be new arrays
for i = 1 to n1
  L[i] = A[p+i-1]
for j = 1 to n2
  R[j] = A[q+j]
L[n1+1] = infinte
L[n2+1] = infinte
i = 1
j = 1
for k = p to r
  if L[i] <= R[j]
    A[k] = L[i]
    i = i + 1
  else A[k] = R[j]
    j = j + 1
```
1. Divide & Conqer
2. Running time: Θ(n lgn)
  - Divide: Computes the middle of subarray, Θ(1)
  - Conquer: Recursively solve 2 subproblems, each of size n/2, which contributes 2T(n/2) to the running time
  - Combine: merge on an n-element subarray, Θ(n)
  
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
4. Counting sort is **stable**

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
#### Radix sort
1. Running time: Given n d-digit numbers in which each digit can take on up to *k* possible values, RADIX-SORT correctly sorts these numbers in **Θ(d(n+k))** if the stable sort it uses takes Θ(n+k) time.
```
// Assumes that each element in the n-element array A has d digits, where digit 1 is the lowest-order digit and digit d is the // highest-order digit.

RADIX-SORT(A,d):
for i = 1 to d:
  use a stable sort(e.g. counting sort) to sort array A on digit i
```
#### Bucket sort
1. Bucket sort assumes that the input is drawn from a uniform distribution. To produce the output, we simply sort the numbers in each bucket and then go through the buckets in order, listing the elements in each.
2. Running time: Θ(n) for average case
```
BUCKET_SORT(A)
let B[0..n-1] be a new array
n = A.len
for i = 0 to n-1:
  make B[i] an empty list
for i = 1 to n
  insert A[i] into list B[floor(n A[i])]
for i = 0 to n-1
  sort list B[i] with insetion sort
concatenate the lists B[0],B[1],...,B[n-1] together in order
```
3. Consider A[i] and A[j], either A[i] goes into the same bucket as A[j] or it goes into a bucket with a lower index. If A[i] and A[j] go into the same bucket, then the insertion sort puts them into the same order. Otherwise, they will be ordered in the last step when concatenating each bucket. Therefore this algo works.
