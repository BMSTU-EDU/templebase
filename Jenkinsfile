pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build maven') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test maven') {
            steps {
                sh 'mvn test'
            }
            
        }
        stage('Build docker') {
            steps {
                sh '/usr/bin/docker build --pull -t templebase:latest .'
            }
        }
        stage('TAG') {
            steps {
                sh '/usr/bin/docker tag templebase:latest localhost:5000/templebase:latest'
            }
        }
        stage('Push to local registry') {
            steps {
                sh '/usr/bin/docker push localhost:5000/templebase:latest'
            }
        }
    }
}
