# basic-java-app
learn to build and deploy a java app using Jenkins Pipeline

* The application is created to show the simplest of Jenkins pipelines to build a java project and push the image to docker hub
* This application is made using spring initiatizer plugin in VS code to create a simple java class
* Adjust pom.xml > artifact id to name the application
* Jenkins file has following steps:
    * Build using Maven 
    * Create Docker image
    * Push image to docker hub repo
* Important files ```pom.xml```, ```Jenkinsfile```, ```Dockerfile```, ```.gitignore```
* In the Jenkins manager include Docker credentials, github credentials and set up Maven tool 


## Improvements for multi-branch pipeline support in Jenkins
* In the Jenkins configuration of the job branches of git repository can be chosen to poll build from
* Using groovy script conditional check different stages can be considered for different branches


## Other branches in this repo
* jenkins_lib : shows how to use external groovy script to supplement Jenkinsfile at a global Jenkins config --> [Link](https://github.com/utkaln/basic-java-app/tree/jenkins_lib)
* jenkins_lib_project_only : shows how to use external groovy script configured just specific to the project (not globally available) --> [Link](https://github.com/utkaln/basic-java-app/tree/jenkins_lib_project_only)
* jenkins_lib_update_version: this has library support along with changes to update version of the build in the docker image and in git with every build --> [Link](https://github.com/utkaln/basic-java-app/tree/jenkins_lib_update_version)
