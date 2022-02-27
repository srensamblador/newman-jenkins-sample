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
                // Newman tests && reports
                sh 'newman run postman/tests.json --global-var="url=tomcat:8080" --reporters cli,junit --reporter-junit-export "reports/newman.xml"'                      
            }
        }
    }
}
