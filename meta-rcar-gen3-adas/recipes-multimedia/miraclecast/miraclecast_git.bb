SUMMARY = "MiracleCast"
DESCRIPTION = "MiracleCast - Wifi-Display/Miracast Implementation"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=7314adf793af1c4ce355355a659e6891"

MIRACLECAST_DHCP_SERVER ?= "kea"

DEPENDS += "glib-2.0 systemd readline libcheck"
RDEPENDS:${PN} += "wpa-supplicant iproute2 ${MIRACLECAST_DHCP_SERVER} bash python3-core \
    gstreamer1.0-libav gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-plugins-good \
"

S = "${WORKDIR}/git"

BRANCH = "master"
SRC_URI = "git://github.com/albfan/miraclecast.git;branch=${BRANCH};protocol=https"

SRCREV = "937747fd4de64a33bccf5adb73924c435ceb821b"

inherit meson pkgconfig

EXTRA_OEMESON += "-Dip-binary=/sbin/ip"

FILES:${PN} += "${datadir}"
