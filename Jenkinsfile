pipeline {
    agent { docker { image 'maven:3.3.3' } }
    triggers { pollSCM('H/5 * * * *') }
    stages {
        stage('test') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}