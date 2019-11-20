pipeline {
    agent any
    tools {
        jdk 'jdk8'
        maven 'localMaven' 
    }
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/fernandezcg/Spring3MVC.git'
                echo 'Descargado'
                bat "Build.bat"
                echo 'Construido'
            }
        }
        stage('Quality') {
            steps {
                bat "Quality.bat"
                echo 'Quality...'
                checkstyle canComputeNew: false, defaultEncoding: '', failedTotalHigh: '10', failedTotalLow: '30', failedTotalNormal: '20', healthy: '', pattern: '', unHealthy: '', unstableTotalHigh: '5', unstableTotalLow: '15', unstableTotalNormal: '10'
            }
            post { 
              always { 
                echo 'always!'
                echo "${env.JOB_NAME}"
              }
              unstable { 
                echo 'unstable!'
                deploy adapters: [tomcat8(credentialsId: '03e1e109-4a5c-40f0-a3f1-909323c4fb34', path: '', url: 'http://localhost:8081/')], contextPath: null, war: '**/*.war'
              }
              success { 
                echo 'sucess!'
                deploy adapters: [tomcat8(credentialsId: '03e1e109-4a5c-40f0-a3f1-909323c4fb34', path: '', url: 'http://localhost:8081/')], contextPath: null, war: '**/*.war'
                deploy adapters: [tomcat8(credentialsId: '03e1e109-4a5c-40f0-a3f1-909323c4fb34', path: '', url: 'http://localhost:8082/')], contextPath: null, war: '**/*.war'
              }
            }

        }
   }
}
