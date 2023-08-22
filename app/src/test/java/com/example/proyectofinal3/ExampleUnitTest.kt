package com.example.proyectofinal3

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class StringComparatorTest {

    private lateinit var stringComparator: StringComparator

    @Before
    fun setup() {
        stringComparator = StringComparator()
    }

    @Test
    fun testCompare_sameStrings() {
        val result = stringComparator.compare("Hello", "Hello")
        assertTrue(result)
    }

    @Test
    fun testCompare_differentStrings() {
        val result = stringComparator.compare("Hello", "World")
        assertFalse(result)
    }
}