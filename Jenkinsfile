pipeline {
    agent any
    tools {
            maven 'Maven 3.9.6'
            jdk 'jdk11'
    }
    stages {
        stage ('Cloning Git'){
            steps {
                git branch: 'reporting', credentialsId: '1', url: 'https://github.com/serkancura/rd-web-e2e-ta-selenide.git'
            }
        }
        stage('Run Test'){
            steps {
               sh 'mvn clean test'
            }
        }
        stage ('Reporting') {
            steps {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }

    }
}