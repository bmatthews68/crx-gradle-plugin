package com.btmatthews.gradle.plugins.crx

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
class CRXArchive {

    def static CRX_MAGIC = 0x34327243
    def static CRX_VERSION = 2

    def byte[] signature
    def byte[] data

    def write(file) {
        file.withOutputStream { os ->
            def header = ByteBuffer.allocate(16)
            header.order(ByteOrder.LITTLE_ENDIAN)
            header.putLong(CRX_MAGIC)
            header.putLong(CRX_VERSION)
            header.putLong(signature.length)
            header.putLong(data.length)
            os << header
            os << signature
            os << data
        }
    }

    def read(file) {
        file.withInputStream { is ->
            def headerData = new byte[16]
            is >> headerData
            def header = ByteBuffer.wrap(headerData)
            header.order(ByteOrder.LITTLE_ENDIAN)
            if (header.getLong() == CRX_MAGIC && header.getLong() == CRX_VERSION) {
                signature = new byte[header.getLong()]
                is >> signature
                data = new byte[header.getLong()]
                is >> data
            }
        }
    }
}
