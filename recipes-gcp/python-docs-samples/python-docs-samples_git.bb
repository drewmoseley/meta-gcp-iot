SUMMARY = "Google Cloud Platform Python Samples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/GoogleCloudPlatform/python-docs-samples;branch=master"
SRCREV = "47a39ccedf3cfdaa7825269800af7bf1294cc79c"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

PACKAGES += "${PN}-mqtt-example"

FILES_${PN}-mqtt-example = "${ROOT_HOME}/cloudiot_mqtt_example.py ${ROOT_HOME}/roots.pem"

do_install() {
    install -m 0700 -d ${D}${ROOT_HOME}
    install -m 0700 ${S}/iot/api-client/mqtt_example/cloudiot_mqtt_example.py ${D}${ROOT_HOME}
    install -m 0700 ${S}/iot/api-client/mqtt_example/resources/roots.pem ${D}${ROOT_HOME}
}
