#!/bin/sh

# run with ./run.sh
# after setting permissons with:
# chmod +x run.sh

# both Server.java and Client.java 
# dont specify namespace
# so they will be in bin/
# and dont need to be proceeded by namespace


java -classpath ./bin Server &
sleep 5
java -classpath ./bin Client
