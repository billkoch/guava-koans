package com.karbonsoftware.guava.koans;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Strings;

public class AboutStrings {

	@Test
	public void convertEmptyStringToNull() {
		Assert.assertNull(null, Strings.emptyToNull(""));
	}

	@Test
	public void convertNullToEmpty() {
		Assert.assertEquals("", Strings.nullToEmpty(null));
	}

	@Test
	public void checkingForNullOrEmpty() {
		Assert.assertTrue(Strings.isNullOrEmpty(null));
		Assert.assertTrue(Strings.isNullOrEmpty(""));
		Assert.assertFalse(Strings.isNullOrEmpty("I'm not null, or empty darn it!"));
	}

	@Test
	public void paddingStrings() {
		Assert.assertEquals("HHello", Strings.padStart("Hello", 6, 'H'));
		Assert.assertEquals("Helloo", Strings.padEnd("Hello", 6, 'o'));
	}

	@Test
	public void repitition() {
		Assert.assertEquals("HeyHeyHey", Strings.repeat("Hey", 3));
	}
}
