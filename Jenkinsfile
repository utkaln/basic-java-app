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
                    //grv = load "jenkins-script.groovy"
                }
            }
        }
        
        stage("package jar") {
            steps {
                script {
                    echo "Pseudo packaged jar ..."
                    //grv.package_jar()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo "Pseudo Built image ..."
                    //grv.build_image()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    //grv.deploy()
                    sh 'kubectl create deployment nginx --image=nginx'
                }
            }
        }
    }
}
