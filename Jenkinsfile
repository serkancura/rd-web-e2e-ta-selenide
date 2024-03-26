pipeline {
    agent any
    tools {
            maven 'mvn'
            jdk 'jdk'
    }
    stages {
        stage ('Cloning Git'){
            steps {
                git branch: 'reporting', credentialsId: '1', url: 'https://github.com/serkancura/rd-web-e2e-ta-selenide.git'
            }
        }
        stage('Run Test'){
            steps {
               sh 'mvn clean install'
               sh 'mvn test'
            }
        }
        stage ('Reporting') {
            steps {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }

    }
}