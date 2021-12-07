# basic-java-app
learn to build and deploy a java app

* The application is created to show the simplest of Jenkins pipelines to build a java project and push the image to docker hub
* This application is made using spring initiatizer plugin in VS code to create a simple java class
* Adjust pom.xml > artifact id to name the application
* Jenkins file has following steps:
    * Build using Maven 
    * Create Docker image
    * Push image to docker hub repo
* Important files ```pom.xml```, ```Jenkinsfile```, ```Dockerfile```, ```.gitignore```
* In the Jenkins manager include Docker credentials, github credentials and set up Maven tool 
