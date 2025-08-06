pipeline {
  agent any

  tools {
    tools {
    jdk 'jdk17'               // This must match an installed JDK name (see next option)
    maven 'Maven 3.9.9'       // Use this if it's already installed
}

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
