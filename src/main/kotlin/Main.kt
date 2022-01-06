fun main() {
    println("Find the pair which adds up to a sum:")
    println("${pairWithTargetSum(6, intArrayOf(1,2,3,4,6))} expected [1,3]")
    println("${pairWithTargetSum(11, intArrayOf(2,5,9,11))} expected [0,2]")


    println("Remove duplicate from sorted array inplace:")
    println("${removeDuplicates(intArrayOf(2,3,3,3,6,9,9))} expected 4")
    println("${removeDuplicates(intArrayOf(2,2,2,11))} expected 2")
    println("${removeDuplicates(intArrayOf(2,11))} expected 2")
    println("${removeDuplicates(intArrayOf(2))} expected 1")
    println("${removeDuplicates(intArrayOf(2,2))} expected 1")

    println("Remove instances of K from sorted array inplace:")
    println("${removeInstancesOfKInplace(3,intArrayOf(2,3,3,3,6,9,9))} expected 4")
    println("${removeInstancesOfKInplace(11,intArrayOf(2,2,2,11))} expected 3")
    println("${removeInstancesOfKInplace(2,intArrayOf(2,11))} expected 1")
    println("${removeInstancesOfKInplace(3,intArrayOf(3, 2, 3, 6, 3, 10, 9, 3))} expected 4")
    println("${removeInstancesOfKInplace(2,intArrayOf(2, 11, 2, 2, 1))} expected 2")
}

/**
 * Given an unsorted array of numbers and a target ‘key’,
 * remove all instances of ‘key’ in-place and return the new length of the array.
 */
fun removeInstancesOfKInplace(k: Int, arr: IntArray): Int {
    var left = 0
// 2,3
    for(right in arr.indices) {
       if(arr[right] != k) {
           arr[left] = arr[right]
           left++
       }
    }
    return left
}

/**
 * Given an array of sorted numbers, remove all duplicates from it.
 *    You should not use any extra space;
 *    after removing the duplicates in-place return the new length of the array.
 */
fun removeDuplicates(arr: IntArray): Int { // abc
    var left = 1
    var right = 1
    if(arr.size == 1) return 1
    while(right < arr.size) {
        val rightEntry = arr[right]
        if(arr[left-1] != rightEntry) {
            arr[left] = rightEntry
            left++
        }
        right++
    }
    return left
}

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 */
fun pairWithTargetSum(target: Int, arr: IntArray): Pair<Int,Int> {

    var indexStart = 0
    var indexEnd = arr.size-1
    while(arr[indexEnd] + arr[indexStart] != target) {
        val sum = arr[indexEnd] + arr[indexStart]
        if(sum > target) indexEnd--
        else indexStart++

        if(indexStart == indexEnd) return Pair(-1,-1)
    }
    return Pair(indexStart,indexEnd)
}