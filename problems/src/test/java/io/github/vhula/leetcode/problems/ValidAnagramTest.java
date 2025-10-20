package io.github.vhula.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false),
                Arguments.of("listen", "silent", true),
                Arguments.of("hello", "billion", false),
                Arguments.of("aacc", "ccac", false),
                Arguments.of("", "", true),
                Arguments.of(null, null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testIsAnagram(String s, String t, boolean expected) {
        ValidAnagram validAnagram = new ValidAnagram();
        if (expected) {
            assertTrue(validAnagram.isAnagramWithSorting(s, t));
            assertTrue(validAnagram.isAnagramWithHashMap(s, t));
            assertTrue(validAnagram.isAnagramWithCharArray(s, t));
        } else {
            assertFalse(validAnagram.isAnagramWithSorting(s, t));
            assertFalse(validAnagram.isAnagramWithHashMap(s, t));
            assertFalse(validAnagram.isAnagramWithCharArray(s, t));
        }
    }

}