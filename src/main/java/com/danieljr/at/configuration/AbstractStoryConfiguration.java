package com.danieljr.at.configuration;

import com.danieljr.at.jbehave.JBehaveReport;
import com.danieljr.at.jbehave.PropertyExamplesTableConverter;
import com.danieljr.at.jbehave.PropertyParameterConverter;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Junior.
 */
public abstract class AbstractStoryConfiguration extends JUnitStories {

    private ApplicationContext context;

    protected AbstractStoryConfiguration() {
        context = getAnnotatedApplicationContext();

        Embedder embedder = configuredEmbedder();
        String DEFAULT_STORY_TIMEOUT_SECS = "7200";
        embedder.embedderControls().doIgnoreFailureInStories(true)
                .useStoryTimeouts(DEFAULT_STORY_TIMEOUT_SECS)
                .doFailOnStoryTimeout(false)
                .doGenerateViewAfterStories(true)
                .doIgnoreFailureInView(false)
                .doVerboseFailures(true);
    }

    @Override
    public Configuration configuration() {
        StoryReporterBuilder reporterBuilder = new StoryReporterBuilder().withFormats(storyFormat())
                .withFailureTraceCompression(true).withReporters(getReporters());

        return new MostUsefulConfiguration().useStoryReporterBuilder(reporterBuilder)
                .useStoryControls(new StoryControls().doResetStateBeforeScenario(true))
                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true))
                .useParameterConverters(getConverters());
    }

    private ParameterConverters getConverters() {
        List<ParameterConverters.ParameterConverter> converters = new ArrayList<>();
        converters.add(new PropertyParameterConverter(context.getEnvironment()));
        converters.add(new PropertyExamplesTableConverter(context.getEnvironment()));
        return new ParameterConverters().addConverters(converters);
    }

    private StoryReporter[] getReporters() {
        return new StoryReporter[]{new JBehaveReport()};
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new SpringStepsFactory(configuration(), context);
    }

    protected Format[] storyFormat() {
        return new Format[]{Format.IDE_CONSOLE, Format.XML, Format.HTML};
    }

    protected ApplicationContext getContextInstance() {
        if (context == null) {
            this.context = getAnnotatedApplicationContext();
        }
        return context;
    }

    public abstract ApplicationContext getAnnotatedApplicationContext();
}