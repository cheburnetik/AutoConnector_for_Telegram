package io.autoconnector.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.autoconnector.engine.EngineState
import io.autoconnector.i18n.LocalStrings
import io.autoconnector.ui.theme.AppColors

/**
 * Full-screen, scrollable "how to connect Telegram" guide with copy buttons
 * and tappable proxy links. Replaces the old cramped AlertDialog.
 */
@Composable
fun ConnectGuidePage(
    s: EngineState,
    onCopy: (String) -> Unit,
    onOpen: (String) -> Unit,
    onBack: () -> Unit,
) {
    val t = LocalStrings.current
    val portA = s.portA
    val portB = s.portB
    val linkA = "tg://socks?server=127.0.0.1&port=$portA"
    val linkB = "tg://socks?server=127.0.0.1&port=$portB"
    fun sub(text: String) = text.replace("{A}", "$portA").replace("{B}", "$portB")

    Surface(Modifier.fillMaxSize(), color = AppColors.background) {
        Column(Modifier.fillMaxSize()) {
            GuideTopBar(onBack)

            Column(
                Modifier.fillMaxWidth().weight(1f).verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Text(
                    t.readCarefully,
                    color = AppColors.red,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 22.sp,
                )

                // Intro warning.
                Box(
                    Modifier.fillMaxWidth()
                        .background(AppColors.red.copy(alpha = 0.08f), RoundedCornerShape(12.dp))
                        .border(1.dp, AppColors.red.copy(alpha = 0.35f), RoundedCornerShape(12.dp))
                        .padding(14.dp),
                ) {
                    Text(t.guideIntro, color = AppColors.onSurface, fontSize = 14.sp, lineHeight = 20.sp)
                }

                VariantCard("1", t.variant1) {
                    Body(sub(t.variant1Body))
                    Spacer(Modifier.height(10.dp))
                    ProxyButton(t.proxyBtn(portA)) { onOpen(linkA) }
                    Spacer(Modifier.height(8.dp))
                    ProxyButton(t.proxyBtn(portB)) { onOpen(linkB) }
                }

                VariantCard("2", t.variant2) {
                    Body(sub(t.variant2Body))
                    Spacer(Modifier.height(10.dp))
                    CopyBox("$linkA\n$linkB", onCopy)
                }

                VariantCard("3", t.variant3) {
                    Body(sub(t.variant3Body))
                    Spacer(Modifier.height(10.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CopyChip(t.host, "127.0.0.1", onCopy)
                        CopyChip(t.port, "$portA", onCopy)
                        CopyChip(t.port, "$portB", onCopy)
                    }
                }

                VariantCard("✓", t.whatNext, AppColors.green) {
                    Body(sub(t.whatNextBody))
                }

                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

// === pieces =============================================================

@Composable
private fun GuideTopBar(onBack: () -> Unit) {
    Surface(
        Modifier.fillMaxWidth(),
        color = AppColors.accent,
    ) {
        Box(Modifier.background(Brush.horizontalGradient(listOf(AppColors.accent, AppColors.accentDark)))) {
            Row(
                Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = onBack) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = LocalStrings.current.back, tint = Color.White)
                }
                Text(LocalStrings.current.connectTelegram, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }
    }
}

@Composable
private fun VariantCard(
    badge: String,
    title: String,
    accent: Color = AppColors.accent,
    content: @Composable () -> Unit,
) {
    Box(
        Modifier.fillMaxWidth()
            .background(AppColors.card, RoundedCornerShape(14.dp))
            .border(1.dp, AppColors.cardBorder, RoundedCornerShape(14.dp))
            .padding(14.dp),
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier.size(28.dp).background(accent, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(badge, color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
                }
                Spacer(Modifier.size(10.dp))
                Text(title, color = AppColors.onSurface, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(Modifier.height(8.dp))
            content()
        }
    }
}

@Composable
private fun Body(text: String) {
    Text(text, color = AppColors.onSurface, fontSize = 14.sp, lineHeight = 20.sp)
}

@Composable
private fun ProxyButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = AppColors.accent, contentColor = Color.White),
    ) {
        Icon(Icons.Filled.Bolt, contentDescription = null, modifier = Modifier.size(20.dp))
        Spacer(Modifier.size(8.dp))
        Text(label, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

/** A bordered, selectable text block with a copy button — for the link payload. */
@Composable
private fun CopyBox(text: String, onCopy: (String) -> Unit) {
    Column(
        Modifier.fillMaxWidth()
            .background(AppColors.background, RoundedCornerShape(10.dp))
            .border(1.dp, AppColors.cardBorder, RoundedCornerShape(10.dp))
            .padding(12.dp),
    ) {
        SelectionContainer {
            Text(text, color = AppColors.onSurface, fontFamily = FontFamily.Monospace, fontSize = 14.sp, lineHeight = 19.sp)
        }
        Spacer(Modifier.height(10.dp))
        Row(
            Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp))
                .background(AppColors.accent).clickable { onCopy(text) }.padding(vertical = 9.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(Icons.Filled.ContentCopy, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
            Spacer(Modifier.size(6.dp))
            Text(LocalStrings.current.copy, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
    }
}

/** Small "label: value ⧉" chip that copies [value] on tap. */
@Composable
private fun CopyChip(label: String, value: String, onCopy: (String) -> Unit) {
    Row(
        Modifier.clip(RoundedCornerShape(8.dp))
            .background(AppColors.background)
            .border(1.dp, AppColors.cardBorder, RoundedCornerShape(8.dp))
            .clickable { onCopy(value) }
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(label, color = AppColors.onSurfaceMuted, fontSize = 14.sp)
            Text(value, color = AppColors.onSurface, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
        Spacer(Modifier.size(6.dp))
        Icon(Icons.Filled.ContentCopy, contentDescription = null, tint = AppColors.accent, modifier = Modifier.size(15.dp))
    }
}
