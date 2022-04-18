fun main() {

    println("${compareStringWithBackspaces("xy#z","xzz#")} expected true")
    println("${compareStringWithBackspaces("xy#z","xyz#")} expected false")
    println("${compareStringWithBackspaces("xp#","xyz##")} expected true")
    println("${compareStringWithBackspaces("xywrrmp","xywrrmu#p")} expected true")
    println("${compareStringWithBackspaces("ab#c##","")} expected true")
}

/*
    Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
    Input: str1="xy#z", str2="xzz#"
    Output: true
   "ab#c##"

    Here we can maintain a pointer for each str working backwards starting from the end
    For each string, if pointer is a backspace, keep moving pointer to do the backspaces
    Once both char and char2 are not backspaces and backspaces are "handled" compare them

 */
fun compareStringWithBackspaces(str1: String, str2: String): Boolean {
    var index1 = str1.length - 1
    var index2 = str2.length - 1

    while(index1 >= 0 || index2 >= 0) {
        index1 = findNextLetter(index1, str1)
        index2 = findNextLetter(index2, str2)

        if(index1 < 0 || index2 < 0) break
        if(str1[index1] != str2[index2]) return false
        else {
            index1--
            index2--
        }
    }
    if(index1 > 0 || index2 > 0) return false
    return true
}

private fun findNextLetter(index: Int, str: String): Int {
    var backspaces = 0
    var result = index
    while(result >= 0 && (str[result] == '#' || backspaces > 0)) {
        if(str[result] != '#') {
            backspaces--
        } else backspaces++
        result--
    }
    return result
}