pipeline{
    agent any
        tools{
            maven 'maven_3_9_11'
        }
        stages{
            stage('Build Maven'){
                steps{
                   checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/praveenreddy103946/jenkins-sample']])
                   bat 'mvn clean install'
                }
            }
            stage('Build Docker Image'){
                    steps{
                        script{
                            bat 'docker build -t prawinreddy1439/jenkins-sample .'
                        }
                    }
            }
            stage('push image to Docker Hub'){
                steps{
                    script{
                       // withCredentials([string(credentialsId: 'dockerhub-pwd2', variable: 'dockerhubpwd2')]) {
                        bat 'docker login -u prawinreddy1439 -p proBook@1234'
                        bat 'docker push prawinreddy1439/jenkins-sample'
                   // }
                }
            }
        }
            stage('Deploy Container'){
                steps{
                    script{
                        def image = "prawinreddy1439/jenkins-sample:latest"
                        bat "docker rm -f jenkins-container || exit 0"
                        bat "docker pull ${image}"
                        bat "docker run -d --name jenkins-container -p 8888:9090 -e SERVER_PORT=9090 ${image}"
                    }
                }
            }
    }
}