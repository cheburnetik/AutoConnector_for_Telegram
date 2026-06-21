package io.autoconnector.i18n

object Th : Strings {
    override val tabConnector = "ตัวเชื่อมต่อ"; override val tabScan = "สแกน"
    override val tabCatalog = "แคตตาล็อก"; override val tabLogs = "บันทึก"; override val tabMore = "เพิ่มเติม"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "การสมัครรับข้อมูล"; override val logTabScan = "สแกน"
    override val logGeneral = "ทั่วไป"; override val logEmpty = "ยังว่างเปล่า"
    override val logSessions = "เซสชัน"; override val logErrorsOnly = "เฉพาะข้อผิดพลาด"; override val logNoErrors = "ไม่มีเซสชันที่ล้มเหลว"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "กลับ"; override val copy = "คัดลอก"; override val gotIt = "เข้าใจแล้ว"
    override val later = "ภายหลัง"; override val details = "รายละเอียด"; override val whatIsThis = "นี่คืออะไร?"
    override val delete = "ลบ"

    override val connector = "ตัวเชื่อมต่อ"; override val scan = "สแกน"
    override val notConfigured = "ยังไม่ได้ตั้งค่า! แก้ไข →"; override val howToSetup = "วิธีตั้งค่า"
    override val notifOff = "การแจ้งเตือนปิดอยู่! แก้ไข →"; override val enable = "เปิดใช้งาน"
    override fun fewProxies(n: Int) = "พร็อกซีที่ใช้งานได้ ${n} รายการ กำลังค้นหา รอประมาณ 15 นาที…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "พร็อกซีที่ใช้งานได้: ${alive}  (15 นาที: ${within}) · รวม: ${total}"
    override val notifWhyTitle = "ทำไมต้องมีการแจ้งเตือน?"
    override val notifWhyBody = "ไอคอนการแจ้งเตือนแบบถาวรหมายถึงบริการเบื้องหน้าของ Android " +
        "หากไม่มี ระบบจะยกแอปออกจากหน่วยความจำ ทำให้หยุดค้นหาพร็อกซีและ " +
        "หยุดคงการเชื่อมต่อในเบื้องหลัง นี่คือเหตุผลที่ต้องเปิดการแจ้งเตือนเพื่อให้ " +
        "AutoConnector ทำงานได้"
    override val notifEnableTitle = "เปิดใช้งานการแจ้งเตือน"
    override val notifEnableBody = "หากไม่มีไอคอนการแจ้งเตือน Android จะถือว่าแอปไม่ทำงานและ " +
        "ยกออกจากหน่วยความจำ จากนั้น AutoConnector จะหยุดค้นหาพร็อกซีและหยุดคง " +
        "การเชื่อมต่อในเบื้องหลัง — Telegram จะขาดการเชื่อมโยง\n\nแตะ \"เปิดใช้งาน\" และอนุญาต " +
        "การแจ้งเตือนสำหรับ AutoConnector"
    override val notifPlea = "เปิดการแจ้งเตือนด้วย! หากไม่มี แอปจะไม่สามารถทำงานในเบื้องหลังได้ — " +
        "Android จะยกออกและการค้นหาพร็อกซีกับการเชื่อมต่อจะหยุดลง"

    override val statusConnected = "Telegram เชื่อมต่อแล้ว"; override val statusConnecting = "กำลังเชื่อมต่อ…"
    override val statusOffline = "Telegram ไม่ได้เชื่อมต่อ"; override val statusIdle = "Telegram ว่าง"
    override val nobodyConnected = "ไม่มีใครเชื่อมต่อกับตัวเชื่อมต่อ "; override val howToSetupArrow = "วิธีตั้งค่า →"
    override val directModeViaVpn = "โหมดตรง: VPN ทำงานอยู่ — ไม่มีพร็อกซี"
    override val directModeOff = "โหมดตรง: พร็อกซีปิดอยู่"
    override val directDpiSuffix = " · ต่อต้าน DPI"
    override val connections = "การเชื่อมต่อ"; override val sockets = "ซ็อกเก็ต"; override val speed = "ความเร็ว"
    override val traffic = "ทราฟฟิก"; override val latency = "ความหน่วง"
    override fun pcs(n: Int) = "${n} รายการ"
    override fun netNow(label: String) = "เครือข่าย: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "พร็อกซี ${n}"
    override val trafficSec = "ทราฟฟิก · 60 วินาที"; override val trafficMin = "ทราฟฟิก · 60 นาที"
    override val latencySec = "ความหน่วง · 60 วินาที"; override val latencyMin = "ความหน่วง · 60 นาที"
    override val sec60 = "60 วินาที"; override val min60 = "60 นาที"
    override val unitSec = "วิ"; override val unitMin = "น"; override val unitHour = "ชม"; override val dash = "—"
    override val currentProxy = "พร็อกซีปัจจุบัน"; override val noActiveProxy = "ไม่มีพร็อกซีที่ทำงานอยู่ (Telegram ไม่ได้เชื่อมต่อ)"
    override val host = "โฮสต์"; override val type = "ประเภท"; override val secret = "ความลับ"; override val antiDpi = "ต่อต้าน DPI"; override val obfEngine = "เครื่องมือพรางการเชื่อมต่อ"
    override fun activeSockets(n: Int) = "ซ็อกเก็ต Telegram ที่ทำงานอยู่: ${n}"
    override val noConnections = "ไม่มีการเชื่อมต่อที่ทำงานอยู่"; override val colHost = "โฮสต์"; override val colTime = "เวลา"
    override val modeWord = "โหมด"; override val directViaVpnLine = "ส่งคำขอตรงไปยัง Telegram (VPN ทำงานอยู่)"
    override val connModeHelp = "โหมด (VPN, Wi-Fi, LTE, Ethernet, White) ช่วยให้คุณปรับความเข้มในการสแกนได้ต่างกันและเก็บเรตติ้ง/สถิติของโฮสต์แยกกัน ประเภทเครือข่ายจะถูกตรวจจับอัตโนมัติ ส่วนโหมดสามารถตั้งค่าด้วยตนเองในการตั้งค่าได้"

    override val scanOff = "การสแกนปิดอยู่"; override val proxiesInBase = "พร็อกซีในฐานข้อมูล"
    override val total = "รวม"; override val alive = "ใช้งานได้"; override val dead = "ใช้งานไม่ได้"
    override val tgConnectedTitle = "Telegram เชื่อมต่อผ่าน"; override val successful = "สำเร็จ"
    override val socketsHeld = "อายุของซ็อกเก็ต"; override val over1m = ">1 นาที"; override val over5m = ">5 นาที"; override val over15m = ">15 นาที"
    override val scanCountTitle = "จำนวนการตรวจสอบพร็อกซี"; override val checked = "ตรวจสอบแล้ว"
    override val forAllTime = "ตลอดเวลา"; override val perMinute = "ต่อนาที"; override val perHour = "ต่อชั่วโมง"
    override val subsCountTitle = "จำนวนการดาวน์โหลดการสมัครรับข้อมูล"; override val downloaded = "ดาวน์โหลดแล้ว"; override val failed = "ล้มเหลว"; override val scanTraffic = "ทราฟฟิกการสแกน"; override val subTraffic = "ทราฟฟิกการสมัครรับข้อมูล"; override val subTrafficGraph = "ทราฟฟิกการสมัครรับข้อมูล"
    override val checksMtproto = "การตรวจสอบ MTProto (↑ สำเร็จ · ↓ ล้มเหลว)"

