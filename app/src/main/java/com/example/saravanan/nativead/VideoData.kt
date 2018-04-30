package com.example.saravanan.nativead

import java.io.Serializable

open  class VideoData(var id: String, var title: String, var description: String, var original_source: String, var url_stream:String, var thumbnail:Thumbnail, var duration:String, var videoPosition: Int, var liked: String, var disliked: String, var visted: Boolean, var thumbnail_width:Int, var thumbnail_height:Int) : Serializable {
    constructor() : this("","testf ff", "", "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4","http://clips.vorwaerts-gmbh.de/VfE_html5.mp4",Thumbnail(""),"",0, "false","false",false,100,100)

    fun isLiked(): Boolean {
        return liked == "true"
    }

    fun disLiked(): Boolean {
        return disliked == "true"
    }

    open fun isAdVideo():Boolean{
        return false;
    }
}

data class Thumbnail(var url:String ){

}