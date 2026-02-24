pipeline {
    agent any

    tools {
        maven "Maven"
    }

    stages {

        stage("Checkout") {
            steps {
                git branch: 'main',
                    url: 'https://github.com/puntawatsub/SoftwareEng_Temp_converter.git'
            }
        }

        stage("Build & Test") {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true clean verify"
            }
        }

        stage("Publish Test Report") {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage("Publish Coverage Report") {
            steps {
                jacoco()   // If using JaCoCo plugin
            }
        }
    }

    post {
        success {
            archiveArtifacts 'target/*.jar'
        }
    }
}