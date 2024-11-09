package uk.co.davidkanekanian.count

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
        Button(onClick = { Log.d("Count", "Button clicked") }) {
            Image(
                    painter = painterResource(id = R.drawable.cow),
                    contentDescription = "Cow",
                    modifier = Modifier.size(50.dp)
            )
            Text("Cow")
        }
    }
}
