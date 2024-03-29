package com.example.taskapp

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val listview = binding.listview

        val tasklist = arrayListOf<String>()

        tasklist.add("attend Exam")
        tasklist.add("Complete App dev project")
        tasklist.add("go to college")
        tasklist.add("make maggi ")
        tasklist.add("play pubg")
        tasklist.add("Sham ko sankalp jana h")
        tasklist.add("Study for UPSC")
        tasklist.add("GO to main gate and some  thing")

        val adapterForMyLIStView = ArrayAdapter(this,android.R.layout.simple_list_item_1,tasklist)
        listview.adapter = adapterForMyLIStView
        listview.setOnItemClickListener { parent, view, position, id ->
            val textView = view as TextView
            val hasStrikeThrough = (textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG) > 0

            if (hasStrikeThrough) {
                // Remove strike-through effect
                textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                Toast.makeText(this, "Task TO Do: ${textView.text}", Toast.LENGTH_SHORT).show()
            } else {
                // Apply strike-through effect
                textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                Toast.makeText(this, "Task Done : ${textView.text}", Toast.LENGTH_SHORT).show()
            }
        }


















//        listview.setOnItemClickListener { parent, view, position, id ->
//            // Cast the clicked view to TextView
//            val clickedView = view as TextView
//
//            // Change the text color of the clicked item
//            clickedView.setTextColor(Color.RED) // Change color to your desired color
//
//            // Show a toast indicating the clicked item
//            val text = "Clicked on Item: ${clickedView.text}"
//            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
//
//            // Optional: Delay resetting the color to give visual feedback
////            Handler().postDelayed({
////                // Reset the text color after a delay (e.g., 500ms)
////                clickedView.setTextColor(Color.BLACK) // Reset to default color or your desired color
////            }, 500) // 500ms delay before resetting color, adjust as needed
//        }
//

//       listview.setOnItemClickListener { parent, view, position, id ->
//           val text = "Clicked on Item : "+(view as TextView).text.toString()
//           Toast.makeText(this, text,Toast.LENGTH_SHORT).show()
//       }




    }
}