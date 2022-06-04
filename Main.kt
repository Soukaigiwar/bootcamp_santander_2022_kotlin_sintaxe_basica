import kotlin.math.pow

const val SUM = 1
const val SUB = 2
const val DIV = 3
const val MULT = 4
const val PERCT = 5
const val POW = 6

fun main() {
    println("##################################\n" +
            "# The simpliest Calculator Ever! #\n" +
            "##################################")
    do {
        startCalculator()
        print("Try again? type y or n: ")
        val tryAgain = readLine()!!.lowercase() == "y"
    } while (tryAgain)
    println("Well Done")
}

fun prompt(strMessage:String): String {
    println(strMessage)

    return try {
        val input = readLine()!!
        input.toFloat()
        input
    } catch (ex: Exception) {
        prompt(strMessage)
    }
}

fun startCalculator() {
    val operatorQuestion =  "Enter a valid Operator: "
    println(
        "Enter an operator number as listed:\n" +
                "1 for plus\n" +
                "2 for minus\n" +
                "3 for divided\n" +
                "4 for multiplied\n" +
                "5 for percent\n" +
                "6 for raise to the power\n" +
                "7 for factorial\n"
    )
    var operator = 0
    while (operator !in 1..7) {
        operator = prompt(operatorQuestion).toInt()
    }

    val result: Float = when (operator) {
        SUM -> {
            val (num1, num2) = getPairFloatNumbers()
            num1 + num2
        }
        SUB -> {
            val (num1, num2) = getPairFloatNumbers()
            num1 - num2
        }
        DIV -> {
            val (num1, num2) = getPairFloatNumbers()
            num1 / num2
        }
        MULT -> {
            val (num1, num2) = getPairFloatNumbers()
            num1 * num2
        }
        PERCT -> {
            val (num1, num2) = getPairFloatNumbers()
            (num1 * num2) / 100
        }
        POW -> {
            val (num1, num2) = getPairFloatNumbers()
            num1.pow(num2)
        }
        else -> factorial().toFloat()
    }
    println("The result is: %.2f".format(result))
}

fun getPairFloatNumbers(): Pair<Float, Float> {
    val num1 = prompt("Enter the first number: ").toFloat()
    val num2 = prompt("Enter the second number: ").toFloat()
    return Pair(num1, num2)
}

fun getSingleIntNumber() : Int {
    return prompt("Enter a number: ").toInt()
}

fun factorial():Long {
    var factorial: Long = 1
    val number = getSingleIntNumber()
    for (i in 1..number) {
        factorial *= i.toLong()
    }
    return factorial
}
