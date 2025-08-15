pipeline {
  agent any

  tools {
    jdk 'jdk17'               // Matches your Jenkins JDK config name
    maven 'Maven 3.9.9'       // Matches your Jenkins Maven config name
  }

  stages {
    stage('Checkout') {
      steps {
        // Disable SSL verification for Git
        bat 'git config --global http.sslVerify false'

        // Now perform the checkout
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

