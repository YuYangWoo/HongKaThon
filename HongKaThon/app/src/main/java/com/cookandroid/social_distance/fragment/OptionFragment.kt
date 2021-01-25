package com.cookandroid.social_distance.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.adapter.OptionAdapter
import com.cookandroid.social_distance.base.BaseFragment
import com.cookandroid.social_distance.databinding.FragmentOptionBinding
import com.cookandroid.social_distance.item.OptionItem

class OptionFragment : BaseFragment<FragmentOptionBinding>(R.layout.fragment_option) {
    var optionList = ArrayList<OptionItem>()
    override fun init() {
        super.init()

        initOptionItem()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        with(binding.optionRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = OptionAdapter().apply {
                data = optionList
                notifyDataSetChanged()
            }
        }
    }
    private fun initOptionItem() {
        optionList = arrayListOf(
            OptionItem("앱 버전","앱버전1.0"),
        OptionItem("위치정보 이용약관","제 1 조 (목적)\n" +
                "본 약관은 개인(yyw, ktj)가 제공하는 위치기반서비스에 대해 회사와 위치기반서비스를 이용하는 개인위치정보주체(이하 \"이용자\")간의 권리·의무 및 책임사항, 기타 필요한 사항 규정을 목적으로 합니다.\n" +
                "\n" +
                "제 2 조 (이용약관의 효력 및 변경)\n" +
                "① 본 약관은 이용자가 본 약관에 동의하고 개인이 정한 절차에 따라 위치기반서비스의 이용자로 등록됨으로써 효력이 발생합니다.\n" +
                "② 개인은 법률이나 위치기반서비스의 변경사항을 반영하기 위한 목적 등으로 약관을 수정할 수 있습니다.\n" +
                "③ 약관이 변경되는 경우 회사는 변경사항을 최소 7일 전에 개인의 홈페이지 등 기타 공지사항 페이지를 통해 게시합니다.\n" +
                "제 3 조 (약관 외 준칙)\n" +
                "이 약관에 명시되지 않은 사항에 대해서는 위치 정보의 보호 및 이용 등에 관한 법률, 전기통신사업법, 정보통신망 이용 촉진및 보호 등에 관한 법률 등 관계법령 및 개인이 정한 지침 등의 규정에 따릅니다.\n" +
                "\n" +
                "제 4 조 (서비스의 내용)\n" +
                "회사는 직접 수집하거나 위치정보사업자로부터 수집한 이용자의 현재 위치 또는 현재 위치가 포함된 지역을 이용하여 아래와 같은 위치기반서비스를 제공합니다.\n" +
                "\n" +
                "① 위치정보를 활용한 정보 제공\n" +
                "제 5 조 (서비스 이용요금)\n" +
                "회사가 제공하는 위치기반서비스는 무료입니다.\n" +
                "단, 무선 서비스 이용 시 발생하는 데이터 통신료는 별도이며, 이용자가 가입한 각 이동통신사의 정책에 따릅니다.\n" +
                "\n" +
                "제 6 조 (서비스 이용의 제한·중지)\n" +
                "① 개인은 위치기반서비스사업자의 정책변경 등과 같이 개인의 제반사정 또는 법률상의 이유로 위치기반서비스를 유지할 수 없는 경우 위치기반서비스의 전부 또는 일부를 제한·변경·중지할 수 있습니다.\n" +
                "② 단, 위 항에 의한 위치기반서비스 중단의 경우 개인은 사전에 개인 홈페이지 등 기타 공지사항 페이지를 통해 공지하거나 이용자에게 통지합니다.\n" +
                "제 7 조 (개인위치정보주체의 권리)\n" +
                "① 이용자는 언제든지 개인위치정보의 수집·이용·제공에 대한 동의 전부 또는 일부를 유보할 수 있습니다.\n" +
                "② 이용자는 언제든지 개인위치정보의 수집·이용·제공에 대한 동의 전부 또는 일부를 철회할 수 있습니다. 이 경우 개인은 지체 없이 철회된 범위의 개인위치정보 및 위치정보 수집·이용·제공사실 확인자료를 파기합니다.\n" +
                "③ 이용자는 개인위치정보의 수집·이용·제공의 일시적인 중지를 요구할 수 있으며, 이 경우 개인은 이를 거절할 수 없고 이를 충족하는 기술적 수단을 마련합니다.\n" +
                "④ 이용자는 개인에 대하여 아래 자료에 대한 열람 또는 고지를 요구할 수 있으며, 해당 자료에 오류가 있는 경우에는 정정을 요구할 수 있습니다. 이 경우 정당한 사유 없이 요구를 거절하지 않습니다.\n" +
                "1. 이용자에 대한 위치정보 수집·이용·제공사실 확인자료\n" +
                "2. 이용자의 개인위치정보가 위치정보의 보호 및 이용 등에 관한 법률 또는 다른 법령의 규정에 의하여 제3자에게 제공된 이유 및 내용\n" +
                "⑤ 이용자는 권리행사를 위해 본 약관 제14조의 연락처를 이용하여 회사에 요청할 수 있습니다.\n" +
                "제 8 조 (개인위치정보의 이용 또는 제공)\n" +
                "① 개인은 개인위치정보를 이용하여 위치기반서비스를 제공하는 경우 본 약관에 고지하고 동의를 받습니다.\n" +
                "② 개인은 이용자의 동의 없이 개인위치정보를 제3자에게 제공하지 않으며, 제3자에게 제공하는 경우에는 제공받는 자 및 제공목적을 사전에 이용자에게 고지하고 동의를 받습니다.\n" +
                "③ 개인은 개인위치정보를 이용자가 지정하는 제3자에게 제공하는 경우 개인위치정보를 수집한 통신단말장치로 매회 이용자에게 제공받는 자, 제공일시 및 제공목적을 즉시 통지합니다.\n" +
                "④ 단, 아래의 경우 이용자가 미리 특정하여 지정한 통신단말장치 또는 전자우편주소, 온라인게시 등으로 통지합니다.\n" +
                "1. 개인위치정보를 수집한 당해 통신단말장치가 문자, 음성 또는 영상의 수신기능을 갖추지 아니한 경우\n" +
                "2. 이용자의 개인위치정보를 수집한 통신단말장치 외의 통신단말장치 또는 전자우편주소, 온라인게시 등으로 통보할 것을 미리 요청한 경우\n" +
                "⑤ 개인은 위치정보의 보호 및 이용 등에 관한 법률 제16조 제2항에 근거하여 개인위치정보 수집·이용·제공사실 확인자료를 자동으로 기록·보존하며, 해당 자료는 6개월간 보관합니다.\n" +
                "위치정보 제공 현황 자세히 보기\n" +
                "제 9 조 (법정대리인의 권리)\n" +
                "회사는 14세 미만의 이용자에 대해서는 개인위치정보를 이용한 위치기반서비스 제공 및 개인위치정보의 제3자 제공에 대한 동의를 이용자 및 이용자의 법정대리인으로부터 동의를 받아야 합니다. 이 경우 법정대리인은 본 약관 제7조에 의한 이용자의 권리를 모두 가집니다.\n" +
                "\n" +
                "제 10 조 (8세 이하의 아동 동의 보호의무자의 권리)\n" +
                "① 회사는 아래의 경우에 해당하는 자(이하 “8세 이하의 아동 등”)의 위치정보의 보호 및 이용 등에 관한 법률 제26조2항에 해당하는 자(이하 “보호의무자”)가 8세 이하의 아동 등의 생명 또는 신체보호를 위하여 개인위치정보의 이용 또는 제공에 동의하는 경우에는 본인의 동의가 있는 것으로 봅니다.\n" +
                "1. 8세 이하의 아동\n" +
                "2. 피성년후견인\n" +
                "3. 장애인복지법 제2조제2항제2호에 따른 정신적 장애를 가진 사람으로서 장애인고용촉진 및 직업재활법 제2조제2호에 따른 중증장애인에 해당하는 사람(장애인복지법 제32조에 따라 장애인 등록을 한 사람만 해당한다)\n" +
                "② 8세 이하의 아동 등의 생명 또는 신체의 보호를 위하여 개인위치정보의 이용 또는 제공에 동의를 하고자 하는 보호의무자는 서면동의서에 보호의무자임을 증명하는 서면을 첨부하여 회사에 제출하여야 합니다.\n" +
                "③ 보호의무자는 8세 이하의 아동 등의 개인위치정보 이용 또는 제공에 동의하는 경우 본 약관 제7조에 의한 이용자의 권리를 모두 가집니다.\n" +
                "제 11 조 (손해배상)\n" +
                "개인의 위치정보의 보호 및 이용 등에 관한 법률 제15조 및 26조의 규정을 위반한 행위로 인해 손해를 입은 경우 이용자는 개인에 손해배상을 청구할 수 있습니다. 개인은 고의, 과실이 없음을 입증하지 못하는 경우 책임을 면할 수 없습니다.\n" +
                "\n" +
                "제 12 조 (면책)\n" +
                "① 개인은 다음 각 호의 경우로 위치기반서비스를 제공할 수 없는 경우 이로 인하여 이용자에게 발생한 손해에 대해서는 책임을 부담하지 않습니다.\n" +
                "1. 천재지변 또는 이에 준하는 불가항력의 상태가 있는 경우\n" +
                "2. 위치기반서비스 제공을 위하여 회사와 서비스 제휴계약을 체결한 제3자의 고의적인 서비스 방해가 있는 경우\n" +
                "3. 이용자의 귀책사유로 위치기반서비스 이용에 장애가 있는 경우\n" +
                "4. 제1호 내지 제3호를 제외한 기타 개인의 고의·과실이 없는 사유로 인한 경우\n" +
                "② 개인은 위치기반서비스 및 위치기반서비스에 게재된 정보, 자료, 사실의 신뢰도, 정확성 등에 대해서는 보증을 하지 않으며 이로 인해 발생한 이용자의 손해에 대하여는 책임을 부담하지 아니합니다.\n" +
                "제 13 조 (분쟁의 조정 및 기타)\n" +
                "① 개인은 위치정보와 관련된 분쟁의 해결을 위해 이용자와 성실히 협의합니다.\n" +
                "② 전항의 협의에서 분쟁이 해결되지 않은 경우, 개인과 이용자는 위치정보의 보호 및 이용 등에 관한 법률 제28조의 규정에 의해 방송통신위원회에 재정을 신청하거나, 개인정보보호법 제43조의 규정에 의해 개인정보 분쟁조정위원회에 조정을 신청할 수 있습니다.\n" +
                "제 14 조 (회사의 주소 및 연락처)\n" +
                "개인의 상호, 주소 및 연락처는 아래와 같습니다.\n" +
                "\n" +
                "상호 : 개인\n" +
                "대표 : 유양우, 강태종\n" +
                "이메일 : yuyw0712@naver.com"),
        OptionItem("오픈소스 라이선스","    implementation \"org.jetbrains.kotlin:kotlin-stdlib:$(kotlin_version)\"\n" +
                "    implementation 'androidx.core:core-ktx:1.3.2'\n" +
                "    implementation 'androidx.appcompat:appcompat:1.2.0'\n" +
                "    implementation 'com.google.android.material:material:1.2.1'\n" +
                "    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'\n" +
                "    implementation 'androidx.legacy:legacy-support-v4:1.0.0'\n" +
                "    implementation 'com.google.firebase:firebase-database:19.6.0'\n" +
                "    testImplementation 'junit:junit:4.+'\n" +
                "    androidTestImplementation 'androidx.test.ext:junit:1.1.2'\n" +
                "    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'\n" +
                "\n" +
                "    // Glide\n" +
                "    implementation 'com.github.bumptech.glide:glide:4.11.0'\n" +
                "    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'\n" +
                "\n" +
                "    // Coroutine\n" +
                "    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'\n" +
                "\n" +
                "    // Volley\n" +
                "    implementation 'com.android.volley:volley:1.1.1'\n" +
                "\n" +
                "    def lifecycle_version = \"2.2.0\"\n" +
                "    // ViewModel\n" +
                "    implementation \"androidx.lifecycle:lifecycle-viewmodel-ktx:$(lifecycle_version)\"\n" +
                "\n" +
                "    // LiveData\n" +
                "    implementation \"androidx.lifecycle:lifecycle-livedata-ktx:$(lifecycle_version)\"\n" +
                "\n" +
                "    // RecyclerView Selection\n" +
                "    implementation \"androidx.recyclerview:recyclerview-selection:1.1.0-rc03\"\n" +
                "\n" +
                "    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.2'\n" +
                "    implementation 'androidx.navigation:navigation-ui-ktx:2.3.2'\n" +
                "\n" +
                "    implementation 'org.jsoup:jsoup:1.13.1'\n" +
                "\n" +
                "    // Firebase\n" +
                "    implementation platform('com.google.firebase:firebase-bom:26.2.0')\n" +
                "    implementation 'com.google.firebase:firebase-analytics-ktx'"),
        OptionItem("개발자 소개", "개발자 : YuYangWoo, KangTaeJong"),
            OptionItem("사용방법 및 앱 소개","https://github.com/YuYangWoo/HongKaThon")
        )
    }
 }