//declarative pipeline
pipeline {
    agent any
    parameters { string(name: 'projectName', defaultValue: 'recapbuild', description: '')
                 string(name: 'buildNumber', defaultValue: '', description: '')
                 string(name: 'branchName', defaultValue: 'master', description: '')
    
     }
     stages{
         stage("download-artifacts"){
             steps {
                 println "cloing artifacts"
                 sh "aws s3 cp s3://devops09art/${projectName}/${branchName}/${buildNumber}/hello-${buildNumber}.war ."
             }
         }
         stage("deployToTomcat"){
             steps{
                 print "scp -i .pem hello-{buildNumber}.war ec2-user@ip:/var/lib/tomcat/webapps"
             }
         }
     }
}