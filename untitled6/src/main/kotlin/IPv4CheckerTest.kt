
import junit.framework.TestCase.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

class IPv4CheckerTest {

    @Test
    fun `valid IPv4 addresses`() {
        assertTrue(isValidIPv4Address("192.168.1.1"))
        assertTrue(isValidIPv4Address("255.255.255.255"))
        assertTrue(isValidIPv4Address("0.0.0.0"))
        assertTrue(isValidIPv4Address("127.0.0.1"))
    }

    @Test
    fun `invalid IPv4 addresses - wrong format`() {
        assertFalse(isValidIPv4Address("192.168.1"))
        assertFalse(isValidIPv4Address("192.168.1.1.1"))
        assertFalse(isValidIPv4Address("192.168..1"))
        assertFalse(isValidIPv4Address("..168.1.1"))
        assertFalse(isValidIPv4Address("192.168.1."))
    }

    @Test
    fun `invalid IPv4 addresses - out of range`() {
        assertFalse(isValidIPv4Address("256.100.100.100"))
        assertFalse(isValidIPv4Address("100.100.100.300"))
        assertFalse(isValidIPv4Address("-1.100.100.100"))
    }

    @Test
    fun `invalid IPv4 addresses - leading zeros`() {
        assertFalse(isValidIPv4Address("01.2.3.4"))
        assertFalse(isValidIPv4Address("192.168.001.1"))
    }

    @Test
    fun `invalid IPv4 addresses - non-numeric characters`() {
        assertFalse(isValidIPv4Address("192.168.a.1"))
        assertFalse(isValidIPv4Address("hello.world"))
        assertFalse(isValidIPv4Address("192.168.1.1a"))
    }

    @Test
    fun `invalid IPv4 addresses - empty`() {
        assertFalse(isValidIPv4Address(""))
        assertFalse(isValidIPv4Address("   "))
        assertFalse(isValidIPv4Address("1.1.1.1\n"))
        assertFalse(isValidIPv4Address("1.1.1.1 "))
        assertFalse(isValidIPv4Address(" 1.1.1.1"))
    }
}
