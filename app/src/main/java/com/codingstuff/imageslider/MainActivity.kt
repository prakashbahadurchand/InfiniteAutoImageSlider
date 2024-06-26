package com.codingstuff.imageslider

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity(), IPageSwitcher {

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var adapter: ImageAdapter
    private lateinit var imageList: ArrayList<Int>
    private val runnable = Runnable {
        if (viewPager2.currentItem == imageList.size - 1) {
            viewPager2.currentItem = 0
        } else {
            viewPager2.currentItem += 1
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSetup()
    }

    private fun initSetup() {
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.one)
        imageList.add(R.drawable.two)
        imageList.add(R.drawable.three)
        imageList.add(R.drawable.four)
        imageList.add(R.drawable.five)
        imageList.add(R.drawable.six)
        imageList.add(R.drawable.seven)
        imageList.add(R.drawable.eight)


        adapter = ImageAdapter(imageList, this)
        viewPager2.adapter = adapter
        //viewPager2.offscreenPageLimit = 3
        //viewPager2.clipToPadding = false
        //viewPager2.clipChildren = false
        //viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Setup
        //val transformer = CompositePageTransformer()
        //transformer.addTransformer(MarginPageTransformer(40))
        //transformer.addTransformer { page, position ->
        //    val r = 1 - abs(position)
        //    page.scaleY = 0.85f + r * 0.14f
        //}
        //viewPager2.setPageTransformer(transformer)

        // Listener
        /*viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 5000)
            }
        })*/
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 3000)
    }

    override fun switchPage(type: CarouselType, delay: Long) {
        when (type) {
            CarouselType.CITIZEN_CHARTER -> {
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, delay)
            }
            CarouselType.MEDIA -> {
                //handler.removeCallbacks(runnable)
                //handler.postDelayed(runnable, 5000)
            }
            CarouselType.REPRESENTATIVE -> {
                //handler.removeCallbacks(runnable)
                //handler.postDelayed(runnable, 5000)
            }
            CarouselType.STAFF -> {
                //handler.removeCallbacks(runnable)
                //handler.postDelayed(runnable, 5000)
            }
        }
    }

}