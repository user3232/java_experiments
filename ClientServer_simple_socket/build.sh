#!/bin/sh

# run with ./build.sh
# after setting permissons with:
# chmod +x build.sh

# bouth Client.java and Server.java
# dont specify namespaces, so
# generated Client.class
# and Server.class will be just
# in bin/


# build client application (process)
javac -d ./bin Client.java
# build Server application (process)
javac -d ./bin Server.java

