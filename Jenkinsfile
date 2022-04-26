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
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean install'
                }
            }
        }

    }
}
