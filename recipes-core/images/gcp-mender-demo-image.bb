# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

SUMMARY = "A console-only image to demonstrate Google Cloud IOT integration \
with Mender OTA Update capability."

SPLASH_rpi = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL_append = " \
                     kernel-image \
                     kernel-devicetree \
                     kernel-modules \
                     networkmanager \
                     mender-wait-for-timesync \
                     python-paho-mqtt \
                     python-pip \
                     python-grpcio-tools \
"

###DISTRO_FEATURES_append += " wifi"
### IMAGE_INSTALL_append += " \
###                      linux-firmware-bcm43430
### "

INHERIT += "mender-full"

# Mender-specific settings
MENDER_SERVER_URL = "https://mender.gcpotademo.com"
IMAGE_FSTYPES_remove = "rpi-sdimg"
MENDER_ARTIFACT_NAME = "release-1"

RPI_USE_U_BOOT = "1"
MENDER_PARTITION_ALIGNMENT_KB_rpi = "4096"
MENDER_BOOT_PART_SIZE_MB_rpi = "40"
MENDER_STORAGE_TOTAL_SIZE_MB_rpi = "4000"
MENDER_DATA_PART_SIZE_MB_rpi = "1000"
##IMAGE_ROOTFS_MAXSIZE_rpi ?= "20000000"

# Switch to systemd - required for Mender
DISTRO_FEATURES_append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
VIRTUAL-RUNTIME_initscripts = ""

PACKAGE_CLASSES = "package_ipk"

INHERIT += "rm_work"
