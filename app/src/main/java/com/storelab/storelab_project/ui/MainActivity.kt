package com.storelab.storelab_project.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.storelab.storelab_project.R
import com.storelab.storelab_project.model.SharedViewModel
import com.storelab.storelab_project.model.SharedViewModelFactory
import com.storelab.storelab_project.repository.ImageRepository
import com.storelab.storelab_project.ui.fragment.FavouriteFragment
import com.storelab.storelab_project.ui.fragment.GalleryFragment


class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    // private val sharedViewModel: SharedViewModel by viewModels()
    private val repository = ImageRepository()
   // private val sharedViewModel: SharedViewModel by viewModels { SharedViewModelFactory(repository) }
   private var pressedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.activity_main)
            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
            loadFragment(GalleryFragment())
            val sharedViewModelFactory = SharedViewModelFactory(repository)
            val sharedViewModel: SharedViewModel = ViewModelProvider(this, sharedViewModelFactory).get(SharedViewModel::class.java)


            bottomNav=findViewById(R.id.bottomNav)
            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.id_gallery -> {
                        loadFragment(GalleryFragment())
                        true
                    }
                    R.id.id_favourite -> {
                        loadFragment(FavouriteFragment())
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }
        catch(ex:Exception)
        {
            ex.toString()
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            //super.onBackPressed()
            showexitdialog()
            //finish()
        } else {
            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
        pressedTime = System.currentTimeMillis()
    }

    fun showexitdialog()
    {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setMessage("Do you really want to Exit?")
        builder.setPositiveButton("Yes",
            DialogInterface.OnClickListener { dialog, which -> //if user pressed "yes", then he is allowed to exit from application
                finish()
            })
        builder.setNegativeButton("No",
            DialogInterface.OnClickListener { dialog, which -> //if user select "No", just cancel this dialog and continue with app
                dialog.cancel()
            })
        val alert: AlertDialog = builder.create()
        alert.show()
    }

}