    override fun catalogEmpty(mode: String) = "แคตตาล็อก ${mode} ยังว่างเปล่า อาจเป็นเพราะยังไม่พบโฮสต์ หรือแอปยังไม่เคยทำงานในโหมดนี้ คุณสามารถเปลี่ยนโหมดได้ในการตั้งค่า โหมดมีไว้เพื่อรวบรวมโฮสต์แยกกันสำหรับการเชื่อมต่ออินเทอร์เน็ตแต่ละประเภท"
    override val aliveShort = "✓ ใช้งานได้"; override val deadShort = "✗ ใช้งานไม่ได้"
    override val statusLabel = "สถานะ"; override val rating = "เรตติ้ง"; override val port = "พอร์ต"
    override val rttPing = "RTT (ปิง)"; override val checkedField = "ตรวจสอบแล้ว"; override val okOfTotal = "การตรวจสอบสำเร็จ / ทั้งหมด"
    override val tgConnectedField = "Telegram เชื่อมต่อแล้ว"; override val tgSessions = "เซสชัน Telegram"; override val trafficThroughProxy = "ทราฟฟิกผ่านพร็อกซี"
    override val sessionsTotal = "เซสชันทั้งหมด"; override val relayNow = "รีเลย์ตอนนี้"; override val tlsDomain = "โดเมน TLS (SNI)"
    override val sourceSub = "แหล่งที่มา (การสมัครรับข้อมูล)"; override val lastError = "ข้อผิดพลาดล่าสุด"; override val yes = "ใช่"; override val no = "ไม่"
    override val copyAsLink = "คัดลอกเป็นลิงก์"; override val openInTelegram = "เปิดโฮสต์ใน Telegram"; override val makeNextRelay = "ตั้งเป็นรีเลย์ถัดไป"
    override val actCopy = "คัดลอก"; override val actOpen = "เปิด"; override val actRelay = "รีเลย์"
    override fun agoFmt(v: String) = "${v} ที่แล้ว"
    override val catalogTopFor = "รายการ/เรตติ้งพร็อกซีสำหรับ"
    override val catalogModeHelpTitle = "โหมดและเรตติ้ง"
    override val catalogModeHelp = "แอปนับโฮสต์ที่ใช้งานได้และเรตติ้งของแต่ละโหมดเครือข่ายแยกกัน (VPN, Wi-Fi, LTE, Ethernet และ White) \"White\" เป็นโหมดด้วยตนเองแยกต่างหากสำหรับไวต์ลิสต์ ระบบอัตโนมัติจะไม่สลับไปใช้มันเลย ดังนั้นโฮสต์เดียวกันอาจใช้งานได้ในโหมดหนึ่งและใช้งานไม่ได้ในอีกโหมดหนึ่ง"
    override fun catalogInactiveWarn(section: String, active: String) =
        "คุณกำลังดูส่วนที่ไม่ได้ใช้งาน ${section} — สถิติทั้งหมดในตอนนี้จะไปที่ ${active} ไม่ใช่ที่นี่"
    override val manageModeTitle = "จัดการโหมด"
    override val manageResetRating = "รีเซ็ตเรตติ้ง"
    override fun manageResetHint(mode: String) = "สำหรับ ${mode} โดยเฉพาะ คุณสามารถรีเซ็ตเรตติ้งและสถิติการใช้งานของโฮสต์ที่ใช้งานได้ ซึ่งสะดวกเมื่อคุณเชื่อมต่อกับ VPN หรือ LTE ที่ต่างออกไปอย่างสิ้นเชิง เพื่อไม่ให้สถิติเก่ามารบกวน หรือเพื่อดูว่าการสแกนพร็อกซีจะตรวจสอบทุกอย่างใหม่ตั้งแต่ต้นได้เร็วแค่ไหน"
    override val manageDeleteAll = "ลบโฮสต์ใน"
    override fun manageDeleteHint(mode: String) = "คุณสามารถล้างทั้งเรตติ้งและตัวโฮสต์เองจาก ${mode} ได้ ฟีเจอร์ \"สแกนพร็อกซี\" จะรวบรวมมันอีกครั้ง นี่ไม่ใช่การรีเซ็ตการสมัครรับข้อมูล — คุณแตะได้ แล้วรอประมาณ 15 นาทีเพื่อสแกนใหม่"
    override fun manageCopyFrom(mode: String) = "คัดลอกโฮสต์และเรตติ้งทั้งหมดเข้าโหมดนี้ (${mode}) จากอีกโหมดหนึ่ง:"
    override val live = "ใช้งานได้"; override val deadW = "ใช้งานไม่ได้"; override val unitMs = "มิลลิวินาที"
    override val agoMin = "น"; override val agoHour = "ชม"; override val agoDay = "ว"

    override val connectTelegram = "กำลังเชื่อมต่อ Telegram"; override val readCarefully = "อ่านอย่างละเอียด!"
    override val guideIntro = "แอปนี้จะไม่ทำงานหากไม่ตั้งค่า เลือกหนึ่งใน 3 ตัวเลือกด้านล่าง " +
        "แล้วทำตามคำแนะนำอย่างละเอียด"
    override val variant1 = "ตัวเลือกที่ 1 — ปุ่ม"
    override val variant1Body = "แตะ \"พร็อกซี {A}\" — Telegram จะเปิดขึ้น ยืนยันการเพิ่มพร็อกซี กลับ " +
        "มาที่หน้านี้แล้วแตะ \"พร็อกซี {B}\" — ยืนยันการเพิ่มอีกครั้ง\n\nปิดพร็อกซี " +
        "เก่าอื่นๆ ใน Telegram ต้องเหลือพร็อกซีเพียง 2 รายการเท่านั้น — ที่พอร์ต {A} และ {B} " +
        "หากตั้งค่าเป็นอย่างอื่น AutoConnector จะไม่ทำงาน"
    override val variant2 = "ตัวเลือกที่ 2 — ลิงก์"
    override val variant2Body = "คัดลอกข้อความด้านล่างไปยังข้อความที่บันทึกไว้ (หรือแชตใดก็ได้) ใน Telegram — " +
        "นั่นคือส่งให้ตัวเอง แตะลิงก์แรกในข้อความของคุณ — พร็อกซีแรกจะถูกเพิ่ม " +
        "แตะลิงก์ที่สอง — พร็อกซีที่สองจะถูกเพิ่ม จากนั้นปิดพร็อกซีเก่าทั้งหมด"
    override val variant3 = "ตัวเลือกที่ 3 — ด้วยตนเอง"
    override val variant3Body = "เพิ่มพร็อกซี SOCKS5 ด้วยตนเอง: เซิร์ฟเวอร์ localhost (127.0.0.1), พอร์ต {A} " +
        "จากนั้นพร็อกซีที่สอง: localhost, พอร์ต {B} ลบพร็อกซีเก่าทั้งหมด"
    override val whatNext = "ขั้นต่อไปคืออะไร?"
    override val whatNextBody = "ใน Telegram ให้เปิด \"สลับพร็อกซีอัตโนมัติ\" — 5 วินาที คุณสามารถช่วย " +
        "Telegram เชื่อมต่อได้โดยแตะพร็อกซี (ภายใน Telegram) ที่ยังไม่ได้ใช้งานหรือถูกทำเครื่องหมายว่า " +
        "\"ไม่พร้อมใช้งาน\" ด้วยตนเอง — จะทำให้ Telegram พยายามเชื่อมต่อมากขึ้น\n\nตรวจสอบให้แน่ใจว่าพร็อกซีเก่า " +
        "อื่นๆ ถูกลบหมดแล้ว ยกเว้น {A} และ {B} แตะ " +
        "\"ใช้พร็อกซี\" ใน Telegram\n\nรอในขณะที่แอปค้นหาและดาวน์โหลดพร็อกซีให้เพียงพอ " +
        "(5–15 นาที) จากนั้น Telegram จะเชื่อมต่อกับ AutoConnector เอง ซึ่งจะคอยส่งต่อ " +
        "Telegram ผ่านพร็อกซีที่ดีที่สุด: ที่ผ่านการตรวจสอบแล้ว ใช้งานได้ และเร็ว\n\nหากคำแนะนำดู " +
        "ยาก — ขออภัย คุณจะไม่สามารถใช้แอปได้: ไม่สามารถตั้งค่าทุกอย่าง " +
        "อัตโนมัติได้ และการค้นหาพร็อกซีที่ใช้งานได้ต้องใช้เวลา\n\nหากคุณดาวน์โหลดแอปมานานแล้ว " +
        "และไม่พบพร็อกซีที่ใช้งานได้ — อัปเดตแอปหรือรายการสมัครรับข้อมูล แอปนี้ " +
        "ไม่ได้สร้างหรือจัดหาพร็อกซีของตัวเอง มันเพียงค้นหาในอินเทอร์เน็ตจากหลายสิบ " +
        "กลุ่มและหน้าเว็บ"
    override fun proxyBtn(port: Int) = "พร็อกซี ${port}"

