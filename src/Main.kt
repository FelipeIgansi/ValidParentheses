fun main() {
//  isValid("()")
  println( isValid("(]"))//false
  println(isValid("([)]"))//false
  println(isValid("()[]{}"))//true
  println(isValid("(){}}{"))//false
  println(isValid("{[]}"))//true
  println(isValid(")(){}"))//false
}

fun isValid(value: String): Boolean {
  if (value.isEmpty() || value.length % 2 != 0) return false

  val stack = ArrayDeque<Char>()
  val mapOfBrackets = mapOf(
    '(' to ')',
    '[' to ']',
    '{' to '}'
  )

  for (char in value) {
    if (char in mapOfBrackets.keys) {
      stack.addLast(char)
    } else if (stack.isNotEmpty() && mapOfBrackets[stack.last()] == char) {
      stack.removeLast()
    } else {
      return false
    }
  }
  return stack.isEmpty()
}