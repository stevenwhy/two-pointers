fun main() {
    println("Find the pair which adds up to a sum:")
    println("${pairWithTargetSum(6, intArrayOf(1,2,3,4,6))} expected [1,3]")
    println("${pairWithTargetSum(11, intArrayOf(2,5,9,11))} expected [0,2]")
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