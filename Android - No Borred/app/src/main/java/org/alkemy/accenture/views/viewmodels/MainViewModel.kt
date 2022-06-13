package org.alkemy.accenture.views.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val NUM_REGEX = "^[1-9][0-9]*\$"
    var blockbutton: MutableLiveData<Boolean> = MutableLiveData(false)
    var participantsNumber: Int = 0

    fun numberVerification(input: String) {
        blockbutton.value = NUM_REGEX.toRegex().matches(input)


        if(blockbutton.value == true){
            participantsNumber = input.toInt()
        }

    }
}