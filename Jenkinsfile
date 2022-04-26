pipeline {
    agent any

    stages {
        stage ('SCM Checkout') {
            steps{ 
               git "https://github.com/Basant-Web-Project/weather-service"
            }
        }
        stage ('Build') {
            steps {
               def mvnHome =  tool name: '', type: 'maven' 
                sh "${mvnHome}/bin/mvn clean install"
            }
        }

    }
}
