package com.danieljr.at;

import com.danieljr.at.configuration.ProjectConfiguration;
import com.danieljr.at.jbehave.JBehaveUIStories;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Daniel Junior.
 */
public class AllStories extends JBehaveUIStories {

    @Override
    public ApplicationContext getAnnotatedApplicationContext() {
        return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(
                CodeLocations.codeLocationFromClass(this.getClass()), "**/*.story", "");
    }
}