package com.mymusic.testofkotlin
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RemoteViews
import android.widget.Toast
import com.mymusic.testofkotlin.Apisetup.APIinterface
import com.mymusic.testofkotlin.Apisetup.ApiClient
import com.mymusic.testofkotlin.Apisetup.DataItem
import com.mymusic.testofkotlin.Apisetup.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class MainActivity2 : AppCompatActivity() {
    lateinit var NAME: EditText
    lateinit var TITLE: EditText
    lateinit var DESCRIPTION: EditText
    lateinit var ID: EditText
    lateinit var INSERT: Button
    lateinit var Update: Button
    lateinit var DELETE: Button


    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        NAME = findViewById(R.id.name)
        TITLE = findViewById(R.id.title)
        DESCRIPTION = findViewById(R.id.discription)
        ID = findViewById(R.id.delete)
        INSERT = findViewById(R.id.insert)
        Update = findViewById(R.id.update)
        DELETE = findViewById(R.id.deletebtn)

    }

    fun Onclickinsert(view: View) {
        val name: String = NAME.text.toString()
        val title: String = TITLE.text.toString()
        val description: String = DESCRIPTION.text.toString()

        val Api: APIinterface = ApiClient().getApiClient()!!.create(APIinterface::class.java)
        Api.getinsert(name, title, description).enqueue(object : Callback<ArrayList<DataItem>> {
            override fun onResponse(
                call: Call<ArrayList<DataItem>>,
                response: Response<ArrayList<DataItem>>
            ) {
                Toast.makeText(
                    this@MainActivity2,
                    "insert are successfull done ",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<ArrayList<DataItem>>, t: Throwable) {

            }

        })


    }

    fun Onclickupdate(view: View) {
        val id: String = ID.text.toString()
        val name: String = NAME.text.toString()
        val title: String = TITLE.text.toString()
        val description: String = DESCRIPTION.text.toString()


        val Api: APIinterface = ApiClient().getApiClient()!!.create(APIinterface::class.java)
        Api.getupdate(name, title, description, id).enqueue(object : Callback<ArrayList<DataItem>> {
            override fun onResponse(
                call: Call<ArrayList<DataItem>>,
                response: Response<ArrayList<DataItem>>

            ) {
                Toast.makeText(
                    this@MainActivity2,
                    "update are successfull done ",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<ArrayList<DataItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    fun Onclickdelete(view: View) {


        val id: String = ID.text.toString()
        val Api: APIinterface = ApiClient().getApiClient()!!.create(APIinterface::class.java)
        Api.getdelete(id).enqueue(object :Callback<ArrayList<DataItem>>  {
            override fun onResponse(
                call: Call<ArrayList<DataItem>>,
                response: Response<ArrayList<DataItem>>
            ) {
                notification()
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity2, "Delete successful", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // Handle unsuccessful response
                    Toast.makeText(this@MainActivity2, "Delete failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<DataItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity2, "Error: ${t.message}", Toast.LENGTH_SHORT).show()

            }

        })



    }
    @SuppressLint("SuspiciousIndentation")
    fun notification(){
        var notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager





            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)

                    .setSmallIcon(R.drawable.smslogo)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.smslogo))
                    .setSubText("hello bro")
                    .setContentText("Hello")

            } else {

                builder = Notification.Builder(this)
                    .setSmallIcon(R.drawable.smslogo)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.smslogo))
                    .setContentText("Hello")
                    .setSubText("hello bro")
            }
            notificationManager.notify(1234, builder.build())


    }

}