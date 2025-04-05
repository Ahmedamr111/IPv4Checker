// File: main.kt

fun main() {
    while (true) {
        print("Enter an IPv4 address: ")
        val input = readLine()?.trim() ?: ""

        val result = if (isValidIPv4Address(input)) "Valid" else "Not Valid"
        println(result)

        print("Continue? (1 = yes, 0 = no): ")
        val option = readLine()?.trim()

        if (option != "1") {
            println("Exiting.")
            break
        }
    }
}
