pipeline {
  agent any

  tools {
    jdk 'jdk17'               // Make sure this matches your Jenkins JDK config name
    maven 'Maven 3.9.9'       // Make sure this matches your Jenkins Maven config name
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        bat 'mvn clean install'
      }
    }

    stage('Test') {
      steps {
        bat 'mvn test'
      }
    }
  }

  post {
    always {
      junit '**\\target\\surefire-reports\\*.xml'
    }
  }
}
