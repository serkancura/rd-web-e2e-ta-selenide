pipeline {
    agent any
    tools {
            maven 'mvn'
            jdk 'jdk'
    }
    stages {
       /*  stage('Run Docker Compose'){
            steps {
                step(
                     def remoteUrl = [$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: true]
                     echo ${remoteUrl}
                )
            }
        } */
        stage('Run Test'){
            steps {
               sh 'mvn compile'
               sh 'mvn clean test'
            }
        }
    }
    post {
         always {
            allure includeProperties: false, jdk: 'jdk', results: [[path: 'target/allure-results']]
            step([$class: 'DockerComposeBuilder', dockerComposeFile: 'docker-compose.yml', option: [$class: 'StopAllServices'], useCustomDockerComposeFile: true])
        }
    }
}