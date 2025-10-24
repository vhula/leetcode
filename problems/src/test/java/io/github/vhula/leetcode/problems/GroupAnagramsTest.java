package io.github.vhula.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroupAnagramsTest {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(
                                List.of("eat", "tea", "ate"),
                                List.of("tan", "nat"),
                                List.of("bat")
                        )
                ),
                Arguments.of(
                        new String[]{""},
                        List.of(
                                List.of("")
                        )
                ),
                Arguments.of(
                        new String[]{"a"},
                        List.of(
                                List.of("a")
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testGroupAnagrams(String[] strs, List<List<String>> expectedGroups) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        var result = groupAnagrams.groupAnagramsSlow(strs);
        assertEquals(expectedGroups.size(), result.size());
        for (List<String> expectedGroup : expectedGroups) {
            boolean found = result.stream().anyMatch(group -> group.size() == expectedGroup.size() && group.containsAll(expectedGroup));
            assertTrue(found, "Expected group not found: " + expectedGroup);
        }

        result = groupAnagrams.groupAnagramsSortingWithForEachLoop(strs);
        assertEquals(expectedGroups.size(), result.size());
        for (List<String> expectedGroup : expectedGroups) {
            boolean found = result.stream().anyMatch(group -> group.size() == expectedGroup.size() && group.containsAll(expectedGroup));
            assertTrue(found, "Expected group not found: " + expectedGroup);
        }

        result = groupAnagrams.groupAnagramsSortingWithForLoop(strs);
        assertEquals(expectedGroups.size(), result.size());
        for (List<String> expectedGroup : expectedGroups) {
            boolean found = result.stream().anyMatch(group -> group.size() == expectedGroup.size() && group.containsAll(expectedGroup));
            assertTrue(found, "Expected group not found: " + expectedGroup);
        }

        result = groupAnagrams.groupAnagrams(strs);
        assertEquals(expectedGroups.size(), result.size());
        for (List<String> expectedGroup : expectedGroups) {
            boolean found = result.stream().anyMatch(group -> group.size() == expectedGroup.size() && group.containsAll(expectedGroup));
            assertTrue(found, "Expected group not found: " + expectedGroup);
        }
    }

}