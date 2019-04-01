package BinarySearch;

/**
 * @Number: #278. First Bad Version
 * @Descpription: You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 * @Author: Created by xucheng.
 */
public class FirstBadVersion {
    /**
     * binary search
     * time: O(logn)
     * space: O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (!isBadVersion(mid)){
                low = mid+1;
            }
            else high = mid - 1;
        }
        return low;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