    override val setupPortsTitle = "ตั้งค่าพอร์ตใน Telegram"
    override val setupPortsSub = "วิธีเชื่อมต่อ Telegram กับตัวเชื่อมต่อ (พอร์ต 55001/55002)"
    override val settings = "การตั้งค่า"; override val settingsSub = "พอร์ต, ต่อต้าน DPI, สแกน, เครือข่าย, แบตเตอรี่"
    override val subscriptions = "การสมัครรับข้อมูล"; override val subscriptionsSub = "แหล่งพร็อกซีที่จะสแกน"
    override val statistics = "สถิติ"; override val statisticsSub = "ฐานข้อมูลพร็อกซี + กลเม็ดต่อต้าน DPI"
    override val export = "ส่งออก"; override val exportSub = "ลิงก์ tg:// ของพร็อกซีที่ใช้งานได้"
    override val about = "เกี่ยวกับ"; override val aboutSub = "เวอร์ชัน, บิลด์, ดาวน์โหลด, ข้อเสนอแนะ"
    override val hotkeys = "ปุ่มลัด"
    override val hotkeysSub = "ปุ่มทั่วระบบ: คัดลอก / เปิดพร็อกซี"
    override val hotkeysIntro = "ปุ่มลัดทั่วระบบทำงานแม้ว่าหน้าต่างแอปจะไม่ได้โฟกัส มันจะเลือกลิงก์พร็อกซี " +
        "(tg://) ที่ใช้งานได้แบบสุ่มจากพูล — สะดวกสำหรับการสลับพร็อกซีอย่างรวดเร็วโดยไม่ต้อง " +
        "เปิดแอป"
    override val hotkeysNote = "บน macOS การจับปุ่มอาจต้องใช้สิทธิ์การช่วยการเข้าถึง (Accessibility) " +
        "(การตั้งค่าระบบ → ความเป็นส่วนตัวและความปลอดภัย → การช่วยการเข้าถึง)"
    override val hotkeyCopyTitle = "คัดลอกลิงก์พร็อกซี"
    override val hotkeyCopyDesc = "นำลิงก์ tg:// ที่ใช้งานได้แบบสุ่มไปไว้ที่คลิปบอร์ด"
    override val hotkeyEnable = "เปิดใช้งานปุ่มลัด"; override val hotkeyLetterLabel = "ตัวอักษร"; override val hotkeySet = "ตั้งค่า"; override val hotkeyReset = "รีเซ็ต"
    override val hotkeyOpenTitle = "เปิดพร็อกซีใน Telegram"
    override val hotkeyOpenDesc = "เปิดลิงก์ที่ใช้งานได้แบบสุ่ม — Telegram จะรับมันและเสนอให้เชื่อมต่อพร็อกซี"

