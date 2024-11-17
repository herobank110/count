package uk.co.davidkanekanian.count

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.content.ContentResolver
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.davidkanekanian.count.ui.theme.CountTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { App() }
    }
}

@Preview
@Composable
fun App() {
    CountTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AnimalList(Modifier.padding(innerPadding).fillMaxSize())
        }
    }
}

@Composable
fun AnimalList(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Farm Animals")
        TextButton(
                onClick = {
                    // play cow sound
                    // var mediaPlayer = MediaPlayer.create(context, R.raw.sound_file_1)
                    var mediaPlayer =
                            MediaPlayer().apply {
                                setAudioAttributes(
                                        AudioAttributes.Builder()
                                                .setContentType(
                                                        AudioAttributes.CONTENT_TYPE_SONIFICATION
                                                )
                                                .setUsage(AudioAttributes.USAGE_GAME)
                                                .build()
                                        applicationContext,
                                        Uri.Builder()
                                                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                                                .authority(
                                                        resources
                                                                .getResourcePackageName(R.raw.cow)
                                                )
                                                .appendPath(
                                                        resources
                                                                .getResourceTypeName(R.raw.cow)
                                                )
                                                .appendPath(
                                                        resources
                                                                .getResourceEntryName(R.raw.cow)
                                                )
                                                .build()
                                )
                                prepare()
                            }

                    // getResources().openRawResourceFd(R.raw.cow).let {
                    //     mediaPlayer.setDataSource(it.fileDescriptor)//, it.startOffset,
                    // it.length)
                    //     it.close()
                    // }
                    mediaPlayer.start()
                },
                shape = CircleShape
        ) {
            Image(
                    painter = painterResource(id = R.drawable.cow),
                    contentDescription = "Cow",
                    modifier = Modifier.size(150.dp).padding(16.dp)
            )
        }
    }
}
