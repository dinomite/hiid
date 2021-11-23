package net.dinomite.hiid

import kotlin.test.Test
import kotlin.test.assertEquals

class HIIDTest {
    @Test
    fun `Dashes in the correct place`() {
        val hiid = randomHIID().toString()
        assertEquals('-', hiid[8])
        assertEquals('-', hiid[13])
        assertEquals('-', hiid[18])
        assertEquals('-', hiid[23])
    }

    @Test
    fun `Total length is correct`() {
        val hiid = randomHIID().toString()
        assertEquals(36, hiid.length)
    }
}
