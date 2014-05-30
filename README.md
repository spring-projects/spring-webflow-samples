Spring Web Flow Samples
=======================

This is the official samples repository for the [Spring Web Flow](http://github.com/SpringSource/spring-webflow) project.

Build and Run
=============

Running 'mvn package' from this directory generates .war files for all samples.

Samples without a Portlet dependency can be run with the Tomcat Maven plugin. For example:

````
cd booking-mvc
mvn tomcat7:run
````

Eclipse
=======

A. As Classic Eclipse project:
Generate Eclipse settings for all samples:

````
mvn eclipse:clean eclipse:eclipse
````

Import the projects into Eclipse. The Eclipse preferences must have an `M2_REPO` under "Java", "Build Path", "Classpath Variables".

B. When using m2e (Maven Integration for Eclipse), Import the projects into Eclipse. 

File -> Import -> Maven -> Existing Maven Projects

Contributing
============

[Pull requests](http://help.github.com/send-pull-requests) are welcome.

