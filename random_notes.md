
* Java create customize comparator to sort special data structure
```
 private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return (o1.start - o2.start == 0)? o1.end - o1.end : o1.start - o2.start;
        }
    }
 Collections.sort(intervals, new IntervalComparator());   
```
