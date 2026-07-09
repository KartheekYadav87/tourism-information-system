pipeline {
    agent any

    environment {
        IMAGE_NAME = "tourism-information-system"
        CONTAINER_NAME = "tourism-app"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Remove Old Container') {
            steps {
                sh 'docker rm -f $CONTAINER_NAME || true'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name $CONTAINER_NAME -p 8081:8081 $IMAGE_NAME'
            }
        }
    }

    post {
        success {
            echo 'Application deployed successfully!'
        }

        failure {
            echo 'Deployment failed.'
        }
    }
}