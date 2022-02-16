package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retardedUsers : MutableList<User>
    private lateinit var adapter: UserAdapter
    private val viewModel : MyViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("onCreate", "onCreate")

        binding.apply {
            viewModel.apply {

                initializeRecyclerView()

//                retardedUsers = mutableListOf(
//                        User("babi", "babi@a.com"),
//                        User("kuda", "kuda@a.com"),
//                        User("ayam", "ayam@a.com"),
//                )

//                adapter.populateData(retardedUsers)


                btnAdd.setOnClickListener{
                    insertOneUser()
//                    insertNewUser()
//                    adapter.populateData(retardedUsers)
                }

               users.observe(this@MainActivity, { users ->
//                    Log.i("LiveData", "$users")
                   adapter.populateData(users)
                })
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.i("onStart", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("onRestart", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("onResume", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("onPause", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("onStop", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("onDestroy", "onDestroy")
    }
    private fun initializeRecyclerView() {
        binding.apply {
            adapter = UserAdapter()
            rvUsers.adapter = adapter
            rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun insertNewUser () {
        retardedUsers.add(
            User("helo", "helo@a.com"),
        )
    }
}

