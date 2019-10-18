pipeline {
  agent {
    docker {
      image 'clojure'
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