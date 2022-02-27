# Jenkins + Newman sample

This demo showcases the usage of [Newman](https://www.npmjs.com/package/newman) to run Postman tests in a CI/CD Jenkins pipeline.

## How to use the demo

First, start the containers using the Compose file attached:

``` $ docker-compose up ```

This starts both a Jenkins instance and a Tomcat hosting a simple web server against which the Postman/Newman tests will be ran.

Access Jenkins at http://localhost:8080. 

Create a new pipeline and configure it as desired. The repo contains the `Jenkinsfile` tasked with running the tests with Newman.

Once done run your pipeline either manually or automatically. Check the build logs to see the results of the execution and/or the Newman reports in your build's workspace.