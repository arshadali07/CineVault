package com.project.core.data.logging

import co.touchlab.kermit.Logger
import com.project.core.domain.logging.CineVaultLogger

object KermitLogger : CineVaultLogger {

    override fun debug(message: String) {
        Logger.d(message)
    }

    override fun info(message: String) {
        Logger.i(message)
    }

    override fun warn(message: String) {
        Logger.w(message)
    }

    override fun error(message: String, throwable: Throwable?) {
        Logger.e(message, throwable)
    }
}