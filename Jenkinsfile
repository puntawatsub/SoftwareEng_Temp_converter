pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }

    stages {
        stage('Build') {
            steps {
                stages {
                    stage("Checkout") {
                        // Get some code from a GitHub repository
                        git branch: 'main',
                                url: 'https://github.com/puntawatsub/SoftwareEng_Temp_converter.git'
                    }
                    stage("Build") {
                        sh "mvn -Dmaven.test.failure.ignore=true clean install"
                    }
                    stage("Generate Report") {
                        junit '**/target/surefire-reports/*.xml'
                    }
                    stage("Publish Coverage Report") {
                        jacoco()
                    }
                }
            }

            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
