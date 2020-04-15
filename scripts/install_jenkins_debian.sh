#!/bin/bash

# this script has been tested on debian buster

# install docker

apt -y install software-properties-common dirmngr apt-transport-https lsb-release ca-certificates curl

curl -fsSL https://download.docker.com/linux/debian/gpg | sudo apt-key add -

apt-add-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"
apt-get update
apt-get install -y docker-ce
systemctl enable docker
systemctl start docker

# run jenkins
mkdir -p /var/jenkins_home
chown -R 1000:1000 /var/jenkins_home/
docker run -p 8080:8080 -p 50000:50000 -v /var/jenkins_home:/var/jenkins_home -d --name jenkins jenkins/jenkins:lts

# show endpoint
echo 'Jenkins installed'
echo 'You should now be able to access jenkins at: http://'$(curl -s ifconfig.co)':8080'
