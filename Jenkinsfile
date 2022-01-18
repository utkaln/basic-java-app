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
            environment {
                AWS_ACCESS_KEY_ID = credentials("jenkins_aws_access_key_id")
                AWS_SECRET_ACCESS_KEY = credentials("jenkins_aws_secret_access_key")
            }
            steps {
                script {
                    sh "pwd"
                    dir("terraform") {
                        sh "terraform init"
                        sh "terraform apply --auto-approve"
                        // read ip address from terraform output and set to env var
                        EC2_PUBLIC_IP = sh(
                            script: "terraform output ec2_public_ip",
                            returnStdout: true
                        ).trim()
                    }
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
                    //deployToEC2Terraform("${params.DOCKER_IMAGE_NAME}")
                    // get IP of EC2 from Terraform output
                    script.echo "IP addr of EC2 instance found as ${EC2_PUBLIC_IP}"
                    // define docker compose command in a shell script
                    def imageNameTag = params.DOCKER_IMAGE_NAME+env.IMAGE_TAG 
                    def dockerComposeCmd = "bash ./docker-shell.sh ${imageNameTag}"
                    

                    script.sshagent(['ec2-instance-ssh-key']) {
                        // Copy the above shell script to EC2 first
                        script.sh "scp -o StrictHostKeyChecking=no docker-shell.sh ec2-user@${EC2_PUBLIC_IP}:/home/ec2-user"

                        // Copy docker-compose from git repo to EC2 instance
                        script.sh "scp -o StrictHostKeyChecking=no docker-compose.yaml ec2-user@${EC2_PUBLIC_IP}:/home/ec2-user"
                        
                        // Script to run docker command
                        // IP subject to change with each restart of EC2
                        // suppress confirmation questions with param -o
                        script.sh "ssh -o StrictHostKeyChecking=no ec2-user@${EC2_PUBLIC_IP} $dockerComposeCmd"
                    }
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
