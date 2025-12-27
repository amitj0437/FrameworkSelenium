pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
    }
    post{
        failure{
            emailext body: 'Build failed.................', subject: 'Build failed', to: 'amitj0437@gmail.com'
        }
    }
}
