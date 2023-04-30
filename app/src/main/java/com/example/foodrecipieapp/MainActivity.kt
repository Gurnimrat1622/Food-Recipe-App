package com.example.foodrecipieapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mIsShowPass = false
//    lateinit var pendingIntent: PendingIntent
//    private val CHANNEL_ID = "channel_id_example_01"
//    private val notificationId = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        createNotificationChannel()
        ShowHidePass.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }
        signup.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            if (email.text.toString().isEmpty() ||
                pwd.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                val storedName = sharedPreferences.getString("Name", "")
                val storedEmail = sharedPreferences.getString("Email", "")
                val storedPassword = sharedPreferences.getString("Password", "")

                val enteredData = email.text.toString().trim()
                val enteredPassword = pwd.text.toString().trim()

                if ((enteredData == storedEmail || enteredData == storedName) && enteredPassword == storedPassword) {
                    // Credentials are correct
                    val intent = Intent(this, RecepiePage::class.java)
                    startActivity(intent)
                } else {
                    // Credentials are incorrect
                    Toast.makeText(this, "Enter The correct Credentials", Toast.LENGTH_SHORT).show()
                }
            }
//            sendNotification()
        }


        showPassword(mIsShowPass)
    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            pwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ShowHidePass.setImageResource(R.drawable.ic_baseline_visibility_24)
        } else {
            // To hide the password
            pwd.transformationMethod = PasswordTransformationMethod.getInstance()
            ShowHidePass.setImageResource(R.drawable.ic_baseline_visibility_off_24)
        }
        // This line of code to put the pointer at the end of the password string
        pwd.setSelection(pwd.text.toString().length)
    }


//    private fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name = "Notification Title"
//            val descriptionText = "Notification Description"
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
//                description = descriptionText
//            }
//            val intent = Intent(this, MainActivity::class.java)
//            pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)
//            val notificationManager: NotificationManager =
//                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.createNotificationChannel(channel)
//        }
//    }
//
//    private fun sendNotification() {
//
//        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setContentTitle("Log In ")
//            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
//            .setContentText("You Have Successfully Logged In")
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .setContentIntent(pendingIntent)
//            .setAutoCancel(true)
//        with(NotificationManagerCompat.from(this)) {
//            notify(notificationId, builder.build())
//        }
//    }
}