    override val relayPorts = "พอร์ตรีเลย์"
    override val relayPortsHelp = "พอร์ตในเครื่องที่ตัวเชื่อมต่อรับฟังอยู่ คุณป้อนพอร์ตเหล่านี้ใน " +
        "Telegram เป็นพร็อกซี SOCKS5 (127.0.0.1 : พอร์ต) ใช้สองพอร์ตเพื่อความน่าเชื่อถือ — Telegram " +
        "จะคงการเชื่อมต่อกับทั้งสอง"
    override val portA = "พอร์ต A"; override val portB = "พอร์ต B"
    override val antiDpiTrick = "กลเม็ดต่อต้าน DPI"
    override val antiDpiHelp = "วิธีพรางการเชื่อมต่อเพื่อให้ ISP/DPI ไม่รู้จักและ " +
        "บล็อกมัน\n• \"หมุนเวียนอัตโนมัติ\" จะเลือกกลเม็ดที่ใช้งานได้เอง\n• \"ไม่มีกลเม็ด DPI\" — การเชื่อมต่อ " +
        "ธรรมดา\n• ที่เหลือเป็นเทคนิคเฉพาะ (เลียนแบบเบราว์เซอร์, แยกแพ็กเก็ต ฯลฯ)"
    override val onlyFakeTls = "FakeTLS เท่านั้น (ee)"
    override val applyDpiTo = "ใช้ต่อต้าน DPI กับ"
    override val applyDpiHelp = "จะใช้กลเม็ดต่อต้าน DPI ที่เลือกกับอะไร:\n• รีเลย์ Telegram — กับ " +
        "การเชื่อมต่อ Telegram ที่ทำงานอยู่ผ่านตัวเชื่อมต่อ\n• การตรวจสอบพร็อกซี — กับการตรวจสอบพร็อกซีในเบื้องหลัง " +
        "(การตรวจสอบจะทำงานเหมือนการเชื่อมต่อจริง และสถิติกลเม็ดจะแม่นยำขึ้น)\n" +
        "• เมื่อเชื่อมต่อตรง — เมื่อพร็อกซีปิดอยู่ (หรือถูกข้ามขณะ VPN ทำงาน) และ Telegram " +
        "ไปยังเซิร์ฟเวอร์ของมันโดยตรง: ที่นี่ไม่มีพร็อกซี ดังนั้นกลเม็ดจะลดเหลือเพียงการแยก " +
        "แพ็กเก็ต TCP แรก (การแฮนด์เชก) ออกเป็นหลายเซกเมนต์เล็กๆ เพื่อให้ DPI ไม่สามารถจับคู่ได้ในการอ่านครั้งเดียว"
    override val toRelay = "รีเลย์ Telegram"; override val toProbes = "การตรวจสอบพร็อกซี"
    override val toDirect = "เมื่อเชื่อมต่อตรง"
    override val vpnSection = "เมื่อ VPN เปิดอยู่"
    override val vpnHelp = "จะทำอย่างไรเมื่อ VPN ทำงานอยู่บนอุปกรณ์:\n• ผ่านพร็อกซี MTProto — " +
        "Telegram จะไปผ่านพร็อกซีที่พบตามปกติ (อยู่บน VPN)\n• โดยตรง — ตัวเชื่อมต่อจะ " +
        "ไม่ใช้พร็อกซีและเชื่อมต่อ Telegram ตรงไปยังเซิร์ฟเวอร์ของ Telegram: " +
        "VPN ให้การเข้าถึงอยู่แล้ว ชั้นพร็อกซีเพิ่มเติมจึงไม่จำเป็น (เร็วกว่าและเสถียรกว่า) " +
        "หากไม่มี VPN จะใช้พร็อกซีตามปกติ"
    override val linkFormat = "รูปแบบลิงก์พร็อกซี"
    override val linkFormatHelp = "วิธีคัดลอกและเปิดพร็อกซี tg:// เปิด Telegram โดยตรง (ต้องติดตั้ง Telegram Desktop) http (t.me) เปิดผ่านเบราว์เซอร์และเสนอให้เปิดใน Telegram — สะดวกหาก tg:// ไม่ได้ลงทะเบียน"
    override val linkTg = "tg:// (เปิด Telegram โดยตรง)"; override val linkTgSub = "tg://proxy?… — เปิด Telegram"
    override val linkHttp = "http (t.me, ผ่านเบราว์เซอร์)"; override val linkHttpSub = "https://t.me/proxy?… — เปิดเบราว์เซอร์"
    override val viaMtproto = "พร็อกซีผ่าน MTProto"; override val viaMtprotoSub = "แม้มี VPN ทราฟฟิกก็ไปผ่านพร็อกซี"
    override val directly = "เชื่อมต่อโดยตรง"; override val directlySub = "เมื่อ VPN ทำงานอยู่ — ข้ามพร็อกซี ตรงไปยัง Telegram"
    override val notifications = "การแจ้งเตือน"
    override val scanCheck = "สแกนและตรวจสอบ"
    override val scanCheckHelp = "• สแกน, นาที — ดาวน์โหลดรายการพร็อกซีจากการสมัครรับข้อมูลบ่อยแค่ไหน\n" +
        "• ตรวจสอบ, นาที — ตรวจสอบความใช้งานได้ของพร็อกซีในฐานข้อมูลใหม่บ่อยแค่ไหน\n• ขนาดชุด — " +
        "ตรวจสอบพร็อกซีกี่รายการต่อรอบ\n• ขนาน — รันการตรวจสอบกี่รายการพร้อมกัน (มากขึ้น = " +
        "เร็วขึ้น แต่โหลดเครือข่ายและแบตเตอรี่สูงขึ้น)"
    override val scanMin = "สแกน, นาที"; override val checkMin = "ตรวจสอบ, นาที"; override val batchSize = "ขนาดชุด"; override val parallel = "ขนาน"
    override val speedByNet = "ความเข้มการสแกนตามเครือข่าย"
    override val speedByNetHelp = "ตรวจสอบพร็อกซีบ่อยแค่ไหนขึ้นอยู่กับเครือข่ายปัจจุบัน " +
        "\"มาตรฐาน\" = ช่วงเวลาพื้นฐาน เลื่อนขวาเพื่อให้น้อยลง (ช้าลง ประหยัดทราฟฟิก/แบตเตอรี่) " +
        "เลื่อนซ้ายเพื่อให้บ่อยขึ้น (เร็วขึ้น ดุดันขึ้น) มาตราส่วนลอการิทึม สูงสุด ×100 ทั้งสองทาง\n" +
        "• VPN — เมื่อ VPN ภายนอกทำงานอยู่\n• Wi-Fi — บนเครือข่าย Wi-Fi\n• LTE — บนเครือข่ายมือถือ"
    override val intensStandard = "มาตรฐาน"
    override val intensSlower = "ช้าลง"
    override val intensFaster = "เร็วขึ้น"
    override val maintenance = "รีเซ็ตข้อมูล"
    override val maintenanceHelp = "• \"รีเซ็ตแคตตาล็อกและสถิติ\" — ทำให้เรตติ้ง ตัวนับ ทราฟฟิก " +
        "และบันทึกการตรวจสอบเป็นศูนย์ แต่คงโฮสต์ที่ดาวน์โหลดและการสมัครรับข้อมูลไว้ (ทุกอย่างจะถูกจัดเรตใหม่ใน " +
        "การสแกนครั้งถัดไป)\n• \"ล้างโฮสต์ที่ดาวน์โหลด\" — ลบพูลพร็อกซีทั้งหมดแต่คง " +
        "การสมัครรับข้อมูลไว้เพื่อให้การสแกนเติมพูลใหม่ การสมัครรับข้อมูลจะไม่ถูกแตะต้องในทุกกรณี"
    override val backupTitle = "ส่งออก / นำเข้า"
    override val backupHelp = "บันทึกหรือกู้คืนข้อมูลแอปเป็น JSON ทำเครื่องหมายสิ่งที่จะ " +
        "รวมไว้ — รวมกันแบบใดก็ได้:\n• การตั้งค่า — พารามิเตอร์ทั้งหมดของแอป\n• การสมัครรับข้อมูล — รายการแหล่ง " +
        "ที่มา (URL + เปิด/ปิด)\n• แคตตาล็อกโฮสต์ที่ใช้งานได้ — พร็อกซีที่ใช้งานได้ทุกตัวพร้อมเรตติ้งและสถิติ " +
        "ของแต่ละโหมดเครือข่าย\n\n\"ส่งออก\" จะเปิดหน้าที่มี JSON พร้อมใช้งาน — คัดลอกหรือบันทึกลงไฟล์ " +
        "\"นำเข้า\" — วาง JSON (หรือโหลดไฟล์) แล้วจะใช้เฉพาะส่วนที่ทำเครื่องหมายไว้และมีอยู่ใน " +
        "นั้น การนำเข้าจะเพิ่มเข้ากับข้อมูลปัจจุบัน (ไม่ลบทิ้ง)"
    override val backupSettings = "การตั้งค่า"
    override val backupSubs = "การสมัครรับข้อมูล"
    override val backupHosts = "แคตตาล็อกโฮสต์ที่ใช้งานได้ (ต่อโหมด)"
    override val exportWord = "ส่งออก"
    override val importWord = "นำเข้า"
    override val backupExportTitle = "ส่งออกข้อมูล"
    override val backupImportTitle = "นำเข้าข้อมูล"
    override val backupSelectExport = "จะส่งออกอะไร:"
    override val backupSelectImport = "จะนำเข้าอะไร:"
    override val backupCopyBtn = "คัดลอก"
    override val backupSaveFile = "บันทึกลงไฟล์"
    override val backupLoadFile = "โหลดจากไฟล์"
    override val backupDoImport = "นำเข้า"
    override val backupPasteLabel = "วาง JSON สำรองข้อมูลที่นี่"
    override val backupJsonLabel = "JSON สำรองข้อมูล"
    override val backupAndroidFileNote = "ไม่มีไฟล์ที่นี่ — ใช้คัดลอก / วาง"
    override val eraseAllHosts = "ลบโฮสต์ทั้งหมด"
    override val factoryReset = "รีเซ็ตทุกอย่าง (เหมือนเปิดครั้งแรก)"
    override val factoryResetConfirm = "รีเซ็ตแอปกลับสู่สถานะโรงงานทั้งหมด? การตั้งค่าทั้งหมดและ " +
        "แคตตาล็อกโฮสต์ทั้งหมดจะถูกลบ การสมัครรับข้อมูลจะถูกกู้คืนเป็นค่าเริ่มต้น เหมือนการเปิดครั้งแรก"
    override val resetCatalog = "รีเซ็ตแคตตาล็อกและสถิติ"
    override val resetCatalogConfirm = "ทำให้เรตติ้ง ตัวนับ และบันทึกการตรวจสอบทั้งหมดเป็นศูนย์? " +
        "โฮสต์ที่ดาวน์โหลดและการสมัครรับข้อมูลจะถูกคงไว้และจัดเรตใหม่ในการสแกนครั้งถัดไป"
    override val clearHosts = "ล้างโฮสต์ที่ดาวน์โหลด"
    override val clearHostsConfirm = "ลบรายการโฮสต์ (พร็อกซี) ที่ดาวน์โหลดทั้งหมด? " +
        "การสมัครรับข้อมูลจะถูกคงไว้และการสแกนจะเติมพูลใหม่"
    override val doReset = "รีเซ็ต"
    override val doCancel = "ยกเลิก"
    override val adaptiveSpeed = "ความเร็วปรับอัตโนมัติ"
    override val adaptiveHelp = "การตรวจสอบความใช้งานได้จะรันที่ช่วงเวลาพื้นฐาน (จาก \"สแกนและตรวจสอบ\" และ " +
        "คูณด้วยตัวคูณเครือข่ายด้วย) \"ความเร็วปรับอัตโนมัติ\" จะเร่งหรือลดความเร็วลง " +
        "โดยอัตโนมัติตามจำนวนพร็อกซีที่ใช้งานได้ในปัจจุบัน\n\n" +
        "• ใช้งานได้น้อย (ต่ำกว่าเกณฑ์ \"น้อย\") → ช่วงเวลา × \"เร่ง\" ตัวคูณต่ำกว่า 1 = บ่อยขึ้น: " +
        "0.5 — บ่อยขึ้นสองเท่า, 0.25 — 4 เท่า เติมพูลได้เร็วขึ้น\n" +
        "• ใช้งานได้มาก (สูงกว่าเกณฑ์ \"มาก\") → ช่วงเวลา × \"ชะลอ\" สูงกว่า 1 = น้อยลง: 2 — " +
        "ครึ่งหนึ่งของความถี่, 4 — หนึ่งในสี่ ประหยัดแบตเตอรี่และทราฟฟิก\n" +
        "• ระหว่างเกณฑ์ — ความเร็วพื้นฐาน (×1)\n\n" +
        "ตัวอย่าง:\n" +
        "— รวบรวมพร็อกซีเร็วขึ้น: \"เร่ง\" 0.25 และ/หรือเกณฑ์ \"น้อย\" 40\n" +
        "— ประหยัดแบตเตอรี่เมื่อมีเพียงพอ: \"ชะลอ\" 8 และ/หรือเกณฑ์ \"มาก\" 30\n" +
        "— ปิดการปรับอัตโนมัติ: ตั้งตัวคูณทั้งสองเป็น 1\n\n" +
        "ค่าเริ่มต้น: น้อย 20, เร่ง 0.5, มาก 50, ชะลอ 4"
    override val threshMany = "เกณฑ์ \"มาก\""; override val threshFew = "เกณฑ์ \"น้อย\""; override val mulFast = "เร่ง ×"; override val mulLazy = "ชะลอ ×"
    override val subIntensityTitle = "ความเข้มการสมัครรับข้อมูล"
    override val subIntensityHint = "การหยุดพักระหว่างการดาวน์โหลดการสมัครรับข้อมูล: กี่นาทีก่อนดาวน์โหลดรายการพร็อกซีใหม่ (แยกกันต่อโหมดเครือข่าย)"
    override val baseScanTitle = "ความเร็วการสแกนพื้นฐาน"
    override val baseScanHelp = "ความเร็วการตรวจสอบความใช้งานได้อ้างอิง \"ความเร็วปรับอัตโนมัติ\" และตัวคูณ \"ความเร็ว " +
        "ตามโหมด\" จะถูกคำนวณเทียบกับมัน\n\n" +
        "• รันบ่อยแค่ไหน, นาที — ช่วงเวลาระหว่างรอบการตรวจสอบ\n" +
        "• ชุดต่อเธรด, โฮสต์ — แต่ละเธรดตรวจสอบกี่โฮสต์ต่อรอบ\n" +
        "• เธรด — รันการตรวจสอบกี่รายการพร้อมกัน หนึ่งรอบจะตรวจสอบ \"ชุด × เธรด\" โฮสต์\n" +
        "• อย่าสแกนโฮสต์ซ้ำบ่อยกว่าทุก N นาที — ป้องกันการสแกนถี่: โฮสต์ที่เพิ่งตรวจสอบจะ " +
        "ถูกข้ามในรอบนี้\n\n" +
        "เธรดมากขึ้นและชุดใหญ่ขึ้น = พูลโตเร็วขึ้น แต่โหลดเครือข่ายและแบตเตอรี่หนักขึ้น"
    override val baseScanPeriod = "รันบ่อยแค่ไหน, นาที"
    override val baseScanBatch = "ชุดต่อเธรด, โฮสต์"; override val baseScanThreads = "จำนวนเธรด"
    override val adaptiveDesc = "หากพร็อกซีที่ใช้งานได้น้อยกว่า \"น้อย\" หรือมากกว่า \"มาก\" ให้ใช้ตัวคูณเพิ่มเติม"
    override val fewWord = "น้อย"; override val manyWord = "มาก"
    override fun fasterX(x: String) = "เร็วขึ้น ${x}×"
    override fun slowerX(x: String) = "ช้าลง ${x}×"
    override fun ifAliveLt(n: Int) = "หากพร็อกซีที่ใช้งานได้ < ${n} แล้ว:"
    override fun ifAliveGt(n: Int) = "หากพร็อกซีที่ใช้งานได้ > ${n} แล้ว:"
    override val disabledWord = "ปิด"
    override val speedByModeTitle = "ความเร็วตามโหมด"
    override val speedByModeHelp = "ตัวคูณความเร็วการสแกนสำหรับแต่ละโหมดเครือข่าย เพิ่มจากความเร็ว " +
        "พื้นฐาน \"มาตรฐาน\" (×1) = ช่วงเวลาพื้นฐาน ขวา — น้อยลง (ช้าลง ประหยัดทราฟฟิก/" +
        "แบตเตอรี่), ซ้าย — บ่อยขึ้น (เร็วขึ้น ดุดันขึ้น) มาตราส่วนลอการิทึม สูงสุด ×100 ทั้งสอง " +
        "ทาง\n\n" +
        "ใต้แถบเลื่อนแต่ละอันคือพารามิเตอร์รอบที่ได้พร้อมความเร็วปรับอัตโนมัติที่ใช้แล้ว — " +
        "แสดงแยกกันสำหรับ \"ใช้งานได้น้อย\" (× \"เร่ง\") และ \"ใช้งานได้มาก\" (× \"ชะลอ\")\n\n" +
        "โหมด:\n• VPN — VPN ภายนอกทำงานอยู่\n• LTE — เครือข่ายมือถือ\n• Wi-Fi — เครือข่าย Wi-Fi\n" +
        "• Ethernet — การเชื่อมต่อแบบมีสาย\n• White — โหมดพร็อกซี \"white\" ด้วยตนเอง"
    override val aliveLt = "ใช้งานได้ <"; override val aliveGt = "ใช้งานได้ >"
    override val periodWord = "ช่วงเวลา"; override val nonstopWord = "ไม่หยุด"
    override val batchWord = "ชุด"; override val threadsWord = "เธรด"; override val scanModeOff = "สแกนปิด"
    override val netBattery = "เครือข่ายและแบตเตอรี่"
    override val netBatteryHelp = "• Wi-Fi เท่านั้น — อย่าสแกนบนเครือข่ายมือถือ (ประหยัดดาต้า)\n• ชาร์จ " +
        "เท่านั้น — ทำงานเฉพาะขณะโทรศัพท์กำลังชาร์จ\n• ข้ามเมื่อแบตเตอรี่ต่ำ — หยุดสแกนชั่วคราวเมื่อ " +
        "แบตเตอรี่ต่ำ"
    override val onlyWifi = "Wi-Fi เท่านั้น"; override val onlyCharging = "ชาร์จเท่านั้น"; override val skipLowBattery = "ข้ามเมื่อแบตเตอรี่ต่ำ"
    override val autosaved = "การตั้งค่าจะถูกบันทึกโดยอัตโนมัติ"
    override val dpiAutoLabel = "หมุนเวียนกลเม็ด DPI อัตโนมัติ"; override val dpiNoneLabel = "ไม่มีกลเม็ด DPI (ธรรมดา)"
    override val experimental = "ทดลอง"
    override val experimentalHelp = "เครื่องมือพร็อกซีทางเลือกแทน MTProto upstream พร้อมบันทึกวินิจฉัย " +
        "เส้นทางอ้างอิง (ที่ทำงานได้) จะไม่เปลี่ยนเมื่อตั้งเป็น \"ปิด\" เปลี่ยนเฉพาะวิธีที่สตรีมเข้ารหัสถูกเขียนไปยัง " +
        "ซ็อกเก็ต TCP ของ upstream (ขนาดเซกเมนต์, เวลา, ขอบเขตเรกคอร์ด TLS) — ตัวสตรีมเองยังคงเหมือนเดิมทีละไบต์ " +
        "ใช้กับรีเลย์พร็อกซีที่ทำงานอยู่เท่านั้น (ไม่ใช่การตรวจสอบ ไม่ใช่เส้นทางตรง)"
    override val expEngineTitle = "เครื่องมือพร็อกซี (การพรางซ็อกเก็ต)"
    override val expConnectTitle = "เครื่องมือเชื่อมต่อ (การเลือก upstream)"
    override val expEngineWarn = "⚠ โหมดทดลอง หากการเชื่อมต่อแย่ลง ให้สลับกลับไปที่ \"ปิด (เส้นทางอ้างอิง)\""
    override val netLog = "เปิดบันทึกการแลกเปลี่ยนเครือข่าย"
    override val netLogSub = "เขียนใคร-ถึงใคร-เมื่อไหร่ และขนาดแพ็กเก็ตลงไฟล์ (ไม่มีข้อมูลเพย์โหลด) — " +
        "เพื่อเปรียบเทียบรูปแบบการแลกเปลี่ยนเมื่อมีกับเมื่อไม่มี VPN"
    override val openLogFolder = "เปิดโฟลเดอร์บันทึก"; override val copyPath = "คัดลอกพาท"
    override val helpShow = "ช่วยเหลือ"; override val helpHide = "ซ่อนความช่วยเหลือ"
    override val quickSwitchIntro = "ที่นี่คุณสามารถเลือกกลเม็ดข้ามการบล็อกได้ หาก Telegram แสดงข้อผิดพลาด " +
        "“พร็อกซีที่คุณใช้ตั้งค่าไม่ถูกต้องและจะถูกปิดใช้งาน โปรดหาตัวอื่น” " +
        "ให้ทดลองว่าประเภทการพรางทราฟฟิกใดใช้งานได้เพื่อให้ Telegram หยุดแสดงข้อความนั้น เริ่ม " +
        "ด้วยโหมด split* โหมด coalesce* ก็ใช้งานได้เช่นกัน แต่รูปภาพ/วิดีโอจะโหลดได้ไม่ดีใน Telegram เมื่อใช้มัน"
    override val quickSwitchTitle ="ข้ามการบล็อก"; override val quickSwitchSub = "การจัดรูปแบบ, เชื่อมต่อ, ต่อต้าน DPI"

