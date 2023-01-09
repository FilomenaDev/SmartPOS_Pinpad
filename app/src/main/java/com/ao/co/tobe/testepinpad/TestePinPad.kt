package com.ao.co.tobe.testepinpad

import android.app.Application
import com.nexgo.oaf.apiv3.APIProxy
import com.nexgo.oaf.apiv3.DeviceEngine

class TestePinPad: Application() {

    var deviceEngine: DeviceEngine? = null

    override fun onCreate() {
        super.onCreate()
        deviceEngine = APIProxy.getDeviceEngine(this)
    }
}