#!/usr/bin/env groovy
def package_jar() {
    echo "Package stage of basic java app starting ..."
    sh 'mvn package'
}

def build_image() {
    echo "Build Docker image for basic java app and push to docker hub ..."

    // use docker hub credentials from jenkins credentials settings
    withCredentials([usernamePassword(credentialsId: 'docker-hub-utkal', passwordVariable: 'PSWD', usernameVariable: 'UID')]) {
        // command to build an image with a tag (version)
        // image name must match with private repo name in docker hub
        sh 'docker build -t utkal/demo-java-maven-app:java-maven-2.0 .'

        // authenticate to docker hub
        sh "echo $PSWD | docker login -u $UID --password-stdin"

        // push image to docker hub
        sh 'docker push utkal/demo-java-maven-app:java-maven-2.0'
    }
}

    def deploy() {
        echo "Dummy Method"
        echo "Deploy step of basic java app completed ||||||"
    }

return this
