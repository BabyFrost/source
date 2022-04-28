pipeline {
	agent any
	
	stages {
	
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
  						} catch (Exception e) {
  							bat "kubectl create deployment source-deployment --image=127.0.0.1:5000/voufi/source:${BUILD_NUMBER} --replicas=1"
  							bat "kubectl expose deployment source-deployment --type=LoadBalancer --name=source-service --port=8088"
  						}
					}
    			}
	        }
	    }
	    
	}
}