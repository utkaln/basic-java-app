#!/usr/bin/env groovy
library identifier: 'jenkins-lib@main', retriever: modernSCM(
    [$class: 'GitSCMSource',
        remote: 'https://github.com/utkaln/jenkins-lib.git',
        credentialsId: 'github-credentials-utkaln' ]
)
def grv
pipeline {
    agent any
    prameters {
        string(name: 'EC2_IP', defaultValue: '', description: 'IP of the EC2 instance') 
    }
    tools {
        maven 'Maven'
    }
    stages {
        stage("Init") {
            steps {
                script {
                    echo "Initializing Build Process from Github Webhook"
                    grv = load "jenkins-script.groovy"
                }
            }
        }
        
        stage("Update Version") {
            steps {
                script {
                    // updates version incrementally 0.0.X
                    updateVersion()
                }
            }
        }

        stage("Package Jar") {
            steps {
                script {
                    //grv.package_jar()
                    packageJar()
                }
            }
        }

        stage("Build Image") {
            steps {
                script {
                    //grv.build_image()
                    buildImage "utkal/demo-java-maven-app:basic-java-"
                }
            }
        }

        stage("Deploy") {
            steps {
                script {
                    //grv.deploy()
                    echo "EC2 IP is: ${params.EC2_IP}"
                }
            }
        }

        stage("Commit to Git") {
            steps {
                script {
                    commitVersion() 
                }
            }
        }
    }
}
