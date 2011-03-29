package com.karbonsoftware.guava.koans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class AboutImmutableCollections {

	@Test
	public void creatingAListWithBareJavaApisIsPainful() {
		List<String> names = new ArrayList<String>();
		names.add("George");
		names.add("Tom");
		names.add("Barbara");
		names.add("Clyde");

		Assert.assertEquals(4, names.size());
		Assert.assertTrue(names.contains("George"));
		Assert.assertTrue(names.contains("Tom"));
		Assert.assertTrue(names.contains("Barbara"));
		Assert.assertTrue(names.contains("Clyde"));
	}

	@Test
	public void creatingAnImmutableListOfElements() {
		// ZOMG! How much better is this than the code above!?
		List<String> names = ImmutableList.of("George", "Tom", "Barbara", "Clyde");

		Assert.assertEquals(4, names.size());
		Assert.assertTrue(names.contains("George"));
		Assert.assertTrue(names.contains("Tom"));
		Assert.assertTrue(names.contains("Barbara"));
		Assert.assertTrue(names.contains("Clyde"));
	}

	@Test
	public void whyTheCollectionsApiFallsShortOfCreatingUnmodifiableCollections() {
		List<String> names = new ArrayList<String>();
		names.add("George");
		names.add("Tom");
		names.add("Barbara");
		names.add("Clyde");

		List<String> unmodifiableNames = Collections.unmodifiableList(names);

		Assert.assertEquals(4, names.size());
		Assert.assertEquals(4, unmodifiableNames.size());

		names.add("I can circumvent the unmodifiable List by changing the source List.");

		Assert.assertEquals(5, names.size());
		Assert.assertEquals(5, unmodifiableNames.size());
		Assert.assertTrue(unmodifiableNames.contains("I can circumvent the unmodifiable List by changing the source List."));

		// NOTE: This problem exists for _ANY_ of the
		// Collections.unmodifiable*() methods.
	}

	@Test(expected = UnsupportedOperationException.class)
	public void tryingToModifyAnImmutableListResultsInAnException() {
		List<String> names = ImmutableList.of("George", "Tom", "Barbara", "Clyde");
		names.add("This should cause an Exception.");
	}

	@Test
	public void creatingAnImmutableMapOfElements() {
		Map<String, String> statesToCapitals = ImmutableMap.of("Ohio", "Columbus", "Pennsylvania", "Harrisburg", "Illinois", "Springfield");

		Assert.assertEquals("Columbus", statesToCapitals.get("Ohio"));
		Assert.assertEquals("Harrisburg", statesToCapitals.get("Pennsylvania"));
		Assert.assertEquals("Springfield", statesToCapitals.get("Illinois"));
	}

	@Test
	public void buildersLetYouCreateMapsOfUnlimtedSize() {
		/*
		 * This won't compile because the of() method on ImmutableMap does not
		 * use varargs:
		 * 
		 * Map<String, String> statesToCapitals = ImmutableMap.of("Ohio",
		 * "Columbus", "Pennsylvania", "Harrisburg", "Illinois", "Springfield",
		 * "Texas", "Austin", "Michigan", "Lansing", "Oregon", "Salem");
		 */

		// Builders are helpful here:
		ImmutableMap<String, String> statesToCapitals = new ImmutableMap.Builder<String, String>().put("Ohio", "Columbus")
				.put("Pennsylvania", "Harrisburg").put("Illinois", "Springfield").put("Texas", "Austin").put("Michigan", "Lansing")
				.put("Oregon", "Salem").build();

		Assert.assertEquals("Columbus", statesToCapitals.get("Ohio"));
		Assert.assertEquals("Harrisburg", statesToCapitals.get("Pennsylvania"));
		Assert.assertEquals("Springfield", statesToCapitals.get("Illinois"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void tryingToModifyAnImmutableMapResultsInAnException() {
		Map<String, String> statesToCapitals = ImmutableMap.of("Ohio", "Columbus", "Pennsylvania", "Harrisburg", "Illinois", "Springfield");

		statesToCapitals.put("This will", "cause an UnsupportedOperationException");
	}

	@Test
	public void immutableBiMapsAllowYouToInverseTheKeyValueRelationship() {
		ImmutableBiMap<String, String> statesToCapitals = ImmutableBiMap.of("Ohio", "Columbus", "Pennsylvania", "Harrisburg", "Illinois",
				"Springfield");

		ImmutableBiMap<String, String> capitalsToStates = statesToCapitals.inverse();

		Assert.assertEquals("Ohio", capitalsToStates.get("Columbus"));
		Assert.assertEquals("Pennsylvania", capitalsToStates.get("Harrisburg"));
		Assert.assertEquals("Illinois", capitalsToStates.get("Springfield"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void tryingToModifyAnImmutableBiMapResultsInAnException() {
		ImmutableBiMap<String, String> statesToCapitals = ImmutableBiMap.of("Ohio", "Columbus", "Pennsylvania", "Harrisburg", "Illinois",
				"Springfield");

		statesToCapitals.put("Wisconsin", "Madison");
	}
}
