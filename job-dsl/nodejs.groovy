job('Groovy-edit1') {
    scm {
        git('git://github.com/csenguttuvan/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('csenguttuvan')
            node / gitConfigEmail('chris.senguttuvan@kaltura.com')
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
        shell("npm install")
    }
}

