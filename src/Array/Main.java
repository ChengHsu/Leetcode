package Array;

public class Main {

    public static void main(String[] args) {
//        int[] nums = {9, 9, 9};
//        Array.Main main = new Array.Main();
//        int idx = main.removeDuplicates(nums);
//        System.out.println("IDX: "+idx);
//        int idx = main.removeElement(nums,2);
//        int maxSum = main.maxSubArray(nums);
//        nums = main.plusOne(nums);
//
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;
//        main.merge(nums1,m,nums2,n);

//        Array.PascalTriangle pt = new Array.PascalTriangle();
//        List<List<Integer>> ret1 = pt.generate_v1(5);
//        List<List<Integer>> ret2 = pt.generate_v2(5);
//        List<Integer> row = pt.getRow(3);
//        System.out.println(row);

//        int[] prices = {7,6,4,3,1};
//        Array.BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new Array.BestTimeToBuyAndSellStock();
//        bestTimeToBuyAndSellStock.maxProfit(prices);

//        int[] numbers = {2,7,11,15};
//        Array.TwoSum twoSum = new Array.TwoSum();
//        int[] idxs = twoSum.twoSum(numbers, 9);
//        for (int idx : idxs
//                ) {
//            System.out.println(idx);
//        }
//        int[] numbers = {2,2,1,1,1,2,2};
//        Array.MajorityElement majorityElement = new Array.MajorityElement();
//        int elem = majorityElement.majorityElement(numbers);
//        System.out.println(elem);
//        int[] numbers = {1,2,3,4,5,6,7};
//        int k = 3;
//        Array.RotateArray rotateArray = new Array.RotateArray();
//        rotateArray.rotate(numbers,k);

//        int[] numbers = {1,2,1};
//        Array.ContainsDuplicate containsDuplicate = new Array.ContainsDuplicate();
//        boolean res = containsDuplicate.containsNearbyDuplicate(numbers,0);
//        System.out.println(res);

//        int[] numbers = {8,6,4,2,3,5,7,0,1};
//        Array.MissingNumber missingNumber = new Array.MissingNumber();
//        int missingNum = missingNumber.missingNumber(numbers);
//        System.out.println(missingNum);

//        int[] numbers = {0,1,0,3,12};
//        Array.MoveZeros moveZeros = new Array.MoveZeros();
//        moveZeros.moveZeroes(numbers);

//        int[] numbers = {2,2,3,1};
//        Array.ThirdMaximumNumber t = new Array.ThirdMaximumNumber();
//        int res =  t.thirdMax(numbers);
//        System.out.println(res);

//        int[] nums = {4,3,2,7,8,2,3,1};
//        Array.FindAllNumbersDisappearedInTheArray f = new Array.FindAllNumbersDisappearedInTheArray();
//        f.findDisappearedNumbers(nums);

//        int[] nums = {1,3,1,5,4};
//        int k = 0;
//        Array.KdiffPairsInAnArray kdiffPairsInAnArray = new Array.KdiffPairsInAnArray();
//        int numsPairs = kdiffPairsInAnArray.findPairs(nums,k);
//        System.out.println(numsPairs);

//        int[] nums = {1,0,1,1,0,1};
//        Array.MaxConsecutiveOnes maxConsecutiveOnes = new Array.MaxConsecutiveOnes();
//        int maxOneNum =  maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
//        System.out.println(maxOneNum);
//
//        int[] nums = {1,4,3,2};
//        Array.ArrayPartition arrayPartition = new Array.ArrayPartition();
//        int sum = arrayPartition.arrayPairSum(nums);
//        System.out.println(sum);

//        int[][] nums = {{1,2},{3,4}};
//        Array.ReshapeTheMatrix reshapeTheMatrix = new Array.ReshapeTheMatrix();
//        int[][] curNums = reshapeTheMatrix.matrixReshape(nums,1,4);
//        System.out.println(curNums.length);
//        System.out.println(curNums[0].length);

//          int[] nums = {2, 6, 4, 8, 10, 9, 15};
//          Array.ShortestUnsortedContinuousSubarray subarray = new Array.ShortestUnsortedContinuousSubarray();
//          int subLen = subarray.findUnsortedSubarray(nums);
//          System.out.println(subLen);

//        int[] flowerbed = {1,0,0,0,1,0,0};
//        Array.CanPlaceFlowers canPlaceFlowers = new Array.CanPlaceFlowers();
//        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed,2));

//        int[] nums = {-5,-4,1,2,3,4,5};
//        Array.MaximumProductOfThreeNumbers maximumProductOfThreeNumbers = new Array.MaximumProductOfThreeNumbers();
//        System.out.println(maximumProductOfThreeNumbers.maximumProduct(nums));

//        int[] nums = {1,12,-5,-6,50,3};
//        Array.MaximumAverageSubarray maximumAverageSubarray = new Array.MaximumAverageSubarray();
//        System.out.println(maximumAverageSubarray.findMaxAverage(nums,4));

//        int[] nums = {3,4,2,3};
//        Array.NonDecreasingArray nonDecreasingArray = new Array.NonDecreasingArray();
//        boolean res = nonDecreasingArray.checkPossibility(nums);
//        System.out.println(res);

//        int[] nums = {1,3,5,7,0,1,3,5,7,9};
//        Array.LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new Array.LongestContinuousIncreasingSubsequence();
//        System.out.println(longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums));

//        int[][] nums = {
//                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
//        };
//        Array.MaxAreaofIsland maxAreaofIsland = new Array.MaxAreaofIsland();
//        System.out.println(maxAreaofIsland.maxAreaOfIsland(nums));

//        int[] nums = {1,2,2,3,1,4,2};
//        Array.DegreeofanArray degreeofanArray = new Array.DegreeofanArray();
//        System.out.println(degreeofanArray.findShortestSubArray(nums));

//        int[][] nums = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
//        Array.FlippinganImage flippinganImage = new Array.FlippinganImage();
//        flippinganImage.flipAndInvertImage(nums);

//        int[] bits = {1, 1,1, 0};
//        Array.OneBitAndTwoBitCharacters oneBitAndTwoBitCharacters = new Array.OneBitAndTwoBitCharacters();
//        System.out.println(oneBitAndTwoBitCharacters.isOneBitCharacter(bits));

//        int[] nums = {1, 2,3};
//        Array.FindPivotIndex findPivotIndex = new Array.FindPivotIndex();
//        System.out.println(findPivotIndex.pivotIndex(nums));

//        int[] nums = {0,0,0,1};
//        LargestNumberAtLeastTwiceofOthers largestNumberAtLeastTwiceofOthers = new LargestNumberAtLeastTwiceofOthers();
//        System.out.println(largestNumberAtLeastTwiceofOthers.dominantIndex(nums));

        int[] nums = {1,3,5,6};
        SearchInsertPos searchInsertPos = new SearchInsertPos();
        System.out.println(searchInsertPos.searchInsert(nums,7));

    }
}
