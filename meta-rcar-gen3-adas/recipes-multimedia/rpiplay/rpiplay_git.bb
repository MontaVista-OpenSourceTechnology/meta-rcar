SUMMARY = "RPIPlay"
DESCRIPTION = "An open-source implementation of an AirPlay mirroring server for the Raspberry Pi."

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS += "libplist mdns gstreamer1.0-plugins-base gstreamer1.0-libav gstreamer1.0-plugins-bad"

S = "${WORKDIR}/git"

BRANCH = "master"
SRC_URI = "git://github.com/FD-/RPiPlay.git;branch=${BRANCH};protocol=https \
    file://0001-Use-waylandsink-by-default.patch \
"

SRCREV = "64d0341ed3bef098c940c9ed0675948870a271f9"

inherit cmake pkgconfig