    override val sourceUrl = "URL แหล่งที่มา"
    override fun sourceAlive(alive: Int, total: Int) = "ใช้งานได้ ${alive}/${total}"
    override val open = "เปิด"; override val active = "ใช้งานอยู่"; override val inactive = "ไม่ได้ใช้งาน"
    override val lastDownloaded = "ดาวน์โหลดแล้ว"; override val notDownloaded = "ยังไม่ได้ดาวน์โหลด"
    override fun sourceCounts(dead: Int, total: Int) =
        " ใช้งานได้, ${dead} ใช้งานไม่ได้, ${total} ทั้งหมด"

    override val proxyBase = "ฐานข้อมูลพร็อกซี"
    override val totalInBase = "รวมในฐานข้อมูล"; override val aliveNow = "ใช้งานได้ตอนนี้"; override val deadStat = "ใช้งานไม่ได้"
    override val aliveIn15 = "ใช้งานได้ใน 15 นาที"; override val checksAllTime = "การตรวจสอบตลอดเวลา"
    override val antiDpiTricks = "กลเม็ดต่อต้าน DPI"; override val noStatsYet = "ยังไม่มีข้อมูล — กลเม็ดจะสะสมเมื่อมีการตรวจสอบ/เชื่อมต่อ"
    override val attempts = "ความพยายาม"; override val handshake = "แฮนด์เชก"; override val score = "คะแนน"
    override val tgConnect = "TG เชื่อมต่อ"; override val socketsOver1m = "ซ็อกเก็ต >1นาที"
    override val over10kb = "ซ็อกเก็ต >10KB"; override val over100kb = ">100KB"; override val workTime = "เวลาทำงาน"
    override val statsLegend = "แฮนด์เชก — แฮนด์เชกที่สำเร็จ (% ของความพยายาม) · คะแนน — ค่า · " +
        "\"เวลาทำงาน\" — รวมของซ็อกเก็ต ≥5KB และนานกว่า 1 นาที"
    override val resetStats = "รีเซ็ตสถิติกลเม็ด"

