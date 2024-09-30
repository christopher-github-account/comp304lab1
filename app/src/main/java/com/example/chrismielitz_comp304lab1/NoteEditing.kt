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

class NoteEditing : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val gobacktomain = Intent(this,MainActivity::class.java)
            var my_title by remember {mutableStateOf("")}

            var my_contents by remember { mutableStateOf("")}
            ChrisMielitz_comp304lab1Theme {
                Column {
                    TextField(value=my_title, onValueChange = {my_title = it}, label = {Text("Title")})
                    TextField(value=my_contents, onValueChange = {my_contents = it}, label = {Text("Body")})
                    Button(onClick = {



                        //This will find the index of the note that has the title as its title, and then edit the note there and then it will go back to the home screen
                        var number = alltheNotes.indexOf(alltheNotes.find{ it.thetitle == my_title })
                        alltheNotes[number].thetitle = my_title
                        alltheNotes[number].thecontents = my_contents
                        startActivity(gobacktomain)
                    })

                    {

                        Text("Note save")
                    }
                }
            }

        }
    }






}
