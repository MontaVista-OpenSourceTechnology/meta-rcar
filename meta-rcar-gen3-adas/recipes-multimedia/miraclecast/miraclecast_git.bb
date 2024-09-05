SUMMARY = "MiracleCast"
DESCRIPTION = "MiracleCast - Wifi-Display/Miracast Implementation"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

require include/omx-control.inc

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=7314adf793af1c4ce355355a659e6891"

MIRACLECAST_DHCP_SERVER ?= "kea"

DEPENDS += "glib-2.0 systemd readline libcheck"
RDEPENDS:${PN} += "wpa-supplicant iproute2 ${MIRACLECAST_DHCP_SERVER} bash python3-core \
    ${@oe.utils.conditional("USE_OMX_COMMON", "1", "gstreamer1.0-omx", "gstreamer1.0-libav", d)} \
    gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-plugins-good \
"

S = "${WORKDIR}/git"

BRANCH = "master"
SRC_URI = "git://github.com/albfan/miraclecast.git;branch=${BRANCH};protocol=https \
    ${@oe.utils.conditional("USE_OMX_COMMON", "1", "file://0001-Use-omx-instead-of-libav.patch", "", d)} \
"

SRCREV = "937747fd4de64a33bccf5adb73924c435ceb821b"

inherit meson pkgconfig

EXTRA_OEMESON += "-Dip-binary=/sbin/ip"

FILES:${PN} += "${datadir}"
