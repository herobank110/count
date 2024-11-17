package uk.co.davidkanekanian.count

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
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
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Farm Animals")
        TextButton(onClick = { playSound(context) }, shape = CircleShape) {
            Image(
                    painter = painterResource(id = R.drawable.cow),
                    contentDescription = "Cow",
                    modifier = Modifier.size(150.dp).padding(16.dp)
            )
        }
    }
}

fun playSound(context: Context?) {
    // simple version:
    var mediaPlayer = MediaPlayer.create(context, R.raw.cow)
    // complex version:
    // var mediaPlayer =
    //         MediaPlayer().apply {
    //             setAudioAttributes(
    //                     AudioAttributes.Builder()
    //                             .setContentType(
    //                                     AudioAttributes.CONTENT_TYPE_SONIFICATION
    //                             )
    //                             .setUsage(AudioAttributes.USAGE_GAME)
    //                             .build()
    //             )
    //             prepare()
    //         }
    mediaPlayer.start()
}
