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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import com.example.appcontrolescolar.data.FakeData
import com.example.appcontrolescolar.data.model.Student
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material.icons.outlined.Computer
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun ProfileScreen() {
    val student = FakeData.student
    Scaffold(
        containerColor = Color(0xFFF5F6F8)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            ProfileHeader()

            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = student.controlNumber,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF94A3B8),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    StatCard(
                        modifier = Modifier.weight(1f),
                        title = "${student.semester}",
                        subtitle = "SEMESTER",
                        iconColor = TecBlue,
                        backgroundColor = Color.White
                    )

                    StatCard(
                        modifier = Modifier.weight(1f),
                        title = "${student.average}",
                        subtitle = "AVERAGE GRADE",
                        iconColor = TecGold,
                        backgroundColor = TecBlue,
                        textColor = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                CareerCard(career = student.career)
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Today's Classes",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )

                    Text(
                        text = "View Schedule",
                        color = TecBlue,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TodayClassCard(
                    hour = "07:00 AM",
                    subject = "Data Structures",
                    classroom = "Lab 3",
                    active = true
                )

                Spacer(modifier = Modifier.height(14.dp))

                TodayClassCard(
                    hour = "09:00 AM",
                    subject = "Calculus III",
                    classroom = "Room 204",
                    active = false
                )

                Spacer(modifier = Modifier.height(90.dp))
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = TecBlue,
                shape = RoundedCornerShape(bottomStart = 36.dp, bottomEnd = 36.dp)
            )
            .padding(top = 30.dp, bottom = 28.dp, start = 20.dp, end = 20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "MY PROFILE",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Avatar",
                        tint = TecBlue,
                        modifier = Modifier.size(64.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .background(TecGold, RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Editar",
                        tint = TecBlue,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun StatCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    iconColor: Color,
    backgroundColor: Color,
    textColor: Color = Color(0xFF0F172A)
) {
    Card(
        modifier = modifier.height(170.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(
                        if (backgroundColor == TecBlue) Color.White.copy(alpha = 0.10f)
                        else Color(0xFFF1F5F9),
                        RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (subtitle == "SEMESTER") Icons.Outlined.School else Icons.Outlined.TrendingUp,
                    contentDescription = null,
                    tint = iconColor
                )
            }

            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = if (backgroundColor == TecBlue) Color.White.copy(alpha = 0.85f) else Color(0xFF475569)
                )
            }
        }
    }
}

@Composable
fun CareerCard(career: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(58.dp)
                    .background(Color(0xFFFFF3E8), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Outlined.Computer,
                    contentDescription = "Carrera",
                    tint = Color(0xFFFF7A00)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = career,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )
                Text(
                    text = "Computing Systems Engineering",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF64748B)
                )
            }

            Icon(
                imageVector = Icons.Outlined.ChevronRight,
                contentDescription = "Ver",
                tint = Color(0xFF94A3B8)
            )
        }
    }
}

@Composable
fun TodayClassCard(
    hour: String,
    subject: String,
    classroom: String,
    active: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.width(88.dp)
            ) {
                Text(
                    text = hour,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF94A3B8)
                )
            }

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(42.dp)
                    .background(Color(0xFFE2E8F0))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = subject,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (active) Color(0xFF0F172A) else Color(0xFF6B7280)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = classroom,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF64748B)
                )
            }

            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        if (active) Color(0xFF22C55E) else Color(0xFFE5E7EB),
                        CircleShape
                    )
            )
        }
    }
}