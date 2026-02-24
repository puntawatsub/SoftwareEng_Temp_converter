pipeline {
    agent any

    environment {
        PATH = "/usr/local/bin/docker"

        // Define Docker Hub credentials ID
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        // Define Docker Hub repository name
        DOCKERHUB_REPO = 'puntawatsubhamani/week6_inclass_test1'
        // Define Docker image tag
        DOCKER_IMAGE_TAG = 'latest'
    }

    tools {
        maven 'Maven'
    }

    stages {
        stage('Check Docker') {
            steps {
                sh 'docker --version'
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/puntawatsub/SoftwareEng_Temp_converter.git' //CHECK THE GITHUB REPO
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG% .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                        docker push %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG%
                    '''
                }
            }
        }
    }
}
