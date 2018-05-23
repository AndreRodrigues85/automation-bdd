package com.danieljr.at.jbehave;

import org.apache.log4j.Logger;
import org.jbehave.core.model.*;
import org.jbehave.core.reporters.StoryReporter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Daniel Junior.
 */
@Component
public class JBehaveReport implements StoryReporter {

    private static final Logger log = Logger.getLogger(JBehaveReport.class);

    private ThreadLocal<Boolean> runningStoryStatus = new ThreadLocal<>();

    private ThreadLocal<Story> storyThreadLocal = new ThreadLocal<>();

    public JBehaveReport() {
    }

    public void storyNotAllowed(Story story, String filter) {
        log.info(String.format("%s (NOT ALLOWED [filter: %s])", story, filter));
    }

    public void storyCancelled(Story story, StoryDuration storyDuration) {
        log.info(String.format("%s (CANCELLED [duration: %s])", story, storyDuration));
    }

    public void beforeStory(Story story, boolean givenStory) {
        this.storyThreadLocal.set(story);
        if (!story.getName().equals("BeforeStories") && !story.getName().equals("AfterStories")) {
            this.runningStoryStatus.set(true);
            this.reportBeforeStory(story);
        }
    }

    private void reportBeforeStory(Story story) {
        log.info("==========================================================");
        log.info("Begin Story: " + story.getName());
        log.info("==========================================================");
    }

    public void afterStory(boolean givenStory) {
        Story story = this.storyThreadLocal.get();
        if (story.getName() != null && !story.getName().equals("BeforeStories") && !story.getName().equals("AfterStories")) {
            this.reportAfterStory(this.storyThreadLocal.get());
        }
    }

    private void reportAfterStory(Story story) {
        String status = this.runningStoryStatus.get() ? " PASSED " : " FAILED ";
        log.info("==========================================================");
        log.info("End Story:  " + story.getName());
        log.info("Status: " + status);
        log.info("==========================================================");
    }

    public void narrative(Narrative narrative) {
        log.info(narrative.toString());
    }

    public void lifecyle(Lifecycle lifecycle) {
        log.info(lifecycle.toString());
    }

    public void scenarioNotAllowed(Scenario scenario, String filter) {
        log.info(String.format("%s (NOT ALLOWED [filter: %s])", scenario, filter));
    }

    public void beforeScenario(String scenarioTitle) {
        log.info("==========================================================");
        log.info("Scenario: " + scenarioTitle);
        log.info("==========================================================");
    }

    public void scenarioMeta(Meta meta) {
        log.info(meta.toString());
    }

    public void afterScenario() {
    }

    public void givenStories(GivenStories givenStories) {
    }

    public void givenStories(List<String> storyPaths) {
    }

    public void beforeExamples(List<String> steps, ExamplesTable table) {
    }

    public void example(Map<String, String> tableRow) {
    }

    public void afterExamples() {
    }

    public void beforeStep(String step) {
    }

    public void successful(String step) {
        log.info(String.format("%s (SUCCESSFUL)", step));
    }

    public void ignorable(String step) {
        log.info(String.format("%s (IGNORED)", step));
    }

    public void pending(String step) {
        log.info(String.format("%s (PENDING)", step));
    }

    public void notPerformed(String step) {
        log.info(String.format("%s (NOT PERFORMED)", step));
    }

    public void failed(String step, Throwable cause) {
        this.runningStoryStatus.set(false);
        log.info(String.format("%s (FAILED)", step));
    }

    public void failedOutcomes(String step, OutcomesTable table) {
    }

    public void restarted(String step, Throwable cause) {
    }

    @Override
    public void restartedStory(Story story, Throwable throwable) {
    }

    public void dryRun() {
    }

    public void pendingMethods(List<String> methods) {
    }
}