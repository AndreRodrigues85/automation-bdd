# Automation BDD project

This repository contains an automation project and you can use it as an example or a template for your own project.

Technologies: Java language, JBehave, JUnit, Spring framework, Page Object Model, and Selenium WebDriver

WebSite Automated in this project: http://automationpractice.com/index.php

## Getting Started

- How to Clone a repository:<br />
Please execute the steps as described in the tutorial.<br />
Reference: https://help.github.com/articles/cloning-a-repository/

- How to Fork a repository:<br />
Please execute the steps as described in the tutorial.<br />
Reference: https://help.github.com/articles/fork-a-repo/


**Now if you want to create your own project then I will do my best to help you out on this journey.**

## Create a Java Maven project

- Take a look at the prerequisites before creating a java maven project.<br />
Reference: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

- You need to create a maven project through the command line or through your IDE.<br />
Reference: https://maven.apache.org/guides/getting-started/

## Add dependencies to the POM file

You need to open the POM file and add dependencies for JBehave, JUnit, Spring and Selenium as below:

    <dependencies>
            <!-- Selenium -->
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>${selenium.version}</version>
            </dependency>
    
            <!-- JBehave -->
            <dependency>
                <groupId>de.codecentric</groupId>
                <artifactId>jbehave-junit-runner</artifactId>
                <version>${junit.runner.version}</version>
            </dependency>
            <dependency>
                <groupId>org.jbehave</groupId>
                <artifactId>jbehave-core</artifactId>
                <version>${jbehave.core.version}</version>
                <classifier>resources</classifier>
                <type>zip</type>
            </dependency>
            <dependency>
                <groupId>org.jbehave.site</groupId>
                <artifactId>jbehave-site-resources</artifactId>
                <version>${jbehave.site.version}</version>
                <type>zip</type>
            </dependency>
            <dependency>
                <groupId>org.jbehave</groupId>
                <artifactId>jbehave-spring</artifactId>
                <version>${jbehave.core.version}</version>
            </dependency>
            <dependency>
                <groupId>org.jbehave.web</groupId>
                <artifactId>jbehave-web-selenium</artifactId>
                <version>3.5.5</version>
            </dependency>
    
            <!-- Spring -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-web</artifactId>
                <version>${spring.version}</version>
            </dependency>
    
            <!-- Log4j-->
            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>${log4j.version}</version>
            </dependency>
        </dependencies>

## Download Selenium Driver

- You need to download the driver of each browser you want to run the automated tests.<br />
Download from here: http://www.seleniumhq.org/download/

- You need to add the .exe driver file in the resources folder.

## Stories

- In a Story file, you can define as many scenarios as you need and below are few recognized keywords that are available to be used:<br />
1. Narrative<br />
2. Scenario<br />
3. Given, When, Then, And (Steps)<br />
4. Meta<br />
5. Examples<br />

- JBehave executes your .story files. JBehave's syntax is supported by the RegexStoryParser and Gherkin syntax is supported by the GherkinStoryParser.<br />
Reference: http://jbehave.org/reference/stable/story-syntax.html

## Steps

- Each step in your story file needs to be mapped in the Step class. Please check on the link below how it does work.<br />
Reference: http://jbehave.org/reference/stable/finding-steps.html

## Spring

- Spring framework in general, and Spring Testing module in particular support the following aspects:<br />

1. Isolation<br />
2. Inversion of Control<br />
3. Data Access<br />
4. Transaction Management<br />
5. Dependency Injection<br />

Reference: http://mkuthan.github.io/blog/2014/05/29/acceptance-testing-using-jbehave-spring-framework-and-maven/

## Page Object Model

Page Object Model reduces duplicated code and means that if the UI changes, the fix need only be applied in one place.<br />
Reference: https://github.com/SeleniumHQ/selenium/wiki/PageObjects

Define Explicit Waits with Expected Conditions before taking any action on the elements of your page.<br />
Reference: https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

Check the best practices.<br />
Reference: https://seleniumhq.github.io/docs/best.html

## How to run it

- Run the AllStories file as JUnit. It will locate all your story files with StoryFinder().findPaths().<br />
Reference: http://jbehave.org/reference/stable/running-stories.html

## Support

There are two ways you can support this project:

- Open an issue for support.<br />
Reference: https://help.github.com/articles/creating-an-issue/

- Create a new branch out of master and submit your pull request.<br />
Reference: https://help.github.com/articles/creating-a-pull-request/

## Thanks for your contribution