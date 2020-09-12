#!/bin/bash

if which qemu
then
	qemu $* -boot c -kernel linux-2.6.20.1/arch/i386/boot/bzImage -hda ./image.img -append "root=/dev/hda clock=pit"
else
	echo No he trobat executable qemu / No he encontrado ejecutable qemu
	echo Està instal.lat? / ¿Está instalado?
	echo Està actualitzada la variable PATH? / ¿Está actualizada la variable PATH?
fi
