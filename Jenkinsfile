pipeline {
    agent any

    tools {
        nodejs "Node17"
    }

    stages {        
        stage('Checkout'){
            steps{
                // Clone repo
                git branch: 'develop', url: 'https://github.com/srensamblador/newman-jenkins-sample'
            }
        }
        stage('Test'){
            steps{
                // Newman tests
                sh "newman run postman/tests.json --global-var='url=tomcat:8888'"                      
            }
        }
    }
}
