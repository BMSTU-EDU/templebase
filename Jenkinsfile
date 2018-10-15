pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            
        }
        stage('Build') {
            steps {
                sh 'docker build --pull -t templebase:latest .'
            }
        }
        stage('TAG') {
            steps {
                sh 'docker tag templebase:latest localhost:5000/templebase:latest'
            }
        }
        stage('Push to local registry') {
            steps {
                sh 'docker push localhost:5000/templebase:latest'
            }
        }
    }
}
