package id.my.adamabd.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

    // Options for the radio buttons
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column {
        options.forEach { option ->
            Row {
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { selectedOption = option },
                    // Customize colors, if desired
                    colors = RadioButtonDefaults.colors()
                )
                Text(text = option)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        RadioButtonGroupDemo()
    }
}