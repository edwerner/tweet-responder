# Tweet Responder

## Twitter bot responds to cat-related tweets

## Requirements
* [Apache Maven](http://maven.apache.org) 3.3.9 or greater
* [Google Cloud SDK](https://cloud.google.com/sdk/)
* `gcloud components install app-engine-java`
* `gcloud components update`

## Setup

Use either:

* `gcloud init`
* `gcloud beta auth application-default login`

We support building with [Maven](http://maven.apache.org/), [Gradle](https://gradle.org), and [IntelliJ IDEA](https://cloud.google.com/tools/intellij/docs/).
The samples have files to support both Maven and Gradle.  To use the IDE plugins, see the documentation pages above.

## Maven
[Using Maven and the App Engine Plugin](https://cloud.google.com/appengine/docs/flexible/java/using-maven)
& [Maven Plugin Goals and Parameters](https://cloud.google.com/appengine/docs/flexible/java/maven-reference)
### Running locally

    $ mvn jetty:run-exploded
  
### Deploying

    $ mvn appengine:deploy

## Gradle
[Using Gradle and the App Engine Plugin](https://cloud.google.com/appengine/docs/flexible/java/using-gradle) 
& [Gradle Tasks and Parameters](https://cloud.google.com/appengine/docs/flexible/java/gradle-reference)
### Running locally

    $ gradle jettyRun

### Deploying

    $ gradle appengineDeploy

