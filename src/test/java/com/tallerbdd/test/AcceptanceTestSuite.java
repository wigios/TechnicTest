package com.tallerbdd.test;

import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.io.StoryFinder;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AcceptanceTestSuite extends SerenityStories {
	
	/**
	 * Instantiates a new acceptance test suite.
	 */
	public AcceptanceTestSuite() {
		storyPaths();
	}

	@Override
	public List<String> storyPaths() {
		return new StoryFinder()
				.findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/*.story"), null);
	}
}
