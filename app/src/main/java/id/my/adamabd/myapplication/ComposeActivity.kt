package id.my.adamabd.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.my.adamabd.myapplication.ui.theme.MyApplicationTheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RadioButtonGroupDemo()
                }
            }
        }
    }
}

@Composable
fun RadioButtonGroupDemo() {
    // State to hold the currently selected option
    var selectedOption by remember { mutableStateOf("Option 1") }

    val options = listOf("Option 1", "Option 2", "Option 3")

    Column {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(MaterialTheme.shapes.extraSmall)
                        .padding(start = 0.dp, end = 8.dp),
                    painter = painterResource(id = R.drawable.gdsc_logo),
                    contentDescription = null
                )
                Spacer(Modifier.width(8.dp))
                Text(text = option, Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
                Box(Modifier.padding(8.dp)) {
                    RadioButton(
                        selected = option == selectedOption,
                        onClick = { selectedOption = option },
                        colors = RadioButtonDefaults.colors()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() {
    MyApplicationTheme {
        RadioButtonGroupDemo()
    }
}