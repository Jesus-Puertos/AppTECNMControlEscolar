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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.outlined.Apartment
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Layers
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Science
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appcontrolescolar.ui.theme.TecBlue
import com.example.appcontrolescolar.ui.theme.TecGold

@Composable
fun MapScreen() {
    val searchText = remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = TecBlue,
                contentColor = Color.White,
                modifier = Modifier.navigationBarsPadding()
            ) {
                Icon(
                    imageVector = Icons.Default.MyLocation,
                    contentDescription = "Ubicación"
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
            MapHeader()

            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                OutlinedTextField(
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("Buscar edificio o aula")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Buscar"
                        )
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = TecBlue,
                        unfocusedBorderColor = Color(0xFFD6DCE5),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    FilterChipCustom("Todos", true)
                    FilterChipCustom("Aulas", false)
                    FilterChipCustom("Labs", false)
                    FilterChipCustom("Cafetería", false)
                }

                Spacer(modifier = Modifier.height(20.dp))

                CampusMapCard()

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Edificios cercanos",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )

                Spacer(modifier = Modifier.height(14.dp))

                BuildingItem(
                    title = "Edificio A",
                    subtitle = "Aulas generales · 120 m",
                    iconColor = Color(0xFF2563EB)
                )

                Spacer(modifier = Modifier.height(12.dp))

                BuildingItem(
                    title = "Laboratorio 3",
                    subtitle = "Prácticas de computación · 180 m",
                    iconColor = Color(0xFF10B981)
                )

                Spacer(modifier = Modifier.height(12.dp))

                BuildingItem(
                    title = "Cafetería Central",
                    subtitle = "Zona de alimentos · 220 m",
                    iconColor = Color(0xFFFF7A00)
                )

                Spacer(modifier = Modifier.height(90.dp))
            }
        }
    }
}

@Composable
fun MapHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = TecBlue,
                shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
            )
            .padding(20.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "CAMPUS LOCATOR",
                color = Color.White.copy(alpha = 0.70f),
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Mapa del campus",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Encuentra rápidamente edificios, aulas y laboratorios",
                color = Color.White.copy(alpha = 0.85f),
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun FilterChipCustom(text: String, selected: Boolean) {
    Card(
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) TecBlue else Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.wrapContentHeight()
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            color = if (selected) Color.White else Color(0xFF475569),
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun CampusMapCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8FAFC))
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .padding(20.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE2E8F0),
                        shape = RoundedCornerShape(20.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .size(width = 110.dp, height = 64.dp)
                    .offset(x = 28.dp, y = 42.dp)
                    .background(Color(0xFFDCEBFF), RoundedCornerShape(18.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Edificio A",
                    color = TecBlue,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .size(width = 130.dp, height = 72.dp)
                    .offset(x = 180.dp, y = 82.dp)
                    .background(Color(0xFFE7FAF1), RoundedCornerShape(18.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Lab 3",
                    color = Color(0xFF0F9F6E),
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .size(width = 116.dp, height = 62.dp)
                    .offset(x = 90.dp, y = 210.dp)
                    .background(Color(0xFFFFF1E8), RoundedCornerShape(18.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Cafetería",
                    color = Color(0xFFFF7A00),
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .size(22.dp)
                    .offset(x = 250.dp, y = 200.dp)
                    .background(TecGold, CircleShape)
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Layers,
                        contentDescription = null,
                        tint = TecBlue,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Plano del campus",
                        color = Color(0xFF334155),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun BuildingItem(
    title: String,
    subtitle: String,
    iconColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
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
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(iconColor.copy(alpha = 0.12f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                val icon = when {
                    title.contains("Lab") -> Icons.Outlined.Science
                    title.contains("Cafetería") -> Icons.Outlined.Coffee
                    else -> Icons.Outlined.Apartment
                }

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF64748B)
                )
            }

            Icon(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = "Ubicar",
                tint = TecBlue
            )
        }
    }
}