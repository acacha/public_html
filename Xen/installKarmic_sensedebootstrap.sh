NAME=ebox2
XEN_VG=xen_vm
SIZE=50G
SWAP_SIZE=512MB
DISTRO=karmic
RAM=1024
MAC=00:16:3E:00:eb:b0 
IMAGE_PATH=/home/sergi/karmic_ubuntu_server.tar.gz

sudo lvcreate -L ${SIZE} -n ${NAME} ${XEN_VG} || exit
sudo mkfs.ext3 /dev/$XEN_VG/${NAME}
sudo lvcreate -L ${SWAP_SIZE} -n ${NAME}swap ${XEN_VG} && sudo mkswap /dev/${XEN_VG}/${NAME}swap

sudo mkdir /mnt/${NAME}
sudo mount /dev/mapper/${XEN_VG}-${NAME} /mnt/${NAME}
#sudo /usr/sbin/debootstrap --arch=amd64 --include=linux-image-server,grub --components=main,restricted,universe,multiverse $DISTRO /mnt/${NAME} \
#http://es.archive.ubuntu.com/ubuntu/ 
sudo mount /dev/mapper/xen_vm-repositori_maquina_virtual /mnt/repositori_maquina_virtual
sudo tar -xvpzf $IMAGE_PATH -C /mnt/${NAME}/

#Canviar el nom de màquina. Fitxers /etc/hosts i /etc/hostname 

sudo bash -c "cat <<EOF >/mnt/${NAME}/etc/hosts   
127.0.0.1	localhost
127.0.1.1	${NAME}.iesebre.com	${NAME}

# The following lines are desirable for IPv6 capable hosts
::1     localhost ip6-localhost ip6-loopback
fe00::0 ip6-localnet
ff00::0 ip6-mcastprefix
ff02::1 ip6-allnodes
ff02::2 ip6-allrouters
ff02::3 ip6-allhosts
EOF"

sudo bash -c "cat <<EOF >/mnt/${NAME}/etc/hostname          
${NAME}
EOF"

sudo bash -c "cat <<EOF >/mnt/${NAME}/etc/resolv.conf
domain iesebre.com
search iesebre.com
nameserver 192.168.2.1

#DNS timofonica Ferreries
#nameserver 80.58.61.250
#nameserver 80.58.61.254
EOF"

sudo umount /mnt/${NAME}

sudo bash -c "cat <<EOF >/etc/xen/${NAME}
bootloader = '/usr/lib/xen-3.2-1/bin/pygrub'
memory = ${RAM}
name = '${NAME}'
vif = [ 'mac=${MAC}, bridge=eth0' ]          # replace with DomU's IP
dhcp = 'dhcp'
#netmask = '255.255.255.0'
#gateway = 'XXX'                        # Dom0
disk = [ 'phy:/dev/${XEN_VG}/${NAME},xvda1,w','phy:/dev/${XEN_VG}/${NAME}swap,xvda2,w' ]
EOF"

