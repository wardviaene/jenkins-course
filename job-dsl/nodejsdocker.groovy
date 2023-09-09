job('NodeJS Docker example dsl') {
    scm {
        git('https://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('pyrosandro/docker-nodejs-demo-dsl')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('pyrosandro-dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
