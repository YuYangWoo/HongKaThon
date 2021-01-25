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
        OptionItem("위치정보 이용약관","위치제공한다."),
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
        OptionItem("개발자 소개", "개발자 : YuYangWoo, KangTaeJong")
        )
    }
 }