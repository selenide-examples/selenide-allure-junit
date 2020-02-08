node() {

    def repoURL = 'https://github.com/gabrielstar/selenide-allure-junit.git'

    stage("Prepare Workspace") {
        cleanWs()
        env.WORKSPACE_LOCAL = sh(returnStdout: true, script: 'pwd').trim()
        echo "Workspace set to:" + env.WORKSPACE_LOCAL
    }
    stage('Checkout') {
        git branch: 'feature/allure_configuration', credentialsId: '', url: repoURL
    }
    stage('Execute Tests') {
        withMaven(maven: 'maven35') {
            sh """
					cd ${env.WORKSPACE_LOCAL}
					mvn clean test -Dselenide.remote=http://192.168.99.1:4444/wd/hub
				"""
        }
    }
    stage('Allure Reports') {
        withMaven(maven: 'maven35') {
            sh """
					cd ${env.WORKSPACE_LOCAL}
					mvn site
				"""
            allure includeProperties: true, jdk: '', report: "${env.APP_WORKSPACE}target/site/allure-report", results: [[path: "${env.APP_WORKSPACE}target/allure-results"]]

        }
    }
    stage('Expose reports') {
        archive "**/allure.zip"
        archive '**/allure-results'
        archive '**/allure-report'
        archive '**/site'
    }
}