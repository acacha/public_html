#!/bin/sh
#
# This file runs the corresponded demo.
DEMO=NetworkDemo

`dirname $0`/../../../bin/emulator -Xdescriptor:`dirname $0`/${DEMO}.jad
