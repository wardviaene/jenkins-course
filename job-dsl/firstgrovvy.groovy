pipeline {
    agent any
    
    statges {
        stage("build") {
            steps{
                echo 'building application...'
            }
        }
       
    statges {
        stage("Testing") {
            steps{
                echo 'Testing applications features...'
            }
        }
       
    statges {
        stage("Deploy") {
            steps{
                echo 'Deploying application to staging env...'
            }
        }
       
    }
}

