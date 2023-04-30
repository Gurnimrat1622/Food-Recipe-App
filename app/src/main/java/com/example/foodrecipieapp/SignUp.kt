package com.example.foodrecipieapp

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.*

class SignUp : AppCompatActivity() {
    lateinit var pendingIntent: PendingIntent
    private val CHANNEL_ID = "channel_id_example_01"
    private val notificationId = 101
    private var mIsShowPass = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        createNotificationChannel()
        ShowHidePass1.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword1(mIsShowPass)
        }
        ShowHidePass2.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword1(mIsShowPass)
        }
        DateOfBirth.setOnClickListener {
            showDatePickerDialog(this, DateOfBirth)
        }
        submitbtn.setOnClickListener {

            if (namesign.text.toString().isEmpty() ||
                emailsign.text.toString().isEmpty() ||
                conformpwdsign.text.toString().isEmpty() ||
                passwordsign.text.toString().isEmpty()||
                DateOfBirth.text.toString().isEmpty()

            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("Name", namesign.text.toString().trim())
                editor.putString("Email", emailsign.text.toString().trim())
                editor.putString("Password", passwordsign.text.toString().trim())
                editor.apply()
                submitbtn.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
            sendNotification()

        }

        showPassword1(mIsShowPass)


    }
    private fun showPassword1(isShow: Boolean) {
        if (isShow) {
            // To show the password
            passwordsign.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ShowHidePass2.setImageResource(R.drawable.ic_baseline_visibility_24)
            conformpwdsign.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ShowHidePass1.setImageResource(R.drawable.ic_baseline_visibility_24)
        } else {
            // To hide the password
            passwordsign.transformationMethod = PasswordTransformationMethod.getInstance()
            ShowHidePass2.setImageResource(R.drawable.ic_baseline_visibility_off_24)
            conformpwdsign.transformationMethod = PasswordTransformationMethod.getInstance()
            ShowHidePass1.setImageResource(R.drawable.ic_baseline_visibility_off_24)
        }
        // This line of code to put the pointer at the end of the password string
        passwordsign.setSelection(passwordsign.text.toString().length)
    }
    fun showDatePickerDialog(context: Context, editText: EditText) {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val dateString = dateFormat.format(selectedDate.time)
                DateOfBirth.setText(dateString)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name, importance).apply {
                description = descriptionText
            }
            val intent = Intent(this,MainActivity::class.java)
            pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_MUTABLE)
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {

        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Account Created ")
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentText("Thank You For Creating An Account")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)) {
            notify(notificationId, builder.build())
        }


    }

}