package Math;

/**
 * @Number: #923. 3Sum With Multiplicity
 * @Descpription: Given an integer array A, and an integer target,
 * return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 * 3 <= A.length <= 3000
 * @Author: Created by xucheng.
 */
public class ThreeSumWithMultiplicity {
    /**
     * Turn 3sum to 2sum
     * time: O(n^2)
     * space: O(1)
     *
     * @param A
     * @param target
     * @return
     */
//    public int threeSumMulti(int[] A, int target) {
//        int MOD = 1_000_000_007;
//        long ans = 0;
//        // 1. sort
//        Arrays.sort(A);
//        // 2. for every A[i], find if A[j] + A[k] = target - A[i]
//        for (int i = 0; i < A.length; i++) {
//            int sum = target - A[i];
//            int j = i + 1, k = A.length - 1;
//            while (j < k) {
//                if (A[j] + A[k] > sum)
//                    k--;
//                else if (A[j] + A[k] < sum)
//                    j++;
//                    // A[j] + A[k] == sum
//                else {
//                    if (A[j] != A[k]) {
//                        int left = 1, right = 1;
//                        // count the # of same A[j]
//                        while (j + 1 < k && A[j] == A[j + 1]) {
//                            left++;
//                            j++;
//                        }
//                        // count the # of same A[k]
//                        while (k - 1 > j && A[k] == A[k - 1]) {
//                            right++;
//                            k--;
//                        }
//                        // calculate the permutations:  # of ways of selecting A[j] from 「left」A[j]s
//                        // and selecting A[k] from 「right」A[k]s
//                        ans += left * right;
//                        ans %= MOD;
//                        j++;
//                        k--;
//                    } else {
//                        // ways of choosing 2 numbers from (k-j+1) numbers
//                        ans += (k - j + 1) * (k - j) / 2;
//                        ans %= MOD;
//                        // no numbers left since A[j] == A[k]
//                        break;
//                    }
//                }
//
//            }
//        }
//        return (int) ans;
//    }

    /**
     * 4 cases
     * time: O(n + W^2)
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti(int[] A, int target) {
        int MAX_A = 100;
        int MOD = 1_000_000_007;
        int[] count = new int[MAX_A + 1];

        // 1. calculate the freq
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }

        long ans = 0;

        // case 1: All different
        for (int x = 0; x < 100; x++) {
            for (int y = x + 1; y < 100; y++) {
                int z = 100 - x - y;
                if (y < z && z <= 100) {
                    ans += count[x] * count[y] * count[z];
                    ans %= MOD;
                }
            }
        }

        // case 2: x == y != z
        for (int x = 0; x < 100; x++) {
            int z = target - 2 * x;
            if (x < z && z < 100) {
                ans += count[z] * count[x] * (count[x] - 1) / 2;
                ans %= MOD;
            }
        }

        // case 3: x != y == z
        for (int x = 0; x < 100; x++) {
            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (x < y && y <= 100) {
                    ans += count[x] * count[y] * (count[y] - 1) / 2;
                    ans %= MOD;
                }
            }
        }

        // case 4: x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (0 <= x && x <= 100) {
                ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                ans %= MOD;
            }
        }

        return (int)ans;
    }

}
