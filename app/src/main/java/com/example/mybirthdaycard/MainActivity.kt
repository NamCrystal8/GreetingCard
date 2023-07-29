package com.example.mybirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mybirthdaycard.ui.theme.MyBirthDayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBirthDayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthDayGreetingWithText(message = "Chúc mừng sinh nhật", from = "Nam")
                }
            }
        }
    }
}


@Composable
fun BirthDayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        content = {
            Text(
                text = message,
                fontSize = 36.sp
            );
            Text(
                text = "-từ " + from,
                fontSize = 24.sp
            )
        }
    )

}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    MyBirthDayCardTheme {
        BirthDayGreetingWithText(message = "Chúc mừng sinh nhật", from = "Nam")
    }
}