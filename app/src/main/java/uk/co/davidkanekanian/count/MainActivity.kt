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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
        Scaffold(modifier = Modifier.fillMaxSize()) {
                innerPadding ->
            AnimalList(Modifier.padding(innerPadding).fillMaxSize())
        }
    }
}

@Composable
fun AnimalList(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val animals =
            listOf(
                    mapOf("name" to "camel", "sound" to R.raw.camel, "image" to R.drawable.camel),
                    mapOf("name" to "cat", "sound" to R.raw.cat, "image" to R.drawable.cat),
                    mapOf("name" to "cow", "sound" to R.raw.cow, "image" to R.drawable.cow),
                    mapOf(
                            "name" to "dolphin",
                            "sound" to R.raw.dolphin,
                            "image" to R.drawable.dolphin
                    ),
                    mapOf("name" to "duck", "sound" to R.raw.duck, "image" to R.drawable.duck),
                    mapOf(
                            "name" to "peacock",
                            "sound" to R.raw.peacock,
                            "image" to R.drawable.peacock
                    ),
                    mapOf(
                            "name" to "penguin",
                            "sound" to R.raw.penguin,
                            "image" to R.drawable.penguin
                    ),
                    mapOf("name" to "pig", "sound" to R.raw.pig, "image" to R.drawable.pig),
                    mapOf("name" to "sheep", "sound" to R.raw.sheep, "image" to R.drawable.sheep),
            )
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        animals.forEach { animal ->
            TextButton(
                    onClick = { playSound(context, animal["sound"] as Int) },
                    shape = CircleShape
            ) {
                Image(
                        painter = painterResource(id = animal["image"] as Int),
                        contentDescription = animal["name"] as String,
                        modifier = Modifier.size(150.dp).padding(16.dp)
                )
            }
        }
    }
}

fun playSound(context: Context?, sound: Int) {
    // simple version:
    var mediaPlayer = MediaPlayer.create(context, sound)
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
