pipeline {
    agent any

    stages {
        stage ('SCM Checkout') {
          git "https://github.com/Basant-Web-Project/weather-service"
        }
        stage ('Build') {
            steps {
               sh 'mvn clean install'
            }
        }

    }
}
