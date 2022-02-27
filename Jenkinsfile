pipeline {
    agent any

    tools {
        nodejs "Node17"
    }

    stages {
        stage('Test'){
            steps{
                // Newman tests
                sh "newman run postman/tests.json --global-var='host=tomcat' --global-var='port=8888'"                      
            }
        }
    }
}
