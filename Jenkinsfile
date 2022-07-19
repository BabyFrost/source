pipeline {
	agent any
	
	stages {
	
		stage("SonarQube Analysis") {
			steps {
	            bat "mvn clean verify sonar:sonar -Dsonar.projectKey=source"
	        }	
  		}
	
	    stage( "Build" ) {
	        steps {
	            bat "mvn clean package"
	        }
	    }
	    	    
	    stage( "Docker Build" ) {
	        steps {
	        bat "docker build -t localhost:5000/voufi/source:${BUILD_NUMBER} ."
	        }
	    }
	    
	    stage( "Docker Push" ) {
	        steps {
	      		bat "docker push localhost:5000/voufi/source:${BUILD_NUMBER}"
	        }
	    }
	    
	    stage( "Kubernetes Deployment" ) {
	    	steps {
	            withKubeConfig([ credentialsId: 'jenkins-robot', serverUrl: 'http://127.0.0.1:8001'] ) {
	            	script {
  						try {
  							bat "kubectl set image deployment/source-deployment source=127.0.0.1:5000/voufi/source:${BUILD_NUMBER} --record"
  							bat "kubectl apply -f config.yaml"
  						} catch (Exception e) {
  							bat "kubectl apply -f config.yaml"
  						}
					}
    			}
	        }
	    }
	    
	}
}