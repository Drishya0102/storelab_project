package com.storelab.storelab_project.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.storelab.storelab_project.adapter.ImageListAdapter
import com.storelab.storelab_project.databinding.ActivityImagelistBinding
import com.storelab.storelab_project.model.Image
import com.storelab.storelab_project.model.UserViewModel
import com.storelab.storelab_project.utils.AppConstant
import retrofit2.Response

class ImageActivity: AppCompatActivity(),
    ImageListAdapter.OnItemClickListener {

    //val url = "https://picsum.photos/v2/list?page=1&limit=100"
    private var Manager: GridLayoutManager? = null
    var imageadapter : ImageListAdapter?= null
    private lateinit var binding: ActivityImagelistBinding
    private var userViewModel: UserViewModel? = null
    val favimageList = ArrayList<Image>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityImagelistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.rvImages.layoutManager = GridLayoutManager(this,2)
        imageadapter = ImageListAdapter(applicationContext)
        binding.rvImages.setAdapter(imageadapter)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        //  userViewModel = ViewModelProvider.of(this@MainActivity).get(UserViewModel::class.java)
        //imageadapter!!.setOnItemClickListener(this)

        getData()

    }

    private fun getData() {
        /*userViewModel!!.getImagePagewise().observe(this) {
                userList ->
            imageadapter?.setImageList(userList as ArrayList<Image>)
        }*/
    }


    override fun onItemClick(item: Image?,pos:Int) {
        if (item != null) {

            if (favimageList.contains(item) == true)
            {
                favimageList.remove(item)
            }
            else
            {
                favimageList.add(item)
            }

            AppConstant.showToast(applicationContext,item.id+" is addded as Favourite" +
                    " and ArrayList size is = "+favimageList!!.size)
        }
    }

}