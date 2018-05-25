FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://gcp-iot-mender-device-identity"

do_install_append() {
    install -d ${D}/${datadir}/mender/identity
    install -m 0755  ${WORKDIR}/gcp-iot-mender-device-identity ${D}/${datadir}/mender/identity/mender-device-identity
}
