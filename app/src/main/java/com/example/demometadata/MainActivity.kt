package com.example.demometadata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private var mAdapter: MetaDataAdapter? = null
    private var listManager: LinearLayoutManager? = null
    var mUrl = "http://stephenhy.site/nam/live/backend/web/upload/demo.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listManager = LinearLayoutManager(baseContext, RecyclerView.VERTICAL, false)
        lvMetaData!!.layoutManager = listManager
        if (mAdapter == null){
            mAdapter = MetaDataAdapter()
        }
        runOnUiThread{
            val data = MetadataLoader.loadMetaData(mUrl)
            mAdapter!!.clear()
            mAdapter!!.add(data!!)
            lvMetaData.adapter = mAdapter
        }
    }
}
