package com.example.jentracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.title = "Chip Tracker"

        val lolCount = findViewById<TextView>(R.id.lolCount)
        val lolButton = findViewById<Button>(R.id.lolButton)

        val thatsFairCount = findViewById<TextView>(R.id.thatsFairCount)
        val thatsFairButton = findViewById<Button>(R.id.thatsFairButton)

        val luckyCount = findViewById<TextView>(R.id.luckyCount)
        val luckyButton = findViewById<Button>(R.id.luckyButton)

        val rightOnCount = findViewById<TextView>(R.id.rightOnCount)
        val rightOnButton = findViewById<Button>(R.id.rightOnButton)

        val gotchaCount = findViewById<TextView>(R.id.gotchaCount)
        val gotchaButton = findViewById<Button>(R.id.gotchaButton)

        val fairEnoughCount = findViewById<TextView>(R.id.fairEnoughCount)
        val fairEnoughButton = findViewById<Button>(R.id.fairEnoughButton)

        val imSorryCount = findViewById<TextView>(R.id.imSorryCount)
        val imSorryButton = findViewById<Button>(R.id.imSorryButton)

        val dominosCount = findViewById<TextView>(R.id.dominosCount)
        val dominosButton = findViewById<Button>(R.id.dominosButton)

        val db = FirebaseFirestore.getInstance()
        db.collection("Data").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                for(i in task.result!!) {
                    lolCount.text = i["lols"].toString()
                    thatsFairCount.text = i["thatsFairs"].toString()
                    luckyCount.text = i["luckys"].toString()
                    rightOnCount.text = i["rightOns"].toString()
                    gotchaCount.text = i["gotchas"].toString()
                    fairEnoughCount.text = i["fairEnoughs"].toString()
                    imSorryCount.text = i["imSorrys"].toString()
                    dominosCount.text = i["dominos"].toString()
                }
            }
        }

        lolButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countLols = i["lols"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["lols"] = countLols.toString()
                        db.collection("Data").document("Count").update(stat)
                        lolCount.text = countLols.toString()
                    }
                }
            }
        }

        thatsFairButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countThatsFair = i["thatsFairs"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["thatsFairs"] = countThatsFair.toString()
                        db.collection("Data").document("Count").update(stat)
                        thatsFairCount.text = countThatsFair.toString()
                    }
                }
            }
        }

        luckyButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countLucky = i["luckys"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["luckys"] = countLucky.toString()
                        db.collection("Data").document("Count").update(stat)
                        luckyCount.text = countLucky.toString()
                    }
                }
            }
        }

        rightOnButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countRightOn = i["rightOns"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["rightOns"] = countRightOn.toString()
                        db.collection("Data").document("Count").update(stat)
                        rightOnCount.text = countRightOn.toString()
                    }
                }
            }
        }

        gotchaButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countGotcha = i["gotchas"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["gotchas"] = countGotcha.toString()
                        db.collection("Data").document("Count").update(stat)
                        gotchaCount.text = countGotcha.toString()
                    }
                }
            }
        }

        fairEnoughButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countFairEnough = i["fairEnoughs"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["fairEnoughs"] = countFairEnough.toString()
                        db.collection("Data").document("Count").update(stat)
                        fairEnoughCount.text = countFairEnough.toString()
                    }
                }
            }
        }

        imSorryButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countImSorry = i["imSorrys"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["imSorrys"] = countImSorry.toString()
                        db.collection("Data").document("Count").update(stat)
                        imSorryCount.text = countImSorry.toString()
                    }
                }
            }
        }

        dominosButton.setOnClickListener {
            db.collection("Data").get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for(i in task.result!!) {
                        val countDominos = i["dominos"].toString().toInt() + 1
                        val stat: MutableMap<String, Any> = HashMap()
                            stat["dominos"] = countDominos.toString()
                        db.collection("Data").document("Count").update(stat)
                        dominosCount.text = countDominos.toString()
                    }
                }
            }
        }
    }
}