//declarative pipeline
pipeline {
    agent any
    parameters { string(name: 'sourceBranch', defaultValue: 'staging', description: '') 
                }
    stages {
        stage("checkout-clone") {
            steps{
                println "Here we are cloning our source code"
                checkout([$class: 'GitSCM', branches: [[name: '${sourceBranch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'recap', url: 'https://github.com/KuruvaSomaSekhar/privatecode.git']]])

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
                sh "s3 cp target/hello-${BUILD_NUMBER}.war s3://devops09art/${env. JOB_NAME}/${sourceBranch}/${BUILD_NUMBER}/ "
            }
        }

    }
}