job('NodeJS Docker example') {
    scm {
        git('git://github.com/pika-3kw/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Giangnam')
            node / gitConfigEmail('giangnam10a2@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('pika3kw/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
