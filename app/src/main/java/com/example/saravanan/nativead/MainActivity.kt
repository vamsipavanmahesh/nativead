package com.example.saravanan.nativead

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.inmobi.ads.InMobiAdRequestStatus
import com.inmobi.ads.InMobiInterstitial
import com.inmobi.sdk.InMobiSdk
import com.inmobi.ads.InMobiNative
import kotlinx.android.synthetic.main.fragment_feeds.*


class MainActivity : AppCompatActivity() {


    val mNativeAds = ArrayList<InMobiNative>()
    val mFeedItems = ArrayList<VideoData>()
    private val AD_POSITION = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InMobiSdk.init(this, "2aeea78e965843edaa7b7db5e5aca851");
        InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);

        val nativeAd = InMobiNative(this@MainActivity, 1521099592582, mInterstitialListener)
        nativeAd.load()
        mNativeAds.add(nativeAd)
        viewManager = LinearLayoutManager(this)
        viewAdapter = FeedAdapter(this,mFeedItems);
        recyclerFeed.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager




    var mInterstitialListener: InMobiNative.NativeAdListener = object : InMobiNative.NativeAdListener {
        override fun onAdImpressed(p0: InMobiNative) {
        }

        override fun onAdLoadSucceeded(p0: InMobiNative) {
            val nativeAdFeedItem = AdFeedItem(p0)
            mFeedItems.add(nativeAdFeedItem)
            viewAdapter.notifyDataSetChanged()
        }

        override fun onMediaPlaybackComplete(p0: InMobiNative) {
        }

        override fun onAdLoadFailed(p0: InMobiNative, p1: InMobiAdRequestStatus) {
        }

        override fun onUserWillLeaveApplication(p0: InMobiNative?) {
        }

        override fun onAdClicked(p0: InMobiNative) {
        }

        override fun onAdFullScreenDisplayed(p0: InMobiNative?) {
        }

        override fun onAdFullScreenWillDisplay(p0: InMobiNative?) {
        }

        override fun onAdStatusChanged(p0: InMobiNative) {
        }

        override fun onAdFullScreenDismissed(p0: InMobiNative?) {

        }

    }
}