/*,ImageDisplayAdapter.ImageItemClickListener,
    UserAdapter.OnItemClickListener {


    //val url = "https://picsum.photos/v2/list?page=1&limit=100"
    private var Manager: GridLayoutManager? = null
    //var adapter: ImageAdapter? = null
    var imageadapter1 : ImageDisplayAdapter ?= null

    var imageadapter : UserAdapter ?= null
    //var recyclerView:RecyclerView ?=null
    private var imageList :List<Image> ?= null

    val pageNumber = 1
    private lateinit var binding: ActivityMain1Binding

    private var userViewModel: UserViewModel? = null
    var result: Response<List<Image>>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.rvImages.layoutManager = GridLayoutManager(this,2)
       *//* fetchImages(pageNumber)
        binding.swipeRefreshLayout.setOnRefreshListener {
            var nextPageNumber: Int = 0
            if (pageNumber < TOTAL_PAGES) {
                nextPageNumber = pageNumber + 1
            }
            fetchImages(nextPageNumber)
        }*//*

        imageadapter = UserAdapter(applicationContext)
        binding.rvImages.setAdapter(imageadapter)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
      //  userViewModel = ViewModelProvider.of(this@MainActivity).get(UserViewModel::class.java)
     //   imageadapter!!.setOnItemClickListener(this)

        *//*swipeToRefreshLV.setOnRefreshListener {

            // on below line we are setting refreshing to false/
            swipeToRefreshLV.isRefreshing = false

            // on below line we are creating a variable
            // for our original list
            val originalList = courseList.toMutableList()

            // on below line we are shuffling our list.
            val shuffledList = originalList.shuffled()

            // on below line we are initializing our course adapter
            // and passing course list and context.
            val courseAdapter = CourseLVAdapter(courseList = shuffledList, this@MainActivity)

            // on below line we are setting adapter to our list view.
            courseLV.adapter = courseAdapter
        }
*//*
       *//* with(binding)
        {

            with(imageadapter)
            {
                swipeRefreshLayout.setOnRefreshListener {

                    // on below line we are setting refreshing to false/
                    swipeRefreshLayout.isRefreshing = false
                    userViewModel!!.imagePagewise.observe(this@MainActivity) {
                            userList ->
                        imageadapter?.setImageList(userList as ArrayList<Image>)
                    }
                }
                swipeRefreshLayout.isRefreshing = true
            }
        }*//*

        getData()

    }

    private fun getData() {
        userViewModel!!.allUsers.observe(this) {
                userList ->
            imageadapter?.setImageList(userList as ArrayList<Image>)
        }
    }

 *//*   fun fetchImages(nextPageNumber: Int)
    {

        if (AppConstant.isNetworkConnected(this@MainActivity))
        {
            val apiService = ApiClient.getClient().create(ApiInterface::class.java)
            try
            {
                val rLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                rLayoutManager.gapStrategy =
                    StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

                *//**//*     GlobalScope.launch {
                     val result = apiService.getImagesfromurl()
                     if (result != null)
                     {
                         val subsRes: List<Image> =
                             result.body() as List<Image>
                         imageList = subsRes
                         withContext(Dispatchers.Main) {
                             rvImages.apply {
                                 layoutManager = rLayoutManager
                                 imageadapter =
                                     ImageDisplayAdapter(imageList, applicationContext)
                                 binding.rvImages.adapter = adapter
                             }

                         }

                     }
                     with(imageadapter)
                     {
                         this?.imageClickListener = this@MainActivity
                     }
                 }*//**//*


                GlobalScope.launch {
                    result = apiService.getImagesfromurl1(nextPageNumber)
                }
                if (result != null) {
                    try {
                        val subsRes: List<Image> =
                            result!!.body() as List<Image>
                        imageList = subsRes
                        if (imageadapter == null) {
                            imageadapter = ImageDisplayAdapter(imageList!!, this@MainActivity)
                            binding.rvImages.adapter = imageadapter
                        } else {
                            //imageList = response?.body()!!
                            imageadapter?.notifyDataSetChanged()
                        }

                    } catch (e: java.lang.Exception) {
                    }

                }

            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }*//*



    override fun onImageClicked(binding: ItemImageBinding, item: Image) {
        AppConstant.showToast(applicationContext,item.download_url)
    }

    override fun onItemClick(item: Image?) {
        if (item != null) {
            AppConstant.showToast(applicationContext,item.download_url)
        }
    }

*//*private fun fetchImages() {
    val url = "https://picsum.photos/v2/list?page=1&limit=100"
    val request = Request.Builder().url(url).build()

    OkHttpClient().newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            val responseBody = response.body?.string()
            val images = Gson().fromJson(responseBody, Array<Image>::class.java)

            runOnUiThread {
                adapter = ImageAdapter(images.toList(),this@MainActivity)
                recyclerView?.adapter = adapter
            }
        }


    })


      val url = AppConstant.//"https://jsonplaceholder.typicode.com/photos"
    val request = Request.Builder().url(url).build()

    OkHttpClient().newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            val responseBody = response.body?.string()
            val images = Gson().fromJson(responseBody, Array<Image>::class.java)

            runOnUiThread {
                adapter = ImageAdapter(images.toList(), this@MainActivity)
                recyclerView?.adapter = adapter
            }
        }
    })
}*//*



*//*  //working code
  private fun fetchImages() {

      if (AppConstant.isNetworkConnected(this@MainActivity))
      {
          val apiService = ApiClient.getClient().create(ApiInterface::class.java)
          try
          {
              //val classificationCall: Call<ImageList> = apiService.getImagesfromurl()
              GlobalScope.launch {
                  val result = apiService.getImagesfromurl(pageNumber)


                  if (result != null)
                  // Checking the results
                      //Log.d("Details: ", result.body().toString())
                      try {
                          val subsRes: List<Image> =
                              result.body() as List<Image>
                          withContext(Dispatchers.Main) {
                              adapter = ImageAdapter(subsRes,this@MainActivity)
                              recyclerView?.adapter = adapter

                          }
                          var nextPageNumber: Int? = null
                          if (pageNumber < TOTAL_PAGES) {
                              nextPageNumber = pageNumber + 1
                          }



                      } catch (e: java.lang.Exception) {
                      }
              }
          }
          catch (e: Exception) {
              e.printStackTrace()
          }
      }
  }

*//*
}*/