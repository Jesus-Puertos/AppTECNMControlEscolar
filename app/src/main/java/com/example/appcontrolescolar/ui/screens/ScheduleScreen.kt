package com.example.appcontrolescolar.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appcontrolescolar.ui.theme.TecBlue
import com.example.appcontrolescolar.ui.theme.TecGold

@Composable
fun ScheduleScreen() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = TecBlue,
                contentColor = Color.White,
                modifier = Modifier.navigationBarsPadding()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Acción"
                )
            }
        },
        containerColor = Color(0xFFF5F6F8)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            ScheduleHeader()

            Column(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 18.dp)
            ) {
                TimeClassCard(
                    hour = "08:00",
                    endHour = "09:00",
                    subject = "Física I",
                    teacher = "Prof. A. Einstein",
                    tag = "A2",
                    colorLine = Color(0xFF29B6F6),
                    cardColor = Color(0xFFEFF7FD)
                )

                Spacer(modifier = Modifier.height(16.dp))

                TimeClassCard(
                    hour = "10:00",
                    endHour = "12:00",
                    subject = "Programación Orientada a Objetos",
                    teacher = "Prof. G. Hopper",
                    tag = "Lab 3",
                    colorLine = Color(0xFF10B981),
                    cardColor = Color(0xFFEFFAF5)
                )

                Spacer(modifier = Modifier.height(16.dp))

                LunchCard()

                Spacer(modifier = Modifier.height(16.dp))

                TimeClassCard(
                    hour = "13:00",
                    endHour = "14:00",
                    subject = "Inglés IV",
                    teacher = "Prof. W. Shakespeare",
                    tag = "LC",
                    colorLine = Color(0xFFFF6B00),
                    cardColor = Color(0xFFFFF5EC)
                )

                Spacer(modifier = Modifier.height(16.dp))

                TimeClassCard(
                    hour = "15:00",
                    endHour = "16:00",
                    subject = "Cálculo Integral",
                    teacher = "Prof. I. Newton",
                    tag = "B12",
                    colorLine = Color(0xFF6366F1),
                    cardColor = Color(0xFFF1F2FF)
                )

                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@Composable
fun ScheduleHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = TecBlue,
                shape = RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp)
            )
            .padding(20.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "SEMESTRE AGO-DIC 2026",
                color = Color.White.copy(alpha = 0.65f),
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Horario",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ScheduleDayChip("Lun", "12", false)
                ScheduleDayChip("Mar", "13", true)
                ScheduleDayChip("Mié", "14", false)
                ScheduleDayChip("Jue", "15", false)
                ScheduleDayChip("Vie", "16", false)
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ScheduleDayChip(day: String, number: String, selected: Boolean) {
    Card(
        modifier = Modifier
            .width(58.dp)
            .height(88.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) Color.White else Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = day,
                color = if (selected) TecBlue else Color.White.copy(alpha = 0.7f)
            )
            Text(
                text = number,
                color = if (selected) TecBlue else Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .background(
                        if (selected) TecBlue else Color.Transparent,
                        CircleShape
                    )
            )
        }
    }
}

@Composable
fun TimeClassCard(
    hour: String,
    endHour: String,
    subject: String,
    teacher: String,
    tag: String,
    colorLine: Color,
    cardColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = hour,
            modifier = Modifier.width(58.dp),
            color = Color(0xFF94A3B8),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.width(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .width(5.dp)
                        .height(120.dp)
                        .background(colorLine)
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = subject,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = teacher,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color(0xFF475569)
                            )
                        }

                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White.copy(alpha = 0.6f)
                            )
                        ) {
                            Text(
                                text = tag,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                color = colorLine,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.AccessTime,
                            contentDescription = null,
                            tint = colorLine,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "$hour - $endHour",
                            color = colorLine,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LunchCard() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "12:00",
            modifier = Modifier.width(58.dp),
            color = Color(0xFF94A3B8),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.width(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8FAFC))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🍴 Lunch Break",
                    color = Color(0xFF94A3B8),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}