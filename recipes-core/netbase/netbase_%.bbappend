GCP_IOT_MENDER_DEMO_HOST_IP_ADDRESS ?= ""

do_install_append() {
    if [ -n "${GCP_IOT_MENDER_DEMO_HOST_IP_ADDRESS}" ]; then
        echo "${GCP_IOT_MENDER_DEMO_HOST_IP_ADDRESS} mender.gcpotademo.com gcs.mender.gcpotademo.com" >> ${D}${sysconfdir}/hosts
    fi
}
