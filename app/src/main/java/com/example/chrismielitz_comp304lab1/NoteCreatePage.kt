package com.example.chrismielitz_comp304lab1

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_MAIN
import android.content.Intent.ACTION_VIEW
import android.content.Intent.CATEGORY_HOME
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.chrismielitz_comp304lab1.ui.theme.ChrisMielitz_comp304lab1Theme

class NoteCreatePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val gotonoteeditingscreen = Intent(this, NoteEditing::class.java)
            var thetitle by remember { mutableStateOf("") }
            var thecontents by remember { mutableStateOf("") }
            ChrisMielitz_comp304lab1Theme {
                Column {
                    TextField(
                        value = thetitle,
                        onValueChange = { thetitle = it },
                        label = { Text("Title") })
                    TextField(
                        value = thecontents,
                        onValueChange = { thecontents = it },
                        label = { Text("Body") })
                    Button(onClick = {
                        startActivity(gotonoteeditingscreen)
                        var aNewNote = Note(thetitle, thecontents)
                        alltheNotes.add(aNewNote)
                    })
                    {

                        Text("Create Note")
                    }
                }
            }
        }
    }
}

