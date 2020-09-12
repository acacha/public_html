#!/bin/bash
# Create an new TAP interface for the user ’sergi’ and remember its name.
interface=`/usr/bin/VBoxTunctl -b -u sergi`

#Change permissions to /dev/net/tun
/bin/chmod 666 /dev/net/tun

# If for some reason the interface could not be created, return 1 to
# tell this to VirtualBox.
if [ -z "$interface" ]; then
exit 1
fi
# Write the name of the interface to the standard output.
echo $interface
# Bring up the interface.
/sbin/ifconfig $interface up
#Create Bridge
/usr/sbin/brctl addbr br0
/sbin/ifconfig eth0 0.0.0.0 promisc
/usr/sbin/brctl addif br0 eth0
dhclient br0
# And add it to the bridge.
/usr/sbin/brctl addif br0 $interface
