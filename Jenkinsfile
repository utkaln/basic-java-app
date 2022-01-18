#!/usr/bin/env groovy
library identifier: 'jenkins-lib@main', retriever: modernSCM(
    [$class: 'GitSCMSource',
        remote: 'https://github.com/utkaln/jenkins-lib.git',
        credentialsId: 'github-credentials-utkaln' ]
)
def grv
pipeline {
    agent any
    parameters {
        string(name: 'DOCKER_IMAGE_NAME', defaultValue: 'utkal/demo-java-maven-app:basic-java-', description: '') 
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
                    echo "Dummy Build image call"
                    //grv.build_image()
                    buildImage "${params.DOCKER_IMAGE_NAME}"
                }
            }
        }

        stage("Provision Instance") {
            
            steps {
                script {
                    provisionEC2Terraform()
                }
            }
        }
        
        stage("Deploy to EC2 via Terraform") {
            steps {
                script {
                    // add delay to allow terraform to create ec2 instance and run bootstrap
                    echo "Waiting for EC2 instance to initialize in 90 seconds..."
                    sleep(90) {
                        // on interrupt do
                    }
                    echo "Starting deployment step"
                
                    //grv.deploy()
                    deployToEC2Terraform()
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