    override fun aliveLinks(n: Int) = "ลิงก์ที่ใช้งานได้: ${n}"
    override val copyAll = "คัดลอกทั้งหมด"
    override val openRandom = "เปิดแบบสุ่ม"; override val copyRandom = "คัดลอกแบบสุ่ม"; override val allShort = "ทั้งหมด"
    override val copyTop = "คัดลอก TOP"; override val randomHost = "โฮสต์แบบสุ่ม"
    override val exportToFile = "ส่งออกไปยังไฟล์"; override val exportSaved = "บันทึกลงไฟล์แล้ว:"
    override val dlNow = "ดาวน์โหลดตอนนี้"
    override fun downloadingFmt(sec: Long) = "กำลังดาวน์โหลด… ${sec}วิ"
    override val cancel = "ยกเลิก"
    override val deleteConfirmTitle = "ลบการสมัครรับข้อมูล?"
    override val subscriptionsAddHint = "เพิ่มการสมัครรับข้อมูลหรือลิงก์พร็อกซี →"
    override val addSourcesTitle = "เพิ่ม"
    override val addSubsLabel = "การสมัครรับข้อมูล (หนึ่ง URL ต่อบรรทัด)"
    override val addSubsHelp = "แต่ละบรรทัดที่มี URL ที่ถูกต้องจะกลายเป็นการสมัครรับข้อมูลของตัวเองและถูกดึงเป็นระยะ"
    override val addProxiesLabel = "ลิงก์พร็อกซีพร้อมใช้ (รายการคงที่)"
    override val addProxiesHelp = "วางชุดลิงก์ไปยังพร็อกซีเฉพาะ (tg://proxy, https://t.me/proxy, …) นี่ไม่ใช่การสมัครรับข้อมูล — รายการจะไม่ถูกดาวน์โหลด พร็อกซีจะถูกเพิ่มเข้าแคตตาล็อกเท่านั้น"
    override val addButton = "เพิ่ม"
    override fun addedFmt(subs: Int, proxies: Int) = "เพิ่มแล้ว: การสมัครรับข้อมูล ${subs} รายการ, พร็อกซี ${proxies} รายการ"
    override val perSecond = "ต่อวินาที"
    override val graphSpeed = "ความเร็ว"
    override val graphVolume = "ปริมาณ"
    override val graphLatency = "ปิง"
    override val graphConnects = "การเชื่อมต่อ"
    override val scanNow = "สแกนตอนนี้"; override val scanOnShort = "เปิดสแกน"
    override val scanRunning = "กำลังสแกน"; override val scanIdle = "สแกนว่าง"; override val scanOffState = "สแกนปิด"; override val scanBatchPerThread = "ชุด/เธรด"; override val scanPassHosts = "โฮสต์ในรอบ"; override val minRescanLabel = "อย่าสแกนโฮสต์ซ้ำบ่อยกว่าทุก N นาที"
    override val scanPlanTitle = "แผน"; override val scanNowTitle = "ตอนนี้"; override val currentScheduleTitle = "ตารางปัจจุบัน"
    override val scheduleWord = "ตารางเวลา"; override val unitPcsPerSec = "รายการ/วิ"
    override val scanNowThreadsLabel = "เธรดที่ทำงานอยู่ตอนนี้"; override val scanNowPerThreadLabel = "การตรวจสอบต่อเธรด (แผน)"; override val scanNowElapsedLabel = "เวลาที่ทำงาน"
    override val scanOkGraph = "สแกนสำเร็จ"; override val scanFailGraph = "สแกนล้มเหลว"; override val scanTrafficGraph = "ทราฟฟิกการสแกน"; override val scanAliveGraph = "พร็อกซีที่ใช้งานได้ทั้งหมด"; override val scanPingGraph = "ปิง"; override val threadsGraph = "เธรด"
    override val scanEvery = "ทุก"; override val scanNextRun = "รอบถัดไป"
    override val scanThreads = "เธรด"; override val scanBatch = "ชุด"
    override val scanElapsed = "กำลังทำงาน"; override val scanIdleNow = "—"
    override val effForFew = "เมื่อน้อย"; override val effForMany = "เมื่อมาก"
    override val effCheck = "ตรวจสอบ"; override val effBatch = "ชุด"; override val effPar = "ขนาน"
    override val effContinuous = "ต่อเนื่อง"; override val secShort = "วิ"; override val minShort = "นาที"

    override val appTagline = "ตัวเชื่อมต่ออัตโนมัติข้ามแพลตฟอร์ม: ค้นหา ตรวจสอบ และรันพร็อกซี MTProto " +
        "ที่ Telegram ทำงานผ่าน"
    override val version = "เวอร์ชัน"; override val buildDate = "วันที่บิลด์"
    override val downloadSources = "ดาวน์โหลดและแหล่งที่มา"; override val openOnGithub = "เปิดบน GitHub"
    override val feedbackBugs = "ข้อเสนอแนะและรายงานข้อบกพร่อง"; override val writeTelegram = "เขียนถึงบน Telegram"

