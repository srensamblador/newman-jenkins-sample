pipeline {
    agent any

    tools {
        maven "M3"
        nodejs "Node17"
    }

    stages {
        stage('Build') {
            steps {
                // Clone git repo
                git branch: 'develop', url: 'https://github.com/srensamblador/newman-jenkins-sample'

                // Compile
                sh "mvn -f web-server/pom.xml clean compile"                
            }
            
        }
        stage('Test'){
            steps{
                // Run SpringBoot server
                sh "mvn -f web-server/pom.xml spring-boot:run -Dspring-boot.run.arguments=--server.port=8081 &"

                // Newman tests
                sh "newman run postman/tests.json"         
            }
        }
        stage('Deploy'){
            steps{
                // Package WAR file
                sh "mvn -f web-server/pom.xml -Dmaven.test.failure.ignore=true package"
            }
        }
    }
    post {        
        success {
            // Archive WAR files
            archiveArtifacts 'web-server/target/*.war'
        }
    }
}
