pipeline {
  agent {
    docker {
      image 'clojure:openjdk-8-lein-2.9.1'
    }

  }
  stages {
    stage('build') {
      steps {
        sh 'lein cljsbuild once min'
      }
    }
    stage('test') {
      steps {
        sh 'lein test'
      }
    }
    stage('build docker image') {
      steps {
        sh 'docker build -t "simple-reframe-todo" .'
      }
    }
  }
}