#!/bin/bash

version=$@
arr=(majorversion minorversion revision)
c=0

# tr ersetzt erstes mit zweitem zeichen (. mit \n)
for i in $(echo $version | tr "." "\n")
do
	echo "versionpart $i => ${arr[$c]}"
	echo -n $i > ${arr[$c]}
	c=$c+1
done

#aktuelle version ausgeben
./get-version.cmd