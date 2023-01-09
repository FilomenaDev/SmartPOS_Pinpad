package com.ao.co.tobe.testepinpad

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.ao.co.tobe.testepinpad.databinding.ActivityMainBinding
import com.nexgo.common.ByteUtils
import com.nexgo.oaf.apiv3.DeviceEngine
import com.nexgo.oaf.apiv3.SdkResult
import com.nexgo.oaf.apiv3.device.pinpad.*

class MainActivity : AppCompatActivity() {

    private lateinit var mKeyborad: View
    private lateinit var mKeyborad_0: Button
    private lateinit var mKeyborad_1: Button
    private lateinit var mKeyborad_2: Button
    private lateinit var mKeyborad_3: Button
    private lateinit var mKeyborad_4: Button
    private lateinit var mKeyborad_5: Button
    private lateinit var mKeyborad_6: Button
    private lateinit var mKeyborad_7: Button
    private lateinit var mKeyborad_8: Button
    private lateinit var mKeyborad_9: Button
    private lateinit var mKeyborad_cancel: Button
    private lateinit var mKeyborad_clear: Button
    private lateinit var mKeyborad_confirm: Button
    private var deviceEng: DeviceEngine? = null
    private var pinpad: PinPad? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deviceEng = ((this.application as TestePinPad).deviceEngine)
        pinpad = deviceEng!!.pinPad

        mKeyborad = findViewById(R.id.keyboard_view)
        mKeyborad_1 = findViewById(R.id.keyboard_1)
        mKeyborad_2 = findViewById(R.id.keyboard_2)
        mKeyborad_3 = findViewById(R.id.keyboard_3)
        mKeyborad_4 = findViewById(R.id.keyboard_4)
        mKeyborad_5 = findViewById(R.id.keyboard_5)
        mKeyborad_6 = findViewById(R.id.keyboard_6)
        mKeyborad_7 = findViewById(R.id.keyboard_7)
        mKeyborad_8 = findViewById(R.id.keyboard_8)
        mKeyborad_9 = findViewById(R.id.keyboard_9)
        mKeyborad_0 = findViewById(R.id.keyboard_0)
        mKeyborad_cancel = findViewById(R.id.keyboard_cancel)
        mKeyborad_clear = findViewById(R.id.keyboard_clear)
        mKeyborad_confirm = findViewById(R.id.keyboard_confirm)

        mKeyborad.post(Runnable {
            run {
                var pinpadLayout = PinpadLayoutEntity()
                val location = IntArray(2)
                var r: Rect

                mKeyborad_1.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_1.width + r.left
                r.bottom = mKeyborad_1.height + r.top
                pinpadLayout.key1 = r

                mKeyborad_2.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_2.width + r.left
                r.bottom = mKeyborad_2.height + r.top
                pinpadLayout.key2 = r

                mKeyborad_3.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_3.width + r.left
                r.bottom = mKeyborad_3.height + r.top
                pinpadLayout.key3 = r

                mKeyborad_4.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_4.width + r.left
                r.bottom = mKeyborad_4.height + r.top
                pinpadLayout.key4 = r

                mKeyborad_5.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_5.width + r.left
                r.bottom = mKeyborad_5.height + r.top
                pinpadLayout.key5 = r

                mKeyborad_6.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_6.width + r.left
                r.bottom = mKeyborad_6.height + r.top
                pinpadLayout.key6 = r

                mKeyborad_7.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_7.width + r.left
                r.bottom = mKeyborad_7.height + r.top
                pinpadLayout.key7 = r

                mKeyborad_8.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_8.width + r.left
                r.bottom = mKeyborad_8.height + r.top
                pinpadLayout.key8 = r

                mKeyborad_9.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_9.width + r.left
                r.bottom = mKeyborad_9.height + r.top
                pinpadLayout.key9 = r

                mKeyborad_0.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_0.width + r.left
                r.bottom = mKeyborad_0.height + r.top
                pinpadLayout.key10 = r

                mKeyborad_cancel.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_cancel.width + r.left
                r.bottom = mKeyborad_cancel.height + r.top
                pinpadLayout.keyCancel = r

                mKeyborad_clear.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_clear.width + r.left
                r.bottom = mKeyborad_clear.height + r.top
                pinpadLayout.keyClear = r

                mKeyborad_confirm.getLocationOnScreen(location)
                r = Rect()
                r.left = location[0]
                r.top = location[1]
                r.right = mKeyborad_confirm.width + r.left
                r.bottom = mKeyborad_confirm.height + r.top
                pinpadLayout.keyConfirm = r

                val number : ByteArray = pinpad!!.setPinpadLayout(pinpadLayout)
                if (number != null){
                    mKeyborad_1.text = number[1].toString()
                    mKeyborad_2.text = number[2].toString()
                    mKeyborad_3.text = number[3].toString()
                    mKeyborad_4.text = number[4].toString()
                    mKeyborad_5.text = number[5].toString()
                    mKeyborad_6.text = number[6].toString()
                    mKeyborad_7.text = number[7].toString()
                    mKeyborad_8.text = number[8].toString()
                    mKeyborad_9.text = number[9].toString()
                    mKeyborad_0.text = number[0].toString()

                    val supperLen = intArrayOf(0x04,0x05,0x06,0x07,0x08,0x09,0x0a,0x0b)
                    val pan = ByteUtils.string2ASCIIByteArray("1234567890123")
                    pinpad!!.setPinKeyboardViewMode(PinKeyboardViewModeEnum.DEFAULT)
                    pinpad!!.inputOnlinePin(supperLen,60,pan,10,
                        PinAlgorithmModeEnum.ISO9564FMT1,object: OnPinPadInputListener {
                        override fun onInputResult(retCode: Int, data: ByteArray?) {
                            when(retCode){
                                SdkResult.Success -> {
                                    Log.d("Teste1", ByteUtils.byteArray2HexStringWithSpace(data))
                                }
                                SdkResult.Fail -> {
                                    Log.d("Teste1", "Falhou")

                                }
                                SdkResult.PinPad_Input_Cancel ->{
                                    Log.d("Teste1", "Cancelado")

                                }
                                SdkResult.PinPad_Other_Error ->{
                                    Log.d("Teste1","Outros Erros")

                                }
                                SdkResult.PinPad_No_Pin_Input -> {
                                    Log.d("Teste1","Nenhum Pin Inserido ")
                                }
                                SdkResult.PinPad_Input_Timeout -> {
                                    Log.d("Teste1","Tempo acabou")

                                }
                                SdkResult.PinPad_KeyIdx_Error -> {
                                    Log.d("Teste1","Key Index Error")

                                }
                                SdkResult.PinPad_No_Key_Error -> {
                                    Log.d("Teste1","No Key Error")

                                }
                                SdkResult.PinPad_Key_Len_Error -> {
                                    Log.d("Teste1","Key Len Error")

                                }
                            }

                        }

                        override fun onSendKey(keyCode: Byte) {
                            when(keyCode){
                                PinPadKeyCode.KEYCODE_STAR ->{
                                  println("$keyCode")

                                }
                                PinPadKeyCode.KEYCODE_CLEAR->{
                                    println("$keyCode")
                                }
                            }
                        }

                    })

                }
            }
        })

    }
}