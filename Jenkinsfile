pipeline {
    agent any
    tools {
            maven 'mvn'
            jdk 'jdk'
    }
    stages {
        stage('Run Docker Compose'){
            steps {
                sh 'apt install docker-compose'
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }
        stage('Run Test'){
            steps {
               sh 'mvn build'
               sh 'mvn clean test'
            }
        }
    }
    post {
         always {
            allure includeProperties: false, jdk: 'jdk', results: [[path: 'target/allure-results']]
             sh 'docker-compose down'
        }
    }
}