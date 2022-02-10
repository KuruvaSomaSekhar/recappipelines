//declarative pipeline
pipeline {
    agent any
    stages {
        stage("checkout-clone") {
            steps{
                println "Here we are cloning our source code"
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'recap', url: 'https://github.com/KuruvaSomaSekhar/privatecode.git']]])

            }
        }
        stage("build"){
            steps{
                println "Here we build"
                sh "mvn clean package"
            }
        }
        stage("upload"){
            steps{
                println "Uplod to s3"
                sh "ls -lart"
            }
        }

    }
}