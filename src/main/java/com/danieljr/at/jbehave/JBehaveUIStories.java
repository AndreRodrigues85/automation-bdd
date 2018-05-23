package com.danieljr.at.jbehave;

import com.danieljr.at.configuration.AbstractStoryConfiguration;
import com.danieljr.at.jbehave.format.CustomFormat;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.reporters.Format;

/**
 * Created by Daniel Junior.
 */
public abstract class JBehaveUIStories extends AbstractStoryConfiguration {

    public JBehaveUIStories() {
    }

    public Configuration configuration() {
        return super.configuration();
    }

    @Override
    protected Format[] storyFormat() {
        return new Format[]{Format.IDE_CONSOLE, Format.XML, new CustomFormat(this.getContextInstance().getEnvironment())};
    }
}