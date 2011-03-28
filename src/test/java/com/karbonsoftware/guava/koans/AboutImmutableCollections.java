package com.karbonsoftware.guava.koans;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class AboutImmutableCollections {

	@Test
	public void creatingAnImmutableListOfElements() {
		List<String> names = ImmutableList.of("George", "Tom", "Barbara", "Clyde");

		Assert.assertEquals(4, names.size());

		/*
		 * ZOMG! How much better is this than:
		 * 
		 * List<String> names = new ArrayList<String>(); names.add("George");
		 * names.add("Tom"); names.add("Barbara"); names.add("Clyde");
		 */
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
