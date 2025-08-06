pipeline {
  agent any

  tools {
    jdk 'jdk17'
    maven 'Maven 3.8.8'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
  }

  post {
    always {
      junit '**/target/surefire-reports/*.xml'
    }
  }
}
