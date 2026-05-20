pipeline {
    agent any
    
    environment {
        DOCKER_BUILDKIT = '1'
        DOCKER_CLIENT_TIMEOUT = '600' // Augmenté à 10 minutes
        COMPOSE_HTTP_TIMEOUT = '600'  // Augmenté à 10 minutes
        DOCKER_MAX_CONCURRENT_UPLOADS = '1'
    }
    
    tools {
        maven "maven_for_git"
    }
    
    stages{
        stage("git checkout") {
            steps{
                git branch: 'main', credentialsId: 'cc2be19b-e7fd-40a5-a23a-4c3af892caa9', url: 'https://github.com/ravakadiamondra21/factureTrigger.git'
            }
        }
        
        stage("build the application") {
            steps {
                bat "mvn clean install"
            }
        }
        
        stage("UnitTestExecution") {
            steps {
                bat "mvn test"
            }
        }
        
        stage("Build the docker file") {
            steps {
                bat "docker build -t ravaka021/facturetriggerapp:1.0 ."
            }
        }
        
        stage("Push the docker image") {
            steps {
                    withCredentials([string(credentialsId: 'ravaka021', variable: 'dockerHubPass')]) {
                        bat """
                        set HTTP_PROXY=
                        set HTTPS_PROXY=
                        set NO_PROXY=localhost,127.0.0.1,registry-1.docker.io,docker.io,production.cloudflare.docker.com
                        docker login -u ravaka021 -p %dockerHubPass%
                        docker push ravaka021/facturetriggerapp:1.0
                         """
                    }
                    bat "docker logout"
                
            }
        }
    }
}