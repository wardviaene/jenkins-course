// example of custom API
import groovy.json.JsonSlurperClassic 

@NonCPS
def jsonParse(def json) {
    new groovy.json.JsonSlurperClassic().parseText(json)
}

def repo = "edwardviaene/jenkins-course"

def token = httpRequest authentication: 'bitbucket-oauth', contentType: 'APPLICATION_FORM', httpMode: 'POST', requestBody: 'grant_type=client_credentials', url: 'https://bitbucket.org/site/oauth2/access_token'
def accessToken = jsonParse(token.content).access_token
def pr = httpRequest customHeaders: [[maskValue: true, name: 'Authorization', value: 'Bearer ' + accessToken]], url: "https://api.bitbucket.org/2.0/repositories/${repo}/pullrequests"

for (p in jsonParse(pr.content).values) { 
    println(p.source.branch.name)
}
