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
        stage("Docker build") {
             steps {
                    sh "docker build -t templebase:latest ."
                    sh "docker tag templebase:latest localhost:5000/templebase:latest"
                    sh "docker push localhost:5000/templebase:latest"
             }
        }
        
    }
}
