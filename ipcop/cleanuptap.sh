#!/bin/bash
# Remove the interface from the bridge.  The second script parameter is
# the interface name.
/usr/sbin/brctl delif br0 $2

/sbin/ifconfig br0 down

/usr/sbin/brctl delbr br0 

dhclient eth0


# And use VBoxTunctl to remove the interface.
VBoxTunctl -d $2

#Change permissions to /dev/net/tun
/bin/chmod 660 /dev/net/tun
/bin/chown root:vboxusers /dev/net/tun

