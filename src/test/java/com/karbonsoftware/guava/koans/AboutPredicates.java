package com.karbonsoftware.guava.koans;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class AboutPredicates {

	@Test
	public void predicatesAreGoodAtFilteringOutElementsFromACollection() {
		Predicate<Integer> isOdd = new Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				return input % 2 != 0;
			}

		};

		List<Integer> oneThroughTen = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Collection<Integer> oddNumbersOneThroughTen = Collections2.filter(oneThroughTen, isOdd);

		Assert.assertTrue(oddNumbersOneThroughTen.contains(1));
		Assert.assertTrue(oddNumbersOneThroughTen.contains(3));
		Assert.assertTrue(oddNumbersOneThroughTen.contains(5));
		Assert.assertTrue(oddNumbersOneThroughTen.contains(7));
		Assert.assertTrue(oddNumbersOneThroughTen.contains(9));

		Assert.assertFalse(oddNumbersOneThroughTen.contains(2));
		Assert.assertFalse(oddNumbersOneThroughTen.contains(4));
		Assert.assertFalse(oddNumbersOneThroughTen.contains(6));
		Assert.assertFalse(oddNumbersOneThroughTen.contains(8));
	}
}
