#!/bin/bash

# install dependencies
apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common

# get gpg key
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -

# add docker repo
add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"

# update repository
apt-get update
apt-get install -y docker-ce docker-ce-cli containerd.io
systemctl enable docker

# jenkins setup
mkdir -p /var/jenkins_home/.ssh
cp /root/.ssh/authorized_keys /var/jenkins_home/.ssh/authorized_keys
chmod 700 /var/jenkins_home/.ssh
chmod 600 /var/jenkins_home/.ssh/authorized_keys
chown -R 1000:1000 /var/jenkins_home
docker run -p 2222:22 -v /var/jenkins_home:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock --restart always -d wardviaene/jenkins-slave