    override val language = "ภาษา"; override val langAuto = "อัตโนมัติ (ระบบ)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "ภาษา"
    override val raceWidthTitle = "การเชื่อมต่อแบบขนาน"
    override val connectionSection = "การเชื่อมต่อและข้ามการบล็อก"
    override val connectionSectionHelp = "เครื่องมือเชื่อมต่อ, upstream แบบขนาน, เครื่องมือพร็อกซี และกลเม็ดต่อต้าน DPI — ทั้งหมดในส่วนเดียว"
    override val netLogSection = "บันทึกการแลกเปลี่ยนเครือข่าย"
    override val platform = "แพลตฟอร์ม"

    override val scanModeTitle = "โหมดเครือข่าย"; override val scanModeAuto = "อัตโนมัติ"; override val scanModeManualLabel = "ด้วยตนเอง"
    override val activeModeLabel = "โหมดที่ใช้งาน"; override val formingListLabel = "กำลังสร้างรายการ"; override val catalogModeTabs = "โหมด"
    override val resetModeRatings = "รีเซ็ตเรตติ้งโฮสต์"; override val forgetModeHosts = "ลืมโฮสต์ของโหมด"
    override val exportModeTitle = "ส่งออกตามโหมด"; override val modePickerTitle = "โหมด"
    override val modeHelp = "แต่ละโหมดเครือข่ายมีเรตติ้งพร็อกซีของตัวเองและความเข้มในการสแกน + การดาวน์โหลดการสมัครรับข้อมูลของตัวเอง \"อัตโนมัติ\" จะเลือกโหมดจากเครือข่ายที่ใช้งาน \"ด้วยตนเอง\" ให้คุณเลือกโหมดใดก็ได้เอง (รวมถึง White ซึ่งระบบอัตโนมัติไม่เคยเลือก)"
    override val autoSelect = "เลือกอัตโนมัติ"; override val manualSelect = "เลือกด้วยตนเอง"
    override val connStatsTitle = "การเชื่อมต่อตอนนี้"; override val connOnPort = "การเชื่อมต่อบนพอร์ต"; override val outgoingConns = "การเชื่อมต่อขาออก"
    override val modeChoice = "การเลือกโหมด"; override val autoChoice = "เลือกอัตโนมัติ"; override val manualChoice = "กำหนดด้วยตนเอง"
    override val directOnVpn = "เชื่อมต่อตรงไป TG บน VPN"; override val onWord = "เปิด"; override val offWord = "ปิด"
    override val directStateActive = "ใช้งานอยู่"; override val directStateOff = "ปิดในการตั้งค่า"; override val directStateIdle = "เปิดในการตั้งค่า แต่ไม่ได้ใช้งาน"
    override val wpHintTitle = "White คืออะไร?"
    override val wpHint = "White — WhitePages: โปรไฟล์เครือข่ายแบบด้วยตนเอง เปิดด้วยมือเท่านั้น (การเลือกอัตโนมัติไม่เคยเลือกมัน) " +
        "เก็บเรตติ้งโฮสต์ของตัวเอง ดาวน์โหลดการสมัครรับข้อมูล และสแกนแยกอิสระจาก VPN/Wi-Fi/LTE"

