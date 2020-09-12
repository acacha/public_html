#!/bin/bash

ARCH=i386
DISTRIBUTION=karmic
MIRROR=http://es.archive.ubuntu.com/ubuntu/

/bin/mkdir -p ~/ProvesDiscs/images
/usr/bin/nice /bin/dd if=/dev/zero of=~/ProvesDiscs/images/1G.img bs=1024k count=1000
/usr/bin/sudo sleep 1
lo_free_device=$(/usr/bin/sudo /sbin/losetup -f)
/usr/bin/sudo losetup $lo_free_device ~/ProvesDiscs/images/1G.img

echo "lo_free_device:$lo_free_device"

#Autoparticionar amb SFDISK
echo "sfdisk $lo_free_device..."
/usr/bin/sudo /sbin/sfdisk $lo_free_device <<EOF
# taula de particions de ${lo_free_device}
unit: sectors

${lo_free_device}p1 : start=       63, size=  2040192, Id=83
${lo_free_device}p2 : start=        0, size=        0, Id= 0
${lo_free_device}p3 : start=        0, size=        0, Id= 0
${lo_free_device}p4 : start=        0, size=        0, Id= 0
EOF

/usr/bin/sudo /bin/mkdir -p /mnt/temp

#Accedir a les particions
first_partition_loop_free_device=$(/usr/bin/sudo /sbin/losetup -f)
echo "losetup -o 63 ${first_partition_loop_free_device} ${lo_free_device}"
/usr/bin/sudo /sbin/losetup  -o 63 ${first_partition_loop_free_device} ${lo_free_device}

/usr/bin/sudo /sbin/losetup -a
sleep 5

echo "mkfs.ext3 ${first_partition_loop_free_device}..."
/usr/bin/sudo /sbin/mkfs.ext3 ${first_partition_loop_free_device}
echo "/bin/mount ${first_partition_loop_free_device} /mnt/temp..."
/usr/bin/sudo /bin/mount ${first_partition_loop_free_device} /mnt/temp

#Instal·lar una Ubuntu bàsica amb debootstrap
/usr/bin/sudo /usr/bin/apt-get install debootstrap > /dev/null
/usr/bin/sudo /usr/sbin/debootstrap --arch $ARCH $DISTRIBUTION /mnt/temp $MIRROR

exit

#Instal·lar un gestor d'arrancada


#Alliberar dispositius de loop
/usr/bin/sudo /bin/umount /mnt/temp
/usr/bin/sudo /sbin/losetup -d ${first_partition_loop_free_device}
/usr/bin/sudo /sbin/losetup -d ${second_partition_loop_free_device}
/usr/bin/sudo /sbin/losetup -d ${lo_free_device}


#Instal·lar VirtualBox
#Obtenir la versió d'Ubuntu
#En alguns sistemes el paquet lsb no hi és:
/usr/bin/sudo /usr/bin/apt-get install lsb > /dev/null
ubuntu_release=`lsb_release -c | awk '{ print $2}'`
#Comprovar si ja existeix la la­nia a sources.list
virtualbox_in_sources=`cat /etc/apt/sources.list | grep "deb http://download.virtualbox.org/virtualbox/debian $ubuntu_release non-free"`

#Només afegim la la línia si no existeix
if [ -z "$virtualbox_in_sources" ]; then
  /usr/bin/sudo /bin/cp /etc/apt/sources.list /etc/apt/sources.list.orig.virtualbox
    echo "deb http://download.virtualbox.org/virtualbox/debian $ubuntu_release non-free" | sudo tee -a /etc/apt/sources.list
fi
    
#Instal·lar la clau de virtual box
/usr/bin/sudo /usr/bin/apt-get install wget > /dev/null
/usr/bin/wget -q http://download.virtualbox.org/virtualbox/debian/sun_vbox.asc -O- | /usr/bin/sudo /usr/bin/apt-key add -

# Actualitzar apt                                                                  
/usr/bin/sudo /usr/bin/apt-get update > /dev/null
/usr/bin/sudo /usr/bin/apt-get install virtualbox-3.0 > /dev/null

echo "VBoxManage convertfromraw ~/ProvesDiscs/images/1G.img ~/ProvesDiscs/images/1G.vdi..."
/usr/bin/sudo /bin/rm -rf /home/sergi/ProvesDiscs/images/1G.vdi
/usr/bin/VBoxManage convertfromraw ~/ProvesDiscs/images/1G.img ~/ProvesDiscs/images/1G.vdi

VBoxManage createvm --name 1GB --register

VBoxManage modifyvm 1GB -hda ~/ProvesDiscs/images/1G.vdi 

VBoxManage startvm 1GB

#Qemu
#/usr/bin/sudo /usr/bin/apt-get install qemu > /dev/null


#Punt de muntatge
#/usr/bin/sudo /bin/mkdir -p /mnt/1GB

#/bin/mount -o loop ~/ProvesDiscs/images/1G.img /mnt/1GB

