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
                checkstyle canComputeNew: false, defaultEncoding: '', failedTotalHigh: '7', failedTotalLow: '20', failedTotalNormal: '10', healthy: '', pattern: '', unHealthy: '', unstableTotalHigh: '10', unstableTotalLow: '40', unstableTotalNormal: '20'
            }
            post { 
              always { 
                echo 'always!'
              }
              unstable { 
                echo 'unstable!'
              }
              success { 
                echo 'sucess!'
              }
            }

        }
   }
}
