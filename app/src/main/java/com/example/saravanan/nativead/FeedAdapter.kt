package com.example.saravanan.nativead

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.*
import java.util.*
import android.R.raw
import android.widget.TextView

import android.widget.RelativeLayout
import android.opengl.ETC1.getWidth
import com.inmobi.ads.InMobiNative






class FeedAdapter(val context: Context, var arrModelData: List<VideoData>) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_post, parent, false)
        return ViewHolder(v,parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.prepareHolder(arrModelData[position]);
    }

    override fun getItemCount(): Int {
        return arrModelData.size
    }

    class ViewHolder(itemView: View,parent: ViewGroup) : RecyclerView.ViewHolder(itemView) {
        private  val parentT = parent;
        private val viewMain: RelativeLayout = itemView.findViewById(R.id.viewMain)
        private val viewAd: RelativeLayout    = itemView.findViewById(R.id.viewAd)
        private val videoView: VideoView    = itemView.findViewById(R.id.video)
        private val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        var videoData: VideoData?? = null;
        public fun prepareHolder(videoData: VideoData){
            this.videoData = videoData;
            txtTitle.text = videoData.title;

            if((videoData is AdFeedItem)  && videoData.isAdVideo()){
                viewAd.visibility = View.VISIBLE;
                viewMain.visibility = View.GONE;
                val nativeAd = (videoData as AdFeedItem).adItem
                val primaryView = nativeAd!!.getPrimaryViewOfWidth(itemView.context, itemView, parentT,  parentT.width)
                viewAd.addView(primaryView)
            }else {
                viewMain.visibility = View.VISIBLE;
                viewAd.visibility = View.GONE;
                val uri = Uri.parse(videoData.url_stream)
                videoView.setVideoURI(uri)
                videoView.start()
            }
        }

    }
}