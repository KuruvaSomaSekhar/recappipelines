//declarative pipeline
pipeline {
    agent any
    stages {
        stage("checkout-clone") {
            steps{
                println "Here we are closing our source code"
            }
        }
        stage("build"){
            steps{
                println "Here we build"
            }
        }
        stage("upload"){
            steps{
                println "Uplod to s3"
            }
        }

    }
}