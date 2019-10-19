pipeline {
    agent none
    stages {
        stage('build') {
            agent {
                docker { image 'clojure:openjdk-8-lein-2.9.1' }
            }
            steps {
                sh 'lein cljsbuild once min'

                sh 'lein test'

                sh 'lein cljsbuild test'
            }
        }
        stage('build docker image') {
            agent none
            steps {
                sh 'docker build -t "simple-reframe-todo" .'
            }
        }
    }
}