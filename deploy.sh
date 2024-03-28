#!/bin/bash
source env.sh
# export EXIFWEB_PORT=8080
# export EXIFWEB_DIR=$HOME/Projects/git.exifweb/webapp/target/exifweb
# echo "cp: $EXIFWEB_DIR/WEB-INF/classes:$EXIFWEB_DIR/WEB-INF/lib/*"
# java -Dfile.encoding=UTF-8 -classpath "$EXIFWEB_DIR/WEB-INF/classes:$EXIFWEB_DIR/WEB-INF/lib/*" image.exifweb.ExifWebApp

cp -v target/*.jar /fast-disk/java-apps/
