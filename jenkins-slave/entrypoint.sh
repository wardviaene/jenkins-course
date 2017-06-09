#!/bin/bash
dpkg-reconfigure openssh-server
/usr/sbin/sshd -D
