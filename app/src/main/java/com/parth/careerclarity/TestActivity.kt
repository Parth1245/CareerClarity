package com.parth.careerclarity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.parth.careerclarity.ui.theme.CareerClarityTheme

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CareerClarityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuizScreen(
                        modifier = Modifier.padding(innerPadding),
                        onQuizComplete = { score ->
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra("score", score)
                            startActivity(intent)
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun QuizScreen(modifier: Modifier = Modifier, onQuizComplete: (Int) -> Unit) {
    val questions = listOf(
        "Do you like coding?",
        "Do you enjoy analyzing data?",
        "Do you like designing things?"
    )

    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var totalScore by remember { mutableIntStateOf(0) }

    if (currentQuestionIndex < questions.size) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = questions[currentQuestionIndex],
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            Button(
                onClick = {
                    totalScore += 2
                    currentQuestionIndex++
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text("Yes")
            }

            Button(
                onClick = {
                    totalScore += 1
                    currentQuestionIndex++
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text("Maybe")
            }

            Button(
                onClick = {
                    totalScore += 0
                    currentQuestionIndex++
                },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text("No")
            }
        }
    } else {
        LaunchedEffect(Unit) {
            onQuizComplete(totalScore)
        }
    }
}
