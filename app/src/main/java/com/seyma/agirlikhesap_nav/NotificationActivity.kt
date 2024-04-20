package com.seyma.agirlikhesap_nav

import NotificationHelper
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.AlertDialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.seyma.agirlikhesap_nav.databinding.ActivityNotificationBinding
import java.util.Calendar
import java.util.Date

class NotificationActivity : AppCompatActivity() {


    private lateinit var binding : ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel()
        binding.sumbmitButton.setOnClickListener {
            scheduleNotification()
        }

    }
    @SuppressLint("ScheduleExactAlarm")

    private fun scheduleNotification() {
        val intent = Intent(applicationContext, Notification::class.java)
        val title = binding.titleET.text.toString()
        val message = binding.messageET.text.toString()
        intent.putExtra(titleExtra, title)
        intent.putExtra(messageExtra, message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val scheduledTime = getTime()
        val currentTime = System.currentTimeMillis()

        if (scheduledTime == currentTime) {
            // Scheduled time is the same as current time, send notification immediately
            val notificationHelper = NotificationHelper(applicationContext)
            notificationHelper.createNotification(title, message)
            showAlert(scheduledTime, title, message)
        } else {
            // Schedule the notification
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                scheduledTime,
                pendingIntent
            )
            showAlert(scheduledTime, title, message)
        }
    }
    private fun showAlert(time:Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)

        AlertDialog.Builder(this)
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title:" + title +
                        "\nMessage: " + message +
                        "\nAt:" + dateFormat.format(date) + " " + timeFormat.format(date))
            .setPositiveButton("Okay") {_,_ ->}
            .show()

    }
    private fun getTime(): Long{
        val minute = binding.timePicker.minute
        val hour = binding.timePicker.hour
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calender = Calendar.getInstance()
        calender.set(year, month,day,hour,minute)
        return calender.timeInMillis
    }

    private fun   createNotificationChannel() {

        val name="Notif Channel"
        val desc = " A Description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(channelID,name,importance)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        channel.description = desc
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}