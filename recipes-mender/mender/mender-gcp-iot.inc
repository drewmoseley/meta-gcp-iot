FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://gcp-iot-mender-device-identity \
    file://mender.conf \
"

do_install_append() {
    install -d ${D}/${datadir}/mender/identity
    install -m 0755  ${WORKDIR}/gcp-iot-mender-device-identity ${D}/${datadir}/mender/identity/mender-device-identity
}

MENDER_UPDATE_POLL_INTERVAL_SECONDS = "30"
MENDER_INVENTORY_POLL_INTERVAL_SECONDS = "30"
MENDER_RETRY_POLL_INTERVAL_SECONDS = "30"

do_compile_prepend() {
  bbwarn "You are building with the meta-gcp-iot layer, which is not intended for production use"
}
