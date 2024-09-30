package com.example.chrismielitz_comp304lab1

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_MAIN
import android.content.Intent.ACTION_VIEW
import android.content.Intent.CATEGORY_HOME
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.chrismielitz_comp304lab1.ui.theme.ChrisMielitz_comp304lab1Theme


val alltheNotes = mutableListOf<Note>()
val another_intent = Intent()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val createthisNote = Intent(this, NoteCreatePage::class.java)
            //val o = Bundle()



            val editmyNote = Intent(this, NoteEditing::class.java)

            ChrisMielitz_comp304lab1Theme {
                Column {
                    var thetitletext by remember { mutableStateOf("QuickNotes") }
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Column {


                            Text(
                                text = thetitletext,
                                modifier = Modifier.padding(innerPadding)
                            )



                            for (Note in alltheNotes)
                                Card(onClick = { startActivity(editmyNote)
                                    var thetitle = Note.thetitle
                                another_intent.putExtra("title", thetitle)}) {
                                val thecontents = Note.thecontents
                                    another_intent.putExtra("title", thecontents)

                                    var thetitle = Note.thetitle
                                    var thecontent = Note.thecontents
                                    Text(text = thetitle)
                                    Text(text = thecontent)
                                }

                            FloatingActionButton(onClick = { startActivity(createthisNote) }) {
                                Icon(Icons.Filled.AddCircle, "This will make a note")
                            }

                        }


                    }


                }


            }


        }
    }
}
