[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[ဒေါင်းလုဒ် (နောက်ဆုံးဗားရှင်း)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — အပလီကေးရှင်းသည် MTProto-proxy များကို အင်တာနက်ပေါ်တွင် အလိုအလျောက်ရှာဖွေ၍ ၎င်းတို့၏ အသက်ဝင်မှုကို စစ်ဆေးပြီး Telegram ပိတ်ဆို့ထားသည့်နေရာများတွင်ပင် တည်ငြိမ်စွာအလုပ်လုပ်စေသည့် local relay တစ်ခုကို တည်ဆောက်ပေးသည်။ အသုံးပြုသူသည် အလုပ်လုပ်နေသော proxy များကို လက်ဖြင့်ရှာစရာမလိုပါ — AutoConnector for Telegram သည် အမြန်ဆုံးနှင့် အသက်ဝင်ဆုံးများကို အမြဲတမ်းရွေးချယ်ပေးပြီး ၎င်းတို့ကို သင့်ကွန်ပျူတာ/ဖုန်းမှတဆင့်ပင် စမ်းသပ်ပေးသည်။

တနည်းအားဖြင့်ဆိုရလျှင်: ၎င်းသည် အများသုံးအခမဲ့ MTProto proxy များပါသော Telegram channel များနှင့် subscription အမျိုးမျိုးကို စကင်ဖတ်သည့်စကင်နာဖြစ်ပြီး သင့် Telegram ထဲသို့ အလိုအလျောက်ထည့်သွင်းပေးသည်။ Telegram client ကို အပ်ဒိတ်လုပ်စရာမလိုပါ။ proxy များ၏ ရရှိနိုင်မှုကို သင့်စက်နှင့် ကွန်ရက်ပတ်ဝန်းကျင်မှတဆင့်ပင် စစ်ဆေးပေးသည်။ VPN မပါဘဲ WiFi+LTE တွင် အလုပ်လုပ်သည်။

ပလက်ဖောင်းများ: Android, Windows, Linux, MacBook။

Android ဗားရှင်းသည် သူ့ဘာသာသူ အလုပ်လုပ်သော်လည်း Windows တွင် "СПЛИТ..." (Split) သို့မဟုတ် "КОАЛЕСИНГ.." (Coalescing) proxy engine ကို ထည့်သွင်းရန်လိုသည် — settings ထဲတွင် သို့မဟုတ် "Telegram ချိတ်ဆက်ထားသည်" စာသားနှင့် မီးခိုး/အစိမ်းရောင် စက်ဝိုင်းကြီး၏ ညာဘက်ရှိ ခလုတ်တွင်ရှိသည်။ သို့မဟုတ် သင့်အတွက် ပိုကောင်းစွာအလုပ်လုပ်မည့်အရာကို ရွေးချယ်ပါ၊ အကြောင်းမှာ ပိတ်ဆို့မှုများသည် နေရာတိုင်းတွင် မတူညီသောကြောင့်ဖြစ်သည်။ "КОАЛЕСИНГ.." (Coalescing) mode များသည် နောက်ဆုံးအဆင့်အတွက်ဖြစ်သည် — ထိုနည်းဖြင့် Telegram သည် အလုပ်လုပ်စပြုမည်ဖြစ်သော်လည်း chat များတွင် media အကြောင်းအရာ ပို့ခြင်း/ပြသခြင်းမှာ ပျက်စီးသွားလိမ့်မည်။

COMODO ကဲ့သို့ firewall ကို အသုံးပြုနေပါက ပိတ်ထားရန် အကြံပြုသည်: ၎င်းသည် အပလီကေးရှင်းကို sandbox ထဲသို့ ထည့်ပစ်ပြီး ၎င်း၏ firewall သည် MTProto proxy များသို့ ထွက်ခွာသွားသော connection များကို ပျက်စီးစေသည်။ သို့မဟုတ် အပလီကေးရှင်းကို virtual machine ထဲတွင် run ပါ၊ ထိုနေရာတွင် TCP stack သည် လုံးဝပြောင်းလဲသွားမည်ဖြစ်ပြီး AutoConnector ၏ အပြုအမူသည် ကွဲပြားသွားမည်။

ထို့အပြင် အလုပ်လုပ်သော proxy နှင့် Telegram အတွင်းရှိ "ချိတ်ဆက်ပြီး" စာသားသို့ ပိုမြန်စွာရောက်စေရန် Telegram ကို port 55001 နှင့် 55002 ကြားပြောင်းရန် (proxy settings ထဲတွင်) လက်ဖြင့်ကူညီပေးပါ။

# ✨ စွမ်းဆောင်ရည်များ

- **Proxy အလိုအလျောက်ရှာဖွေခြင်း** — ဖွင့်ထားသော စာမျက်နှာများနှင့် subscription ဒါဇင်များစွာကို စကင်ဖတ်သည်။
- **အသက်ဝင်မှုစစ်ဆေးခြင်း** — တကယ့် MTProto-handshake၊ အမြန်နှုန်း/တည်ငြိမ်မှုအလိုက် အဆင့်သတ်မှတ်ခြင်း။
- **Local relay** — Telegram သည် `127.0.0.1` သို့ ချိတ်ဆက်ပြီး AutoConnector for
  Telegram သည် trafic ကို အကောင်းဆုံးအသက်ဝင်သော proxy မှတဆင့် လမ်းကြောင်းချပေးကာ
  လက်ရှိအသုံးပြုသည့်အရာ ကျသွားပါက ပြောင်းပေးသည်။
- **Anti-DPI** — ဖုံးကွယ်ခြင်းနည်းပရိယာယ်များ (browser အတုခြင်း၊ packet များ
  ခွဲခြမ်းခြင်း၊ FakeTLS စသည်)၊ «Auto-cycle» mode သည် အလုပ်လုပ်သောအရာကို သူ့ဘာသာရွေးချယ်သည်။
- **အသေးစိတ်စာရင်းအင်း** — အသက်ဝင်/သေဆုံးသော proxy များ၊ အမြန်နှုန်း၊ latency၊ traffic၊
  anti-DPI နည်းပရိယာယ်တစ်ခုစီ၏ ထိရောက်မှု။
- **Proxy စာရင်း** — အဆင့်အလိုက်ထိပ်တန်းများကို host တစ်ခုစီ၏ အသေးစိတ်ကတ်ဖြင့်:
  host တစ်ခုစီအတွက် «Telegram connection / အောင်မြင်သော / စစ်ဆေးမှုစုစုပေါင်း» နှင့်
  နောက်ဆုံးကြိုးပမ်းမှု ၂၅ ကြိမ်၏ မှတ်တမ်း (TCP/TLS/connection ကြာချိန်စုစုပေါင်း၊ လက်ခံ/ပို့ဆောင် byte) ကို မြင်နိုင်သည်။
- **Host ရွေးချယ်မှု ပြောင်းလွယ်ပြင်လွယ်** — «ကျယ်ပြန့်မှု» slider: «စစ်ဆေးပြီးအကောင်းဆုံးများကို ဆုပ်ကိုင်ထားခြင်း»
  မှ «အသက်ဝင်သော အမျိုးမျိုးကို တတ်နိုင်သမျှ ကျယ်ကျယ်ပြန့်ပြန့်စမ်းခြင်း» အထိ၊ Telegram သည် relay port များကြားတွင်
  ပြေးလွှားနေသောအခါ ရွေးချယ်မှုသည် အလိုအလျောက် ကျယ်ပြန့်လာသည်။ သီးခြား slider — connection
  timeout (100 ms … 15 s) နှင့် «upstream race» (connection အများကို တပြိုင်နက်)။
- **interface ဘာသာစကား ၁၂ မျိုး** အလိုအလျောက်ရှာဖွေခြင်းနှင့်အတူ၊ RTL-အထောက်အပံ့။

> ### 1.0.19 နှင့်နှိုင်းယှဉ်ပါက ဘာအသစ်လဲ
> - **ကွန်ရက်အမျိုးအစားအလိုက် သီးခြား database နှင့် host အဆင့်သတ်မှတ်ချက်များ** — VPN / Wi-Fi / LTE /
>   Ethernet / White: ချိတ်ဆက်မှုအမျိုးအစားတစ်ခုစီသည် ၎င်း၏ကိုယ်ပိုင် အသက်ဝင်proxy pool ကိုထိန်းသိမ်းသည်၊
>   VPN အောက်တွင်သာ အလုပ်လုပ်သောအရာကို Telegram သို့ မထည့်မိစေရန်။
> - **Upstream race** — connection အများကို တပြိုင်နက်၊ အမြန်ဆုံးအသက်ဝင်သောအရာ အနိုင်ရသည်၊
>   «ရွေးချယ်မှုကျယ်ပြန့်မှု» slider (စစ်ဆေးပြီးအကောင်းဆုံးများမှ တတ်နိုင်သမျှ
>   ကျယ်ပြန့်အထိ) ၊ Telegram သည် relay port များကြားတွင် ပြေးလွှားသောအခါ pool အလိုအလျောက်ကျယ်ပြန့်လာခြင်း၊
>   ချိန်ညှိနိုင်သော connection timeout (100 ms…15 s)။
> - **အသေးစိတ်ကတ်ပါသော host စာရင်း** — «Telegram connection / အောင်မြင်သော /
>   စစ်ဆေးမှုစုစုပေါင်း» နှင့် host အလိုက် နောက်ဆုံးကြိုးပမ်းမှု ၂၅ ကြိမ်၏မှတ်တမ်း (TCP/TLS အချိန်၊
>   connection ကြာချိန်၊ လက်ခံ/ပို့ဆောင် byte)။
> - အမြန်နှုန်း၊ ping နှင့် port လှုပ်ရှားမှု (စက္ကန့်နှင့်မိနစ်အလိုက်) ၏ **live graph များ**
>   နှင့် scanning graph များ။
> - **Anti-DPI နှင့် proxy engine များ** — «Auto-cycle» ပါသော ဖုံးကွယ်ခြင်းနည်းပရိယာယ်အစုံ၊
>   obfuscation engine နှင့် တိကျသောပိတ်ဆို့မှုအတွက် စမ်းသပ်ဆဲ engine များ (split/coalescing)။
> - settings၊ host များနှင့် subscription များ **export/import** + စက်ရုံအခြေအနေသို့ အပြည့်အဝ reset။
> - **အေးခဲစတင်မှု အမြန်** — anonymizer အများမှတဆင့် subscription များကို
>   thread အများဖြင့် ပြင်းထန်စွာ download ခြင်း။
> - interface ဘာသာစကား **၂၆ မျိုး** အလိုအလျောက်ရှာဖွေခြင်းနှင့်အတူ (+RTL)။

# ပထမဆုံးအကြိမ် run သည့်အခါ အရေးကြီးသည်:

- localhost:55001 နှင့် localhost:55002 ဟူသော သတ်မှတ်ထားသော SOCKS5 proxy ကို သတ်မှတ်၍ Telegram ကို ပြင်ဆင်ပါ။
- ၎င်းတို့မှလွဲ၍ အခြား proxy များကို ဖျက်ပါ။
- Telegram တွင် "proxy ကိုအသုံးပြုမည်" ကို ဖွင့်ပါ။
- Android တွင် notification များကို မပိတ်ပါနှင့်၊ မဟုတ်လျှင် နောက်ကွယ်တွင် အလုပ်လုပ်မည်မဟုတ်ပါ။
- ပထမဆုံးအကြိမ် run သည့်အခါ MTProto proxy များကို download ပြီး စစ်ဆေးနေချိန်နှင့် Telegram client ကိုယ်တိုင် ပြောင်းသွားသည်အထိ ~၁၅ မိနစ်ခန့် စောင့်ပါ။

# ဘာမှအလုပ်မလုပ်လျှင်

1. ဘာမှ အလုပ်မလုပ်လျှင် ပရိုဂရမ်ကို အသက်ဝင်proxy များ၏ အလိုအလျောက်စာရင်းအဖြစ် အသုံးပြုပါ။ CTRL+WIN+ALT+P နှင့် CTRL+SHIFT+ALT+P hotkey ဖြင့် AutoConnector ၏ window ကိုမဖွင့်ဘဲ ကျပန်း proxy တစ်ခုကို သင့် Telegram ထဲသို့ အမြန်ထည့်နိုင်သည်။ ထို့ကြောင့် Telegram သည် AutoConnector မပါဘဲ proxy သို့ တိုက်ရိုက်သွားမည်ဖြစ်သော်လည်း အခမဲ့ proxy များတင်သော chat များကို စောင့်ကြည့်ရန်နှင့် ၎င်းတို့ကို စစ်ဆေးရန် အချိန်ကုန်စရာမလိုတော့ပါ။ AutoConnector ကို tray ထဲတွင်ထားပါ၊ "Connector" toggle ကိုပိတ်၍ "Scan" toggle ကို ဖွင့်ထားပါ။

2. AutoConnector ကို အခြားစက်တွင် စမ်းကြည့်ပါ: ဖုန်း၊ သူငယ်ချင်းဖုန်း၊ ကွန်ပျူတာ။ Windows/Android ပလက်ဖောင်းအသီးသီးတွင် ပိတ်ဆို့မှုဖြတ်ကျော်ခြင်းနိယာမသည် လုံးဝကွဲပြားသည်။ Android တွင် ဖြစ်နိုင်ခြေအများဆုံးအနေဖြင့် ဘာsettings မှ မလိုဘဲ အလုပ်လုပ်မည်ဖြစ်သည်။

3. ဘာမှ အလုပ်မလုပ်လျှင် တစ်ရက်အတွက် VPN ကို ယာယီဖွင့်၍ ထိုနေ့တွင် AutoConnector + Telegram ကို စမ်းသပ်ပါ (Telegram ကို port 55001 နှင့် 55002 တွင် proxy သတ်မှတ်၍ AutoConnector မှတဆင့် ချိတ်ဆက်ပါ)။ ပရိုဂရမ်အတွင်း "VPN ဖွင့်ထားစဉ် -> MTProto သို့ proxy ချမည်" check box ကိုဖွင့်ပါ။ AutoConnector စတင်အလုပ်လုပ်လား ကြည့်ပါ။ ဖြစ်ပါက ကောက်ချက်ရှင်းသည် — AutoConnector သည် proxy များကို အောင်မြင်စွာရှာဖွေ၍ Telegram trafic ကို ထိုနေရာသို့ အောင်မြင်စွာ ထုတ်လွှင့်ပေးသော်လည်း VPN ကိုပိတ်လျှင် သင့်နိုင်ငံ၏ ပိတ်ဆို့မှုစနစ်သည် ထွက်ခွာသွားသော connection အားလုံးကို အလွန်တင်းကျပ်စွာ ပိတ်ဆို့ထားသည်။ ထိုကဲ့သို့ဆိုလျှင် ပိတ်ဆို့မှုဖြတ်ကျော်နိုင်သော အလုပ်လုပ်သည့်နည်းကိုရွေးရန် AutoConnector ထဲတွင် နာရီဝက်ခန့် နည်းလမ်းများ စမ်းသပ်ရန်လိုသည်။ ဖြစ်နိုင်ချေအားလုံးကို အလိုအလျောက်စမ်းသပ်ခြင်းကို ပရိုဂရမ်က ယခုအချိန်ထိ မတတ်နိုင်သေးပါ (anti-DPI နည်းပရိယာယ်များ၏ auto-cycle သာရှိသည်)။ စမ်းသပ်ပြီးနောက် VPN ကိုပိတ်ပြီး "VPN ဖွင့်ထားစဉ် MTProto သို့ proxy ချမည်" check box ကို "တိုက်ရိုက် proxy ချမည်" အခြေအနေသို့ ပြန်ပေးပါ။

4. (၃) အတွက် အခြားရွေးချယ်စရာ။ သင့် Windows/Linux host ပေါ်တွင် virtual machine တစ်ခုထည့်ပါ။ ၎င်းအတွင်း Telegram + AutoConnector ကို run ပါ။ VPN မပါဘဲပင် ပြီးပြည့်စုံစွာ အလုပ်လုပ်စပြုလား။ ဆိုလိုသည်မှာ သင့်နိုင်ငံ၏ ပိတ်ဆို့မှုစနစ်မဟုတ်ဘဲ သင့် host က သင့် connection များကို ပျက်စီးစေနေခြင်းဖြစ်သည်! အကြောင်းရင်းများ: firewall များ၊ antivirus များ၊ VPN ၏ ကျန်ရစ်ခဲ့သောအရာများ။ antivirus က AutoConnector ကို sandbox ထဲထည့်ခြင်း သို့မဟုတ် firewall က AutoConnector ၏ ထူးခြားသော anti-DPI နည်းပရိယာယ်များကို ပိတ်ဆို့ခြင်းဖြစ်ပါက host ပေါ်ရှိ AutoConnector ကို antivirus နှင့် firewall ၏ ကင်းလွတ်ခွင့် (exception) ဖြင့် ဖွင့်ရန်လိုသည်။ သို့မဟုတ် ကွန်ပျူတာကို restart ၍ ၎င်းတို့ကို ခေတ္တလုံးဝပိတ်ပါ။ ဟုတ်ပါသည်၊ ရယ်စရာအကြံပြုချက်ဖြစ်သော်လည်း ကွန်ပျူတာကို restart ပါ၊ အကြောင်းမှာ VPN ပရိုဂရမ်များသည် မကြာခဏ glitch ဖြစ်ပြီး host ပေါ်တွင် TUN device ကို တစ်ဝက်တစ်ပျက်အခြေအနေဖြင့် ချန်ထားနိုင်သောကြောင့်ဖြစ်သည်။ restart ပြီးနောက် VPN ကို မ run ပါနှင့်၊ ဦးစွာ AutoConnector ကို စမ်းသပ်ပါ။

  5. ပိတ်ဆို့မှုဖြတ်ကျော်ခြင်းကို စမ်းကြည့်ပါ။ ဖွင့်ခလုတ်ကို settings ထဲတွင် သို့မဟုတ် ပင်မ screen တွင်ရှာပါ (မီးခိုး/အစိမ်းရောင် စက်ဝိုင်းကြီး၏ ညာဘက်ရှိ ခလုတ်ကိုရှာပါ)။ ~၁၅ မိနစ်ခန့် အချိန်ပေးရန်လိုသည်။ ၎င်းတို့သည် အုပ်စု ၃ စုဖြင့် ဖွဲ့စည်းထားသည်:
	  - Proxy engine။ Coalescing* mode တစ်ခုခုကို စမ်းပါ။ ဖြစ်နိုင်ချေအများဆုံးအနေဖြင့် ချက်ချင်းအလုပ်လုပ်မည်။ သို့သော် Telegram တွင် ပုံ/ဗီဒီယိုများ load မဖြစ်ပါ (၎င်းသည် bug မဟုတ်ဘဲ feature/အလျှော့အတင်းဖြစ်သည်)။ ထို့နောက် Split* mode များကို စမ်းပါ၊ အလုပ်လုပ်ပါက ပုံများ load ဖြစ်သည်။ သို့မဟုတ် "ပိတ်" သို့ ပြန်ထားပါ။
	  - "Parallel upstream race" ကို စမ်းပါ။ ၎င်းဆိုလိုသည်မှာ Telegram သည် proxy သို့ connection ၁ ခု ပြုလုပ်သောအခါ AutoConnector သည် မတူညီသော MTProto proxy များသို့ connection ၅-၃၀ ခုပြုလုပ်၍ အကောင်းဆုံးကို Telegram သို့ ထည့်ပေးခြင်းဖြစ်သည်။ အပလီကေးရှင်း settings ထဲတွင် timeout (၃-၅ စက္ကန့်) နှင့် parallel upstream အရေအတွက်ကို ၃၀ ခုအထိ ရွေးနိုင်သည်။
	  - "anti-DPI နည်းပရိယာယ်များ၏ auto-cycle" ကိုဖွင့်ပါ၊ ၎င်းတို့ကို ပရိုဂရမ်က သူ့ဘာသာ စမ်းသပ်သွားမည်။
	  - Telegram ပိုမြန်စွာပြောင်းစေရန် proxy settings (Telegram ထဲ) တွင် ၅-၁၀ စက္ကန့်တိုင်း လက်ဖြင့် နောက် port သို့ အလှည့်ကျ ပြောင်းပါ 55001->55002->55001->...

6. အင်အားအကြီးဆုံး/အမြန်ဆုံး settings ပေါင်းစပ်မှု:
	- connection timeout ၅ စက္ကန့်
	- host ရွေးချယ်မှုကျယ်ပြန့်မှု 100%
	- parallel connection ၃၀ ခု
	- DPI နည်းပရိယာယ်များ auto-cycle
	- parallel upstream race
	- proxy engine: Coalescing*
	- Telegram အတွင်း proxy window တွင် ၁၀ စက္ကန့်တိုင်း port အသစ်ကို အလှည့်ကျ နှိပ်ပါ။

7. Windows နှင့် Android တွင် ပြင်ဆင်မှုမူဝါဒ ကွဲပြားသည်! အထက်တွင်ရေးထားသမျှသည် အဓိကအားဖြင့် Windows နှင့်သက်ဆိုင်သည်။ Android တွင် အများစုမှာ ဘာsettings မှ မလိုဘဲ (settings မည်သို့ပင်ဖြစ်စေ) အလုပ်လုပ်သည်။ Windows တွင် TCP stack ကွဲပြားပြီး Telegram အပလီကေးရှင်းကွဲပြားကာ ၎င်းသည် Android ထက် အရည်အသွေးအားဖြင့် များစွာညံ့ဖျင်းသည်။ တရားဝင်ဖြစ်သည့်အရာသာမက အခြား Telegram client တစ်ခုခုကို စမ်းကြည့်ပါ။

8. ကျေးဇူးပြု၍ အသေးစိတ် bug report များကို မည်သည့်ဘာသာစကားဖြင့်မဆို https://t.me/AutoConnector_for_Telegram တွင် ရေးပါ — ပလက်ဖောင်း၊ မည်သည့်နည်းလမ်းများစမ်းခဲ့သည် (settings)၊ firewall/antivirus ရှိသလား၊ VPN/virtual machine မှ စမ်းခဲ့သလား။ ဘာကိုစမ်းခဲ့ပြီး မည်သို့အလုပ်လုပ်လာသည်ဆိုသော အပြုသဘောဆောင်သည့် နည်းလမ်းများကိုလည်း ရေးပါ။


## 📥 ဒေါင်းလုဒ်

build အားလုံးကို release စာမျက်နှာတွင်: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | ဖိုင် | စတင်ခြင်း |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK ကို install (Google Play ပြင်ပ — source မှ install ခွင့်ပြုပါ) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | unzip → `AutoConnector\AutoConnector.exe` ကို run |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | unzip → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | unzip → `AutoConnector.app` ကို double-click (ပိတ်ဆို့ပါက — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 စစ်မှန်ကြောင်းစစ်ဆေးခြင်း (release 1.1.0)

APK ကို release-certificate ဖြင့် လက်မှတ်ထိုးထားသည် (apksigner၊ scheme v1+v2+v3)။ install မလုပ်မီ စစ်ဆေးနိုင်သည်:

- **လက်မှတ်ထိုးထားသော certificate (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — ဤ fingerprint သည် နောင်လာမည့် release အားလုံးအတွက် တူညီသည်။
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

စစ်ဆေးခြင်း: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificate) နှင့်
`sha256sum -c SHA256SUMS.txt` (ဖိုင်များ၏ ခိုင်မာမှု; `SHA256SUMS.txt` ကို release တွင် ပူးတွဲထားသည်)။

## 📸 ဖန်သားပြင်ဓာတ်ပုံများ

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — active session</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan နှင့် graph များ</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Proxy စာရင်း (mode အလိုက်)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Host ကတ် + မှတ်တမ်း</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Relay log များ</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Settings</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>tg://-link များ Export</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Hotkey များ</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>ချိတ်ဆက်မှုလမ်းညွှန်</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · ရုရှ UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · ရုရှ UI</sub></td>
<td align="center"><sub>interface ဘာသာစကား ၂၆ မျိုး<br>အလိုအလျောက်ရှာဖွေခြင်းနှင့်အတူ</sub></td>
</tr>
</table>


## တုံ့ပြန်ချက်

bug နှင့် မှတ်ချက်များကို ဤနေရာသို့ ပို့ပါ - https://t.me/AutoConnector_for_Telegram

## 🔐 လက်မှတ်စစ်ဆေးခြင်း

release များမှ APK ကို release-key ဖြင့် လက်မှတ်ထိုးထားသည်။ ဤသို့စစ်ဆေးနိုင်သည်:

```bash
# Checksum (release မှ SHA256SUMS.txt နှင့် နှိုင်းယှဉ်ပါ)
sha256sum AutoConnector_for_Telegram.apk

# ဒစ်ဂျစ်တယ်လက်မှတ်နှင့် certificate fingerprint
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

တရားဝင် build များကို လက်မှတ်ထိုးထားသော certificate fingerprint (SHA-256) ကို
release တစ်ခုစီ၏ ဖော်ပြချက်တွင် ထုတ်ဖော်ထားသည် — APK ကို အစားထိုးမထားကြောင်း
သေချာစေရန် ၎င်းကို နှိုင်းယှဉ်ပါ။

## 📄 လိုင်စင်

[MIT](LICENSE).
