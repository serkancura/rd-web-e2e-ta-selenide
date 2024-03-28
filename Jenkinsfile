pipeline {
    agent any
    tools {
            maven 'mvn'
            jdk 'jdk'
    }
    stages {
        stage('Run Test'){
            steps {
               sh 'mvn clean'
               sh 'mvn install'
            }
        }
    }
    post {
         always {
            allure includeProperties: false, jdk: 'jdk', results: [[path: 'target/allure-results']]
        }
    }
}