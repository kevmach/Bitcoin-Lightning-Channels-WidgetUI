pipeline {
  agent any

  tools {
    jdk 'jdk17'               // Must match a JDK name in Jenkins Global Tool Config
    maven 'Maven 3.9.9'       // Must match a Maven name in Jenkins Global Tool Config
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
