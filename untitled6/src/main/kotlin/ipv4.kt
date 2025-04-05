import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.Assert.assertFalse

fun isValidIPv4Address(ip: String): Boolean {
    if (ip.any { it.isWhitespace() }) return false

    val segments = ip.split(".")
    if (segments.size != 4) return false

    for (segment in segments) {
        if (segment.isEmpty()) return false
        if (!segment.all { it.isDigit() }) return false
        if (segment.length > 1 && segment.startsWith("0")) return false

        val number = segment.toIntOrNull() ?: return false
        if (number !in 0..255) return false
    }

    return true
}
