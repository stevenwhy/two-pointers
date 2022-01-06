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

    println("Square the numbers in a sorted array:")
    println("${squareAnArray(intArrayOf(-2, -1, 0, 2, 3))} expected 0, 1, 4, 4, 9")
    println("${squareAnArray(intArrayOf(-3, -1, 0, 1, 2))} expected 0 1 1 4 9")

    println("Find Triples Which Sum to 0:")
    println("${findAllUniqueTripletsSumToZero(intArrayOf(-3, 0, 1, 2, -1, 1, -2))} expected [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]")
    println("${findAllUniqueTripletsSumToZero(intArrayOf(-5, 2, -1, -2, 3))} expected [-5, 2, 3], [-2, -1, 3]")
}

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
fun findAllUniqueTripletsSumToZero(arr: IntArray): MutableList<Triple<Int,Int,Int>> {
    // We can first sort the array to make the problem easier
    // Then we want to find 3 numbers X,Y,Z such that X + Y = -Z
    //  sorted array makes it easier to skip repeats since we only want unique triples
    val result: MutableList<Triple<Int,Int,Int>> = mutableListOf()
    if(arr.size < 3) return result
    val sorted = arr.sorted()

    for(i in sorted.indices) {
        if(i > 0 && sorted[i] == sorted[i-1]) continue

        // search for pairs which sum to -arr[i]
        var right = sorted.size - 1
        var left = i+1
        while(left < right) {
            val sum = sorted[left] + sorted[right]
            if(sum == -sorted[i]) {
                result.add(Triple(sorted[i],sorted[left],sorted[right]))
                right--
                left++
            } else if (sum > -sorted[i]) {
                right--
            } else left++
        }
    }
    return result
}

/**
 * Given a sorted array, create a new array
 *   containing squares of all the number of the input array in the sorted order.
 */
fun squareAnArray(arr: IntArray): MutableList<Int> {
    val result: MutableList<Int> = List(arr.size) { -1 }.toMutableList()
    var left = 0
    var right = arr.size-1
    var resultIndex = arr.size-1
    while(left != right) {
        val leftSquare = arr[left] * arr[left]
        val rightSquare = arr[right] * arr[right]
        if(rightSquare > leftSquare) {
            result[resultIndex] = rightSquare
            right--
        } else {
            result[resultIndex] = leftSquare
            left++
        }
        resultIndex--
        if(right == left) result[resultIndex] = arr[left]*arr[left]
    }
    return result
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