    override val recentAttempts = "การเชื่อมต่อและการตรวจสอบล่าสุด"
    override val kindCheck = "การตรวจสอบ"
    override val kindTg = "เทเลแกรม"
    override val histWho = "ใคร"
    override val histWhen = "เมื่อไหร่"
    override val histReq = "คำขอ"
    override val histSess = "เซสชัน"
    override val histScan = "สแกน"
    override val testNow = "ทดสอบตอนนี้"
    override val testShort = "ทดสอบ"
    override val testResult = "ผลการทดสอบ"
    override val testStop = "หยุด"
    override val testingNow = "กำลังทดสอบ…"
    override val prewarmTitle = "อุ่นซ็อกเก็ตล่วงหน้า (ทดลอง)"
    override val prewarmHelp = "คงซ็อกเก็ตไปยังพร็อกซีไว้สองสามตัวล่วงหน้า เพื่อให้การเชื่อมต่อ " +
        "Telegram ใหม่ข้ามขั้นตอนเชื่อมต่อ/แฮนด์เชกได้ ทดลอง: เบื้องหลังจะเชื่อมต่อใหม่ตลอดเวลา → " +
        "สิ้นเปลืองทราฟฟิกและ CPU เล็กน้อย ไม่มีการส่งทราฟฟิกปลอม (ซึ่งจะทำให้เซสชันจริงเสียหาย) — " +
        "ซ็อกเก็ตเพียงหมุนเวียนเท่านั้น มีประโยชน์ที่สุดกับพร็อกซี FakeTLS"
    override val prewarmEnable = "เปิดการอุ่นล่วงหน้า"
    override val prewarmModeDeferred = "เลื่อนเวลา (TLS เท่านั้น)"
    override val prewarmModeDeferredSub = "คง TCP + FakeTLS ไว้; ส่ง init ให้เสร็จตอนส่งต่อ ยังไม่ผูกมัด DC — สมจริงที่สุด"
    override val prewarmModeFull = "แฮนด์เชกเต็มรูปแบบ"
    override val prewarmModeFullSub = "คงซ็อกเก็ตที่เชื่อมต่อสมบูรณ์ข้าม DC; นำกลับมาใช้เฉพาะเมื่อ DC/tag ตรงกัน อายุสั้นกว่า"
    override val prewarmPoolLabel = "ซ็อกเก็ตสำรอง"
    override val prewarmHoldLabel = "คงไว้แต่ละตัว, วิ"
    override val prewarmNote = "หมุนเวียนเท่านั้น (ไม่มี keepalive ระดับแอป) ซ็อกเก็ตอยู่ได้ไม่กี่วินาทีถึง~หนึ่งนาที ขึ้นกับพร็อกซี/DC"
    override val prewarmStatus = "อุ่นล่วงหน้า"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} พร้อม · คงไว้ ${holdSecs}วิ"
    override val prewarmStar = "สีส้มหนา = ซ็อกเก็ตที่ส่งต่อมาแบบอุ่นจากพูลอุ่นล่วงหน้า (ข้ามเชื่อมต่อ/แฮนด์เชก)"
    override fun prewarmTableTitle(holdSecs: Int) = "อุ่นซ็อกเก็ตล่วงหน้า (คงไว้ ${holdSecs}วิ)"
    override val prewarmTableHelp = "\"อุ่นซ็อกเก็ตล่วงหน้า\" เปิดซ็อกเก็ตไปยังพร็อกซีสองสามตัวไว้ล่วงหน้า เพื่อให้การเชื่อมต่อ " +
        "Telegram ใหม่ข้ามขั้นตอนเชื่อมต่อ/แฮนด์เชกได้ ตารางนี้แสดงซ็อกเก็ตที่กำลังอุ่น: แต่ละตัวมีอายุนานเท่าไร " +
        "Telegram กำลังใช้อยู่หรือไม่ และทราฟฟิก เปิด/ปิดและตั้งค่า (โหมด, จำนวนซ็อกเก็ต, " +
        "เวลาคงไว้) ได้ใน เพิ่มเติม → การตั้งค่า → \"อุ่นซ็อกเก็ตล่วงหน้า (ทดลอง)\""
    override val prewarmNoneWarming = "ยังไม่มีซ็อกเก็ตที่กำลังอุ่น"
    override val prewarmColAge = "อายุ"
    override val prewarmColUse = "ใน TG?"
    override val prewarmInUse = "ใน TG"
    override val prewarmNew = "ใหม่"
    override val lanShareTitle = "แชร์ผ่าน LAN (เว็บพอร์ทัล)"
    override val lanShareDesc = "ให้อุปกรณ์อื่นบน Wi-Fi นี้ใช้ AutoConnector นี้เป็นพร็อกซี; เบราว์เซอร์ที่เปิดที่อยู่ด้านล่างจะได้หน้าพร็อกซีที่ดีที่สุด"
    override val lanShareUrlsLabel = "เพื่อนบ้านเชื่อมต่อที่:"
    override val lanShareNoIp = "ไม่มีที่อยู่ในเครือข่ายท้องถิ่น — เชื่อมต่อกับ Wi-Fi"
    override val lanFirewallTitle = "อนุญาตบนเครือข่ายท้องถิ่น"
    override val lanFirewallBody = "การเปิดสิ่งนี้จะเปิดพอร์ตรีเลย์ให้เครือข่ายท้องถิ่นของคุณ ไฟร์วอลล์ของ Windows (หรืออื่นๆ) อาจถามว่าจะอนุญาต AutoConnector หรือไม่ — เลือก อนุญาต / ใช่ หากคุณปฏิเสธ ทราฟฟิกของเพื่อนบ้านไปยัง AutoConnector จะถูกบล็อก และหน้า/พร็อกซีจะเข้าถึงไม่ได้"
    override val lanFirewallConfirm = "เปิดใช้งาน"
    override val lanInfoTitle = "นี่มีไว้เพื่ออะไร?"
    override val lanInfoBody = "รัน AutoConnector บนคอมพิวเตอร์หรือโทรศัพท์เครื่องเดียวบน Wi-Fi ของคุณ และอุปกรณ์อื่นทุกเครื่องในเครือข่ายเดียวกัน — รวมถึง iPhone ที่แอปนี้ไม่รองรับโดยตรง — ก็สามารถเปิดที่อยู่ในเบราว์เซอร์แล้วใช้งานได้: หน้าพร็อกซีที่ดีที่สุดเพื่อเพิ่มลงใน Telegram ของพวกเขา หรืออุปกรณ์นี้เองเป็นพร็อกซี SOCKS อุปกรณ์หนึ่งค้นหาและคงพร็อกซีไว้ ที่เหลือยืมใช้ผ่าน LAN"
    override val volTriggerTitle = "ทริกเกอร์ปุ่มปรับเสียง"
    override val volTriggerSub = "สลับพร็อกซีด้วยรูปแบบการกดปุ่มเสียงอย่างรวดเร็ว"
    override val volEnableLabel = "เฝ้าดูปุ่มปรับเสียง"
    override val volHelpTitle = "นี่คืออะไร?"
    override val volHelpBody = "บน Android ไม่มีปุ่มลัดคีย์บอร์ดทั่วระบบ จึงใช้ปุ่มปรับเสียงแทน เมื่อเปิดใช้งาน AutoConnector จะเฝ้าดูรูปแบบการกดเพิ่ม/ลดเสียงอย่างรวดเร็ว (เช่น ขึ้น-ขึ้น-ลง-ลง) ในเบื้องหลัง เมื่อจดจำรูปแบบได้ มันจะเปิดลิงก์ tg:// ของพร็อกซีที่ดีและใช้งานได้แบบสุ่ม เพื่อให้ Telegram รับและสลับ — วิธีหมุนเวียนพร็อกซีที่รวดเร็วและแนบเนียนโดยไม่ต้องเปิดแอป ปุ่มเสียงยังทำงานตามปกติ (การกดไม่ถูกดูดกลืน) สิ่งนี้ต้องใช้สิทธิ์ Accessibility (เพื่ออ่านปุ่มเสียงในเบื้องหลังและเปิดลิงก์); จะไม่มีการร้องขอสิ่งใดจนกว่าคุณจะเปิดสวิตช์ ตั้งเวลาสูงสุดระหว่างการกดด้านล่าง; รูปแบบที่จดจำได้แสดงอยู่ด้านล่าง"
    override val volGrantTitle = "เปิด Accessibility (สำคัญ)"
    override val volGrantBody = "Android (โดยเฉพาะ 13+) บล็อก Accessibility สำหรับแอปที่ไม่ได้ติดตั้งจาก Google Play — นั่นคือเหตุผลที่ AutoConnector เป็นสีเทาและขึ้นว่า \"การตั้งค่าถูกจำกัด\" / \"ไม่อนุญาตการเข้าถึง\"\n\nวิธีปลดบล็อก:\n1. เปิด \"ข้อมูลแอป\" (ปุ่มด้านล่าง หรือ การตั้งค่า → แอป → AutoConnector for Telegram)\n2. แตะเมนู ⋮ (มุมขวาบน) → \"อนุญาตการตั้งค่าที่ถูกจำกัด\" → ยืนยัน\n3. กลับไป: การตั้งค่า → Accessibility → AutoConnector for Telegram → เปิดใช้งาน\n\nหากคุณไม่เห็น \"อนุญาตการตั้งค่าที่ถูกจำกัด\" ลองเปิดสวิตช์ใน Accessibility สักครั้งก่อน (คุณจะได้รับข้อความว่าถูกบล็อก) จากนั้นขั้นตอนที่ 2 จะปรากฏ\n\nบน Xiaomi/MIUI, Samsung ฯลฯ เส้นทางอาจต่างกันเล็กน้อย — มองหา ⋮ เดียวกันใน \"ข้อมูลแอป\" บน Android 12 และเก่ากว่ามักไม่มีข้อจำกัด — เปิดใช้งานใน Accessibility ได้เลย\n\nปุ่มเสียงถูกสังเกตเท่านั้น ไม่เคยถูกบล็อก"
    override val volOpenAppInfo = "เปิดข้อมูลแอป"
    override val volAccessOn = "Accessibility: ได้รับอนุญาตแล้ว"
    override val volAccessOff = "Accessibility: ยังไม่ได้รับอนุญาต"
    override val volOpenAccess = "เปิดการตั้งค่า Accessibility"
    override val volGapLabel = "มิลลิวินาทีสูงสุดระหว่างการกด"
    override val volPatternsTitle = "รูปแบบที่จดจำได้"
    override val volPatternPick = "รูปแบบ"
    override val volPatternsLegend = "↑ = เพิ่มเสียง, ↓ = ลดเสียง"
    override val volNoRights = "แอปยังไม่มีสิทธิ์จัดการปุ่มปรับเสียง — ให้สิทธิ์ตามขั้นตอนที่ด้านล่างของหน้านี้"
    override val volGrantShort = "ยังไม่มีสิทธิ์ Accessibility อ่านขั้นตอนโดยละเอียดที่ด้านล่างของหน้านี้ แล้วแตะ \"ตรวจสอบ\""
    override val volCheck = "ตรวจสอบ"
    override val volCheckOk = "✓ เสร็จสิ้น — ได้รับสิทธิ์แล้ว ทริกเกอร์ทำงาน"
    override val volCheckFail = "✗ ยังไม่มีสิทธิ์ — ทำตามขั้นตอนด้านบนให้ครบ"
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = เพิ่มเสียง, ↓ = ลดเสียง)"
    override val histLegend = "คอลัมน์ — ใคร: ✓/✗ TG = การเชื่อมต่อ Telegram จริง, สแกน = การตรวจสอบเบื้องหลัง เมื่อไหร่: เวลาที่ผ่านมา TCP/TLS/คำขอ: ความหน่วงแฮนด์เชกและคำขอแรก, มิลลิวินาที เซสชัน: เซสชันรีเลย์อยู่นานเท่าไร ↓/↑: ไบต์ที่รับ / ส่งผ่านโฮสต์"
    override val tgOkTotalHint = "การเชื่อมต่อ Telegram / สำเร็จ / การตรวจสอบทั้งหมด"
    override val breadthTitle = "ความกว้างในการเลือกโฮสต์"
    override val breadthHelp = "ซ้าย = ยึดติดกับโฮสต์ที่พิสูจน์แล้วว่าดีที่สุด; ขวา = ลองให้กว้างที่สุดเท่าที่จะทำได้ทั่วทุกโฮสต์ที่ใช้งานได้ เมื่อ Telegram สลับพอร์ตรีเลย์ไปเรื่อยๆ แอปจะขยายการค้นหาโดยอัตโนมัติ"
    override val breadthNarrow = "พิสูจน์แล้ว"
    override val breadthWide = "กว้างที่สุด"
    override val connTimeoutTitle = "ไทม์เอาต์การเชื่อมต่อต่อโฮสต์"
    override val connTimeoutHelp = "รอ upstream หนึ่งตัว (TCP + TLS + คำตอบ MTProto แรก) นานเท่าไรก่อนจะข้ามไปยังพร็อกซีถัดไป"
    override val factoryResetDone = "รีเซ็ตทุกอย่างแล้ว โปรดปิดแอปแล้วเปิดใหม่อีกครั้ง"
}
