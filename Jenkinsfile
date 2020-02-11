node() {

    def repoURL = 'https://github.com/gabrielstar/selenide-allure-junit.git'
    def gridURL = 'http://192.168.99.1:4444/wd/hub'
    //def gridURL = 'http://10.2.1.56:4444/wd/hub'
    def branch = 'feature/cleaning'

    stage("Prepare Workspace") {
        cleanWs()
        env.WORKSPACE_LOCAL = sh(returnStdout: true, script: 'pwd').trim()
        echo "Workspace set to:" + env.WORKSPACE_LOCAL
    }
    stage('Checkout') {
        git branch: branch, credentialsId: '', url: repoURL
    }
    stage('Execute Tests') {
        withMaven(maven: 'maven35') {
            sh """
					cd ${env.WORKSPACE_LOCAL}
					mvn clean test -Dtest=RegressionTestSuite -Dselenide.remote=${gridURL}
				"""
        }
    }
    stage('Site Reports') {
        withMaven(maven: 'maven35') {
            sh """
					cd ${env.WORKSPACE_LOCAL}
					mvn site
				"""
        }
    }
    stage('Allure Reports') {
        withMaven(maven: 'maven35') {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]

        }
    }

}