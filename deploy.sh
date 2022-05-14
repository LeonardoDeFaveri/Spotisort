#!/bin/bash

if [[ ! $# -eq 0 ]]; then
    cd $1
fi;

ID=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.artifactId -q -DforceStdout 2> /dev/null)

# folder="./target/${ID}"
folder="./target/spotisort"
dest_ID=$(echo $ID | tr '[:upper:]' '[:lower:]')

rm -rf ${TOMCAT_WEBAPPS}/${dest_ID} 2> /dev/null
cp -r ${folder} ${TOMCAT_WEBAPPS}/${dest_ID}

echo "Deployed to ${TOMCAT_WEBAPPS}/${dest_ID}"