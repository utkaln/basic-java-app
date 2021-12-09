#!/usr/bin/env groovy
@Library('shared-lib')_
def grv
pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    echo "Initialize groovy script ..."
                    grv = load "jenkins-script.groovy"
                }
            }
        }
        
        stage("package jar") {
            steps {
                script {
                    //grv.package_jar()
                    packageJar()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    //grv.build_image()
                    buildImage "utkal/demo-java-maven-app:java-app-3.0"
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    grv.deploy()
                }
            }
        }
    }
}
