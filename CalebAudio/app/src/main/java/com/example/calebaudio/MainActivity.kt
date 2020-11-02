package com.example.calebaudio

import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import java.io.File
import android.Manifest
import android.content.pm.PackageManager
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.os.Environment
import java.io.IOException

private val peticion = 1
private lateinit var url1: Uri

class MainActivity : AppCompatActivity() {

    lateinit var recorder: MediaRecorder
    lateinit var player: MediaPlayer
    lateinit var archivo: File
    lateinit var grabar : Button
    lateinit var reproducir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grabar = findViewById<Button>(R.id.grabar)
        reproducir = findViewById<Button>(R.id.reproducir)


        grabar.setOnClickListener() {

            recorder = MediaRecorder()
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            val path = File(Environment.getExternalStorageDirectory()
                    .getPath())
            try {
                archivo = File.createTempFile("temporal", ".3gp", path)
            } catch (e: IOException) {
            }

            recorder.setOutputFile(archivo.absolutePath)
            try {
                recorder.prepare()
            } catch (e: IOException) {
            }

            recorder.start()

        }

        reproducir.setOnClickListener(){
        player.start()

    }


        }
    }
