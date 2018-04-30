package com.example.saravanan.nativead

import com.inmobi.ads.InMobiNative

class AdFeedItem(var adItem: InMobiNative??) : VideoData() {

    fun getItem():InMobiNative{
        return adItem!!;
    }

    override fun isAdVideo():Boolean{
        return true;
    }
}