package com.danieljr.at.steps;

import com.danieljr.at.context.TestContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel Junior.
 */
public abstract class AbstractSteps {

    @Autowired
    protected TestContext context;
}